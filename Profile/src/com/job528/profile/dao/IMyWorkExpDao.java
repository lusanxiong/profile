package com.job528.profile.dao;

import java.util.List;

import com.job528.profile.model.MyWorkExp;

public interface IMyWorkExpDao {

	public List<MyWorkExp> getMyWorkExpByUserId(Integer userId);
	
	public List<MyWorkExp> getMyWorkExpById(Integer id,Integer userId);
	
	public void delelte(MyWorkExp myWorkExp);

	public void saveOrUpdate(MyWorkExp myWorkExp);
	
	/*
	 * 查询用户最近一次工作经历
	 */
	public MyWorkExp getLastMyWorkExp(Integer userId);
	
	/*
	 * 查询多个户最近一次工作经历
	 */
	public List<MyWorkExp> getUsersLastMyWorkExp(List<Integer> userIds);
	
	/*
	 * 查询多个用户工作经历的部分字段
	 */
	public List<MyWorkExp> getUsersMyWorkExpInfo(List<Integer> userIds);
	
}
