package com.job528.profile.vo;

import com.job528.profile.model.MyTraining;
import com.job528.util.JsonUtils;

public class Training extends BaseVO {

	private MyTraining myTraining;
	
	

	public MyTraining getMyTraining() {
		return myTraining;
	}

	public void setMyTraining(MyTraining myTraining) {
		this.myTraining = myTraining;
	}
	
	public String getJsonString(){
		return JsonUtils.getJsonString4JavaPOJO(this.myTraining);
	}

	@Override
	protected boolean validator() {
		// TODO Auto-generated method stub
		return false;
	}
}
