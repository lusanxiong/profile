package com.job528.profile.vo;

import com.job528.lucene.bean.UserInfo;
import com.job528.profile.model.MyMessage;

public class Message {

	private MyMessage message;
	
	private UserInfo sender;
	
	private UserInfo recevier;
	
   
	private String sendType;

	private String content;
	
	public MyMessage getMessage() {
		return message;
	}

	
	public void setMessage(MyMessage message) {
		this.message = message;
	}

	

	public UserInfo getSender() {
		return sender;
	}


	public void setSender(UserInfo sender) {
		this.sender = sender;
	}

	

	public UserInfo getRecevier() {
		return recevier;
	}


	public void setRecevier(UserInfo recevier) {
		this.recevier = recevier;
	}


	/**
	 * 100,系统信息,0:关注信息,1:解除关注信息,2:私信信息
	 * @return
	 */
	public String getSendType() {
		switch(this.message.getType()){
		case 0:
			sendType = "关注信息";
			break;
		case 1:
			sendType = "解除关注信息";
			break;
		case 2:
			sendType = "私信";
			break;
		case 100:
			sendType = "系统信息";
			break;
		}
		return sendType;
	}

	public String getContent() {
		switch(this.message.getType()){
		case 100:
			content = "系统信息" + this.message.getContent();
			break;
		case 0:
			content = this.getSender() != null ? this.getSender().getName() + "添加你为关注对象！" : "";
			break;
		case 1:
			content = this.getSender() != null ? this.getSender().getName() + "和你解除了关注关系...": "";
			break;
		default:
			break;
		}
		return content;
	}
}
