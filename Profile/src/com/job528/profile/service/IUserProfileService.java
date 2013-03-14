package com.job528.profile.service;

import java.util.List;
import java.util.Map;

import com.job528.ejb.entity.Friend;
import com.job528.ejb.entity.UserProfile;
import com.job528.profile.model.MyResume;
import com.job528.profile.vo.HotFamousUserInfoDTO;

public interface IUserProfileService {
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
	 * 获取会员的工作行业名称
	 * @param userId
	 * @return
	 */
	public Map<Integer, String> getWorkCallingNames(Integer userId);
	
	/**
	 * 获取会员的工作公司名称
	 * @param userId
	 * @return
	 */
	public List<String> getWorkCompanyNames(Integer userId);
	
	/**
	 * 根据用户Id取用户微博信息
	 * @param userId
	 * @return
	 */
	public UserProfile getUserProfileByUserId(Integer userId);
	
	
	/**
	 * 根据简历信息更新会员的微博信息
	 * @param myResume
	 */
	public void updateProfile(MyResume myResume);
	
	
	/**
	 * @param top 查询多少个热门用户
	 * @param userId 当前用户id,用于查询关系
	 * 改方法根据用户的的fans数排序
	 */
	public List<Friend> getHotUsers(Integer top,Integer userId);
	
	/**
	 * 查询草根名人
	 * @param pageNo 当前页号
	 * @param pageSize 每页记录数 
	 * 
	 * @return Hot
	 * 
	 */
	public List<HotFamousUserInfoDTO> getHotFamousUserInfo(int pageNo,int pageSize) ;
}
