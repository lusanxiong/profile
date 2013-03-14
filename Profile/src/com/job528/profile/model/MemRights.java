package com.job528.profile.model;

import java.sql.Timestamp;

/**
 * MemRights entity. @author MyEclipse Persistence Tools
 */

public class MemRights implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer memId;
	private Short memberType;
	private Timestamp beginValidDate;
	private Timestamp endValidDate;
	private Integer maxPosNum;
	private Integer maxResumeNum;
	private Integer viewingResume;
	private Integer viewedResume;
	private Short cancelFlag;
	private Integer postingNum;
	private String checkUser;
	private Timestamp checkDate;
	private String lastViewIp;
	private Timestamp lastViewTime;
	private Integer todayViewNumber;
	private Integer timeInterval;
	private Integer maxViewResumeToday;

	// Constructors

	/** default constructor */
	public MemRights() {
	}

	/** minimal constructor */
	public MemRights(Integer id, Integer memId, Short memberType,
			Timestamp beginValidDate, Timestamp endValidDate,
			Integer maxPosNum, Integer maxResumeNum, Integer viewingResume,
			Integer viewedResume, Integer postingNum, String checkUser,
			Timestamp checkDate) {
		this.id = id;
		this.memId = memId;
		this.memberType = memberType;
		this.beginValidDate = beginValidDate;
		this.endValidDate = endValidDate;
		this.maxPosNum = maxPosNum;
		this.maxResumeNum = maxResumeNum;
		this.viewingResume = viewingResume;
		this.viewedResume = viewedResume;
		this.postingNum = postingNum;
		this.checkUser = checkUser;
		this.checkDate = checkDate;
	}

	/** full constructor */
	public MemRights(Integer id, Integer memId, Short memberType,
			Timestamp beginValidDate, Timestamp endValidDate,
			Integer maxPosNum, Integer maxResumeNum, Integer viewingResume,
			Integer viewedResume, Short cancelFlag, Integer postingNum,
			String checkUser, Timestamp checkDate, String lastViewIp,
			Timestamp lastViewTime, Integer todayViewNumber,
			Integer timeInterval, Integer maxViewResumeToday) {
		this.id = id;
		this.memId = memId;
		this.memberType = memberType;
		this.beginValidDate = beginValidDate;
		this.endValidDate = endValidDate;
		this.maxPosNum = maxPosNum;
		this.maxResumeNum = maxResumeNum;
		this.viewingResume = viewingResume;
		this.viewedResume = viewedResume;
		this.cancelFlag = cancelFlag;
		this.postingNum = postingNum;
		this.checkUser = checkUser;
		this.checkDate = checkDate;
		this.lastViewIp = lastViewIp;
		this.lastViewTime = lastViewTime;
		this.todayViewNumber = todayViewNumber;
		this.timeInterval = timeInterval;
		this.maxViewResumeToday = maxViewResumeToday;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMemId() {
		return this.memId;
	}

	public void setMemId(Integer memId) {
		this.memId = memId;
	}

	public Short getMemberType() {
		return this.memberType;
	}

	public void setMemberType(Short memberType) {
		this.memberType = memberType;
	}

	public Timestamp getBeginValidDate() {
		return this.beginValidDate;
	}

	public void setBeginValidDate(Timestamp beginValidDate) {
		this.beginValidDate = beginValidDate;
	}

	public Timestamp getEndValidDate() {
		return this.endValidDate;
	}

	public void setEndValidDate(Timestamp endValidDate) {
		this.endValidDate = endValidDate;
	}

	public Integer getMaxPosNum() {
		return this.maxPosNum;
	}

	public void setMaxPosNum(Integer maxPosNum) {
		this.maxPosNum = maxPosNum;
	}

	public Integer getMaxResumeNum() {
		return this.maxResumeNum;
	}

	public void setMaxResumeNum(Integer maxResumeNum) {
		this.maxResumeNum = maxResumeNum;
	}

	public Integer getViewingResume() {
		return this.viewingResume;
	}

	public void setViewingResume(Integer viewingResume) {
		this.viewingResume = viewingResume;
	}

	public Integer getViewedResume() {
		return this.viewedResume;
	}

	public void setViewedResume(Integer viewedResume) {
		this.viewedResume = viewedResume;
	}

	public Short getCancelFlag() {
		return this.cancelFlag;
	}

	public void setCancelFlag(Short cancelFlag) {
		this.cancelFlag = cancelFlag;
	}

	public Integer getPostingNum() {
		return this.postingNum;
	}

	public void setPostingNum(Integer postingNum) {
		this.postingNum = postingNum;
	}

	public String getCheckUser() {
		return this.checkUser;
	}

	public void setCheckUser(String checkUser) {
		this.checkUser = checkUser;
	}

	public Timestamp getCheckDate() {
		return this.checkDate;
	}

	public void setCheckDate(Timestamp checkDate) {
		this.checkDate = checkDate;
	}

	public String getLastViewIp() {
		return this.lastViewIp;
	}

	public void setLastViewIp(String lastViewIp) {
		this.lastViewIp = lastViewIp;
	}

	public Timestamp getLastViewTime() {
		return this.lastViewTime;
	}

	public void setLastViewTime(Timestamp lastViewTime) {
		this.lastViewTime = lastViewTime;
	}

	public Integer getTodayViewNumber() {
		return this.todayViewNumber;
	}

	public void setTodayViewNumber(Integer todayViewNumber) {
		this.todayViewNumber = todayViewNumber;
	}

	public Integer getTimeInterval() {
		return this.timeInterval;
	}

	public void setTimeInterval(Integer timeInterval) {
		this.timeInterval = timeInterval;
	}

	public Integer getMaxViewResumeToday() {
		return this.maxViewResumeToday;
	}

	public void setMaxViewResumeToday(Integer maxViewResumeToday) {
		this.maxViewResumeToday = maxViewResumeToday;
	}

}