package com.job528.profile.service;

import java.util.ArrayList;
import java.util.List;

import com.job528.profile.LoginInfo;
import com.job528.profile.model.MyEducation;
import com.job528.profile.model.MyLanguage;
import com.job528.profile.model.MyResume;
import com.job528.profile.model.MyTraining;
import com.job528.profile.model.MyUsers;
import com.job528.profile.model.MyWorkExp;
import com.job528.profile.vo.Experience;

public interface IMyResumeService {
	
	/**
	 * 获取账号信息
	 * @param userId
	 * @return
	 */
	public MyUsers getAccountInfoByUserId(Integer userId);
	
	/**
	 * 获取账号信息
	 * @param email
	 * @return
	 */
	public MyUsers getAccountInfoByEmail(String email);
	
	
	/**
	 * 验证邮箱是否被其他用户占用
	 * @param myUserId
	 * @param email
	 * @return
	 */
	public boolean verificateMail(Integer myUserId,String email);
	
	/**
	 * 修改账户信息
	 * @param account
	 */
	public void updateAccountInfo(MyUsers account);

	/**
	 * 获取简历信息
	 * @param userId
	 * @return
	 */
	public MyResume getResumeByUserId(Integer userId);

	/**
	 * 查询会员的工作经历
	 * 
	 * @param userId
	 * @return
	 */
	public List<MyWorkExp> getWorkExpByUserId(Integer userId);
	
	/**
	 * 查询单条会员的工作经历
	 * @param id , userId
	 * @return
	 */
	public List<MyWorkExp> getWorkExpById(Integer id,Integer userId); 
	
	/**
	 * 查询会员的最近一次工作经历
	 */
	public Experience getLastWorkExp(Integer userId) ;
	

	/**
	 * 查询会员的教育经历
	 * 
	 * @param userId
	 * @return
	 */
	public List<MyEducation> getEducationByUserId(Integer userId);
	
	/**
	 * 查询会员的单条教育经历
	 * @param userId id
	 * @return
	 */
	public List<MyEducation> getEducationById(Integer id,Integer userId);

	/**
	 * 查询会员的培训经历
	 * 
	 * @param userId
	 * @return
	 */
	public List<MyTraining> getTrainingByUserId(Integer userId);
	
	/**
	 * 查询单条会员的培训经历
	 * 
	 * @param userId id
	 * @return
	 */
	public List<MyTraining> getTrainingById(Integer id,Integer userId);

	/**
	 * 查询会员的语言能力
	 * 
	 * @param userId
	 * @return
	 */
	public List<MyLanguage> getLanguageByUserId(Integer userId);
	
	/**
	 * 查询会员单条语言能力
	 * 
	 * @param userId
	 * @return
	 */
	public List<MyLanguage> getLanguageById(Integer id,Integer userId);
	
	
	public void delMyLanguageById(Integer languageId);
	
	
	public void addorUpdateDateMyLanguage(MyLanguage myLanguage);

	/**
	 * 添加修改教育信息
	 * @param myEducation
	 */
	public void addOrUpdateEducation(MyEducation myEducation);

	/**
	 * 删除修改教育信息
	 * @param myEducation
	 */
	public void deleteEducation(MyEducation myEducation);

	/**
	 * 添加修改培训信息
	 * @param myTraining
	 */
	public void addOrUpdateTraining(MyTraining myTraining);

	
	/**
	 * 删除培训信息
	 * @param myTraining
	 */
	public void deleteTraining(MyTraining myTraining);
	
	/**
	 * 更新简历
	 * @param myResume
	 * @param upDateWeibo
	 */
	public void updateResume(MyResume myResume,boolean upDateWeibo);
	
	/**
	 * 删除工作经历
	 * @param myWorkExp
	 */
	public void deleteWorkExp(MyWorkExp myWorkExp);

	/**
	 * 更新工作经历
	 * @param myWorkExp
	 */
	public void saveOrUpdate(MyWorkExp myWorkExp);
	
	/**
	 * 获取简历完整程度
	 * @param userId
	 * @param type
	 * @return
	 */
	public String getResumeStatePer(Integer userId, Integer type);
	
    /**
     * 登录
     * @param loginName
     * @param pwd
     * @param ip
     * @param loginInfo
     * @return
     */
	public Integer login(String loginName, String pwd, String ip, LoginInfo loginInfo);
	
	/**
	 * 用户登录
	 * 
	 * @return -1代表登录失败
	 */
	public Integer login(int userId,String ip,LoginInfo logininfo);
	
	/**
	 * 获取简历百分比
	 * @param userId
	 * @return 0-100
	 */
	public Integer getScore(Integer userId);
	
	public List<Experience> getUsersLastWorkExp(List<Integer> userIds);


	public List<MyWorkExp> getUsersWorkExp(
			List<Integer> userIds);

	public List<MyEducation> getUsersLastEducation(List<Integer> userIds);

	public List<MyResume> getUsersResumeInfo(List<Integer> userIds);

	public List<Integer> getAttenationUsers(int myUserId,List<Integer> userIds);
	
}
