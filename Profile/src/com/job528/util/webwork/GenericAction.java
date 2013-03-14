package com.job528.util.webwork;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.estelsource.common.exception.ErrorCode;

import com.job528.common.DataDictionary.SessionAttrName;
import com.job528.profile.LoginInfo;
import com.job528.profile.service.ISessionService;
import com.job528.profile.vo.Profile;
import com.job528.util.StrUtils;
import com.job528.util.StringUtil;
import com.job528.util.log.MyLog;
import com.job528.util.web.DateConverter;
import com.job528.util.web.GlobalForward;
import com.job528.util.web.WebUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 通用的Action，提供Request参数的获取。
 * 
 */
@SuppressWarnings("serial")
public class GenericAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware {

	protected static final MyLog log = MyLog.getLogger(GenericAction.class);
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	private static final String LOGIN_USER_PROFILE = "login_user_profile";
	public ISessionService sessionService;

	public enum ExceptionCode {
		@ErrorCode(comment = "The exception occured when calling member service.")
		CALL_MEMBER_SERVICE_ERROR,

		@ErrorCode(comment = "The exception occured when calling credit card service.")
		CALL_CREDITCARD_SERVICE_ERROR

	}

	// protected LoginInfo loginInfo = new LoginInfo(getRequest(),
	// getHttpResponse());

	public LoginInfo getLoginInfo() {
		LoginInfo loginInfo = new LoginInfo(getRequest(), getHttpResponse());
		return loginInfo;
	}

	static {
		register();

	}

	/**
	 * 注册日期格式转换类 主要是为struts的BeanUtils的类，提供日期转换格式的插件。 否则，BeanUtils则将字符串转为日期时，会报错
	 */
	private static void register() {
		ConvertUtils.register(new DateConverter(), Date.class);
	}

	/**
	 * 清除Session
	 */
	protected void clearSession() {
		// roleUser = (UserWrapper) getFromSession("onlineRoleUser");
		ActionContext.getContext().getSession().clear();
		// putSession("onlineRoleUser", roleUser);
	}

	/**
	 * 应当对此方法进行限制使用
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected Map getSession() {
		return ActionContext.getContext().getSession();
	}

	@SuppressWarnings("unchecked")
	protected void putSession(Object key, Object value) {
		ActionContext.getContext().getSession().put(key, value);
		
	}

	@SuppressWarnings("unchecked")
	protected void removeSession(Object key) {
		ActionContext.getContext().getSession().remove(key);
		ActionContext.getContext().getSession().put(key, null);
	}
	protected Object getFromSession(Object key) {
		return getSession().get(key);
	}

	/**
	 * 跳转错误页面 记录错误信息到日志中
	 * 
	 * @param message
	 * @return
	 */
	protected String forwardError(String message) {
		// System.err.println("GenericAction:"+message);
		// log.error(message);
		super.addActionError(message);

		return GlobalForward.FORWARD_TO_ERROR;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

		request.setAttribute("basePath", StringUtil.getBasePath(request));
		request.setAttribute("cookieUserId", getUserId());
	}

	/**
	 * 改方法输出信息到response中,并返回null,用户ajax请求
	 * 
	 * @param msg
	 * @return String
	 * @throws IOException
	 */
	protected String writeJson(String msg) throws IOException {
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(msg);
		out.close();
		return null;
	}

	protected String writeText(String msg) throws IOException {
		PrintWriter out = response.getWriter();
		out.print(msg);
		out.close();
		return null;
	}

	/**
	 * 判断是否登录, 登录true ,未登录 false
	 * 
	 * @return boolean
	 */
	protected boolean isLogin() {
		return this.getLoginInfo().isLogin();
	}

	/**
	 * 判断是否登录, 登录true ,未登录 false
	 * 
	 * @return boolean
	 */
	protected Integer getUserId() {
		return this.getLoginInfo().getLoginUserId();
	}

	/**
	 * 获取客户端ip
	 */
	protected String getIp() {
		return request.getRemoteAddr();
	}

	/**
	 * 获取主站域名
	 * 
	 * @return
	 */
	public String getJob528Domain() {
		return "http://www" + WebUtil.getDomain(request);
	}

	protected String getParameter(String key) {
		if (StringUtil.isValidStr(key))
			return request.getParameter(key);
		return "";
	}

	protected String getRequestValue(String key, String defValue) {
		if (StrUtils.isNull(key))
			return "";
		if (StrUtils.isNull(request.getParameter(key)))
			return defValue;
		return request.getParameter(key);
	}

	public Profile getLoginUserProfile() {
		if (this.getFromSession(LOGIN_USER_PROFILE) != null) {
			return (Profile) this.getFromSession(LOGIN_USER_PROFILE);
		}
		return null;
	}

	public void setLoginUserProfile(Profile profile) {
		this.putSession(LOGIN_USER_PROFILE, profile);
	}

	public HttpServletResponse getHttpResponse() {
		ActionContext ctx = ActionContext.getContext();
		response = (HttpServletResponse) ctx
				.get(ServletActionContext.HTTP_RESPONSE);
		return response;
	}
	
	public HttpServletRequest getRequest() {
		ActionContext ctx = ActionContext.getContext();
		request = (HttpServletRequest) ctx
				.get(ServletActionContext.HTTP_REQUEST);
		return request;
	}

	public int getPage() {
		return StringUtil.getIntValue(this.getParameter("page"), 1);
	}
	
	/**
	 * 存放session
	 * 
	 * @param sessionMap: 存放session属性键值对
	 * 
	 * @return 把指定的session属性键值对存入servelt session中。
	 */
	public void setHttpSession(Map<SessionAttrName, Object> sessionMap) {
		if(sessionMap==null || sessionMap.size()==0)
			return;
		
		HttpSession session = request.getSession(true);
		for(Map.Entry<SessionAttrName, Object> m : sessionMap.entrySet()) {
			 if(m.getValue() == null || "".equals(m.getValue()) || m.getKey() == null) {
				 continue;
			 }
			 
			 session.setAttribute(m.getKey().toString(), m.getValue());
		}
		////System.out.println("sessionid1=="+session.getId());
	}
	
	/**
	 * 存放session
	 * 
	 * @param SessionAttrName: 属性名
	 * @param attrValue :属性值
	 * 
	 * @return 把指定的session属性键值对存入servelt session中。
	 */
	public void setHttpSession(SessionAttrName attrName, Object attrValue) {
		HttpSession session = request.getSession(true);
		
		if(attrValue != null && !"".equals(attrValue)) {
			session.setAttribute(attrName.toString(), attrValue);
		}
	}
	
	/**
	 * 移除session
	 * 
	 * @param SessionAttrName: 属性名
	 * @param attrValue :属性值
	 * 
	 * @return 把指定的session属性键值对存入servelt session中。
	 */
	public void removeSessionAllAttributes() {
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			/*Object[] obj = SessionAttrName.values();
			for(Object o : obj) {
				//System.out.println("o==="+o);
				session.removeAttribute(obj.toString());
			}*/
			session.invalidate();
		}
		
	}
	
	/**
	 * 获取session属性
	 * 
	 * @param attrName:属性名称
	 * 
	 * @return 属性值
	 */
	public Object getHttpSessionAttribute(SessionAttrName attrName) {
		HttpSession session = request.getSession(false);
		//System.out.println("sessionid2=="+session.getId());
		
		if(session != null) {
			Object isReadDatabase = session.getAttribute(SessionAttrName.IS_READ_DATABASE.toString());
			//System.out.println("isReadDatabase=="+isReadDatabase);
			
			//session中的属性值已经读取过数据库。
			if(isReadDatabase!=null && (Boolean)isReadDatabase) {
				//System.out.println(attrName.toString()+"==key value="+session.getAttribute(attrName.toString()));
				return session.getAttribute(attrName.toString()); //直接从session中取
			}
		}
		
		//System.out.println("sessionid2.2=="+session.getId());
		
		//重新往session中存入所需的值
		setUserSesssionAllAttr();
		
		return session.getAttribute(attrName.toString());
	}

	public ISessionService getSessionService() {
		return sessionService;
	}

	public void setSessionService(ISessionService sessionService) {
		this.sessionService = sessionService;
	}
	
	/*
	 * 重新设置该用户的全部session属性
	 */
	public void setUserSesssionAllAttr() {
		String userIdStr = getUserIdFromCookie();
		//System.out.println("userIdStr=="+userIdStr);
		int userId = ( (userIdStr!=null&&!userIdStr.equals(""))  ? Integer.parseInt(userIdStr) : 0);
    	if(userId == 0) return;
    	
    	Map<SessionAttrName, Object> sessionMap = sessionService.getUserSessionData(userId);
    	//System.out.println("sessionMap=="+sessionMap);
    	setHttpSession(sessionMap);
	}
	//得到用户的session属性
	public Map<SessionAttrName, Object>  getUserSessionAllValue(){
		String userIdStr = getUserIdFromCookie();
		int userId = ( (userIdStr!=null&&!userIdStr.equals(""))  ? Integer.parseInt(userIdStr) : 0);
    	if(userId == 0) return null;
    	Map<SessionAttrName, Object> sessionMap = sessionService.getUserSessionData(userId);
    	
    	return sessionMap;
	}
	/*
	 * 重新设置该用户的全部session属性
	 */
	public void setUserSesssionAllAttr(int userid) {
    	Map<SessionAttrName, Object> sessionMap = sessionService.getUserSessionData(userid);
    	setHttpSession(sessionMap);
	}
	
	/*
	 * 从cookie中获取userId值
	 */
	public String getUserIdFromCookie() {
		Cookie[] cookies = request.getCookies();
		String userId = "";
    	if(null!=cookies){
    		String userIdKey = LoginInfo.LOGIN_USER_ID;
    		for(int i=0;i<cookies.length;i++){
    			if(cookies[i].getName().indexOf(userIdKey) > -1){
    				userId = cookies[i].getValue();
    				return userId;
    			}
    		}
    	}
    	
    	return userId;
	}
	
	/**
	 * 获取网站的基础路径
	 */
	public String getBasePath() {
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
		
		return basePath;
	}
}
