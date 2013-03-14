package com.job528.lucene.search;


import com.job528.lucene.bean.SearchUserCondition;
import com.job528.lucene.bean.UserInfo;
import com.job528.lucene.bean.UserPager;

public interface ISearchUser {
	
	/**
	 * 根据条件查询用户
	 * @param condition
	 * @return
	 * @throws Exception
	 */
	public UserPager searchUserByCondition(SearchUserCondition condition) throws Exception;
	
	
	/**
	 * 根据条件查询用户
	 * @param condition
	 * @return
	 * @throws Exception
	 */
	public UserPager searchUser(SearchUserCondition condition) throws Exception;
	
	/**
	 * 根据条件随机查询用户
	 * @param condition
	 * @return
	 * @throws Exception
	 */
	public UserPager searchUserWithRandom(SearchUserCondition condition) throws Exception;
	
	/**
	 * 根据条件查询用户总数
	 * @param condition
	 * @return
	 * @throws Exception
	 */
	public Integer searchUserCountByCondition(SearchUserCondition condition) throws Exception;
	
	/**
	 * 根据用户Id查询用户信息
	 * @param userId
	 * @return
	 */
	public UserInfo getUserInfoById(Integer userId);

}
