package com.job528.profile.vo;

import com.job528.profile.model.MyEducation;
import com.job528.util.JsonUtils;

public class Education extends BaseVO {

	private MyEducation myEducation;

	public MyEducation getMyEducation() {
		return myEducation;
	}

	public void setMyEducation(MyEducation myEducation) {
		this.myEducation = myEducation;
	}


	public String getJsonString(){
		return JsonUtils.getJsonString4JavaPOJO(this.myEducation);
	}

	@Override
	protected boolean validator() {
		// TODO Auto-generated method stub
		return false;
	}
}
