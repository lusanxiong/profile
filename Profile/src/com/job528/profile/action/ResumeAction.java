package com.job528.profile.action;

import com.job528.profile.model.MyResume;
import com.job528.profile.service.IMyResumeService;
import com.job528.profile.vo.Experience;
import com.job528.profile.vo.Resume;
import com.job528.util.webwork.GenericAction;

@SuppressWarnings("serial")
public class ResumeAction extends GenericAction {
	
	protected static final String LOGIN_USER_RESUME = "login_user_resume";
	protected IMyResumeService resumeService;
	
	public Resume getLoginResume() {
		
		if(getFromSession(LOGIN_USER_RESUME) != null){
			return (Resume)getFromSession(LOGIN_USER_RESUME);
		}
		Resume resume = new Resume();
		
		MyResume myResume = resumeService.getResumeByUserId(this.getUserId());
		resume.setMyResume(myResume);
		
		//获取会最近一次工作所担任的职务
		Experience ex = resumeService.getLastWorkExp(this.getUserId());
		resume.setLastPostName(ex.getPost());
		
		putSession(LOGIN_USER_RESUME, resume);
		return resume;
	}

	public void setLoginResume(Resume resume) {
		putSession(LOGIN_USER_RESUME, resume);
	}
	
	public Integer getScore() {
		return resumeService.getScore(getUserId());
//		request.setAttribute("score", score);
	}
	
	public IMyResumeService getResumeService() {
		return resumeService;
	}

	public void setResumeService(IMyResumeService resumeService) {
		this.resumeService = resumeService;
	}
}
