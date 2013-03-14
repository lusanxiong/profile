package com.job528.profile.model;

import java.sql.Date;

/**
 * MyRecommendJob entity. @author MyEclipse Persistence Tools
 */

public class MyRecommendJob implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userId;
	private Integer tragetId;
	private Integer posId;
	private Integer memId;
	private Date recDate;
	private Boolean isRead;

	// Constructors

	/** default constructor */
	public MyRecommendJob() {
	}

	/** full constructor */
	public MyRecommendJob(Integer id, Integer userId, Integer tragetId,
			Integer posId, Date recDate, Boolean isRead) {
		this.id = id;
		this.userId = userId;
		this.tragetId = tragetId;
		this.posId = posId;
		this.recDate = recDate;
		this.isRead = isRead;
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

	public Integer getTragetId() {
		return this.tragetId;
	}

	public void setTragetId(Integer tragetId) {
		this.tragetId = tragetId;
	}

	public Integer getPosId() {
		return this.posId;
	}

	public void setPosId(Integer posId) {
		this.posId = posId;
	}

	public Integer getMemId() {
		return memId;
	}

	public void setMemId(Integer memId) {
		this.memId = memId;
	}

	public Date getRecDate() {
		return this.recDate;
	}

	public void setRecDate(Date recDate) {
		this.recDate = recDate;
	}

	public Boolean getIsRead() {
		return this.isRead;
	}

	public void setIsRead(Boolean isRead) {
		this.isRead = isRead;
	}

}