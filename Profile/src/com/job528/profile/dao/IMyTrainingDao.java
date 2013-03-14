package com.job528.profile.dao;

import java.util.List;

import com.job528.profile.model.MyTraining;

public interface IMyTrainingDao {

	public List<MyTraining> getMyTrainingByUserId(Integer userId);
	
	public List<MyTraining> getMyTrainingById(Integer id,Integer userId);
	
    public void addOrSave(MyTraining myTraining);
	
	public void delelte(MyTraining myTraining);
}
