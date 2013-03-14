package com.job528.profile.model;

/**
 * MyOutSendResumeLog entity. @author MyEclipse Persistence Tools
 */

public class MyOutSendResumeLog implements java.io.Serializable {

	// Fields

	private MyOutSendResumeLogId id;

	// Constructors

	/** default constructor */
	public MyOutSendResumeLog() {
	}

	/** full constructor */
	public MyOutSendResumeLog(MyOutSendResumeLogId id) {
		this.id = id;
	}

	// Property accessors

	public MyOutSendResumeLogId getId() {
		return this.id;
	}

	public void setId(MyOutSendResumeLogId id) {
		this.id = id;
	}

}