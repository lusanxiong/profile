package com.job528.profile.vo;


import com.job528.util.JsonUtils;

public class UserSearchCondition extends BaseVO{

	/**
	 * 关键字
	 */
	private String keyword;
	
	/**
	 * 意向工作城市
	 */
	private String intCity;
	
	//现居住地
	private String place;
	
	//用户标签
	private String userLabel;
	
	/**
	 * 意向工作省份
	 */
	//private String intProvince;
	
	public String getUserLabel() {
		return userLabel!=null ? userLabel.trim() : "";
	}

	public void setUserLabel(String userLabel) {
		this.userLabel = userLabel;
	}

	/**
	 * 意向岗位
	 */
	private String intPost;
	
	/**
	 * 工作过的行业
	 */
	private String calling;
	
	/**
	 * 工作过的公司
	 */
	
	private String  company;
	
	
	private String  school;
	
	
	private String homeCity;
	
	private String homeProvince;
	
	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getIntCity() {
		return intCity;
	}

	public void setIntCity(String intCity) {
		this.intCity = intCity;
	}

	public String getIntPost() {
		return intPost;
	}

	public void setIntPost(String intPost) {
		this.intPost = intPost;
	}


	public String getCalling() {
		return calling;
	}

	public void setCalling(String calling) {
		this.calling = calling;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getHomeCity() {
		return homeCity;
	}

	public void setHomeCity(String homeCity) {
		this.homeCity = homeCity;
	}

	public String getHomeProvince() {
		return homeProvince;
	}

	public void setHomeProvince(String homeProvince) {
		this.homeProvince = homeProvince;
	}

	@Override
	protected boolean validator() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String getJsonString(){
		return JsonUtils.getJsonString4JavaPOJO(this);
	}
	
	
}
