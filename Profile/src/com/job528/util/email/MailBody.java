package com.job528.util.email;

import com.job528.util.email.Email.MailType;

public class MailBody {

	private String toEmail;
	private String mailTitle;
	private String mailContent;
	private MailType mailType; //邮件类型
	
	
	/*
	 *因推荐职位的邮件内容 
	 */
	
	public String getToEmail() {
		return toEmail;
	}
	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}
	public String getMailTitle() {
		return mailTitle;
	}
	public void setMailTitle(String mailTitle) {
		this.mailTitle = mailTitle;
	}
	public String getMailContent() {
		return mailContent;
	}
	public void setMailContent(String mailContent) {
		this.mailContent = mailContent;
	}
	public MailType getMailType() {
		return mailType;
	}
	public void setMailType(MailType mailType) {
		this.mailType = mailType;
	}
	
}
