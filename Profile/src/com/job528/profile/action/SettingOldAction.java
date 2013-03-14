package com.job528.profile.action;

import java.util.Date;

import com.job528.profile.model.MyResume;
import com.job528.profile.model.MyUsers;
import com.job528.profile.service.IUserService;
import com.job528.profile.vo.Resume;
import com.job528.util.StringUtil;


public class SettingOldAction extends ResumeAction {

	private IUserService userService;
	private MyUsers account;
	private String msg; 
	public String execute() {
		account = this.resumeService.getAccountInfoByUserId(this.getUserId());
		String action = this.getParameter("act") != null ?  this.getParameter("act") : "";
		if("0".equals(action)){
			Short resumeStatus = Short.parseShort(this.getParameter("chkResumeStatus"));
			String partComName = this.getParameter("partComName");
			Short relationFlag = Short.parseShort(this.getParameter("chkRelationFlag"));
			if(resumeStatus == 2){
				account.setPartComName(partComName);
			}
			account.setResumeStatus(resumeStatus);
			account.setRelationFlag(relationFlag);
			this.resumeService.updateAccountInfo(account);
			Resume resume = this.getLoginResume();
			MyResume myResume = resume.getMyResume();
			myResume.setRelationFlag(relationFlag);
			myResume.setResumeStatus(resumeStatus);
			java.sql.Date updateDate = new java.sql.Date(new Date().getTime());
			myResume.setUpdateDate(updateDate);
			this.resumeService.updateResume(myResume, false);
			resume.setMyResume(myResume);
			setLoginResume(resume);
			
		}else if("1".equals(action)){
			String oldPwd = this.getParameter("oldPwd");
			String newPwd =  this.getParameter("pwd");
			String newPwd1 =  this.getParameter("pwd1");
			
			if(StringUtil.isValidStr(oldPwd) && StringUtil.isValidStr(newPwd) && StringUtil.isValidStr(newPwd1)){
				if(!newPwd.equals(newPwd1)){
					msg = "两次密码不等！";
				}else{
//					account.setPassword(pwd);
//					this.resumeService.updateAccountInfo(account);
					
					userService.updatePassword(this.getUserId(), oldPwd, newPwd);
				}
			}
			
		}if("2".equals(action)){
			String email = this.getParameter("email").replace(" ", "");
			if(StringUtil.isEmail(email)){
				if(resumeService.verificateMail(this.getUserId(), email)){
					msg = "此邮箱已注册！";
				}else{
					account.setEmail(email);
					this.resumeService.updateAccountInfo(account);
					Resume resume = this.getLoginResume();
					MyResume myResume = resume.getMyResume();
					myResume.setEmail(email);
					java.sql.Date updateDate = new java.sql.Date(new Date().getTime());
					myResume.setUpdateDate(updateDate);
					this.resumeService.updateResume(myResume, false);
					resume.setMyResume(myResume);
					setLoginResume(resume);
				}
			}else{
				msg = "邮箱格式不正确！";
			}
		}
		return SUCCESS;
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
