package com.job528.profile.action;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.job528.common.DataDictionary.JobFunction;
import com.job528.profile.model.MyWorkExp;
import com.job528.profile.vo.Experience;
import com.job528.util.BeanUtil;
import com.job528.util.StringUtil;
import com.job528.util.web.WebUtil;

public class ExperienceOldAction extends ResumeAction {
	private Logger logger = Logger.getLogger(ExperienceOldAction.class);
	
	private static final long serialVersionUID = 1L;
	private List<Experience> experiences = new ArrayList<Experience>();

	public String execute() {
		String exceptionDescription = "Action Exception:params="+WebUtil.getParameterMap(request)+"\n";
		
		MyWorkExp myWorkExp = new MyWorkExp();
		if(StringUtil.isValidStr(this.getParameter("did"))){
			
			myWorkExp.setId(Integer.parseInt(this.getParameter("did")));
			
			try {
				resumeService.deleteWorkExp(myWorkExp);
			}catch(Exception e) {
				e.printStackTrace();
				logger.error(exceptionDescription,e);
			}
		}
		if(StringUtil.isValidStr(this.getParameter("memName"))){
			BeanUtil.setObjectFromRequest(request, myWorkExp);
			myWorkExp.setMyUserId(this.getUserId());
			
			String jobFunctionId = this.getParameter("jobFunctionId");
			jobFunctionId = jobFunctionId != null ? jobFunctionId : "";
			
			int jobFunctionId_int = Integer.parseInt(JobFunction.EMPTY.toString());
			if(!"".equals(jobFunctionId.trim())) {
				jobFunctionId_int = Integer.parseInt(jobFunctionId);
			}
			myWorkExp.setJobFunctionId(jobFunctionId_int);
			if(myWorkExp.getOtherPosition() == null) {
				myWorkExp.setOtherPosition("");
			}
			
			try {
				resumeService.saveOrUpdate(myWorkExp);
			}catch(Exception e) {
				e.printStackTrace();
				logger.error(exceptionDescription,e);
			}
		}
		
		List<MyWorkExp>  workExps = null;
		try {
			workExps = resumeService.getWorkExpByUserId(this.getUserId());
		}catch(Exception e) {
			e.printStackTrace();
			logger.error(exceptionDescription,e);
		}
		
		if (workExps != null && workExps.size() > 0) {
			for (MyWorkExp workExp : workExps) {
				Experience experience = new Experience();
				experience.setMyWorkExp(workExp);
				experiences.add(experience);
			}
		}
		return SUCCESS;
	}


	public List<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}
}
