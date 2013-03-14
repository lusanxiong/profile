package com.job528.profile.service.impl;

import java.util.ArrayList;
import java.util.List;


import com.job528.profile.dao.IApplyDao;
import com.job528.profile.model.MemInfo;
import com.job528.profile.model.MemPosition;
import com.job528.profile.model.MyFavouriate;
import com.job528.profile.model.MyRecommendJob;
import com.job528.profile.model.MySearcher;
import com.job528.profile.service.IApplyService;
import com.job528.profile.vo.ApplyJob;
import com.job528.profile.vo.Favouriate;
import com.job528.profile.vo.RecommendJob;
import com.job528.util.AreaUtil;
import com.job528.util.DateUtil;
import com.job528.util.Pager;
import com.job528.util.StrUtils;

public class ApplyService implements IApplyService {

	private IApplyDao applyDao;

	public IApplyDao getApplyDao() {
		return applyDao;
	}
	public void setApplyDao(IApplyDao applyDao) {
		this.applyDao = applyDao;
	}
	
	@Override
	public void delUserApplyJobByIds(String appIds){
		if(StrUtils.isNull(appIds))
			return;
		String ids[] = appIds.split(",");
		for(String id : ids){
			this.applyDao.delPubHistoryById(Integer.parseInt(id));
		}
	}
	
	
	public Pager<Favouriate> getFavouriateJobs(Integer userId, int page, int pageSize){
		int count = applyDao.getFavouriteJobCount(userId);
		if(count <= 0)
			return new Pager<Favouriate>();
		
		List<Object[]> list = applyDao.getUserFavouriteJob(userId, (page-1) * pageSize, pageSize);
		List<Favouriate> favouriateJobs = new ArrayList<Favouriate>();
		if(list != null && list.size() > 0){
			for(Object[] arrObj : list){
				
				MyFavouriate fav = new MyFavouriate();
				
				Favouriate favouriate = new Favouriate();
				MemInfo info = new MemInfo();
				MemPosition pos = new MemPosition();

				fav.setId(Integer.parseInt(arrObj[0].toString()));
				fav.setMyUserId(Integer.parseInt(arrObj[1].toString()));
				fav.setOperateDate(DateUtil.stringToDate(arrObj[2].toString()));
				fav.setNote(arrObj[3].toString());

				info.setMemId(Integer.parseInt(arrObj[4].toString()));
				info.setMemName(arrObj[5].toString());

				pos.setPosId(Integer.parseInt(arrObj[6].toString()));
				pos.setPosName(arrObj[7].toString());
				
				
				pos.setJobLocation(arrObj[8].toString());
				pos.setReqWorkyear(Short.valueOf(arrObj[9].toString()));
				pos.setReqDegreeId(Integer.parseInt(arrObj[10].toString()));

				favouriate.setMemInfo(info);
				favouriate.setPosition(pos);
				favouriate.setMyFavouriate(fav);
				favouriateJobs.add(favouriate);
			}
		}
		Pager<Favouriate> pager = new Pager<Favouriate>();
		pager.setList(favouriateJobs);
		pager.setPageNo(page);
		pager.setPageSize(pageSize);
		pager.setTotalSize(count);
		return pager;
	}
	
	
	@Override
	public Pager<ApplyJob> getUserInviteJobPagerByResId(Integer resId, int page, int pageSize){
		int count = applyDao.getInviteJobCount(resId);
		if(count <= 0)
			return new Pager<ApplyJob>();
		
		List<ApplyJob> applyList = new ArrayList<ApplyJob>();
		List<Object[]> list = applyDao.getUserInviteJob(resId, (page-1) * pageSize, pageSize);
		if(list != null && list.size() > 0){
			for(Object[] arrObj : list){
				ApplyJob applyJob = new ApplyJob();
				applyJob.setApplyId(Integer.parseInt(arrObj[0].toString()));
				applyJob.setMemId(Integer.parseInt(arrObj[1].toString()));
				applyJob.setPosId(Integer.parseInt(arrObj[2].toString()));
				applyJob.setApplyNumber(Integer.parseInt(arrObj[3].toString()));
				applyJob.setInviteFlag(arrObj[4].toString()); //
				applyJob.setMemFlag(arrObj[5].toString());    //
				applyJob.setPosState(arrObj[6].toString());   //
				applyJob.setMemName(arrObj[7].toString());
				applyJob.setPosName(arrObj[8].toString());
				applyJob.setJobLocation(arrObj[9].toString());			
				applyJob.setApplyDate(arrObj[10].toString());
				applyJob.setEndValidDate(arrObj[11].toString());
				applyJob.setMemMemo(arrObj[12].toString());
				applyJob.setMemReply(arrObj[13].toString());
				applyList.add(applyJob);
			}
		}
		
		Pager<ApplyJob> pager = new Pager<ApplyJob>();
		pager.setList(applyList);
		pager.setPageNo(page);
		pager.setPageSize(pageSize);
		pager.setTotalSize(count);
		
		return pager;
	}
	
	@Override
	public Pager<RecommendJob> getRecommendMeJobs(Integer userId, int page, int pageSize) {
		int count = applyDao.getRecommendMeJobsCount(userId);
		if(count <= 0)
			return new Pager<RecommendJob>();
		List<RecommendJob> jobList = new ArrayList<RecommendJob>();
		List<Object[]> list = applyDao.getUserRecommendMeJobs(userId, (page-1) * pageSize, pageSize);
		if(list != null && list.size() >0){
			
			for(Object[] arrObj : list){
				RecommendJob job = new RecommendJob();
				MyRecommendJob myRecommendJob = new MyRecommendJob();
				myRecommendJob.setId(Integer.parseInt(arrObj[0].toString()));
				myRecommendJob.setMemId(Integer.parseInt(arrObj[1].toString()));
				myRecommendJob.setPosId(Integer.parseInt(arrObj[2].toString()));
				job.setMemName(arrObj[3].toString());
				job.setPosName(arrObj[4].toString());
				job.setJobLocation(AreaUtil.getAddressById(arrObj[5].toString()));
				job.setSalary(arrObj[6].toString());
				job.setPostDate(arrObj[7].toString());
				myRecommendJob.setUserId(Integer.parseInt(arrObj[8].toString()));
				job.setMyRecommendJob(myRecommendJob);
				jobList.add(job);
			}
		}
		Pager<RecommendJob> pager = new Pager<RecommendJob>();
		pager.setList(jobList);
		pager.setPageNo(page);
		pager.setPageSize(pageSize);
		pager.setTotalSize(count);
		
		return pager;
	}
	@Override
	public void saveOrUpdateMySearcher(MySearcher searcher) {
		applyDao.saveOrUpdateMySearcher(searcher);
		
	}
	@Override
	public MySearcher getSearcherByUserId(Integer id) {
		return applyDao.getSearcherByUserId(id);
	}
	@Override
	public List<MySearcher> getSearchersByUserId(Integer userId, Integer id) {
		return applyDao.getSearchersByUserId(userId,id);
	}
	@Override
	public void deleteMySearcher(Integer id) {
		applyDao.deleteMySearcher(id);
	}
	@Override
	public Pager<ApplyJob> getApplyJobByResId(Integer resId, int page,
			int pageSize) {
		int count = this.applyDao.getUserApplyJobCount(resId);
		if(count <= 0)
			return new Pager<ApplyJob>();
		List<ApplyJob> applyList = new ArrayList<ApplyJob>();
		List<Object[]> list = this.applyDao.getUserApplyJob(resId, (page-1)*pageSize, pageSize);
		if(list != null && list.size() > 0){
			for(Object[] arrObj : list){
				ApplyJob applyJob = new ApplyJob();
				applyJob.setApplyId(Integer.parseInt(arrObj[0].toString()));
				applyJob.setMemId(Integer.parseInt(arrObj[1].toString()));
				applyJob.setPosId(Integer.parseInt(arrObj[2].toString()));
				applyJob.setApplyNumber(Integer.parseInt(arrObj[3].toString()));
				applyJob.setInviteFlag(arrObj[4].toString()); //
				applyJob.setMemFlag(arrObj[5].toString());    //
				applyJob.setPosState(arrObj[6].toString());   //
				applyJob.setMemName(arrObj[7].toString());
				applyJob.setPosName(arrObj[8].toString());
				applyJob.setJobLocation(arrObj[9].toString());			
				applyJob.setApplyDate(arrObj[10].toString());
				applyJob.setEndValidDate(arrObj[11].toString());
				applyJob.setMemMemo(arrObj[12].toString());
				applyJob.setMemReply(arrObj[13].toString());
				applyList.add(applyJob);
			}
		}
		
		Pager<ApplyJob> pager = new Pager<ApplyJob>();
		pager.setList(applyList);
		pager.setPageNo(page);
		pager.setPageSize(pageSize);
		pager.setTotalSize(count);
		
		return pager;
	}
	@Override
	public void delFavouriateJobs(String favIds) {
		if(StrUtils.isNull(favIds))
			return;
		String ids[] = favIds.split(",");
		for(String id : ids){
			this.applyDao.delUserFavouriteJob(Integer.parseInt(id));
		}
	}
	@Override
	public void delInviteJob(String inIds) {
		if(StrUtils.isNull(inIds))
			return;
		String ids[] = inIds.split(",");
		for(String id : ids){
			this.applyDao.delPubHistoryById(Integer.parseInt(id));
		}
	}
	@Override
	public void delRecommendJob(String reIds) {
		if(StrUtils.isNull(reIds))
			return;
		String ids[] = reIds.split(",");
		for(String id : ids){
			this.applyDao.delRecommendJobById(Integer.parseInt(id));
		}
	}

}
