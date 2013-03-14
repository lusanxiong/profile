package com.job528.profile.model;

import java.sql.Timestamp;

/**
 * MyMessageData entity. @author MyEclipse Persistence Tools
 */

public class MyMessageData implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userId;
	private Integer targetId;
	private Integer groupId;
	private String message;
	private Integer deleteId;
	private Timestamp createDate;

	// Constructors

	/** default constructor */
	public MyMessageData() {
	}

	/** full constructor */
	public MyMessageData(Integer id, Integer userId, Integer targetId,
			Integer groupId, String message, Integer deleteId,
			Timestamp createDate) {
		this.id = id;
		this.userId = userId;
		this.targetId = targetId;
		this.groupId = groupId;
		this.message = message;
		this.deleteId = deleteId;
		this.createDate = createDate;
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

	public Integer getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getDeleteId() {
		return this.deleteId;
	}

	public void setDeleteId(Integer deleteId) {
		this.deleteId = deleteId;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

}