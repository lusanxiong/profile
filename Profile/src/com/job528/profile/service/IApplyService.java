package com.job528.profile.service;

import java.util.List;

import com.job528.profile.model.MySearcher;
import com.job528.profile.vo.ApplyJob;
import com.job528.profile.vo.Favouriate;
import com.job528.profile.vo.RecommendJob;
import com.job528.util.Pager;

public interface IApplyService {
	
	public Pager<ApplyJob> getApplyJobByResId(Integer resId, int page, int pageSize);
	
	public void delUserApplyJobByIds(String appIds);
	
	public Pager<Favouriate> getFavouriateJobs(Integer userId, int page, int pageSize);
	
	public void delFavouriateJobs(String favIds);
	
	public Pager<ApplyJob> getUserInviteJobPagerByResId(Integer resId, int page, int pageSize);
	
	public void delInviteJob(String ids);
	
	public Pager<RecommendJob> getRecommendMeJobs(Integer userId, int page, int pageSize);
	
	public void delRecommendJob(String reIds);
	
    public void saveOrUpdateMySearcher(MySearcher searcher);
    
    public void deleteMySearcher(Integer id);
	
	public List<MySearcher> getSearchersByUserId(Integer userId, Integer id);
	
	public MySearcher getSearcherByUserId(Integer id);
}
