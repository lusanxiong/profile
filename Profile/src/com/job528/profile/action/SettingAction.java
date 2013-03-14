package com.job528.profile.action;

import com.job528.profile.model.MyUsers;
import com.job528.profile.service.IUserService;

public class SettingAction extends ResumeAction {
	private static final long serialVersionUID = 1L;
	private IUserService userService;
	private MyUsers account;
	
	public String execute() {
		if(!isLogin()) {
			return LOGIN;
		}
		account = this.resumeService.getAccountInfoByUserId(this.getUserId());
		return SUCCESS;
	}
	
	public String edit() {
		return execute();
	}
	
	public String update() {
		account = this.resumeService.getAccountInfoByUserId(this.getUserId());

		Short resumeStatus = Short.parseShort(this.getParameter("chkResumeStatus"));
		String partComName = this.getParameter("partComName");
		Short relationFlag = Short.parseShort(this.getParameter("chkRelationFlag"));
		account.setPartComName(partComName);
		account.setResumeStatus(resumeStatus);
		account.setRelationFlag(relationFlag);
		this.resumeService.updateAccountInfo(account);
		return null;
	}

	public MyUsers getAccount() {
		return account;
	}

	public void setAccount(MyUsers account) {
		this.account = account;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
}
