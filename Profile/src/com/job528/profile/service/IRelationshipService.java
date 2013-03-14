package com.job528.profile.service;


import java.util.List;

import com.job528.ejb.entity.Friend;
import com.job528.ejb.entity.Friends;
import com.job528.ejb.entity.Pager;
import com.job528.ejb.entity.Relationship;

public interface IRelationshipService {
	/**
	 * 添加一个fans 
	 * @param fans
	 * @return 1,2 成功 , 100已经存在 , 500失败
	 */
	public Integer saveRelationship(Relationship relationship);
	/**
	 * 删除一个fans
	 * @param fans
	 * @return 0成功 , 500 失败
	 */
	public Integer deleteRelationship(Relationship relationship);
	
	/**
	 * 根据userId,groupId 查询其所关注的人 
	 * @return List<Friend> null表示没有数据
	 */
	public List<Friends> getAttentionByUserIdForPager(Integer userId,Integer groupId,Integer pageIndex,Integer pageSize);
	
	/**
	 * 根据userId,groupId 查询其粉丝 
	 * @return List<Fans> null表示没有数据
	 */
	public List<Friends> getFansByUserIdForPager(Integer userId,Integer groupId,Integer pageIndex,Integer pageSize);
	
	/**
	 * 更改用户分组
	 * @param userId 当前用户id
	 * @param otherUserId 所关注人id
	 * @param newGroupId 新的分组 id
	 * @return 0成功 200失败(没有更新记录)
	 */
	public Integer updateGroupId(Integer userId,Integer otherUserId,Integer newGroupId);
	
	/**
	 * 根据groupId 查询其关注人的Id
	 * @param userId
	 * @param groupId
	 * @return Pager<Integer> null 表示没有数据
	 */
	public Pager<Friend> getAttentionByGroupId(Integer userId,Integer groupId,Integer pageIndex,Integer pageSize);
	
	/**
	 * 根据groupId 查询关注我人(粉丝)的Id
	 * @param userId
	 * @param groupId
	 * @param pageIndex
	 * @param pageSize
	 * @return Pager<Integer> null 表示没有数据
	 */
	public Pager<Friend> getFansByGroupId(Integer userId,Integer groupId,Integer pageIndex,Integer pageSize);
	
	/**
	 * 查询两个用户之间的关系
	 * @param userId 当前用户id
	 * @param otherUserId 比较用户id
	 * @return 0未关注 , 1单边关注  , 2互相关注 , 3自己不能关注自己
	 */
	public Integer getRelationshipFlag(Integer userId,Integer otherUserId);
	
	/**
	 * 根据用户id查询 与其关系和基本信息
	 * @param userId 
	 * @param otherUserId
	 * @return 
	 * Friend flag=-1表示无关系, 
	 * UserProfile为null 表示无信息, 
	 * 返回时 friend.getUserId() 得到为otherUserId的值
	 */
	public Friend getRelationshipByUserId(Integer userId,Integer otherUserId);

	/**
	 * 根据userId ,groupId 查询记录总数
	 * @param userId
	 * @param groupId
	 * @return 0表示无记录
	 */
	public Integer getCountByUserId(Integer userId, Integer groupId);
	
	
}
