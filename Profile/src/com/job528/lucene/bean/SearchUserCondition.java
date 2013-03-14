package com.job528.lucene.bean;

import java.util.List;

public class SearchUserCondition {

	private List<Integer> userIds;
	
	private List<Integer> outUserIds;
	
    private String homeTown;
	
	private List<String> callings;
	
	private List<String> companys;
	
    private List<String> schools;
    
    private String place; //现居住地
    
    private String keyWord;
    
    private String userLabel; //个人标签
    
	public String getUserLabel() {
		return userLabel!=null ? userLabel.trim() : "";
	}

	public void setUserLabel(String userLabel) {
		this.userLabel = userLabel;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public List<String> getSchools() {
		return schools;
	}

	public void setSchools(List<String> schools) {
		this.schools = schools;
	}
	
	private int pageSize;
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	private int page;
	
	
	public List<Integer> getUserIds() {
		return userIds;
	}

	public void setUserIds(List<Integer> userIds) {
		this.userIds = userIds;
	}

	public List<Integer> getOutUserIds() {
		return outUserIds;
	}

	public void setOutUserIds(List<Integer> outUserIds) {
		this.outUserIds = outUserIds;
	}

	public String getHomeTown() {
		return homeTown;
	}

	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}

	public List<String> getCallings() {
		return callings;
	}

	public void setCallings(List<String> callings) {
		this.callings = callings;
	}

	public List<String> getCompanys() {
		return companys;
	}

	public void setCompanys(List<String> companys) {
		this.companys = companys;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	
}
