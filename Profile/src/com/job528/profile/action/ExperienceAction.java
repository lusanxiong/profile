package com.job528.profile.action;


import java.util.ArrayList;
import java.util.List;
import com.job528.common.DataDictionary.JobFunction;
import com.job528.profile.model.MyWorkExp;
import com.job528.profile.vo.Experience;
import com.job528.util.BeanUtil;
import com.job528.util.StringUtil;

public class ExperienceAction extends ResumeAction {
	
	private static final long serialVersionUID = 1L;
	private List<Experience> experiences = new ArrayList<Experience>();
	private String action;
	
	public String execute() {
		Integer id = StringUtil.toInteger(request.getParameter("id"), 0);
		List<MyWorkExp> workExps = resumeService.getWorkExpById(id,this.getUserId());
		if (workExps != null && workExps.size() > 0) {
			for (MyWorkExp workExp : workExps) {
				Experience experience = new Experience();
				experience.setMyWorkExp(workExp);
				
				experiences.add(experience);
			}
		}
		return SUCCESS;
	}
	
	
	public String all() {
		List<MyWorkExp> workExps = resumeService.getWorkExpByUserId(this.getUserId());
		if (workExps != null && workExps.size() > 0) {
			for (MyWorkExp workExp : workExps) {
				Experience experience = new Experience();
				experience.setMyWorkExp(workExp);
				experiences.add(experience);
			}
		}
		return SUCCESS;
	}
	
	
	
	public String edit() {
		return execute();
	}
	
	public String add() {
		Experience experience = new Experience();
		experiences.add(experience);
		action = "add";
		return SUCCESS;
	}
	
	public String del() {
		Integer id = StringUtil.toInteger(request.getParameter("id"), 0);
		MyWorkExp myWorkExp = new MyWorkExp();
		myWorkExp.setId(id);
		resumeService.deleteWorkExp(myWorkExp);
		return null;
	}
	
	public String merge() {
		MyWorkExp myWorkExp = new MyWorkExp();
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
		resumeService.saveOrUpdate(myWorkExp);
		return null;
	}



	public List<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
}
