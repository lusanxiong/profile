package com.job528.profile.model;

import java.sql.Timestamp;

/**
 * MyMessageInfo entity. @author MyEclipse Persistence Tools
 */

public class MyMessageInfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userId;
	private Integer targetId;
	private Integer ucount;
	private Integer tcount;
	private String ulastMessage;
	private String tlastMessage;
	private Timestamp ucreateDate;
	private Timestamp tcreateDate;

	// Constructors

	/** default constructor */
	public MyMessageInfo() {
	}

	/** full constructor */
	public MyMessageInfo(Integer id, Integer userId, Integer targetId,
			Integer ucount, Integer tcount, String ulastMessage,
			String tlastMessage, Timestamp ucreateDate, Timestamp tcreateDate) {
		this.id = id;
		this.userId = userId;
		this.targetId = targetId;
		this.ucount = ucount;
		this.tcount = tcount;
		this.ulastMessage = ulastMessage;
		this.tlastMessage = tlastMessage;
		this.ucreateDate = ucreateDate;
		this.tcreateDate = tcreateDate;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getTargetId() {
		return this.targetId;
	}

	public void setTargetId(Integer targetId) {
		this.targetId = targetId;
	}

	public Integer getUcount() {
		return this.ucount;
	}

	public void setUcount(Integer ucount) {
		this.ucount = ucount;
	}

	public Integer getTcount() {
		return this.tcount;
	}

	public void setTcount(Integer tcount) {
		this.tcount = tcount;
	}

	public String getUlastMessage() {
		return this.ulastMessage;
	}

	public void setUlastMessage(String ulastMessage) {
		this.ulastMessage = ulastMessage;
	}

	public String getTlastMessage() {
		return this.tlastMessage;
	}

	public void setTlastMessage(String tlastMessage) {
		this.tlastMessage = tlastMessage;
	}

	public Timestamp getUcreateDate() {
		return this.ucreateDate;
	}

	public void setUcreateDate(Timestamp ucreateDate) {
		this.ucreateDate = ucreateDate;
	}

	public Timestamp getTcreateDate() {
		return this.tcreateDate;
	}

	public void setTcreateDate(Timestamp tcreateDate) {
		this.tcreateDate = tcreateDate;
	}

}