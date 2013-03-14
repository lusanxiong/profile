package com.job528.profile.dao;

import java.util.List;

import com.job528.profile.model.MySearcher;

public interface IApplyDao {

	public List<Object[]> getUserApplyJob(int resId, int start, int pageSize);
	
	public int getUserApplyJobCount(int resId);

	public List<Object[]> getUserFavouriteJob(int userId, int start, int pageSize);
	
	public void delUserFavouriteJob(int favId);
	
	public int getFavouriteJobCount(int userId);
	
	public List<Object[]> getUserInviteJob(int resId, int start, int pageSize);
	
	
	public int getInviteJobCount(int resId);

	
	public void delPubHistoryById(int id);
	
	public List<Object[]> getUserRecommendMeJobs(int userId, int start, int pageSize);
	
	public int getRecommendMeJobsCount(int userId);
	
	public void delRecommendJobById(int id);
	
	public void saveOrUpdateMySearcher(MySearcher searcher);
	
	public void deleteMySearcher(Integer id);
	
	public List<MySearcher> getSearchersByUserId(Integer userId, Integer id);
	
	public MySearcher getSearcherByUserId(Integer userId);
}
