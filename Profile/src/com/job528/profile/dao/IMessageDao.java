package com.job528.profile.dao;

import java.io.Serializable;
import java.util.List;

import com.job528.profile.model.MyMessage;
import com.job528.profile.model.MyMessageData;
import com.job528.profile.model.MyMessageInfo;
import com.job528.profile.model.MessageQueue;
import com.job528.util.Pager;

public interface IMessageDao {

	/**
	 * 添加一条新消息
	 * @param message
	 * @return
	 */
	public Serializable addMessage(MyMessage message);
	
	/**
	 * 保存一条私信
	 */
	public MyMessageData savePrivateMessage(int userId ,int targetId ,String message);
	
	/**
	 * 删除一条私信
	 */
	public int deletePrivateMessage(int userId ,int messageId);
	
	/**
	 * 查询我的私信
	 * @param userId
	 */
	public List<MyMessageData> getMyPrivateMessage(int userId,int targetId,int pageIndex, int pageSize);
	
	/**
	 * 查询我的私信列表
	 * @param userId
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public List<MyMessageInfo> getMyPrivateMessageList(int userId,int pageIndex, int pageSize);
	
	/**
	 * 根据messageId 查询私信
	 * @param messageId
	 * @return
	 */
	public MyMessageData getMyPrivateMessageById(int messageId);
	/**
	 * 更新一条新消息
	 * @param message
	 */
	public void updateMessage(MyMessage message);
	
	/**
	 * 删除一条信息
	 * @param id
	 */
	public void delateMessage(int id);
	
	/**
	 * 获取一条信息
	 * @param id
	 * @return
	 */
	public MyMessage getMessageById(int id);
	
	/**
	 * 获取发送的消息
	 * @param sendId
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public Pager<MyMessage> getMySendMessage(int sendId, int page, int pageSize);
	
	/**
	 * 获取接收到的信息
	 * @param sendId
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public Pager<MyMessage> getMyReceviedMessage(int sendId, int page, int pageSize);
	
	/**
	 * 获取关注信息
	 * @param sendId
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public Pager<MyMessage> getMyAttentionMessage(int sendId, int page, int pageSize);
	
	/**
	 * 获取消息队列,客服端自动提取
	 * @param userId
	 * @return 消息bean
	 */
	public MessageQueue getMessageQueue(Integer userId);
	
	/**
	 * 清除消息队列
	 * @param userId 当前用户id
	 * @param flag 标识符 1清除私信队列 2清除粉丝队列 3清除评论队列 other: 清除前面所有
	 */
	public void deleteMessageQueue(Integer userId,Integer flag);
}
