package com.job528.profile.model;

/**
 * MyWorkExpEng entity. @author MyEclipse Persistence Tools
 */

public class MyWorkExpEng implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer myUserId;
	private String beginDate;
	private String endDate;
	private String memName;
	private Integer memType;
	private Integer memCalling;
	private Integer jobFunctionId;
	private String otherPosition;
	private String description;
	private String leftReason;
	private Integer salary;

	// Constructors

	/** default constructor */
	public MyWorkExpEng() {
	}

	/** minimal constructor */
	public MyWorkExpEng(Integer id, Integer myUserId, String beginDate,
			String endDate, String memName, Integer memType,
			Integer memCalling, Integer jobFunctionId, String otherPosition,
			String description, String leftReason) {
		this.id = id;
		this.myUserId = myUserId;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.memName = memName;
		this.memType = memType;
		this.memCalling = memCalling;
		this.jobFunctionId = jobFunctionId;
		this.otherPosition = otherPosition;
		this.description = description;
		this.leftReason = leftReason;
	}

	/** full constructor */
	public MyWorkExpEng(Integer id, Integer myUserId, String beginDate,
			String endDate, String memName, Integer memType,
			Integer memCalling, Integer jobFunctionId, String otherPosition,
			String description, String leftReason, Integer salary) {
		this.id = id;
		this.myUserId = myUserId;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.memName = memName;
		this.memType = memType;
		this.memCalling = memCalling;
		this.jobFunctionId = jobFunctionId;
		this.otherPosition = otherPosition;
		this.description = description;
		this.leftReason = leftReason;
		this.salary = salary;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMyUserId() {
		return this.myUserId;
	}

	public void setMyUserId(Integer myUserId) {
		this.myUserId = myUserId;
	}

	public String getBeginDate() {
		return this.beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return this.endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getMemName() {
		return this.memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public Integer getMemType() {
		return this.memType;
	}

	public void setMemType(Integer memType) {
		this.memType = memType;
	}

	public Integer getMemCalling() {
		return this.memCalling;
	}

	public void setMemCalling(Integer memCalling) {
		this.memCalling = memCalling;
	}

	public Integer getJobFunctionId() {
		return this.jobFunctionId;
	}

	public void setJobFunctionId(Integer jobFunctionId) {
		this.jobFunctionId = jobFunctionId;
	}

	public String getOtherPosition() {
		return this.otherPosition;
	}

	public void setOtherPosition(String otherPosition) {
		this.otherPosition = otherPosition;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLeftReason() {
		return this.leftReason;
	}

	public void setLeftReason(String leftReason) {
		this.leftReason = leftReason;
	}

	public Integer getSalary() {
		return this.salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

}