package com.job528.profile.dao;

import java.util.List;

import com.job528.profile.model.MyEducation;

public interface IMyEducationDao {
	public List<MyEducation> getMyEducationByUserId(Integer userId);
	
	public void addOrSave(MyEducation myEducation);
	
	public void delelte(MyEducation myEducation);
	
	public List<MyEducation> getMyEducationById(Integer id,Integer userId);
	
	/**
	 * 查询多个用户的最近一次的教育经历
	 */
	public List<MyEducation> getUsersLastEducation(List<Integer> userIds);
}
