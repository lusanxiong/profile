package com.job528.profile.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.job528.lucene.LuceneManager;
import com.job528.lucene.bean.Condition;
import com.job528.lucene.bean.MemSearchBean;
import com.job528.profile.dao.IMyRecommendJobDao;
import com.job528.profile.model.MyRecommendJob;
import com.job528.profile.model.MySearcher;
import com.job528.profile.service.IPositionService;
import com.job528.profile.util.JobUtil;
import com.job528.profile.vo.Position;
import com.job528.profile.vo.Resume;
import com.job528.util.AreaUtil;
import com.job528.util.Pager;
import com.job528.util.StringUtil;

public class PositionService implements IPositionService {

	private LuceneManager lucene = LuceneManager.getInstance();
	private IMyRecommendJobDao recommendJobDao;
	
	@Override
	public Pager<Position> getIntentionPosition(Resume resume,Integer page, Integer pageSize) {
		Condition condition = JobUtil.getConditionByIntention(resume.getMyResume(),false);
		com.job528.lucene.bean.Pager pager = new com.job528.lucene.bean.Pager();
		Pager<Position> positionPager = new Pager<Position>();
		pager.setPageNo(page);
		pager.setPageSize(pageSize);
		try {
			pager = lucene.getSearchPositionService().searchIndex(condition, pager);
			if (pager != null && pager.getList() != null) {
				positionPager.setTotalSize(pager.getTotalSize());
				positionPager.setPageNo(page);
				positionPager.setPageSize(pageSize);
				List<Position> posList = new ArrayList<Position>();
				for (MemSearchBean memSearchBean : pager.getList()) {
					Position pos = new Position();
					pos.setMemSearchBean(memSearchBean);
					posList.add(pos);
				}
				positionPager.setList(posList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return positionPager;
	}
	
	
	@Override
	public Pager<Position> getSimpleIntentionPosition(Resume resume,Integer page, Integer pageSize) {
		Condition condition = JobUtil.getConditionByIntention(resume.getMyResume(),true);
		com.job528.lucene.bean.Pager pager = new com.job528.lucene.bean.Pager();
		Pager<Position> positionPager = new Pager<Position>();
		pager.setPageNo(page);
		pager.setPageSize(pageSize);
		try {
			pager = lucene.getSearchPositionService().searchIndex(condition, pager);
			if (pager != null && pager.getList() != null) {
				positionPager.setTotalSize(pager.getTotalSize());
				positionPager.setPageNo(page);
				positionPager.setPageSize(pageSize);
				List<Position> posList = new ArrayList<Position>();
				for (MemSearchBean memSearchBean : pager.getList()) {
					Position pos = new Position();
					pos.setMemSearchBean(memSearchBean);
					posList.add(pos);
				}
				positionPager.setList(posList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return positionPager;
	}
	
	
	@Override
	public Pager<Position> getPositionByCondition(Condition condition,
			Integer page, Integer pageSize) {
		Pager<Position> positionPager = new Pager<Position>();
		com.job528.lucene.bean.Pager pager = new com.job528.lucene.bean.Pager();
		pager.setPageNo(page);
		pager.setPageSize(pageSize);
		
		try {
			pager =lucene.getSearchPositionService().searchIndex(condition, pager);
			if (pager != null && pager.getList() != null) {
				positionPager.setTotalSize(pager.getTotalSize());
				positionPager.setPageNo(page);
				positionPager.setPageSize(pageSize);
				List<Position> posList = new ArrayList<Position>();
				for (MemSearchBean memSearchBean : pager.getList()) {
					Position pos = new Position();
					pos.setMemSearchBean(memSearchBean);
					posList.add(pos);
				}
				positionPager.setList(posList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return positionPager;
	}
	
	
	@Override
	public Pager<Position> getPositionBySearcher(MySearcher searcher,
			Integer page, Integer pageSize) {
		Pager<Position> positionPager = new Pager<Position>();
		com.job528.lucene.bean.Pager pager = new com.job528.lucene.bean.Pager();
		pager.setPageNo(page);
		pager.setPageSize(pageSize);
		Condition condition = this.mySearcher2Condition(searcher);
		try {
			pager =lucene.getSearchPositionService().searchIndex(condition, pager);
			if (pager != null && pager.getList() != null) {
				positionPager.setTotalSize(pager.getTotalSize());
				positionPager.setPageNo(page);
				positionPager.setPageSize(pageSize);
				List<Position> posList = new ArrayList<Position>();
				for (MemSearchBean memSearchBean : pager.getList()) {
					Position pos = new Position();
					pos.setMemSearchBean(memSearchBean);
					posList.add(pos);
				}
				positionPager.setList(posList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return positionPager;
	}
	
	
	private Condition mySearcher2Condition(MySearcher searcher){
		Condition condition = null;
		if(null != searcher){
			condition = new Condition();
			condition.setKeyword(searcher.getKeyword() != null ? searcher.getKeyword() : "");
			condition.setKeywordType(searcher.getKeywordType());
			condition.setExcludeKeyword("");
			condition.setOrderFlag(0);
			condition.setProperity(-1);
			condition.setPositionPostDate(searcher.getPositionPostDate());
			condition.setReqWorkyear(searcher.getWorkedYear1() == 0 ? 11 : searcher.getWorkedYear1());
			condition.setProvidesalary(-1);
			condition.setDegreeID(searcher.getDegreeId1());
			Object JobLocation1Name = StringUtil.isValidStr(searcher.getJobLocation1()) ? AreaUtil.getAddressById(searcher.getJobLocation1()) : "";
			
			condition.setJobLocation1_Name(JobLocation1Name != null ? JobLocation1Name.toString() : "");
			
            Object JobLocation2Name = StringUtil.isValidStr(searcher.getJobLocation2()) ? AreaUtil.getAddressById(searcher.getJobLocation2()) : "";
			
			condition.setJobLocation2_Name(JobLocation2Name != null ? JobLocation2Name.toString() : "");
			
            Object JobLocation3Name = StringUtil.isValidStr(searcher.getJobLocation3()) ? AreaUtil.getAddressById(searcher.getJobLocation3()) : "";
			
			condition.setJobLocation3_Name(JobLocation3Name != null ? JobLocation3Name.toString() : "");

            Object jobFunction1Name = searcher.getJobFunction1() > 0 ? JobUtil.getJobById(searcher.getJobFunction1().toString()) : "";
			condition.setJobFunction1Name(jobFunction1Name != null ? jobFunction1Name.toString() : "");
			Object jobFunction2Name = searcher.getJobFunction2() > 0 ? JobUtil.getJobById(searcher.getJobFunction2().toString()) : "";
			condition.setJobFunction2Name(jobFunction2Name != null ? jobFunction2Name.toString() : "");
			Object jobFunction3Name = searcher.getJobFunction3() > 0 ? JobUtil.getJobById(searcher.getJobFunction3().toString()) : "";
			condition.setJobFunction1Name(jobFunction3Name != null ? jobFunction3Name.toString() : "");
			
			Object calling1Name = searcher.getCalling1() > 0 ? JobUtil.getJobById(searcher.getCalling1().toString()) : "";
			condition.setCalling1Name(calling1Name != null ? calling1Name.toString() : "");
			
			Object calling2Name = searcher.getCalling2() > 0 ? JobUtil.getJobById(searcher.getCalling2().toString()) : "";
			condition.setCalling2Name(calling2Name != null ? calling2Name.toString() : "");
			
			Object calling3Name = searcher.getCalling3() > 0 ? JobUtil.getJobById(searcher.getCalling3().toString()) : "";
			condition.setCalling3Name(calling3Name != null ? calling3Name.toString() : "");
			
		}
		return condition;
	}


	@Override
	public void addRecommendJob(MyRecommendJob myRecommendJob) {
		recommendJobDao.addRecommendJob(myRecommendJob);
	}

	@Override
	public List<MyRecommendJob> getMyRecommendJobByUserId(Integer userId) {
		return recommendJobDao.getMyRecommendJobByUserId(userId);
	}
	
	@Override
	public void addRecommendJob(List<Integer> tragetIds, Integer userId,
			Integer posId,Integer memId) {
		for(Integer tragetId : tragetIds){
			MyRecommendJob myRecommendJob = new MyRecommendJob();
			myRecommendJob.setIsRead(false);
			myRecommendJob.setPosId(posId);
			myRecommendJob.setTragetId(tragetId);
			myRecommendJob.setUserId(userId);
			myRecommendJob.setMemId(memId);
			recommendJobDao.addRecommendJob(myRecommendJob);
		}
		
	}

	@Override
	public Pager<Position> getPositionByKeyWord(Condition condition, Integer page,
			Integer pageSize) {
		com.job528.lucene.bean.Pager pager = new com.job528.lucene.bean.Pager();
		Pager<Position> positionPager = new Pager<Position>();
		pager.setPageNo(page);
		pager.setPageSize(pageSize);
		try {
			pager = lucene.getSearchPositionService().searchIndex(condition, pager);
			if (pager != null && pager.getList() != null) {
				positionPager.setTotalSize(pager.getTotalSize());
				positionPager.setPageNo(page);
				positionPager.setPageSize(pageSize);
				List<Position> posList = new ArrayList<Position>();
				for (MemSearchBean memSearchBean : pager.getList()) {
					Position pos = new Position();
					pos.setMemSearchBean(memSearchBean);
					posList.add(pos);
				}
				positionPager.setList(posList);
			}
		} catch (Exception e) {
			
		}
		return positionPager;
	}

	public IMyRecommendJobDao getRecommendJobDao() {
		return recommendJobDao;
	}


	public void setRecommendJobDao(IMyRecommendJobDao recommendJobDao) {
		this.recommendJobDao = recommendJobDao;
	}

}
