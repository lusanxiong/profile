package com.job528.profile.dao.impl;

import java.util.List;

import org.hibernate.Query;

import com.job528.profile.dao.IMyTrainingDao;
import com.job528.profile.model.MyTraining;
import com.job528.util.dao.GenericDAOHibernateImpl;

public class MyTrainingDao extends GenericDAOHibernateImpl implements IMyTrainingDao {

	@Override
	public List<MyTraining> getMyTrainingByUserId(Integer userId) {		
		String hql = "FROM MyTraining where myuserid =:userId order by endDate desc";	
		Query query = getCurrentSession().createQuery(hql);  
		query.setParameter("userId", userId);
		return query.list();
	}
	
	@Override
	public List<MyTraining> getMyTrainingById(Integer id,Integer userId) {
		String hql = "FROM MyTraining where id =:id and myuserid =:userId";	
		Query query = getCurrentSession().createQuery(hql);
		query.setParameter("id", id);
		query.setParameter("userId", userId);
		return query.list();
	}

	@Override
	public void addOrSave(MyTraining myTraining) {
		super.saveOrUpdate(myTraining);	
		
	}

	@Override
	public void delelte(MyTraining myTraining) {
		super.remove(MyTraining.class,myTraining.getId());
		
	}

}
