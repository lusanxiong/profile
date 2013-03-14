package com.job528.profile.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;


import com.job528.ejb.entity.Param;
import com.job528.profile.dao.IMessageDao;
import com.job528.profile.model.MessageQueue;
import com.job528.profile.model.MyMessage;
import com.job528.profile.model.MyMessageData;
import com.job528.profile.model.MyMessageInfo;
import com.job528.util.DateUtil;
import com.job528.util.Pager;
import com.job528.util.dao.GenericDAOHibernateImpl;

public class MessageDao extends GenericDAOHibernateImpl implements IMessageDao {


	@Override
	public Serializable addMessage(MyMessage message) {
		return super.save(message);
	}
	
	@Override
	public MyMessageData savePrivateMessage(int userId ,int targetId ,String message){
		Map<Integer,Object> inParamsIdxAndValue = new HashMap<Integer,Object>();
		inParamsIdxAndValue.put(2, userId);
		inParamsIdxAndValue.put(3, targetId);
		inParamsIdxAndValue.put(4, message);
		
		Map<Integer, Integer> outParamsIdxAndType = new HashMap<Integer, Integer>(1);
    	outParamsIdxAndType.put(Integer.valueOf(1), Integer.valueOf(java.sql.Types.INTEGER));
    	Map<Integer, ?> result = super.execProcedure("{?=call savePrivateMessage(?,?,?)}", inParamsIdxAndValue, outParamsIdxAndType);
		Integer messageId = (Integer)result.get(1);
		if(messageId<1) {
			return null;
		}
		return getMyPrivateMessageById(messageId);
	}
	
	@Override
	public int deletePrivateMessage(int userId ,int messageId){
		Map<Integer,Object> inParamsIdxAndValue = new HashMap<Integer,Object>();
		inParamsIdxAndValue.put(2, userId);
		inParamsIdxAndValue.put(3, messageId);
		
		Map<Integer, Integer> outParamsIdxAndType = new HashMap<Integer, Integer>(1);
    	outParamsIdxAndType.put(Integer.valueOf(1), Integer.valueOf(java.sql.Types.INTEGER));
    	Map<Integer, ?> result = super.execProcedure("{?=call deletePrivateMessage(?,?)}", inParamsIdxAndValue, outParamsIdxAndType);
		return (Integer)result.get(1);
	}
	
	@Override
	public List<MyMessageData> getMyPrivateMessage(int userId,int targetId,int pageIndex, int pageSize) {
		Param p = new Param();
		p.setPageIndex(pageIndex);
		p.setPageSize(pageSize);
		p.setTable("my_message_data");
		p.setField("*");
		p.setWhere("groupId in (select id from my_message_info where (UserId="+userId+" and TargetId="+targetId+") or (UserId="+targetId+" and TargetId="+userId+")) and DeleteId <> "+userId);
		p.setOrder("CreateDate desc");
		
		Session session = getSession();
		Query query = session.createSQLQuery("{call getForPager(?,?,?,?,?,?,?)}").addEntity(MyMessageData.class);
		setQueryParams(query, p);
		return query.list();
	}
	
	@Override
	public List<MyMessageInfo> getMyPrivateMessageList(int userId,int pageIndex, int pageSize){
		Param p = new Param();
		p.setPageIndex(pageIndex);
		p.setPageSize(pageSize);
		p.setTable("my_message_info");
		p.setField("*");
		p.setWhere("UserId="+userId+" or TargetId="+userId);
		p.setOrder("UCreateDate desc");
		
		Session session = getSession();
		Query query = session.createSQLQuery("{call getForPager(?,?,?,?,?,?,?)}").addEntity(MyMessageInfo.class);
		setQueryParams(query, p);
		return query.list();
	}
	
	@Override
	public MyMessageData getMyPrivateMessageById(int messageId){
		return get(MyMessageData.class, messageId);
	}
	

	@Override
	public void updateMessage(MyMessage message) {
		super.update(message);
	}


	@Override
	public Pager<MyMessage> getMySendMessage(int sendId, int page,
			int pageSize) {
		String hql = "SELECT id,targetId,content,reply,createDate,type,sendId FROM My_Message where type=2 and sendId = ?";
		List<Object[]> objs = super.queryByNativeSQL(hql, (page-1)*pageSize, pageSize, new Object[]{sendId}, null);
		return this.object2Pager(objs);
	}

	@Override
	public Pager<MyMessage> getMyReceviedMessage(int sendId, int page,
			int pageSize) {
		String hql = "SELECT id,targetId,content,reply,createDate,type,sendId FROM My_Message where type=2 and targetId = ?";
		List<Object[]> objs = super.queryByNativeSQL(hql, (page-1)*pageSize, pageSize, new Object[]{sendId}, null);
		return this.object2Pager(objs);
	}

	@Override
	public Pager<MyMessage> getMyAttentionMessage(int sendId, int page,
			int pageSize) {
		String hql = "SELECT id,targetId,content,reply,createDate,type,sendId FROM My_Message where isRead=0 and type<2 and targetId = ?";
		List<Object[]> objs = super.queryByNativeSQL(hql, (page-1)*pageSize, pageSize, new Object[]{sendId}, null);
		return this.object2Pager(objs);
	}
	
	@Override
	public void delateMessage(int id) {
		super.remove(MyMessage.class, id);
	}

	@Override
	public MyMessage getMessageById(int id) {
		return super.get(MyMessage.class, id);
	}
	
	private Pager<MyMessage> object2Pager(List<Object[]> objs){
		Pager<MyMessage> messagePager = new Pager<MyMessage>();
		List<MyMessage> list = new ArrayList<MyMessage>();
		if(objs != null && objs.size() >0){
			for(Object[] obj : objs){
				MyMessage message = new MyMessage();
				message.setContent(obj[2].toString());
				message.setReply(obj[3].toString());
				message.setId(Integer.parseInt(obj[0].toString()));
				message.setCreateDate(DateUtil.stringToDate(obj[4].toString()));
				message.setTargetId(Integer.parseInt(obj[1].toString()));
				message.setType(Integer.parseInt(obj[5].toString()));
				message.setSendId(Integer.parseInt(obj[6].toString()));
				list.add(message);
			}
		}
		messagePager.setList(list);
		messagePager.setTotalSize(list.size());
		return messagePager;
	}
	
	/**
	 * 获取消息队列,客服端自动提取
	 * @param userId
	 * @return 消息bean
	 */
	@Override
	public MessageQueue getMessageQueue(Integer userId){
		return super.get(MessageQueue.class, userId);
	}
	
	/**
	 * 清除消息队列
	 * @param userId 当前用户id
	 * @param flag 标识符 1清除私信队列 2清除粉丝队列 3清除评论队列  other: 清除前面所有
	 */
	@Override
	public void deleteMessageQueue(Integer userId,Integer flag){
		String sql = null;
		switch (flag) {
		case 1:
			sql = "update MessageQueue set privateNumber=0 where userId=?";
			break;
		case 2:
			sql = "update MessageQueue set fansNumber=0 where userId=?";
			break;
		case 3:
			sql = "update MessageQueue set commentNumber=0 where userId=?";
			break;
		default:
			sql = "update MessageQueue set privateNumber=0,fansNumber=0,commentNumber=0 where userId=?";
			break;
		}
		super.updateByQL(sql, new Object []{userId});
	}

	//------------------------------------
	private void setQueryParams(Query query,Param p){
		int i = 0;
		query.setParameter(i++, p.getPageIndex());
		query.setParameter(i++, p.getPageSize());
		query.setParameter(i++, p.getTable());
		query.setParameter(i++, p.getField());
		query.setParameter(i++, p.getQueryField());
		query.setParameter(i++, p.getWhere());
		query.setParameter(i++, p.getOrder());
	}
}
