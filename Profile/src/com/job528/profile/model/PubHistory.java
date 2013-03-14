package com.job528.profile.model;

import java.sql.Timestamp;

/**
 * PubHistory entity. @author MyEclipse Persistence Tools
 */

public class PubHistory implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer myUserId;
	private Integer memId;
	private Integer posId;
	private Short direction;
	private Timestamp perTime;
	private Timestamp memTime;
	private Short perFlag;
	private Short memFlag;
	private Integer applyNumber;
	private Timestamp insertDate;
	private String perMemo;
	private String memMemo;
	private Integer inviteFlag;
	private String memReply;

	// Constructors

	/** default constructor */
	public PubHistory() {
	}

	/** minimal constructor */
	public PubHistory(Integer id, Integer myUserId, Integer memId,
			Integer posId, Timestamp perTime, Timestamp memTime, Short perFlag,
			Integer applyNumber, Timestamp insertDate, String perMemo,
			String memMemo, Integer inviteFlag) {
		this.id = id;
		this.myUserId = myUserId;
		this.memId = memId;
		this.posId = posId;
		this.perTime = perTime;
		this.memTime = memTime;
		this.perFlag = perFlag;
		this.applyNumber = applyNumber;
		this.insertDate = insertDate;
		this.perMemo = perMemo;
		this.memMemo = memMemo;
		this.inviteFlag = inviteFlag;
	}

	/** full constructor */
	public PubHistory(Integer id, Integer myUserId, Integer memId,
			Integer posId, Short direction, Timestamp perTime,
			Timestamp memTime, Short perFlag, Short memFlag,
			Integer applyNumber, Timestamp insertDate, String perMemo,
			String memMemo, Integer inviteFlag, String memReply) {
		this.id = id;
		this.myUserId = myUserId;
		this.memId = memId;
		this.posId = posId;
		this.direction = direction;
		this.perTime = perTime;
		this.memTime = memTime;
		this.perFlag = perFlag;
		this.memFlag = memFlag;
		this.applyNumber = applyNumber;
		this.insertDate = insertDate;
		this.perMemo = perMemo;
		this.memMemo = memMemo;
		this.inviteFlag = inviteFlag;
		this.memReply = memReply;
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

	public Integer getPosId() {
		return this.posId;
	}

	public void setPosId(Integer posId) {
		this.posId = posId;
	}

	public Short getDirection() {
		return this.direction;
	}

	public void setDirection(Short direction) {
		this.direction = direction;
	}

	public Timestamp getPerTime() {
		return this.perTime;
	}

	public void setPerTime(Timestamp perTime) {
		this.perTime = perTime;
	}

	public Timestamp getMemTime() {
		return this.memTime;
	}

	public void setMemTime(Timestamp memTime) {
		this.memTime = memTime;
	}

	public Short getPerFlag() {
		return this.perFlag;
	}

	public void setPerFlag(Short perFlag) {
		this.perFlag = perFlag;
	}

	public Short getMemFlag() {
		return this.memFlag;
	}

	public void setMemFlag(Short memFlag) {
		this.memFlag = memFlag;
	}

	public Integer getApplyNumber() {
		return this.applyNumber;
	}

	public void setApplyNumber(Integer applyNumber) {
		this.applyNumber = applyNumber;
	}

	public Timestamp getInsertDate() {
		return this.insertDate;
	}

	public void setInsertDate(Timestamp insertDate) {
		this.insertDate = insertDate;
	}

	public String getPerMemo() {
		return this.perMemo;
	}

	public void setPerMemo(String perMemo) {
		this.perMemo = perMemo;
	}

	public String getMemMemo() {
		return this.memMemo;
	}

	public void setMemMemo(String memMemo) {
		this.memMemo = memMemo;
	}

	public Integer getInviteFlag() {
		return this.inviteFlag;
	}

	public void setInviteFlag(Integer inviteFlag) {
		this.inviteFlag = inviteFlag;
	}

	public String getMemReply() {
		return this.memReply;
	}

	public void setMemReply(String memReply) {
		this.memReply = memReply;
	}

}