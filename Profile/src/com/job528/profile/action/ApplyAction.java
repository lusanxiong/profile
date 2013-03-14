package com.job528.profile.action;

import java.util.Map;

import com.job528.profile.model.MyResume;
import com.job528.util.StringUtil;

public class ApplyAction extends ResumeAction {
	
	private String message = "";
	public String execute() {
		String posId = this.getParameter("posId");
		
		
		return this.SUCCESS;
	}
	

	
	private String passResume(){
		MyResume resume = this.getLoginResume().getMyResume();
		
		if(resume.getResumeStatus() == 3){
			return "您的简历已经删除,请重新注册您的简历。";
		}
		
		if(resume.getCheckFlag() == 0)
			return "您的简历注册还没完成，请登录个人管理中心进行修改。";
		if(resume.getCheckFlag() == 1)
			return "您的简历待审核，原因是简历不完整，请登录个人管理中心完善您的简历。";
		
		if(resume.getCheckFlag() == 3 || resume.getCheckFlag() == 4)
			return "您的简历过于简单或错误太多，不能通过我们的审核,暂时不能向目标公司发送邮件，请更新后等待我们的相关人员审核后再应聘！";
		
		return "";
	}
	
	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
