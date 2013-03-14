package com.job528.profile.action;

import com.job528.profile.model.MyResume;
import com.job528.profile.util.ResumeUtil;
import com.job528.profile.vo.Resume;

public class ITSkillAction extends ResumeAction {

	private static final long serialVersionUID = 1L;
	private MyResume myResume = new MyResume();
	private String computerLevel;
	private Resume resume;
	
	
	public String execute() {
		resume = getLoginResume();
		myResume = resume.getMyResume();
		return SUCCESS;
	}
	
	public String edit() {
		return execute();
	}
	
	public String update() {
		resume = getLoginResume();
		myResume = resume.getMyResume();
		
		String techTitle = this.getParameter("techTitle");
		String computerLevel = this.getParameter("computerLevel");
		String computerSkills = this.getParameter("computerSkills");

		this.myResume.setTechTitle(techTitle);
		this.myResume.setComputerLevel(Short.valueOf(computerLevel));
		this.myResume.setComputerSkills(computerSkills);
		
		resumeService.updateResume(myResume,false);
		resume.setMyResume(myResume);
		setLoginResume(resume);

		return null;
	}

	public MyResume getMyResume() {
		return myResume;
	}

	public void setMyResume(MyResume myResume) {
		this.myResume = myResume;
	}

	public String getComputerLevel() {
		computerLevel = ResumeUtil.getComputerLevelById(this.myResume
				.getComputerLevel().toString());
		return computerLevel;
	}

	public void setComputerLevel(String computerLevel) {
		this.computerLevel = computerLevel;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	

}
