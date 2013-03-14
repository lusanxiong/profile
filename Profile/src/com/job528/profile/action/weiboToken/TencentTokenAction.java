package com.job528.profile.action.weiboToken;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.googlecode.jsonplugin.annotations.JSON;
import com.job528.common.DataDictionary.SessionAttrName;
import com.job528.common.DataDictionary.WeiboActive;
import com.job528.ejb.entity.TencentToken;
import com.job528.profile.LoginInfo;
import com.job528.profile.service.IMyResumeService;
import com.job528.profile.service.ITencentWeiBoService;

import com.job528.tencent.weibo.WeiBoOAuth;
import com.job528.util.webwork.GenericAction;

public class TencentTokenAction extends GenericAction{
	private static final long serialVersionUID = 1L;
	private ITencentWeiBoService tencentWeiBoService;
	private IMyResumeService   resumeService;
	private Map<String,Object> map=new HashMap<String,Object>();
	
	
	//腾讯微博登录
	public String tencentToken(){
		String code = request.getParameter("code");
		String openid = request.getParameter("openid");//openid腾讯微博用户唯一对应
        String openkey = request.getParameter("openkey");	
	    String responseData="code="+code+"&openid="+openid+"&openkey="+openkey;
		String accessToken = WeiBoOAuth.getToken(responseData);	
		boolean flag = true;
		boolean isBoundAccount = false;//是否已经绑定账户
		//先找用户userID
		if(null == openid||"".equals(openid)){
			flag = false;
		}
		if(null==code||"".equals(code)){
			flag = false;
		}
		if(null==openkey||"".equals(openkey)){
			flag = false;
		}

	     int  userId = tencentWeiBoService.getUserIdByOpenid(openid);
	     //用来判断用户是否登录 
	     boolean isLogin = isLogin();	
			//直接更新accessToken
	     if(isLogin){
	    	 //认证绑定用户
	    	 synTencentWeibo(openid,accessToken,this.getLoginInfo().getLoginUserId());
	    	 isBoundAccount = true;
	     }else{
	    	 if(userId!=0){    	
		    	 isBoundAccount = true;
		    	 int id=tencentWeiBoService.sycTencentUpdate(openid,accessToken);
		    	
		    	 if(id!=0){
						
					   //兼容528普通方式登录(主要是存储用户的cookie信息)
						int result = useLogin(userId);
						flag = (result<=-1 ? false : true);	
						setUserSesssionAllAttr();
					}else{
		    		 flag=false;
		    	 }
		    	 
			}	 
	     }
		     		  
		   
	     
	     map.put("flag", flag);
	     map.put("isBoundAccount", isBoundAccount);
	     map.put("userId", userId);
	     map.put("openid", openid);
		 map.put("accessToken", accessToken);
		 map.put("isLogin", isLogin);
	   return SUCCESS;
	}

	
	//老用户与腾讯微博绑定
	public String synTencentWeibo(String openid,String accessToken,int loginUserId){
		
		boolean flag = true;
		
		map = new HashMap<String,Object>();

	    if(openid==null||"".equals(openid)){
	    	flag = false;
	    }	
	    if(accessToken==null||"".equals(accessToken)){
	    	flag = false;
	    }
		TencentToken tt = new TencentToken();	
		tt.setTencentUserId(openid);
		tt.setUserId(loginUserId);
		tt.setToken(accessToken);
		
		//设置同步
	   int id=tencentWeiBoService.addTencentToken(tt);
		if(id != 0) {
			flag = true;//执行成功!
			setUserSesssionAllAttr();
		}else {
			flag = false;
		}
		
		//返回结果
		map.put("flag",flag);
		return SUCCESS;
	
	}
	
	private int useLogin(int userId) {
		LoginInfo loginInfo = new LoginInfo(request, response);
		String ip = request.getRemoteAddr();
		int result = resumeService.login(userId, ip, loginInfo);
		
    	HttpSession session = request.getSession();
    	session.setAttribute(LoginInfo.LOGIN_USER_RESUME, null);
    	
    	return result;
	}
	
	
	//用腾讯微博注册528用户
	public String tencentWeiboReg() throws Exception {
		boolean flag = true;		
		TencentToken tt = new TencentToken();
		
		//获取用户授权信息
		String userId =(String) request.getParameter("userId");
		if(null == userId || "".equals(userId)) {
			flag = false;
		}
			
		String openid =(String) request.getParameter("openid");

		if(null== openid|| "".equals(openid)){
			flag = false;
		}
					
		String accessToken =(String) request.getParameter("accessToken");
		if(null== accessToken || "".equals(accessToken)){
			flag = false;
		}
				
		 tt.setToken(accessToken);
    	 tt.setTencentUserId(openid);
    	 tt.setUserId(Integer.parseInt(userId));	
		//设置同步
    	 int id=tencentWeiBoService.addTencentToken(tt);
    	 if(id!=0){			
			    flag= true;
				setUserSesssionAllAttr();
			}else{
    		 flag=false;
    	 }
		
		//返回jsonp格式字符
		writeText("var result={flag:\""+String.valueOf(flag)+"\"}");
		return SUCCESS;
	}
	
	
	//删除腾讯微博的同步(把绑定的记录删除)
	public String delTencentWeibo(){
		boolean flag = true;
		Map<SessionAttrName, Object> mapva = getUserSessionAllValue();
		Object openid = mapva.get(SessionAttrName.TENCENT_OPENID);
		String openId = (openid!=null ? (String)openid : "");		
		int userId = this.getLoginInfo().getLoginUserId();
		
		int count = tencentWeiBoService.deleteTencentWeiBo(userId, openId);
		
		if(count==1){
			//删除成功 状态变成未同步 并认证
			flag = true;
			super.setHttpSession(SessionAttrName.TENCENT_ACTIVE, Integer.parseInt(WeiboActive.ACTIVE_NO.toString()));
		}else{
			flag = false;
		}
		
		//返回结果
		map.put("flag",flag);
		
		return SUCCESS;
	}
	
	
	//暂停腾讯微博的同步(ative更新为2)
	 public String pauseTencentWeibo(){
		 boolean flag = true;
		 Map<SessionAttrName, Object> mapva = getUserSessionAllValue();
		 map = new HashMap<String,Object>();
		 Object openid = mapva.get(SessionAttrName.TENCENT_OPENID);
		 String tencentId = (openid!=null?(String)openid:"");
		 if(tencentId==""){
			 flag = false;
		 }
		 //暂停同步
		 int count = tencentWeiBoService.pauseTencentWeibo(tencentId);
		 if(count==1){
			 flag = true;
		     //更行状态
		    super.setHttpSession(SessionAttrName.TENCENT_ACTIVE,Integer.parseInt(WeiboActive.ACTIVE_PAUSE.toString()));
		 }else{
			 flag = false;
		 }
		 map.put("flag", flag);
		 return SUCCESS;
	 }
	 
     //恢复同步功能(更新active为1）
	 public String recoverTencentWeibo(){

		 boolean flag = true;
		 Map<SessionAttrName, Object> mapva = getUserSessionAllValue();
		 map = new HashMap<String,Object>();
		 Object openid = mapva.get(SessionAttrName.TENCENT_OPENID);
		 String tencentId = (openid!=null?(String)openid:"");
		 if(tencentId==""){
			 flag = false;
		 }
		 //暂停同步
		 int count = tencentWeiBoService.recoverTencentWeibo(tencentId);
		 if(count==1){
			 flag = true;
		     //更行状态
		    super.setHttpSession(SessionAttrName.TENCENT_ACTIVE,Integer.parseInt(WeiboActive.ACTIVE_ING.toString()));
		 }else{
			 flag = false;
		 }
		 map.put("flag", flag);
		 return SUCCESS;
	 }
 

	//用json来返回msg
	@JSON(name="result")
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	
	@JSON(serialize=false)
	public ITencentWeiBoService getTencentWeiBoService() {
		return tencentWeiBoService;
	}
	public void setTencentWeiBoService(ITencentWeiBoService tencentWeiBoService) {
		this.tencentWeiBoService = tencentWeiBoService;
	}
	
	
	@JSON(serialize=false)
	public IMyResumeService getResumeService() {
		return resumeService;
	}
	public void setResumeService(IMyResumeService resumeService) {
		this.resumeService = resumeService;
	}
}
