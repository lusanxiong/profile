package com.job528.profile.action;


import java.util.List;

import com.job528.ejb.entity.UserProfile;
import com.job528.profile.model.PrivateMessage;
import com.job528.profile.service.IMessageService;
import com.job528.profile.service.IUserProfileService;
import com.job528.profile.vo.MessagePager;
import com.job528.util.Config;
import com.job528.util.StringUtil;


public class MessageAction extends ResumeAction {

	private IUserProfileService userProfileService;
	private IMessageService messageService; 
	private MessagePager messagePager;
	private List<PrivateMessage> list;
	private UserProfile userProfile;
	public String execute() {
		userProfile = userProfileService.getUserProfileById(getUserId());
		messagePager = messageService.getMyAttentionMessage(this.getUserId(), 1, 30);
		return SUCCESS;
	}
	
	public String savePrivateMessage() throws Exception{
		if(!isLogin()) {
			return writeText("500"); //未登录
		}
		userProfile = userProfileService.getUserProfileById(getUserId());
		int targetId = StringUtil.toInteger(request.getParameter("targetId"), 0);
		String message = StringUtil.trim(request.getParameter("message"));
		list = messageService.savePrivateMessage(getUserId(),targetId,message);
		return SUCCESS;
	}
	
	public String deletePrivateMessage() throws Exception{
		if(!isLogin()) {
			return writeText("500"); //未登录
		}
		int messageId = StringUtil.toInteger(request.getParameter("messageId"), 0);
		int result = messageService.deletePrivateMessage(getUserId(),messageId);
		return writeText(result+"");
	}
	
	public String getMyPrivateMessage(){
		if(!isLogin()) {
			return LOGIN; //未登录
		}
		return SUCCESS;
	}
	
	public String getSendList(){
		if(!isLogin()){
			return LOGIN;
		}
		userProfile = userProfileService.getUserProfileById(getUserId());
		int pageIndex = StringUtil.toInteger(request.getParameter("pageIndex"), 1);
		int targetId = StringUtil.toInteger(request.getParameter("tid"), 0);
		list = messageService.getMyPrivateMessage(getUserId(),targetId, pageIndex, Config.message.pageSize);
		return SUCCESS;
	}
	
	public String getReceivedList(){
		if(!isLogin()){
			return LOGIN;
		}
		messageService.deleteMessageQueue(getUserId(), 1); //清除私信消息 1表示私信
		userProfile = userProfileService.getUserProfileById(getUserId());
		int pageIndex = StringUtil.toInteger(request.getParameter("pageIndex"), 1);
		list = messageService.getMyPrivateMessageList(getUserId(), pageIndex, Config.message.pageSize);
		return SUCCESS;
	}
	
	
	public int getMsgCount(){
		if(this.list != null)
			return this.list.size();
		return 0;
	}
	
	public String getWho(){
		if(this.list != null && this.list.size() >0){
			return this.list.get(0).getUserName();
		}
		return "未知";
	}
	
	public IMessageService getMessageService() {
		return messageService;
	}
	public void setMessageService(IMessageService messageService) {
		this.messageService = messageService;
	}
	
	public MessagePager getMessagePager() {
		return messagePager;
	}

	public void setMessagePager(MessagePager messagePager) {
		this.messagePager = messagePager;
	}

	public List<PrivateMessage> getList() {
		return list;
	}

	public void setList(List<PrivateMessage> list) {
		this.list = list;
	}

	public IUserProfileService getUserProfileService() {
		return userProfileService;
	}

	public void setUserProfileService(IUserProfileService userProfileService) {
		this.userProfileService = userProfileService;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	
	
}
