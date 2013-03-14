package com.job528.profile.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MessageQueue entity. @author MyEclipse Persistence Tools
 */
@Entity
public class MessageQueue implements java.io.Serializable {

	// Fields

	private Integer userId;
	private Integer id;
	private Integer privateNumber;
	private Integer fansNumber;
	private Integer commentNumber;

	// Constructors

	/** default constructor */
	public MessageQueue() {
	}

	/** full constructor */
	public MessageQueue(Integer userId, Integer id, Integer privateNumber, Integer fansNumber, Integer commentNumber) {
		this.userId = userId;
		this.id = id;
		this.privateNumber = privateNumber;
		this.fansNumber = fansNumber;
		this.commentNumber = commentNumber;
	}

	// Property accessors
	@Id
	@Column(name = "UserId", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "Id", nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "PrivateNumber", nullable = false)
	public Integer getPrivateNumber() {
		return this.privateNumber;
	}

	public void setPrivateNumber(Integer privateNumber) {
		this.privateNumber = privateNumber;
	}

	@Column(name = "FansNumber", nullable = false)
	public Integer getFansNumber() {
		return this.fansNumber;
	}

	public void setFansNumber(Integer fansNumber) {
		this.fansNumber = fansNumber;
	}

	@Column(name = "CommentNumber", nullable = false)
	public Integer getCommentNumber() {
		return this.commentNumber;
	}

	public void setCommentNumber(Integer commentNumber) {
		this.commentNumber = commentNumber;
	}

}