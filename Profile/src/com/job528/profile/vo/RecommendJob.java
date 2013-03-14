package com.job528.profile.vo;


import java.util.Date;

import com.job528.profile.model.MyRecommendJob;
import com.job528.util.AreaUtil;
import com.job528.util.DateUtil;
import com.job528.util.StringUtil;

/**
 * MyRecommendJob entity. @author MyEclipse Persistence Tools
 */

public class RecommendJob extends BaseVO {

	// Fields

	private MyRecommendJob myRecommendJob;
	

	private String userName;
	private String posName;
	private String memName;
	private String recDate;
	private String Salary; 
	private String postDate;
	private String jobLocation;
	
	
	// Constructors

	public MyRecommendJob getMyRecommendJob() {
		return myRecommendJob;
	}

	public void setMyRecommendJob(MyRecommendJob myRecommendJob) {
		this.myRecommendJob = myRecommendJob;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPosName() {
		return posName;
	}

	public void setPosName(String posName) {
		this.posName = posName;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getRecDate() {
		return recDate;
	}

	public void setRecDate(String recDate) {
		this.recDate = recDate;
	}

	

	public String getSalary() {
		return Salary;
	}

	public void setSalary(String salary) {
		Salary = salary;
	}

	public String getPostDate() {
		if(StringUtil.isValidStr(postDate)){
			Date date = DateUtil.stringToDate(postDate);
			postDate = DateUtil.dateToString(date);
		}
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	/** default constructor */
	public RecommendJob() {
	}
	
	

	public String getJobLocation() {
		return jobLocation;
	}

	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}

	@Override
	protected boolean validator() {
		// TODO Auto-generated method stub
		return false;
	}

}