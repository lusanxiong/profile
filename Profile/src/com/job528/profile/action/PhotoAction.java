package com.job528.profile.action;


import com.job528.profile.model.MyResume;
import com.job528.profile.vo.Resume;

public class PhotoAction extends ResumeAction {

	private static final long serialVersionUID = 1L;
	private MyResume myResume;
    
	public String execute() {
		myResume = this.getLoginResume().getMyResume();
		return SUCCESS;
	}
	
	public String shield() throws Exception {
		Resume resume = getLoginResume();
		myResume = resume.getMyResume();
		//0 没有头像 1屏蔽头像 2显示头像
		Short photoflag = 2; //默认显示
		try {
			photoflag = Short.valueOf(request.getParameter("photoflag"));
		} catch (NumberFormatException e) {
			photoflag = 2;
		}
		myResume.setPhotoflag(photoflag);
		resumeService.updateResume(myResume, false);
		resume.setMyResume(myResume);
		setLoginResume(resume);
		return writeText(photoflag.toString());
	}

	public MyResume getMyResume() {
		return myResume;
	}




	public void setMyResume(MyResume myResume) {
		this.myResume = myResume;
	}


	
	
}
