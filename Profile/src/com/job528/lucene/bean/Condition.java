package com.job528.lucene.bean;

/**
 *  传入LUCENE进行职位搜索的条件
 * @author JavaColonel
 *
 */
public class Condition {
	private String keyword;
	private int keywordType;			//0职位,1单位 2全部
	private int properity;              //企业性质 -1
	private int positionPostDate;       // 发布日期 几天内  0
	private int reqWorkyear;            // 工作经验  11
	private int providesalary;          // 薪水  -1 
	private int degreeID;               // 学历   -1
	private String jobLocation1_Name;	//工作地区
	private String jobLocation2_Name;
	private String jobLocation3_Name;
	private String jobFunction1Name;	//职位类别
	private String jobFunction2Name;
	private String jobFunction3Name;
	private String calling1Name;        //行业
	private String calling2Name;
	private String calling3Name;
	private String excludeKeyword;      //过滤
	private int orderFlag;              // 0发布时间排序 1 相关性排序
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getKeywordType() {
		return keywordType;
	}
	public void setKeywordType(int keywordType) {
		this.keywordType = keywordType;
	}
	public int getProperity() {
		return properity;
	}
	public void setProperity(int properity) {
		this.properity = properity;
	}
	public int getPositionPostDate() {
		return positionPostDate;
	}
	public void setPositionPostDate(int positionPostDate) {
		this.positionPostDate = positionPostDate;
	}
	public int getReqWorkyear() {
		return reqWorkyear;
	}
	public void setReqWorkyear(int reqWorkyear) {
		this.reqWorkyear = reqWorkyear;
	}
	public int getProvidesalary() {
		return providesalary;
	}
	public void setProvidesalary(int providesalary) {
		this.providesalary = providesalary;
	}
	public int getDegreeID() {
		return degreeID;
	}
	public void setDegreeID(int degreeID) {
		this.degreeID = degreeID;
	}
	public String getJobLocation1_Name() {
		return jobLocation1_Name;
	}
	public void setJobLocation1_Name(String jobLocation1Name) {
		jobLocation1_Name = jobLocation1Name;
	}
	public String getJobLocation2_Name() {
		return jobLocation2_Name;
	}
	public void setJobLocation2_Name(String jobLocation2Name) {
		jobLocation2_Name = jobLocation2Name;
	}
	public String getJobLocation3_Name() {
		return jobLocation3_Name;
	}
	public void setJobLocation3_Name(String jobLocation3Name) {
		jobLocation3_Name = jobLocation3Name;
	}
	public String getJobFunction1Name() {
		return jobFunction1Name;
	}
	public void setJobFunction1Name(String jobFunction1Name) {
		this.jobFunction1Name = jobFunction1Name;
	}
	public String getJobFunction2Name() {
		return jobFunction2Name;
	}
	public void setJobFunction2Name(String jobFunction2Name) {
		this.jobFunction2Name = jobFunction2Name;
	}
	public String getJobFunction3Name() {
		return jobFunction3Name;
	}
	public void setJobFunction3Name(String jobFunction3Name) {
		this.jobFunction3Name = jobFunction3Name;
	}
	public String getCalling1Name() {
		return calling1Name;
	}
	public void setCalling1Name(String calling1Name) {
		this.calling1Name = calling1Name;
	}
	public String getCalling2Name() {
		return calling2Name;
	}
	public void setCalling2Name(String calling2Name) {
		this.calling2Name = calling2Name;
	}
	public String getCalling3Name() {
		return calling3Name;
	}
	public void setCalling3Name(String calling3Name) {
		this.calling3Name = calling3Name;
	}
	public String getExcludeKeyword() {
		return excludeKeyword;
	}
	public void setExcludeKeyword(String excludeKeyword) {
		this.excludeKeyword = excludeKeyword;
	}
	public int getOrderFlag() {
		return orderFlag;
	}
	public void setOrderFlag(int orderFlag) {
		this.orderFlag = orderFlag;
	}
}