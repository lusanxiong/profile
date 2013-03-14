package com.job528.profile.action;



public class LogOutAction extends ResumeAction {
	
	public String execute() {
		this.getLoginInfo().logOut();
		this.removeSession(LOGIN_USER_RESUME);
		this.removeSessionAllAttributes();
		return SUCCESS;
	}	
}
