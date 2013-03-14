package com.job528.profile.action;



import java.util.Map;

import javax.servlet.http.HttpSession;

import com.job528.common.DataDictionary.SessionAttrName;
import com.job528.common.DataDictionary.WeiboActive;
import com.job528.ejb.entity.TencentToken;
import com.job528.ejb.entity.UserProfile;
import com.job528.ejb.entity.WeiboToken;
import com.job528.profile.service.IPositionService;
import com.job528.profile.service.ITencentWeiBoService;
import com.job528.profile.service.IUserProfileService;
import com.job528.profile.service.IUserService;
import com.job528.profile.service.IWeiboTokenService;
import com.job528.profile.vo.Position;
import com.job528.util.Pager;
import com.job528.util.StringUtil;



@SuppressWarnings("serial")
public class HomeAction extends ResumeAction {

	private IUserProfileService userProfileService;
	private IPositionService positionService;
	private IUserService userService;
	private Pager<Position> positionPager = new Pager<Position>();
	private UserProfile userProfile;
	private IWeiboTokenService weiboTokenService;
	private ITencentWeiBoService  tencentWeiBoService;
	private String userForwardPage; //用于存储用户登录之后需要转向的页面。
	
	private String sinaStatus;
	private String tencentStatus;
	

	@Override
	public String execute() throws Exception {
		if(!isLogin()){
			return LOGIN;
		}
		
		Object weiboActive = super.getHttpSessionAttribute(SessionAttrName.SINA_ACTIVE);
		int sinaActive = (weiboActive!=null ? (Integer)weiboActive : 0);
		sinaStatus = WeiboActive.getName(sinaActive);

		Map<SessionAttrName, Object> map = sessionService.getUserSessionData(getUserId());
		Object activeObj = map.get(SessionAttrName.TENCENT_ACTIVE);
		int tencentActive = (activeObj!=null?(Integer)activeObj:0);
		tencentStatus = WeiboActive.getName(tencentActive); 
		
		userProfile = userProfileService.getUserProfileById(getUserId());
		positionPager = positionService.getIntentionPosition(getLoginResume(),1,20);
		if(positionPager.getList() == null){
			positionPager = positionService.getSimpleIntentionPosition(this.getLoginResume(), 1, 20);
		}
		
		//528用户绑定新浪微博账户
		bingWeiboAccount(); 
		
		//腾讯绑定528用户（参照新浪）
		boundTencentAccount();
		
		//转向用户登录之前访问的页面
		if(isForwardUserLastURL()) {
			HttpSession session = request.getSession(true);
			session.removeAttribute(SessionAttrName.USER_OPEN_HISTORY_URL.toString());
			return "forwardUserAccessPage";
			
		}
		
		return SUCCESS;
	}
	
	/**
	 * 528用户在使用新浪微博授权时，登录绑定微博账户
	 * 
	 * 如果登录后，有sinaUserId传过来说明需要绑定微博账号
	 */
	private void bingWeiboAccount() {
		WeiboToken weiboToken = new WeiboToken();
		
		String userId = super.getUserIdFromCookie();
		
		String sinaUserId = request.getParameter("sinaUserId");
		String accessToken = request.getParameter("accessToken");
		if(sinaUserId==null || accessToken==null ||
		   "".equals(sinaUserId) || accessToken.equals("")) {
			return;
		}
		
		weiboToken.setSinaUserId(sinaUserId);
		weiboToken.setUserId(Integer.parseInt(userId));
		weiboToken.setToken(accessToken);
		
		//设置同步
		weiboTokenService.weiboSyn(weiboToken);
	}
	
	public void boundTencentAccount(){

		TencentToken tt = new TencentToken();
		
		String userId = super.getUserIdFromCookie();
		
		String openid = request.getParameter("openid");
		String accessToken = request.getParameter("tencentAccessToken");
		if(openid==null || accessToken==null ||
		   "".equals(openid) || accessToken.equals("")) {
			return;
		}
		
         tt.setUserId(Integer.parseInt(userId));
         tt.setTencentUserId(openid);
         tt.setToken(accessToken);
		
		//设置同步
		tencentWeiBoService.addTencentToken(tt);
	
	}
	
	/**
	 * 记录用户在没有登录之前访问过的URL。登录后重定向到该URL
	 * @return
	 */
	private boolean isForwardUserLastURL() {
		
		//获取最近一次没有登录访问用户访问的页面URL
		Object userUrl = super.getHttpSessionAttribute(SessionAttrName.USER_OPEN_HISTORY_URL);
		if(userUrl != null) {
			String userUrlStr = (String)userUrl;
			//System.out.println("userUrlStr=="+userUrlStr);
			
			if(!userUrlStr.equals("/Profile/") && !userUrlStr.equals("/Profile/home.jsp") 
				&& !userUrlStr.equals("/Profile/home.shtml")
				&& !userUrlStr.equals("index.jsp")
				&& !userUrlStr.equals("index.shtml")) {
				
				if(userUrlStr.indexOf("/Profile") > -1) {
					userUrlStr = userUrlStr.replace("/Profile", "");
					//System.out.println("userUrlStr===3="+userUrlStr);
				}
				userForwardPage = userUrlStr;
				return true;
			}
		}
		
		return false;
	}
	
	public String first(){
		int userId = StringUtil.getIntValue(this.getParameter("uid"), 0);
		this.userService.initUserInfoFristTime(userId);
		return SUCCESS;
	}
	
	public IUserProfileService getUserProfileService() {
		return userProfileService;
	}

	public void setUserProfileService(IUserProfileService userProfileService) {
		this.userProfileService = userProfileService;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public Pager<Position> getPositionPager() {
		return positionPager;
	}

	public void setPositionPager(Pager<Position> positionPager) {
		this.positionPager = positionPager;
	}

	public IPositionService getPositionService() {
		return positionService;
	}

	public void setPositionService(IPositionService positionService) {
		this.positionService = positionService;
	}


	public IUserService getUserService() {
		return userService;
	}


	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	public IWeiboTokenService getWeiboTokenService() {
		return weiboTokenService;
	}

	public void setWeiboTokenService(IWeiboTokenService weiboTokenService) {
		this.weiboTokenService = weiboTokenService;
	}

	public String getUserForwardPage() {
		return userForwardPage;
	}

	public void setUserForwardPage(String userForwardPage) {
		this.userForwardPage = userForwardPage;
	}

	
	public ITencentWeiBoService getTencentWeiBoService() {
		return tencentWeiBoService;
	}

	public void setTencentWeiBoService(ITencentWeiBoService tencentWeiBoService) {
		this.tencentWeiBoService = tencentWeiBoService;
	}

	public String getSinaStatus() {
		return sinaStatus;
	}

	public void setSinaStatus(String sinaStatus) {
		this.sinaStatus = sinaStatus;
	}

	public String getTencentStatus() {
		return tencentStatus;
	}

	public void setTencentStatus(String tencentStatus) {
		this.tencentStatus = tencentStatus;
	}
	
}
