package com.job528.profile.action;

import com.job528.profile.model.MyResume;
import com.job528.profile.util.ResumeUtil;
import com.job528.profile.vo.Resume;
import com.job528.util.StringUtil;

public class AdditionalOldAction extends ResumeAction {

	private MyResume myResume = new MyResume();
	private String computerLevel;

	public String execute() {

		Resume resume = getLoginResume();
		myResume = resume.getMyResume();
		if (StringUtil.isValidStr(this.getParameter("edtag"))) {

			if (this.getParameter("edtag").equals("0")) {
				this.myResume.setOtherSkills(this.getParameter("otherSkills"));
			}else {
				String techTitle = this.getParameter("techTitle");
				String computerLevel = this.getParameter("computerLevel");
				String computerSkills = this.getParameter("computerSkills");

				this.myResume.setTechTitle(techTitle);
				this.myResume.setComputerLevel(Short.valueOf(computerLevel));
				this.myResume.setComputerSkills(computerSkills);
			}
			resumeService.updateResume(myResume,false);
			resume.setMyResume(myResume);
			setLoginResume(resume);
		}

		computerLevel = ResumeUtil.getComputerLevelById(this.myResume
				.getComputerLevel().toString());
		return SUCCESS;
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

	

}
