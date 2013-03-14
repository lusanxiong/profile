package com.job528.profile.model;

import java.util.Date;


/**
 * MyFavouriate entity. @author MyEclipse Persistence Tools
 */

public class MyFavouriate implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer myUserId;
	private Integer memId;
	private String memName;
	private Integer posId;
	private Date operateDate;
	private String note;

	// Constructors

	/** default constructor */
	public MyFavouriate() {
	}

	/** full constructor */
	public MyFavouriate(Integer id, Integer myUserId, Integer memId,
			String memName, Integer posId, Date operateDate, String note) {
		this.id = id;
		this.myUserId = myUserId;
		this.memId = memId;
		this.memName = memName;
		this.posId = posId;
		this.operateDate = operateDate;
		this.note = note;
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

	public Integer getPosId() {
		return this.posId;
	}

	public void setPosId(Integer posId) {
		this.posId = posId;
	}

	public Date getOperateDate() {
		return this.operateDate;
	}

	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}