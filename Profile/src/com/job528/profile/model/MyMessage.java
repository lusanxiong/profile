package com.job528.profile.model;

import java.util.Date;

public class MyMessage implements java.io.Serializable {
	private Integer id;
	/**
	 * 信息发送者id 0 为系统
	 */
	private Integer sendId;
	
	/**
	 * 消息接收者Id
	 */
	private Integer targetId;
	/**
	 * 100,系统信息,0:关注信息,1:解除关注信息 ，2:私信信息
	 */
	private Integer type;
	private String content;
	private String reply;
	private Boolean isRead;
	private Date createDate;
	private Integer uCount; //发送者,共多少条对话
	private Integer tCount; //接收者,共多少条对话

	// Constructors

	/** default constructor */
	public MyMessage() {
	}

	

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSendId() {
		return this.sendId;
	}

	public void setSendId(Integer sendId) {
		this.sendId = sendId;
	}

	public Integer getTargetId() {
		return this.targetId;
	}

	public void setTargetId(Integer targetId) {
		this.targetId = targetId;
	}

	/**
	 * 0,系统信息,1:关注信息,2:私信信息,4:解除关注信息
	 * @return
	 */
	public Integer getType() {
		return this.type;
	}

	/**
	 * 0,系统信息,1:关注信息,2:私信信息,4:解除关注信息
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Boolean getIsRead() {
		return this.isRead;
	}

	public void setIsRead(Boolean isRead) {
		this.isRead = isRead;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}



	public String getReply() {
		return reply;
	}



	public void setReply(String reply) {
		this.reply = reply;
	}



	public Integer getuCount() {
		return uCount;
	}



	public void setuCount(Integer uCount) {
		this.uCount = uCount;
	}



	public Integer gettCount() {
		return tCount;
	}



	public void settCount(Integer tCount) {
		this.tCount = tCount;
	}


}
