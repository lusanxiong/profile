package com.job528.ejb.user.bean;

import java.util.List;

import com.job528.ejb.dto.HotFamousUserDTO;
import com.job528.ejb.entity.Friend;
import com.job528.ejb.entity.UserProfile;

public interface UserProfileDao {

	/**
	 * 根据userId 查询用户信息
	 * @param userId
	 * @return UserProfile null表示没有数据
	 */
	public UserProfile getUserProfileById(Integer userId);
	
	/**
	 * 更新 or 添加 用户信息 ,如果 userName or headImage 为null 表示该字段不更新
	 * @param userName
	 * @param headImage
	 * @param userId
	 * @return 0成功 500失败
	 */
	public Integer mergeUserProfile(String userName,String headImage,Integer userId);
	
	/**
	 * @param top 查询多少个热门用户
	 * @param userId 当前用户id,用于查询关系
	 * 改方法根据用户的的fans数排序
	 */
	public List<Friend> getHotUsers(Integer top,Integer userId);
	
	/**
	 * 分页查询草根名人
	 * 
	 * 分别按粉丝数量，关注数量，发布的微博数量排序
	 * @param 
	 */
	public List<HotFamousUserDTO> getHotFamousUsers(int pageNo,int pageSize) ;
	
}
