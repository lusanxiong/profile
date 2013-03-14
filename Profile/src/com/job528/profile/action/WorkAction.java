package com.job528.profile.action;

import com.job528.profile.model.MyResume;
import com.job528.profile.vo.Resume;
import com.job528.util.StringUtil;

public class WorkAction extends ResumeAction {

	private static final long serialVersionUID = 1L;
	private Resume resume;

	public String execute() {
		resume = getLoginResume();
		return SUCCESS;
	}
	
	public String edit() {
		return execute();
	}
 
	public String update() {
		resume = getLoginResume();
		MyResume myResume = resume.getMyResume();
		Integer year = StringUtil.toInteger(request.getParameter("workedYear"),0);
		Integer month = StringUtil.toInteger(request.getParameter("workedMonth"),0);
		Short comNumber = 0;
		try {
			comNumber = Short.valueOf(request.getParameter("workedComNumber"));
		} catch (NumberFormatException e) {
			comNumber = 0;
		}
		myResume.setWorkedYear(year);
		myResume.setWorkedMonth(month);
		myResume.setWorkedComNumber(comNumber);
		resumeService.updateResume(myResume,false);
		setLoginResume(resume);
		return null;
	}


	public Resume getResume() {
		return resume;
	}


	public void setResume(Resume resume) {
		this.resume = resume;
	}
	
	
}
