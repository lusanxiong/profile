package com.job528.profile.action.weiboToken;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.googlecode.jsonplugin.annotations.JSON;
import com.job528.common.DataDictionary.SessionAttrName;
import com.job528.common.DataDictionary.WeiboActive;
import com.job528.ejb.entity.WeiboToken;
import com.job528.profile.LoginInfo;
import com.job528.profile.service.IMyResumeService;
import com.job528.profile.service.IWeiboTokenService;
import com.job528.profile.vo.SendWeiboDTO;
import com.job528.profile.vo.WeiboOauthDTO;
import com.job528.util.webwork.GenericAction;

/**
 * 新浪微博同步Action
 * @author lusanxiong
 *
 */
public class WeiboTokenAction extends GenericAction{
	private static final long serialVersionUID = 1L;
	
	private IWeiboTokenService weiboTokenService;
	private IMyResumeService   resumeService;
	
	private Map<String,Object> resultMap = new HashMap<String,Object>(6);
	
	/**
	 * 微博登录同步
	 */
	public String LoginSynWeibo() throws Exception{
		boolean flag = true; //执行结果标识
		
		//获取用户授权信息
		String code = request.getParameter("code");
		if(code == null || "".equals(code)) {
			return paramError();
		}
		
		WeiboOauthDTO dto = weiboTokenService.getWeiboOauthInfo(code);
		String sinaUserId = dto.getSinaUserId();
		if(sinaUserId == null || "".equals(sinaUserId)) {
			return paramError();
		}
		
		boolean isBingAccount = false;//是否已经绑定账户
		
		//528用户登录后，认证授权
		int loginUserId = this.getLoginInfo().getLoginUserId();
		boolean isLoginUserOauth = false;  //是否是登录用户认证授权操作
		if(loginUserId > 0 ) {
			
			//使用新浪微博账号绑定528用户
			synWeibo(sinaUserId,dto.getAccessToken());
			
			isLoginUserOauth = true;
			isBingAccount = true;
		}else {
			
			//528用户未登录情况下
		
			int userId = weiboTokenService.getWeiboTokenInfo(sinaUserId);
			
			//如果该用户已经进行同步 了，则更新用户的accessToken
			if(userId != 0) {
				isBingAccount = true;
				
				String accessToken = dto.getAccessToken();
				int id = weiboTokenService.weiboSynUpdate(sinaUserId, accessToken);
				if(id != 0) {
					
					//兼容528普通方式登录(主要是存储用户的cookie信息)
					int result = useLogin(userId);
					flag = (result<=-1 ? false : true);
					
					//System.out.println("session=t==");
					if(flag) {
						setUserSesssionAllAttr(userId);
					}
				}else {
					flag = false;
				}
			}
		
		}
		
		//返回结果
		resultMap.put("isBindAccount",isBingAccount);
		resultMap.put("userid",loginUserId);
		resultMap.put("flag",flag);
		resultMap.put("sinaUserId",sinaUserId);
		resultMap.put("accessToken",dto.getAccessToken());
		resultMap.put("isLoginUserOauth",isLoginUserOauth);
		System.out.println("resultMap="+resultMap);
		return SUCCESS;
	}
	
	/**
	 * 528用户普通登录
	 * 
	 *为了兼容528普通方式登录
	 * @return -1代表登录失败
	 */
	private int useLogin(int userId) {
		LoginInfo loginInfo = new LoginInfo(request, response);
		String ip = request.getRemoteAddr();
		int result = resumeService.login(userId, ip, loginInfo);
		
    	HttpSession session = request.getSession();
    	session.setAttribute(LoginInfo.LOGIN_USER_RESUME, null);
    	
    	return result;
	}
	
	private String paramError() {
		resultMap.put("flag", false);
		resultMap.put("message", "参数错误");
		//throw new IllegalArgumentException("argument:["+paramName+"] is IlleaglArgument");
		return SUCCESS;
	}
	
	
	/**
	 * 微博同步
	 * 
	 * 528老用户登录后，将新浪userId绑定至528用户
	 */
	public String synWeibo(String sinaUserId, String accessToken) throws Exception{
		
		boolean flag = true;
		
		WeiboToken weiboToken = new WeiboToken();
		
		String userId = super.getUserIdFromCookie();
		if(userId==null || "".equals(userId))
			return paramError();
		
		weiboToken.setSinaUserId(sinaUserId);
		weiboToken.setUserId(Integer.parseInt(userId));
		weiboToken.setToken(accessToken);
		
		//设置同步
		int id = weiboTokenService.weiboSyn(weiboToken);
		if(id != 0) {
			flag = true;//执行成功!
			setUserSesssionAllAttr();
		}else {
			flag = false;
		}
		
		
		//返回结果
		resultMap.put("flag",flag);
		resultMap.put("synId",id);
		
		return SUCCESS;
	}
	
	/**
	 * 特别说明：
	 * 该方法提供给www.528.cn跨域请求时调用。
	 * 
	 * 528新用户注册时与其新浪userId绑定。
	 * 
	 * 返回一段jsonp格式的js脚本供客户端解析
	 */
	
	public String regUserSynWeibo() throws Exception {
		boolean flag = true;
		
		WeiboToken weiboToken = new WeiboToken();
		
		//获取用户授权信息
		String userId = request.getParameter("userId");
		if(userId == null || "".equals(userId)) 
			flag = false;
 
		String sinaUserId = request.getParameter("sinaUserId");
		if(sinaUserId==null || "".equals(sinaUserId))
			flag = false;
		
		String accessToken = request.getParameter("accessToken");
		if(accessToken==null || "".equals(accessToken))
			flag = false;
		System.out.println("userId=="+userId);
		System.out.println("sinaUserId=="+sinaUserId);
		System.out.println("accessToken=="+accessToken);
		
		weiboToken.setSinaUserId(sinaUserId);
		weiboToken.setUserId(Integer.parseInt(userId));
		weiboToken.setToken(accessToken);
		
		//设置同步
		int id = weiboTokenService.weiboSyn(weiboToken);
		System.out.println("id==="+id);
		if(id != 0) {
			flag = true;//执行成功!
			setUserSesssionAllAttr();
		}else {
			flag = false;
		}
		
		//返回jsonp格式字符
		writeText("var result={flag:\""+String.valueOf(flag)+"\"}");
		
		return SUCCESS;
	}
	
	/**
	 * 暂停微博同步
	 */
	public String pauseWeibo() throws Exception{
		Object sinaUserId = super.getHttpSessionAttribute(SessionAttrName.SINA_USERID);
		String sinaUserIdStr = (sinaUserId!=null ? (String)sinaUserId : "");
		if(sinaUserIdStr.equals("")) 
			return paramError();
		
		//System.out.println("sinaUserIdStr="+sinaUserIdStr);
		int count = weiboTokenService.pauseSynWeibo(sinaUserIdStr);
		
		boolean flag = (count==1 ? true : false);
		
		//更新session中的同步状态
		if(flag) {
			super.setHttpSession(SessionAttrName.SINA_ACTIVE,Integer.parseInt(WeiboActive.ACTIVE_PAUSE.toString()));
		}
		
		resultMap.put("flag",flag);
		
		return SUCCESS;
	}
	

	/**
	 * 恢复微博同步
	 */
	public String recoverWeibo() throws Exception{
		Object sinaUserId = super.getHttpSessionAttribute(SessionAttrName.SINA_USERID);
		String sinaUserIdStr = (sinaUserId!=null ? (String)sinaUserId : "");
		if(sinaUserIdStr.equals("")) 
			return paramError();
		
		//System.out.println("sinaUserIdStr="+sinaUserIdStr);
		int count = weiboTokenService.recoverSynWeibo(sinaUserIdStr);
		
		boolean flag = (count==1 ? true : false);
		
		//更新session中的同步状态
		if(flag) {
			super.setHttpSession(SessionAttrName.SINA_ACTIVE,Integer.parseInt(WeiboActive.ACTIVE_ING.toString()));
		}
		
		resultMap.put("flag",flag);
		
		return SUCCESS;
	}
	
	/**
	 * 删除微博同步
	 */
	public String cancelWeibo() throws Exception{
		Object sinaUserId = super.getHttpSessionAttribute(SessionAttrName.SINA_USERID);
		String sinaUserIdStr = (sinaUserId!=null ? (String)sinaUserId : "");
		
		int userid = this.getLoginInfo().getLoginUserId();
		if(userid <=0 || sinaUserIdStr.equals(""))
			return paramError();
		
		int count = weiboTokenService.delSynWeibo(userid, sinaUserIdStr);
		
		boolean flag = (count==1 ? true : false);
		
		//更新session中的同步状态
		if(flag) {
			super.setHttpSession(SessionAttrName.SINA_ACTIVE,Integer.parseInt(WeiboActive.ACTIVE_NO.toString()));
		}
		
		//返回结果
		resultMap = new HashMap<String,Object>();
		resultMap.put("flag",flag);
		
		return SUCCESS;
	}
	
	/**
	 * 发送微博
	 */
	public void sendSinaWeibo() throws Exception{
		String content = request.getParameter("texts");
		//System.out.println("context="+content);
		
		Object accessToken = super.getHttpSessionAttribute(SessionAttrName.SINA_ACESS_TOKEN);
		String accessTokenStr = (accessToken!=null ? (String)accessToken : "");
		
		Object weiboActive = super.getHttpSessionAttribute(SessionAttrName.SINA_ACTIVE);
		int active = (weiboActive!=null ? (Integer)weiboActive : -1);
		
		Object sinaUserId = super.getHttpSessionAttribute(SessionAttrName.SINA_USERID);
		String sinaUserIdStr = (sinaUserId!=null ? (String)sinaUserId : "");
		
		SendWeiboDTO dto = new SendWeiboDTO();
		dto.setAccessToken(accessTokenStr);
		dto.setContent(content);
		dto.setWeiboActive(active);
		dto.setSinaUserId(sinaUserIdStr);
		try {
			weiboTokenService.sendSinaWeibo(dto);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*public static void main(String[] args) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("recommendId", 11);
		map.put("recommendUserId", 11);
		map.put("recommendTargetUserId", 11);
		map.put("recommendJobName", "1111");
		map.put("positionId", 11);
		map.put("recommendtest", 11);
		RecommendPosition rp = new RecommendPosition();
		
		long s_time = System.currentTimeMillis();
		for(int i=0; i<1000; i++) {
			BeanUtil.map2Bean(map, rp);
		}
		
		System.out.println("speed-time="+(System.currentTimeMillis()-s_time)+"ms");
		
	}*/

	@JSON(serialize=false)
	public IWeiboTokenService getWeiboTokenService() {
		return weiboTokenService;
	}

	public void setWeiboTokenService(IWeiboTokenService weiboTokenService) {
		this.weiboTokenService = weiboTokenService;
	}

	@JSON(name="result")
	public Map<String,Object> getResultMap() {
		return resultMap;
	}

	
	public void setResultMap(Map<String,Object> resultMap) {
		this.resultMap = resultMap;
	}
	
	@JSON(serialize=false)
	public IMyResumeService getResumeService() {
		return resumeService;
	}


	public void setResumeService(IMyResumeService resumeService) {
		this.resumeService = resumeService;
	}


	public static void main(String[] args) {
		Integer in = null;
		int i = in;
		
		System.out.println(i);
	}
	
	
}
