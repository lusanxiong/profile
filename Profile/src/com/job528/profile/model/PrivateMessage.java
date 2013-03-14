package com.job528.profile.model;

public class PrivateMessage {
	private String headImage;
	private String userName;
	private MyMessageInfo myMessageInfo;
	private MyMessageData myMessageData;
	
	public String getHeadImage() {
		return headImage;
	}
	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public MyMessageInfo getMyMessageInfo() {
		return myMessageInfo;
	}
	public void setMyMessageInfo(MyMessageInfo myMessageInfo) {
		this.myMessageInfo = myMessageInfo;
	}
	public MyMessageData getMyMessageData() {
		return myMessageData;
	}
	public void setMyMessageData(MyMessageData myMessageData) {
		this.myMessageData = myMessageData;
	}
	
	
}
