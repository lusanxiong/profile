package com.job528.ejb.weiboToken.bean;

import java.util.List;

import com.job528.ejb.dto.UserWeiboDTO;
import com.job528.ejb.entity.WeiboToken;

/*
 * 微博同步 客户端
 */
public interface WeiboTokenDao {
	/**
	 * 微博同步
	 * 
	 */
	public int addWeiboToken(WeiboToken weiboToken);
	
	/**
	 * 修改同步状态
	 */
	public int updateWeiboActive(String sinaUserId, int status);
	
	/**
	 * 更新微博
	 * @param WeiboToken
	 * 
	 * @return 更新的记录数
	 */
	public int updateWeiboSyn(WeiboToken weiboToken);
	
	/**
	 * 删除同步
	 */
	public int delWeiboToken(int userId,String sinaUserId);
	
	/**
	 * 删除授权
	 * 
	 * @param id : 主键ID
	 * 
	 * @return 删除的记录数
	 */
	public int delWeiboToken(int id);
	
	/**
	 * 查询用户微博同步
	 * 
	 * @param userId: 用户ID
	 * @param sinaUserId：新浪用户ID
	 * 
	 * @return count:查询的记录数
	 */
	public int getCount(int userId, String sinaUserId);
	
	/**
	 * 查询用户微博同步信息
	 * @param WeiboToken 
	 * @return WeiboToken
	 */
	public WeiboToken getWeiboTokenInfo(WeiboToken wt) ;
	
	/**
	 * 查询用户所有的微博服务商的同步状态
	 * 现包括：新浪微博，腾讯微博
	 * 
	 * @param userId :用户ID
	 * @return list :用户开通的多家微博同步状态信息
	 * 
	 */
	public List<UserWeiboDTO> getUserWeiboList(int userId);
}
