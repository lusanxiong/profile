package com.job528.profile.service;

import java.util.List;

import com.job528.lucene.bean.Condition;
import com.job528.profile.model.MyRecommendJob;
import com.job528.profile.model.MySearcher;
import com.job528.profile.vo.Position;
import com.job528.profile.vo.Resume;
import com.job528.util.Pager;

public interface IPositionService {

	/**
	 * 查询意向职位
	 * @param resume
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public Pager<Position> getIntentionPosition(Resume resume,Integer page, Integer pageSize);
	
	
	/**
	 * 查询意向职位,简单匹配意向职位关键字、地区
	 * @param resume
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public Pager<Position> getSimpleIntentionPosition(Resume resume,Integer page, Integer pageSize);

	/**
	 * 根据条件查询职位
	 * @param condition
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public Pager<Position> getPositionByCondition(Condition condition, Integer page, Integer pageSize);

	/**
	 * 根据搜索器查询职位
	 * @param searcher
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public Pager<Position> getPositionBySearcher(MySearcher searcher, Integer page, Integer pageSize);
	
	
	/**
	 * 根据关键字查询职位
	 * @param condition
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public Pager<Position> getPositionByKeyWord(Condition condition, Integer page, Integer pageSize);

	/**
	 * 推荐职位
	 * @param myRecommendJob
	 */
	public void addRecommendJob(MyRecommendJob myRecommendJob);

	/**
	 * 批量推荐职位
	 * @param tragetIds
	 * @param userId
	 * @param posId
	 * @param memId
	 */
	public void addRecommendJob(List<Integer> tragetIds, Integer userId, Integer posId, Integer memId);

	/**
	 * 查询推荐职位
	 * @param userId
	 * @return
	 */
	public List<MyRecommendJob> getMyRecommendJobByUserId(Integer userId);

}
