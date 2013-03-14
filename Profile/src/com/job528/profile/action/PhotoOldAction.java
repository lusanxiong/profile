package com.job528.profile.action;


import com.job528.profile.model.MyResume;

public class PhotoOldAction extends ResumeAction {

    private MyResume myResume = new MyResume();
    
	public String execute() {
		
		myResume = this.getLoginResume().getMyResume();
		
		return SUCCESS;
	}
	

	

	public MyResume getMyResume() {
		return myResume;
	}




	public void setMyResume(MyResume myResume) {
		this.myResume = myResume;
	}


	
	
}