package com.job528.profile.service;

import java.util.List;

import com.job528.lucene.bean.UserInfo;
import com.job528.lucene.bean.UserPager;
import com.job528.profile.model.MyResume;
import com.job528.profile.vo.Follower;
import com.job528.profile.vo.UserSearchCondition;
import com.job528.util.Pager;

public interface IFriendService {

	/**
	 * 随机获取可能认识的朋友
	 * @param count
	 * @return
	 */
	public List<UserInfo> getMayKnowFriendWithRandom(Integer count, MyResume resume);
	
	
	
	/**
	 * 获取我关注的朋友
	 * @param userId
	 * @param groupId
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public Pager<Follower> getMyFollows(Integer userId, Integer groupId, Integer pageIndex,Integer pageSize);
	
	
	/**
	 * 获取其他好友（targetId）关注的朋友
	 * @param userId
	 * @param targetId
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public Pager<Follower> getOtherFollows(Integer userId, Integer targetId, Integer pageIndex,Integer pageSize);
	
	
	
	
	/**
	 * 获取关注我的朋友
	 * @param userId
	 * @param groupId
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public Pager<Follower> getFans(Integer userId,Integer pageIndex,Integer pageSize);
	
	
	
	/**
	 * 获取关注好友的朋友
	 * @param userId
	 * @param groupId
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public Pager<Follower> getOtherFans(Integer userId, Integer targetId, Integer pageIndex, Integer pageSize);
	
	
	/**
	 * 搜索朋友
	 * @param userId
	 * @param groupId
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public Pager<Follower> searchFriends(Integer userId,UserSearchCondition ucondition,Integer pageIndex,Integer pageSize);
	
	
	
	/**
	 * 获取我关注的朋友包含分组信息
	 * @param userId
	 * @param groupId
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	//public Pager<UserInfo> getMyAttentionFriendsWithGroup(Integer userId, Integer groupId, Integer pageIndex,Integer pageSize);
	

	public Pager<UserInfo> getMyFans(Integer userId, Integer groupId, Integer pageIndex,Integer pageSize);
	
	
	/**
	 * 关注好友
	 * @param userId
	 * @param targetId
	 * @param group
	 * @return
	 */
	public Integer attentionFriend(Integer userId,Integer targetId,Integer group);
	
	
	/**
	 * 批量关注好友
	 * @param userId
	 * @param targetId
	 * @param group
	 * @return 0 失败
	 */
	public Integer batchAttentionFriend(String targetIds,Integer userId,Integer group);
	
	
	/**
	 * 取消关注
	 * @param userId
	 * @param targetId
	 * @param group
	 * @return
	 */
	public Integer unAttentionFriend(Integer userId,Integer targetId);
	
	
	/**
	 * 批量取消关注好友
	 * @param userId
	 * @param targetId
	 * @param group
	 * @return 0 失败
	 */
	public Integer batchUnAttentionFriend(String targetIds,Integer userId);
	
	
	
	/**
	 * 批量移除粉丝
	 * @param userId
	 * @param targetId
	 * @param group
	 * @return 0 失败
	 */
	public Integer batchDelFans(String targetIds,Integer userId);
	
	/**
	 * 修改还有分组
	 * @param userId
	 * @param targetId
	 * @param group
	 * @return
	 */
	public Integer changeFriendGroup(Integer userId,Integer targetId,Integer group);
	
	
	/**
	 * 修改还有分组
	 * @param userId
	 * @param targetId
	 * @param group
	 * @return
	 */
	public Integer batchEditFriendGroup(String targetIds,Integer userId,Integer group);

	/**
	 * 获取所有可能认识的朋友（不分组）
	 * @param resume
	 * @param pageIndex
	 * @param pageSize
	 * @param random 是否随机
	 * @return
	 */
	public UserPager getMayBeFriendNoGroup(MyResume resume, Integer pageIndex,
			Integer pageSize,boolean random);
	
	/**
	 * 获取活跃用户
	 * @param userId
	 * @return
	 */
	public Follower getHotUser(Integer userId);
	
	
	
	/**
	 * 获取活跃用户
	 * @param userId
	 * @return
	 */
	public List<Follower> getTopHotUser(Integer top);
	
	/**
	 * 获取userid 和 targetId 的关系
	 * @param userId
	 * @param targetId
	 * @return
	 */
	public Integer getRelationFlag(Integer userId,Integer otherUserId);
	
	
	/**
	 * 获取用户搜索的条件信息
	 * 
	 * 作为搜索条件的好友类型与好友用户ID
	 */
	
	/*public List<Map<FriendType, Integer>>*/

	
}
