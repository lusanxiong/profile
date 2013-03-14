package com.job528.profile.model;

import java.sql.Timestamp;

import com.job528.profile.util.ResumeUtil;

/**
 * MyUsers entity. @author MyEclipse Persistence Tools
 */

public class MyUsers implements java.io.Serializable {

	// Fields

	private Integer myUserId;
	private String userName;
	private String password;
	private String email;
	private Short engResumeFlag;
	private Short receiveMailType;
	private Timestamp registerDate;
	private Short resumeStatus;
	private Short relationFlag;
	private Short memberClass;
	private Short checkFlag;
	private Short registerBy;
	private Integer loginCount;
	private Timestamp latestLoginDate;
	private String partComName;
	private String operator;

	// Constructors

	/** default constructor */
	public MyUsers() {
	}

	/** minimal constructor */
	public MyUsers(Integer myUserId, String userName, String password,
			String email, Short engResumeFlag, Short receiveMailType,
			Timestamp registerDate, Short resumeStatus, Short relationFlag,
			Short memberClass, Short checkFlag, Short registerBy,
			Integer loginCount, Timestamp latestLoginDate, String partComName) {
		this.myUserId = myUserId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.engResumeFlag = engResumeFlag;
		this.receiveMailType = receiveMailType;
		this.registerDate = registerDate;
		this.resumeStatus = resumeStatus;
		this.relationFlag = relationFlag;
		this.memberClass = memberClass;
		this.checkFlag = checkFlag;
		this.registerBy = registerBy;
		this.loginCount = loginCount;
		this.latestLoginDate = latestLoginDate;
		this.partComName = partComName;
	}

	/** full constructor */
	public MyUsers(Integer myUserId, String userName, String password,
			String email, Short engResumeFlag, Short receiveMailType,
			Timestamp registerDate, Short resumeStatus, Short relationFlag,
			Short memberClass, Short checkFlag, Short registerBy,
			Integer loginCount, Timestamp latestLoginDate, String partComName,
			String operator) {
		this.myUserId = myUserId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.engResumeFlag = engResumeFlag;
		this.receiveMailType = receiveMailType;
		this.registerDate = registerDate;
		this.resumeStatus = resumeStatus;
		this.relationFlag = relationFlag;
		this.memberClass = memberClass;
		this.checkFlag = checkFlag;
		this.registerBy = registerBy;
		this.loginCount = loginCount;
		this.latestLoginDate = latestLoginDate;
		this.partComName = partComName;
		this.operator = operator;
	}

	// Property accessors

	public Integer getMyUserId() {
		return this.myUserId;
	}

	public void setMyUserId(Integer myUserId) {
		this.myUserId = myUserId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Short getEngResumeFlag() {
		return this.engResumeFlag;
	}

	public void setEngResumeFlag(Short engResumeFlag) {
		this.engResumeFlag = engResumeFlag;
	}

	public Short getReceiveMailType() {
		return this.receiveMailType;
	}

	public void setReceiveMailType(Short receiveMailType) {
		this.receiveMailType = receiveMailType;
	}

	public Timestamp getRegisterDate() {
		return this.registerDate;
	}

	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}

	public Short getResumeStatus() {
		return this.resumeStatus;
	}
	
	public String getResumeStatusName() {
		return ResumeUtil.getResumeStatus(resumeStatus.toString(), partComName);
	}
	
	public String getContactStatusName() {
		return relationFlag==0?"公开":"不公开";
	}

	public void setResumeStatus(Short resumeStatus) {
		this.resumeStatus = resumeStatus;
	}

	public Short getRelationFlag() {
		return this.relationFlag;
	}

	public void setRelationFlag(Short relationFlag) {
		this.relationFlag = relationFlag;
	}

	public Short getMemberClass() {
		return this.memberClass;
	}

	public void setMemberClass(Short memberClass) {
		this.memberClass = memberClass;
	}

	public Short getCheckFlag() {
		return this.checkFlag;
	}

	public void setCheckFlag(Short checkFlag) {
		this.checkFlag = checkFlag;
	}

	public Short getRegisterBy() {
		return this.registerBy;
	}

	public void setRegisterBy(Short registerBy) {
		this.registerBy = registerBy;
	}

	public Integer getLoginCount() {
		return this.loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	public Timestamp getLatestLoginDate() {
		return this.latestLoginDate;
	}

	public void setLatestLoginDate(Timestamp latestLoginDate) {
		this.latestLoginDate = latestLoginDate;
	}

	public String getPartComName() {
		return this.partComName;
	}

	public void setPartComName(String partComName) {
		this.partComName = partComName;
	}

	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

}