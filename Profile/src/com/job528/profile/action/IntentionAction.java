package com.job528.profile.action;

import com.job528.profile.model.MyResume;
import com.job528.profile.vo.Intention;
import com.job528.profile.vo.Resume;
import com.job528.util.BeanUtil;
import com.job528.util.StringUtil;

public class IntentionAction extends ResumeAction {

	private static final long serialVersionUID = 1L;
	private Intention intention;

	public String execute() {
		loadIntention();
		return SUCCESS;
	}

	public String edit() {
		loadIntention();
		return SUCCESS;
	}

	public String update() {
		Resume resume = getLoginResume();
		MyResume myResume = resume.getMyResume();

		BeanUtil.setObjectFromRequest(request, myResume);
		if ("on".equals(this.getParameter("houseNeeded"))) {
			myResume.setHouseNeeded(true);
		} else {
			myResume.setHouseNeeded(false);
		}
		resumeService.updateResume(myResume, false);
		resume.setMyResume(myResume);
		setLoginResume(resume);

		intention = new Intention();
		intention.setMyResume(myResume);
		return SUCCESS;
	}

	private void loadIntention() {
		Resume resume = getLoginResume();
		MyResume myResume = resume.getMyResume();
		intention = new Intention();
		intention.setMyResume(myResume);
	}

	public int getPostType() {
		String dg = this.intention.getMyResume().getCheckinDate();
		if (StringUtil.isValidStr(dg)) {
			if ("随时到岗".equals(dg)) {
				return 0;
			} else if (dg.length() > 2) {
				return 1;
			} else {
				return 2;
			}
		}
		return 0;
	}

	public Intention getIntention() {
		return intention;
	}

	public void setIntention(Intention intention) {
		this.intention = intention;
	}

}
