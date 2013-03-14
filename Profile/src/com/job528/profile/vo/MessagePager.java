package com.job528.profile.vo;

import java.util.List;

import com.job528.util.web.Pager;

public class MessagePager extends Pager {

	private List<Message> messageList;

	public List<Message> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
	}
}
