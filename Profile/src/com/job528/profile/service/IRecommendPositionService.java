package com.job528.profile.service;


import com.job528.profile.model.RecommendPosition;
import com.job528.profile.vo.ExecuteResult;

/**
 * 用户推荐职位 给好友
 * 
 * 推荐目标有2类：
 * 1、向站内好友推荐
 * 2、向站外好友推荐
 * 
 * @author lusanxiong
 *
 */
public interface IRecommendPositionService {
	
	/**
	 * 用户推荐职位给 “站内”好友
	 * 
	 * @param recommendUserIds 推荐人的用户ID
	 * @param RecommendPosition entity
	 *
	 * @return ExecuteResult dto
	 */
	public ExecuteResult recommendPosition(int[] recommendUserIds, RecommendPosition rp);
	
	/**
	 * 用户推荐职位给“站外”好友
	 * 
	 * @param friendsEmailList 好友邮件地址列表
	 * @param emailContent 给好友的推荐内容,为空时由系统默认推荐内容
	 * @return ExecuteResult dto
	 */
	public ExecuteResult recommendPositionToOuterFriend(String[] friendsEmailList,String emailContent,RecommendPosition rp);
	
	
	
}
