package com.job528.profile.dao.impl;

import java.util.List;

import org.hibernate.Query;

import com.job528.profile.dao.IMyLanguageDao;
import com.job528.profile.model.MyLanguage;
import com.job528.util.dao.GenericDAOHibernateImpl;

public class MyLanguageDao extends GenericDAOHibernateImpl implements IMyLanguageDao {

	@Override
	public List<MyLanguage> getMyLanguageByUserId(Integer userId) {
		String hql = "FROM MyLanguage where ch_en=0 and myUserId =:userId";	
		Query query = getCurrentSession().createQuery(hql);  
		query.setParameter("userId", userId);
		return query.list();
	}
	
	@Override
	public List<MyLanguage> getMyLanguageById(Integer id,Integer userId) {
		String hql = "FROM MyLanguage where languageId=:id and ch_en=0 and myUserId =:userId";	
		Query query = getCurrentSession().createQuery(hql);  
		query.setParameter("id", id);
		query.setParameter("userId", userId);
		return query.list();
	}

	@Override
	public void delMyLanguageById(Integer languageId) {
		super.remove(MyLanguage.class,languageId);
		
	}

	@Override
	public void upDateMyLanguage(MyLanguage myLanguage) {
		super.saveOrUpdate(myLanguage);
	}

}
