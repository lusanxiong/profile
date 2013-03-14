package com.job528.profile.vo;

import com.job528.profile.model.MyWorkExp;
import com.job528.profile.util.JobUtil;
import com.job528.profile.util.ResumeUtil;
import com.job528.util.JsonUtils;

public class Experience extends BaseVO {

	private MyWorkExp myWorkExp;
	
	
	private String calling;
	
	private String companyType;

	private String post;
	
	public MyWorkExp getMyWorkExp() {
		return myWorkExp;
	}

	public void setMyWorkExp(MyWorkExp myWorkExp) {
		this.myWorkExp = myWorkExp;
	}

	
	
	
	public String getCompanyType() {
		companyType = ResumeUtil.getCompanyTypeById(this.myWorkExp.getMemType().toString());
		return companyType;
	}

	public String getCalling() {
		calling = JobUtil.getJobById(this.myWorkExp.getMemCalling().toString());
		return calling;
	}

	

	public String getPost() {
		if(null == myWorkExp) {
			return "";
		}
		post = JobUtil.getJobById(this.myWorkExp.getJobFunctionId().toString());
		return post;
	}

	

	public String getJsonString(){
		return JsonUtils.getJsonString4JavaPOJO(this.myWorkExp);
	}
	
	
	
	@Override
	protected boolean validator() {
		// TODO Auto-generated method stub
		return false;
	}

}
