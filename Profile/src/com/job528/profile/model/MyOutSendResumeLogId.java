package com.job528.profile.model;

import java.sql.Timestamp;

/**
 * MyOutSendResumeLogId entity. @author MyEclipse Persistence Tools
 */

public class MyOutSendResumeLogId implements java.io.Serializable {

	// Fields

	private Integer logId;
	private Integer myUserId;
	private Integer resId;
	private String nickName;
	private String memEmail;
	private String postionName;
	private Timestamp sendDate;

	// Constructors

	/** default constructor */
	public MyOutSendResumeLogId() {
	}

	/** minimal constructor */
	public MyOutSendResumeLogId(Integer logId, Integer myUserId, Integer resId,
			String nickName, String postionName, Timestamp sendDate) {
		this.logId = logId;
		this.myUserId = myUserId;
		this.resId = resId;
		this.nickName = nickName;
		this.postionName = postionName;
		this.sendDate = sendDate;
	}

	/** full constructor */
	public MyOutSendResumeLogId(Integer logId, Integer myUserId, Integer resId,
			String nickName, String memEmail, String postionName,
			Timestamp sendDate) {
		this.logId = logId;
		this.myUserId = myUserId;
		this.resId = resId;
		this.nickName = nickName;
		this.memEmail = memEmail;
		this.postionName = postionName;
		this.sendDate = sendDate;
	}

	// Property accessors

	public Integer getLogId() {
		return this.logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	public Integer getMyUserId() {
		return this.myUserId;
	}

	public void setMyUserId(Integer myUserId) {
		this.myUserId = myUserId;
	}

	public Integer getResId() {
		return this.resId;
	}

	public void setResId(Integer resId) {
		this.resId = resId;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getMemEmail() {
		return this.memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

	public String getPostionName() {
		return this.postionName;
	}

	public void setPostionName(String postionName) {
		this.postionName = postionName;
	}

	public Timestamp getSendDate() {
		return this.sendDate;
	}

	public void setSendDate(Timestamp sendDate) {
		this.sendDate = sendDate;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MyOutSendResumeLogId))
			return false;
		MyOutSendResumeLogId castOther = (MyOutSendResumeLogId) other;

		return ((this.getLogId() == castOther.getLogId()) || (this.getLogId() != null
				&& castOther.getLogId() != null && this.getLogId().equals(
				castOther.getLogId())))
				&& ((this.getMyUserId() == castOther.getMyUserId()) || (this
						.getMyUserId() != null
						&& castOther.getMyUserId() != null && this
						.getMyUserId().equals(castOther.getMyUserId())))
				&& ((this.getResId() == castOther.getResId()) || (this
						.getResId() != null
						&& castOther.getResId() != null && this.getResId()
						.equals(castOther.getResId())))
				&& ((this.getNickName() == castOther.getNickName()) || (this
						.getNickName() != null
						&& castOther.getNickName() != null && this
						.getNickName().equals(castOther.getNickName())))
				&& ((this.getMemEmail() == castOther.getMemEmail()) || (this
						.getMemEmail() != null
						&& castOther.getMemEmail() != null && this
						.getMemEmail().equals(castOther.getMemEmail())))
				&& ((this.getPostionName() == castOther.getPostionName()) || (this
						.getPostionName() != null
						&& castOther.getPostionName() != null && this
						.getPostionName().equals(castOther.getPostionName())))
				&& ((this.getSendDate() == castOther.getSendDate()) || (this
						.getSendDate() != null
						&& castOther.getSendDate() != null && this
						.getSendDate().equals(castOther.getSendDate())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getLogId() == null ? 0 : this.getLogId().hashCode());
		result = 37 * result
				+ (getMyUserId() == null ? 0 : this.getMyUserId().hashCode());
		result = 37 * result
				+ (getResId() == null ? 0 : this.getResId().hashCode());
		result = 37 * result
				+ (getNickName() == null ? 0 : this.getNickName().hashCode());
		result = 37 * result
				+ (getMemEmail() == null ? 0 : this.getMemEmail().hashCode());
		result = 37
				* result
				+ (getPostionName() == null ? 0 : this.getPostionName()
						.hashCode());
		result = 37 * result
				+ (getSendDate() == null ? 0 : this.getSendDate().hashCode());
		return result;
	}

}