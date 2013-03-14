package com.job528.profile.service;


import java.util.List;

import com.job528.profile.model.MyMessage;
import com.job528.profile.model.MyMessageData;
import com.job528.profile.model.PrivateMessage;
import com.job528.profile.vo.MessagePager;
import com.job528.profile.model.MessageQueue;

public interface IMessageService {

	/**
	 * 发送一条信息
	 * @param message
	 * @return
	 */
	public int sendMessage(MyMessage message);
	
	/**
	 * 保存一条私信
	 */
	public List<PrivateMessage> savePrivateMessage(int userId ,int targetId ,String message);
	
	
	/**
	 * 批量发送私信
	 */
	public void batchSendPrivateMessage(int userId ,String targetIds ,String message);
	
	/**
	 * 删除一条私信
	 */
	public int deletePrivateMessage(int userId ,int messageId);
	
	/**
	 * 根据messageId 查询私信
	 * @param messageId
	 * @return
	 */
	public MyMessageData getMyPrivateMessageById(int messageId);
	
	/**
	 * 查询我的私信
	 * @param userId
	 */
	public List<PrivateMessage> getMyPrivateMessage(int userId,int targetId,int pageIndex, int pageSize);
	
	/**
	 * 查询我的私信列表
	 * @param userId
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public List<PrivateMessage> getMyPrivateMessageList(int userId,int pageIndex, int pageSize);
	
	/**
	 * 删除一条信息
	 * @param id
	 */
	public void deleteMessage(int id);
	
	
	/**
	 * 获取一条信息
	 * @param id
	 */
	public MyMessage getMessage(int id);
	
	/**
	 * 更新一条信息
	 * @param id
	 */
	public void updateMessage(MyMessage message);
	
	/**
	 * 获取我发送的信息
	 * @param userId
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public MessagePager getMySendMessage(int userId,int page,int pageSize);
	
	/**
	 * 获取我收到的信息
	 * @param userId
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public MessagePager getMyReceviedMessage(int userId,int page,int pageSize);
	
	/**
	 * 获取关注信息
	 * @param userId
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public MessagePager getMyAttentionMessage(int userId,int page,int pageSize);
	
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
