package com.job528.profile.service.impl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.job528.lucene.bean.UserInfo;
import com.job528.lucene.search.ISearchUser;
import com.job528.profile.dao.IMessageDao;
import com.job528.profile.dao.IMyResumeDao;
import com.job528.profile.model.MyMessage;
import com.job528.profile.model.MyMessageData;
import com.job528.profile.model.MyMessageInfo;
import com.job528.profile.model.PrivateMessage;
import com.job528.profile.service.IMessageService;
import com.job528.profile.util.ResumeUtil;
import com.job528.profile.vo.Message;
import com.job528.profile.vo.MessagePager;
import com.job528.profile.model.MessageQueue;
import com.job528.util.Pager;
import com.job528.util.StrUtils;
import com.job528.util.log.MyLog;

public class MessageService implements IMessageService {

	private static final MyLog log = MyLog.getLogger(MessageService.class);
	private IMessageDao messageDao;
	private IMyResumeDao resumeDao;
	private ISearchUser searchUserService;


	public int sendMessage(MyMessage message) {
		
		if(message.getReply() == null){
			message.setReply("");
		}
		if(message.getCreateDate() == null){
			message.setCreateDate(new java.sql.Date(new Date().getTime()));
		}
		if(message.getContent() == null)
		{
			message.setContent("");
		}
		Serializable id = messageDao.addMessage(message);
		
		if(id != null){
			return Integer.valueOf(id.toString());
		}
		return 0;
	}
 
	@Override
	public List<PrivateMessage> savePrivateMessage(int userId, int targetId, String message) {
		List<PrivateMessage> list = null;
		MyMessageData myMessageData = messageDao.savePrivateMessage(userId, targetId, message);
		if(null != myMessageData) {
			list = new ArrayList<PrivateMessage>();
			PrivateMessage pm = new PrivateMessage();
			pm.setMyMessageData(myMessageData);
			pm.setHeadImage("/images/people.gif");
			pm.setUserName("tanggaohong");
			list.add(pm);
		}
		return list;
	}
	
	public void batchSendPrivateMessage(int userId ,String targetIds ,String message){
		if(StrUtils.isNull(targetIds) || StrUtils.isNull(message))
			return;
		String tids[] = targetIds.split(",");
		for(String tid : tids){
			messageDao.savePrivateMessage(userId, Integer.parseInt(tid), message);
		}
	}
	
	
	/**
	 * 删除一条私信
	 */
	@Override
	public int deletePrivateMessage(int userId ,int messageId){
		return messageDao.deletePrivateMessage(userId, messageId);
	}
	
	/**
	 * 根据messageId 查询私信
	 * @param messageId
	 * @return
	 */
	public MyMessageData getMyPrivateMessageById(int messageId) {
		return messageDao.getMyPrivateMessageById(messageId);
	}
	
	/**
	 * 查询我的私信
	 * @param userId
	 */
	@Override
	public List<PrivateMessage> getMyPrivateMessage(int userId,int targetId,int pageIndex, int pageSize) {
		List<PrivateMessage> list = null;
		List<MyMessageData> list2 = messageDao.getMyPrivateMessage(userId,targetId,pageIndex,pageSize);
		if(null == list2 || list2.isEmpty()) {
			return null;
		}
		UserInfo userInfo = new UserInfo();
		userInfo = this.searchUserService.getUserInfoById(targetId);
		list = new ArrayList<PrivateMessage>();
		for(MyMessageData m : list2){
			PrivateMessage pm = new PrivateMessage();
			
			pm.setMyMessageData(m);
			if(userInfo != null){
				String imgh = userInfo.getPhoto();
				if(StrUtils.isNull(imgh))
					pm.setHeadImage("../" + ResumeUtil.defaultHeadImg);
				else{
					if(imgh.indexOf("http://") != -1){
						pm.setHeadImage(imgh);
					}
					else{
						pm.setHeadImage("../" + imgh);
					}
				}
				pm.setUserName(userInfo.getName());
			}else{
			    pm.setHeadImage("../" + ResumeUtil.defaultHeadImg);
			    pm.setUserName("未知");
			}
			list.add(pm);
		}
		return list;
	}

	/**
	 * 查询我的私信列表
	 * @param userId
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@Override
	public List<PrivateMessage> getMyPrivateMessageList(int userId,int pageIndex, int pageSize){
		List<PrivateMessage> list = null;
		List<MyMessageInfo> list2 = messageDao.getMyPrivateMessageList(userId,pageIndex,pageSize);
		if(null == list2 || list2.isEmpty()) {
			return null;
		}
		list = new ArrayList<PrivateMessage>();
		for(MyMessageInfo m : list2){
			int tid = m.getTargetId();
			if(userId == tid){
				tid = m.getUserId();
			}
			UserInfo userInfo = this.searchUserService.getUserInfoById(tid);
			PrivateMessage p = new PrivateMessage();
			p.setMyMessageInfo(m);
			if(userInfo != null){
				String imgh = userInfo.getPhoto();
				if(StrUtils.isNull(imgh))
					p.setHeadImage("../" + ResumeUtil.defaultHeadImg);
				else{
					if(imgh.indexOf("http://") != -1){
						p.setHeadImage(imgh);
					}
					else{
						p.setHeadImage("../" + imgh);
					}
				}
				p.setUserName(userInfo.getName());
			}else{
				p.setHeadImage("../" + ResumeUtil.defaultHeadImg);
			    p.setUserName("未知");
			}
			list.add(p);
		}
		return list;
	}
	
	@Override
	public void deleteMessage(int id) {
		messageDao.delateMessage(id);
	}
	
	@Override
	public MessagePager getMySendMessage(int userId, int page, int pageSize) {
		MessagePager messagePager = new MessagePager();
		List<Message> messageList = new ArrayList<Message>();
		Pager<MyMessage> myMessages = messageDao.getMySendMessage(userId, page, pageSize);
		if(myMessages != null && myMessages.getList() != null){
		for(MyMessage myMessage : myMessages.getList()){
			Message message = new Message();
			message.setMessage(myMessage);
			UserInfo recevier = searchUserService.getUserInfoById(myMessage.getTargetId());
			message.setRecevier(recevier);
			messageList.add(message);
		}
		}
		messagePager.setMessageList(messageList);
		messagePager.setDataCount(myMessages.getTotalSize());
		return messagePager;
	}
	
	
	@Override
	public MessagePager getMyReceviedMessage(int userId, int page,
			int pageSize) {
		MessagePager messagePager = new MessagePager();
		List<Message> messageList = new ArrayList<Message>();
		Pager<MyMessage> myMessages = messageDao.getMyReceviedMessage(userId, page, pageSize);
		if(myMessages != null && myMessages.getList() != null){
		for(MyMessage myMessage : myMessages.getList()){
			Message message = new Message();
			message.setMessage(myMessage);
			UserInfo sender = searchUserService.getUserInfoById(myMessage.getSendId());
			message.setSender(sender);
			messageList.add(message);
		}
		}
		messagePager.setMessageList(messageList);
		messagePager.setDataCount(myMessages.getTotalSize());
		return messagePager;
	}
	
	@Override
	public MessagePager getMyAttentionMessage(int userId, int page, int pageSize) {
		MessagePager messagePager = new MessagePager();
		List<Message> messageList = new ArrayList<Message>();
		Pager<MyMessage> myMessages = messageDao.getMyAttentionMessage(userId, page, pageSize);
		if(myMessages != null && myMessages.getList() != null){
		for(MyMessage myMessage : myMessages.getList()){
			Message message = new Message();
			message.setMessage(myMessage);
			int tid = myMessage.getTargetId();
			if(userId == tid){
				tid = myMessage.getSendId();
			}
			UserInfo sender = searchUserService.getUserInfoById(tid);
			message.setSender(sender);
			messageList.add(message);
		}
		}
		messagePager.setMessageList(messageList);
		messagePager.setDataCount(myMessages.getTotalSize());
		return messagePager;
	}
	
	
	@Override
	public void updateMessage(MyMessage message) {
		messageDao.updateMessage(message);	
	}
	
	@Override
	public MyMessage getMessage(int id) {
		return messageDao.getMessageById(id);
	}
	
	
	/**
	 * 获取消息队列,客服端自动提取
	 * @param userId
	 * @return 消息bean
	 */
	@Override
	public MessageQueue getMessageQueue(Integer userId){
		MessageQueue mq = messageDao.getMessageQueue(userId);
		if(null == mq) {
			mq = new MessageQueue();
		}
		return mq;
	}
	
	/**
	 * 清除消息队列
	 * @param userId 当前用户id
	 * @param flag 标识符 1清除私信队列 2清除粉丝队列 3清除评论队列 other: 清除前面所有
	 */
	@Override
	public void deleteMessageQueue(Integer userId,Integer flag){
		messageDao.deleteMessageQueue(userId, flag);
	}
	
	public IMessageDao getMessageDao() {
		return messageDao;
	}
	public void setMessageDao(IMessageDao messageDao) {
		this.messageDao = messageDao;
	}

	public IMyResumeDao getResumeDao() {
		return resumeDao;
	}


	public void setResumeDao(IMyResumeDao resumeDao) {
		this.resumeDao = resumeDao;
	}

	
	public ISearchUser getSearchUserService() {
		return searchUserService;
	}

	public void setSearchUserService(ISearchUser searchUserService) {
		this.searchUserService = searchUserService;
	}

}
