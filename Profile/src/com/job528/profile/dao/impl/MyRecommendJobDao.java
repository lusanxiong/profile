package com.job528.profile.dao.impl;

import java.util.List;

import org.hibernate.Query;

import com.job528.profile.dao.IMyRecommendJobDao;
import com.job528.profile.model.MyRecommendJob;
import com.job528.util.dao.GenericDAOHibernateImpl;

public class MyRecommendJobDao extends GenericDAOHibernateImpl implements IMyRecommendJobDao {

	@Override
	public void addRecommendJob(MyRecommendJob myRecommendJob) {
		super.saveOrUpdate(myRecommendJob);
	}

	@Override
	public List<MyRecommendJob> getMyRecommendJobByUserId(Integer userId) {
		String hql = "FROM MyRecommendJob where userId =:userId order by recDate desc";	
		Query query = getCurrentSession().createQuery(hql);  
		query.setParameter("userId", userId);
		return query.list();
	}

}
