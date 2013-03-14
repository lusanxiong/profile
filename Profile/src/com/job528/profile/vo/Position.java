package com.job528.profile.vo;

import com.job528.lucene.bean.MemSearchBean;
import com.job528.util.DateUtil;
import com.job528.util.StrUtils;

public class Position {

	private MemSearchBean memSearchBean;
	
	private String postDate;
	
	private String salary;
	
	private String location;

	

	public MemSearchBean getMemSearchBean() {
		return memSearchBean;
	}

	public void setMemSearchBean(MemSearchBean memSearchBean) {
		this.memSearchBean = memSearchBean;
	}

	public String getPostDate() {
		postDate = DateUtil.dateToString(this.memSearchBean.getPostDate());
		return postDate;
	}

	

	public String getSalary() {
		if(this.memSearchBean.getSalary() > 100){
			salary = String.valueOf(this.memSearchBean.getSalary()) + "+/月"; 
		}else{
			salary = "面议";
		}
		return salary;
	}

	public String getLocation() {
		String locationName = this.memSearchBean.getJobLocationName();
		if(StrUtils.isNull(locationName))
			location = "不限";
		else{
			location = locationName;
		}
		return location;
	}
	
	
}
