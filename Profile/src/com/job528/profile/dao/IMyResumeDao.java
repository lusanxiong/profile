package com.job528.profile.dao;

import java.util.List;
import java.util.Map;

import com.job528.profile.model.MyResume;
import com.job528.profile.model.MyUsers;

public interface IMyResumeDao {

	public List<MyResume> getResumesByIds(List<Integer> ids);
	
	public MyUsers getMyUserByUserId(Integer userId);
	
	public MyUsers getMyUserByEmail(String email);
	
	/**
	 * 根据email获取账号，排除当前用户id
	 * @param myUserId 要排除的用户id
	 * @param email
	 * @return
	 */
	public MyUsers getMyUserByEmailNotUser(Integer myUserId,String email);
	
	public void saveOrUpdateUser(MyUsers user);
	
	public MyResume getResumesByuserId(Integer userId);
	
	public void saveOrUpdate(MyResume myResume);
	
	public Map<Integer, ?> applyPosition(Integer resId,String postId, boolean reApply);
	
	public Map<Integer,?> getMyResumeSurvey(Integer userId);
	
	public Map<Integer, ?> loginQuery(String userName,String pwd,String ip);
 
	
	
	/**
	 * 获取多个用户的部分简历信息
	 */
	public List<MyResume> getUsersResume(List<Integer> userIds);
	
	/**
	 * 获取多个用户已被当前用户关注的
	 */
	public List<Integer> getAttenationUsers(int myUserId,List<Integer> userIds);
 
	
	public Integer getScore(Integer userId);

 
}