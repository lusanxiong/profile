package com.job528.profile.dao;


import java.util.List;

import com.job528.profile.model.RecommendPosition;


/**
 * 推荐职位DAO
 * @author lusanxiong
 *
 */
public interface IRecommendPositionDao {
	
	/**
	 * 新增职位推荐
	 * 
	 * @param recommendUserIds 推荐人的用户ID
	 * @param RecommendPosition entity
	 * @param outerFriendEmail 站外好友的email地址
	 *
	 * @return ExecuteResult dto
	 */
	public int saveRecommendPosition(int[] recommendUserIds, RecommendPosition rp, String[] outerFriendEmail);
	
	
	/**
	 * 查询推荐职位数量
	 * 
	 * @param RecommendPosition　属性值不为NULL的都做为查询条件 
	 * @param 
	 */
	public int getCount(RecommendPosition rp);
	
	/**
	 * 查询用户的email
	 * 
	 * @param usersId,多个用户ID
	 * 
	 * @return List<String> 用户的email
	 */
	public List<String> getEmailsByUsersId(int[] usersId);
}
