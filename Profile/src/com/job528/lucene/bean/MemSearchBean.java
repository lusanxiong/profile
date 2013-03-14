package com.job528.lucene.bean;

import java.util.Date;

/**
 * 职位搜索Bean
 * @author JavaColonel
 * @version 1.0
 */
public class MemSearchBean{
	private int posID;
	private int memID;
	private String memName;
	private String posName;
	private String jobLocationName;
	private String jobFunctionName;
	private Date postDate;
	private int reqWorkyear;
	private int reqDegreeID;
	private int salary;
	private String callingName;
	private String memAreaNo;
	private String posDescription;
	private int properity;
	
	private String allText;
	private int updateFlag;
	private int Salary1;
	private int PosState;
	
	public int getUpdateFlag() {
		return updateFlag;
	}
	public void setUpdateFlag(int updateFlag) {
		this.updateFlag = updateFlag;
	}
	public int getSalary1() {
		return Salary1;
	}
	public void setSalary1(int salary1) {
		Salary1 = salary1;
	}
	public int getPosState() {
		return PosState;
	}
	public void setPosState(int posState) {
		PosState = posState;
	}
	public String getAllText() {
		return allText;
	}
	public void setAllText(String allText) {
		this.allText = allText;
	}
	public int getPosID() {
		return posID;
	}
	public void setPosID(int posID) {
		this.posID = posID;
	}
	public int getMemID() {
		return memID;
	}
	public void setMemID(int memID) {
		this.memID = memID;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getPosName() {
		return posName;
	}
	public void setPosName(String posName) {
		this.posName = posName;
	}
	public String getJobLocationName() {
		return jobLocationName;
	}
	public void setJobLocationName(String jobLocationName) {
		this.jobLocationName = jobLocationName;
	}
	public String getJobFunctionName() {
		return jobFunctionName;
	}
	public void setJobFunctionName(String jobFunctionName) {
		this.jobFunctionName = jobFunctionName;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	public int getReqWorkyear() {
		return reqWorkyear;
	}
	public void setReqWorkyear(int reqWorkyear) {
		this.reqWorkyear = reqWorkyear;
	}
	public int getReqDegreeID() {
		return reqDegreeID;
	}
	public void setReqDegreeID(int reqDegreeID) {
		this.reqDegreeID = reqDegreeID;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getCallingName() {
		return callingName;
	}
	public void setCallingName(String callingName) {
		this.callingName = callingName;
	}
	public String getMemAreaNo() {
		return memAreaNo;
	}
	public void setMemAreaNo(String memAreaNo) {
		this.memAreaNo = memAreaNo;
	}
	public String getPosDescription() {
		return posDescription;
	}
	public void setPosDescription(String posDescription) {
		this.posDescription = posDescription;
	}
	public int getProperity() {
		return properity;
	}
	public void setProperity(int properity) {
		this.properity = properity;
	}
}
