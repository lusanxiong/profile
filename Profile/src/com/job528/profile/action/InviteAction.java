package com.job528.profile.action;

import java.util.ArrayList;
import java.util.List;

import com.job528.invite.Contact;
import com.job528.invite.ContactsImporter;
import com.job528.invite.email.EmailHelper;
import com.job528.invite.email.OneSixThreeImporter;
import com.job528.invite.email.OneTwoSixImporter;
import com.job528.invite.email.SinaImporter;
import com.job528.invite.email.SohuImporter;
import com.job528.invite.email.TomImporter;
import com.job528.invite.email.YahooImporter;
import com.job528.invite.email.YeahImporter;
import com.job528.invite.exception.ContactsException;
import com.job528.invite.google.GoogleImporter;
import com.job528.invite.msn.MSNImporter;
import com.job528.profile.vo.Resume;
import com.job528.util.StringUtil;

@SuppressWarnings("serial")
public class InviteAction extends ResumeAction {

	private List<Contact> contacts; 
	
	public String msnInvite() throws Exception {
		if(!isLogin()){
			return writeText("500");
		}
		boolean isValidate = "1".equals(StringUtil.trim(request.getParameter("isValidate")));
		String username = StringUtil.trim(request.getParameter("username"));
		String password = StringUtil.trim(request.getParameter("password"));
		MSNImporter importer = new MSNImporter(username, password);
		int resultCode = 0;
		try {
			contacts = importer.getContacts();
			if(null == contacts || contacts.isEmpty()){
				resultCode = 400;
			}
		} catch (Exception e) {
			resultCode = 404;//登录失败
		}
		if(isValidate) {
			return writeText(resultCode+"");
		}
		return SUCCESS;
	}

	public String importInvite() throws Exception {
		if(!isLogin()){
			return writeText("500");
		}
		ContactsImporter importer = null;
		String username = StringUtil.trim(request.getParameter("username"));
		String password = StringUtil.trim(request.getParameter("password"));
		String emailType = StringUtil.trim(request.getParameter("emailType"));
		boolean isValidate = "1".equals(StringUtil.trim(request.getParameter("isValidate")));
		if ("163".equals(emailType)) {
			importer = new OneSixThreeImporter(username + "@163.com", password);
		} else if ("126".equals(emailType)) {
			importer = new OneTwoSixImporter(username + "@126.com", password);
		} else if ("yeah".equals(emailType)) {
			importer = new YeahImporter(username + "@yeah.net", password);
		} else if ("sina".equals(emailType)) {
			importer = new SinaImporter(username + "@sina.com", password);
		} else if ("gmail".equals(emailType)) {
			importer = new GoogleImporter(username+ "@gmail.com", password);
		} else if ("sohu".equals(emailType)) {
			importer = new SohuImporter(username + "@sohu.com", password);
		} else if ("tom".equals(emailType)) {
			importer = new TomImporter(username + "@tom.com", password);
		} else if ("yahoo".equals(emailType)) {
			importer = new YahooImporter(username + "@yahoo.cn", password);
		} 
		int resultCode = 0;
		if(null!=importer){
			try {
				contacts = importer.getContacts();
				if(null == contacts || contacts.isEmpty()){
					resultCode = 400;
				}
			} catch (ContactsException e) {
				resultCode = 404;//登录失败
			}
		}
		if(isValidate) {
			return writeText(resultCode+"");
		}
		return SUCCESS;
	}

	public String sendMail() throws Exception {
		if(!isLogin()){
			return writeText("500"); //未登录
		}
		String emails = StringUtil.trim(request.getParameter("emails"));
		String userName = StringUtil.trim(request.getParameter("userName"));
		if("".equals(userName)) {
			userName = getLoginResume().getMyResume().getPerName();
		}
		if (StringUtil.isEmpty(emails)) {
			return writeText("404");
		}
		String[] emailArr = emails.split(";");
		List<String> list = null;
		if (emailArr.length > 0) {
			list = new ArrayList<String>();
			for (String email : emailArr) {
				if (StringUtil.isEmail(email)) {
					list.add(email);
				}
			}
		}
		EmailHelper.sendInvite(list,userName,StringUtil.getRootPath(request));
		return writeText("0");
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	
	//--------------------------------------
	
}
