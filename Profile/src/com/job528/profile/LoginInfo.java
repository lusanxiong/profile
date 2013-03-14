package com.job528.profile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.job528.profile.vo.Resume;
import com.job528.util.StringUtil;
import com.job528.util.web.Cookies;
import com.job528.util.web.WebUtil;

public class LoginInfo {

	public static final String LOGIN_USER_RESUME = "login_user_resume";
	public static final String LOGIN_USER_ID = "cookieUserId";
	
	private Cookies cookie = new Cookies();
	private HttpSession session;
	private HttpServletResponse response;
	private HttpServletRequest request;
	private String domain;

	private String getUserId() {
		return cookie.getCookie(request, LOGIN_USER_ID);
	}

	public LoginInfo(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		session = this.request.getSession(true);
		domain = WebUtil.getDomain(request);
	}

	public boolean isLogin() {
		if (StringUtil.isValidStr(this.getUserId())) {
			return true;
		}
		return false;
	}

	public int getLoginUserId() {
		if (!this.isLogin())
			return -1;
		return Integer.parseInt(this.getUserId());
	}

	public void setLoginUserId(String userId){
		request.setAttribute(LOGIN_USER_ID, userId);
		cookie.putCookie(this.response, LOGIN_USER_ID, userId,this.domain);
	}
	
	public void setResId(String resId){
		request.setAttribute("resId", resId);
		cookie.putCookie(this.response, "resId", resId,this.domain);
	}
	
	public void setResumeUserID(String userId){
		request.setAttribute("resumeUserID", userId);
		cookie.putCookie(this.response, "resumeUserID", userId,this.domain);
	}
	
	public void setResumeUserName(String resumeUserName){
		request.setAttribute("resumeUserName", resumeUserName);
		cookie.putCookie(this.response, "resumeUserName", resumeUserName,this.domain);
	}
	
	public void setResumePassWord(String resumePassWord){
		request.setAttribute("resumePassWord", resumePassWord);
		cookie.putCookie(this.response, "resumePassWord", resumePassWord,this.domain);
	}
	
	
	public void setResumePerName(String resumePerName){
		request.setAttribute("resumePerName", resumePerName);
		cookie.putCookie(this.response, "resumePerName", resumePerName,this.domain);
	}
	
	public void setResumeEamil(String resumeEamil){
		request.setAttribute("resumeEamil", resumeEamil);
		cookie.putCookie(this.response, "resumeEamil", resumeEamil,this.domain);
	}
	
	public void setResumeResumeStatus(String resumeResumeStatus){
		request.setAttribute("resumeResumeStatus", resumeResumeStatus);
		cookie.putCookie(this.response, "resumeResumeStatus", resumeResumeStatus,this.domain);
	}
	
	public void setResumeMemberClass(String resumeMemberClass){
		request.setAttribute("resumeMemberClass", resumeMemberClass);
		cookie.putCookie(this.response, "resumeResumeStatus", resumeMemberClass,this.domain);
	}
	
	public void setEngResumeFlag(String EngResumeFlag){
		request.setAttribute("EngResumeFlag", EngResumeFlag);
		cookie.putCookie(this.response, "EngResumeFlag", EngResumeFlag,this.domain);
	}
	
	
	public void setCheckFlag(String CheckFlag){
		request.setAttribute("CheckFlag", CheckFlag);
		cookie.putCookie(this.response, "CheckFlag", CheckFlag,this.domain);
	}
	
	public Resume getLoginResume() {
		if (session.getAttribute(LOGIN_USER_RESUME) != null) {
			return (Resume) session.getAttribute(LOGIN_USER_RESUME);
		}
		return null;
	}

	public void setLoginResume(Resume resume) {
		session.setAttribute(LOGIN_USER_RESUME, resume);
	}

	public void logOut(){
		this.setLoginUserId(null);
		this.setCheckFlag(null);
		this.setEngResumeFlag(null);
		this.setResId(null);
		this.setResumeEamil(null);
		this.setResumeMemberClass(null);
		this.setResumePassWord(null);
		this.setResumePerName(null);
		this.setResumeResumeStatus(null);
		this.setResumeUserID(null);
		this.setResumeUserName(null);
	}
	
	
}
