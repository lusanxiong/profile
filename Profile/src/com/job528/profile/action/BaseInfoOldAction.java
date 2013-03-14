package com.job528.profile.action;

import com.job528.profile.model.MyResume;
import com.job528.profile.service.IMyResumeService;
import com.job528.profile.util.ResumeUtil;
import com.job528.profile.vo.Resume;
import com.job528.util.BeanUtil;
import com.job528.util.DateUtil;
import com.job528.util.StringUtil;


public class BaseInfoOldAction extends ResumeAction {

	private static final long serialVersionUID = 1L;
	private Resume resume;

	public String execute() {
		resume = getLoginResume();
		
		if(StringUtil.isValidStr(this.getParameter("resId"))){
			MyResume myResume = resume.getMyResume();
			BeanUtil.setObjectFromRequest(request, myResume);
			myResume.setDegreeScript(ResumeUtil.getDegreeById(myResume.getDegreeId().toString()));
			myResume.setUpdateDate(DateUtil.getSqlDate(new java.util.Date()));
			resumeService.updateResume(myResume, true);
			resume.setMyResume(myResume);
			setLoginResume(resume);
		}
		
		return SUCCESS;
	}
	

	
	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public IMyResumeService getResumeService() {
		return resumeService;
	}
	
	public void setResumeService(IMyResumeService resumeService) {
		this.resumeService = resumeService;
	}
	
}
