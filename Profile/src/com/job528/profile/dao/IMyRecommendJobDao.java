package com.job528.profile.dao;

import java.util.List;

import com.job528.profile.model.MyRecommendJob;

public interface IMyRecommendJobDao {

	public void addRecommendJob(MyRecommendJob myRecommendJob);
	
	public List<MyRecommendJob> getMyRecommendJobByUserId(Integer userId);
}
