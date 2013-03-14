package com.job528.ejb.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Friends implements Serializable {

	private Integer userId;
	private String userName;
	private String headImage;
	private Integer fansNumber;
	private String texts;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getHeadImage() {
		return headImage;
	}
	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}
	public Integer getFansNumber() {
		return fansNumber;
	}
	public void setFansNumber(Integer fansNumber) {
		this.fansNumber = fansNumber;
	}
	public String getTexts() {
		return texts;
	}
	public void setTexts(String texts) {
		this.texts = texts;
	}
	
	
	
}
