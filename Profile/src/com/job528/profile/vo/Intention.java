package com.job528.profile.vo;

import com.job528.profile.model.MyResume;
import com.job528.profile.util.JobUtil;
import com.job528.profile.util.ResumeUtil;
import com.job528.util.AreaUtil;
import com.job528.util.StringUtil;

public class Intention extends BaseVO {

	private MyResume myResume;
	
	/**
	 * 意向岗位
	 */
	private String calling1 = "";
	
	
	/**
	 * 意向岗位
	 */
	private String calling2 = "";
	
	
	/**
	 * 意向岗位
	 */
	private String calling3 = "";
	
	/**
	 * 意向职位
	 */
	private String post;
	
	/**
	 * 工作地点
	 */
	private String jobLocation1 = "";
	
	/**
	 * 工作地点
	 */
	private String jobLocation2 = "";
	
	
	/**
	 * 工作地点
	 */
	private String jobLocation3 = "";
	
	/**
	 * 薪资
	 */
	private String salary;
	
	/**
	 * 到岗
	 */
	private String toPost;
	
	
	
	
	public MyResume getMyResume() {
		return myResume;
	}




	public void setMyResume(MyResume myResume) {
		this.myResume = myResume;
	}




	public String getCalling1() {
		String jobFunction1 = JobUtil.getJobById(this.myResume.getJobFunction1().toString());
		if(StringUtil.isValidStr(jobFunction1)){
			calling1 = jobFunction1;
		}
		
		return calling1;
	}
	
	public String getCalling2() {
		String jobFunction2 = JobUtil.getJobById(this.myResume.getJobFunction2().toString());
		if(StringUtil.isValidStr(jobFunction2)){
			calling2 = jobFunction2;
		}
		
		return calling2;
	}

	public String getCalling3() {
		String jobFunction3 = JobUtil.getJobById(this.myResume.getJobFunction3().toString());
		if(StringUtil.isValidStr(jobFunction3)){
			calling3 = jobFunction3;
		}
		
		return calling3;
	}



	public String getPost() {
		post = this.myResume.getJobSeeking1() + "   " + this.myResume.getJobSeeking2() + "   " +  this.myResume.getJobSeeking3();
		return post;
	}




	public String getJobLocation1() {
		if(StringUtil.isValidStr(this.myResume.getJobLocation1())){
		String jobLocationName = AreaUtil.getAddressById(this.myResume.getJobLocation1().toString());
		
		if(StringUtil.isValidStr(jobLocationName)){
			jobLocation1  = jobLocationName;
		}
		}
		return jobLocation1;
	}
	
	public String getJobLocation2() {
		if(StringUtil.isValidStr(this.myResume.getJobLocation2())){
		String jobLocationName = AreaUtil.getAddressById(this.myResume.getJobLocation2().toString());
		
		if(StringUtil.isValidStr(jobLocationName)){
			jobLocation2  = jobLocationName;
		}
		}
		return jobLocation2;
	}

	
	public String getJobLocation3() {
		if(StringUtil.isValidStr(this.myResume.getJobLocation3())){
		String jobLocationName = AreaUtil.getAddressById(this.myResume.getJobLocation3().toString());
		
		if(StringUtil.isValidStr(jobLocationName)){
			jobLocation3  = jobLocationName;
		}
		}
		return jobLocation3;
	}




	public String getSalary() {
		salary = ResumeUtil.getSalaryById(this.myResume.getSalary().toString());
		return salary;
	}




	public String getToPost() {
		String dg = this.myResume.getCheckinDate();
		if (StringUtil.isValidStr(dg)) {
			if ("随时到岗".equals(dg)) {
				toPost = "随时到岗";
			} else if (dg.length() > 2) {
				toPost = dg + "以后";
			} else {
				toPost = dg + "月以内";
			}
		}
		return toPost;
	}




	@Override
	protected boolean validator() {
		// TODO Auto-generated method stub
		return false;
	}

}
