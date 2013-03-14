package com.job528.profile.model;

import java.sql.Timestamp;

/**
 * MyResumeViewedLog entity. @author MyEclipse Persistence Tools
 */

public class MyResumeViewedLog implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer myUserId;
	private Integer memId;
	private String memName;
	private Timestamp operateDate;
	private String operateIp;
	private Integer relationFlag;

	// Constructors

	/** default constructor */
	public MyResumeViewedLog() {
	}

	/** minimal constructor */
	public MyResumeViewedLog(Integer id, Integer myUserId, Integer memId,
			String memName, Timestamp operateDate, String operateIp) {
		this.id = id;
		this.myUserId = myUserId;
		this.memId = memId;
		this.memName = memName;
		this.operateDate = operateDate;
		this.operateIp = operateIp;
	}

	/** full constructor */
	public MyResumeViewedLog(Integer id, Integer myUserId, Integer memId,
			String memName, Timestamp operateDate, String operateIp,
			Integer relationFlag) {
		this.id = id;
		this.myUserId = myUserId;
		this.memId = memId;
		this.memName = memName;
		this.operateDate = operateDate;
		this.operateIp = operateIp;
		this.relationFlag = relationFlag;
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

	public Integer getMemId() {
		return this.memId;
	}

	public void setMemId(Integer memId) {
		this.memId = memId;
	}

	public String getMemName() {
		return this.memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public Timestamp getOperateDate() {
		return this.operateDate;
	}

	public void setOperateDate(Timestamp operateDate) {
		this.operateDate = operateDate;
	}

	public String getOperateIp() {
		return this.operateIp;
	}

	public void setOperateIp(String operateIp) {
		this.operateIp = operateIp;
	}

	public Integer getRelationFlag() {
		return this.relationFlag;
	}

	public void setRelationFlag(Integer relationFlag) {
		this.relationFlag = relationFlag;
	}

}