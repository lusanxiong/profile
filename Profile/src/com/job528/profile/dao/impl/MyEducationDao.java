package com.job528.profile.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.job528.profile.dao.IMyEducationDao;
import com.job528.profile.model.MyEducation;
import com.job528.util.dao.GenericDAOHibernateImpl;

public class MyEducationDao extends GenericDAOHibernateImpl implements IMyEducationDao {

	@Override
	public List<MyEducation> getMyEducationByUserId(Integer userId) {
		String hql = "FROM MyEducation where myuserid =:userId order by endDate desc";	
		Query query = getCurrentSession().createQuery(hql);  
		query.setParameter("userId", userId);
		return query.list();
	}
	
	@Override
	public List<MyEducation> getMyEducationById(Integer id,Integer userId) {
		String hql = "FROM MyEducation where id =:id and myuserid =:userId";	
		Query query = getCurrentSession().createQuery(hql); 
		query.setParameter("id", id);
		query.setParameter("userId", userId);
		return query.list();
	}

	@Override
	public void addOrSave(MyEducation myEducation) {
		super.saveOrUpdate(myEducation);	
	}

	@Override
	public void delelte(MyEducation myEducation) {
		super.remove(MyEducation.class,myEducation.getId());
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MyEducation> getUsersLastEducation(List<Integer> userIds) {
		String sql = "select w.MyUserID,w.SchoolName from my_education w,"+
				                       "(select myuserid,max(enddate) enddate from my_education where myuserid in (:userIdList) " +
				                        "group by myuserid) t " +
				              "where t.myuserid=w.myuserid and t.enddate=w.enddate";
		
		Query query = getCurrentSession().createSQLQuery(sql);
		query.setParameterList("userIdList", userIds);
		
		List<Object[]> list = query.list();
		if(list == null || list.size() == 0) return null;
		
		List<MyEducation> result = new ArrayList<MyEducation>(list.size());
		for(Object[] obj : list) {
			if(obj==null || obj.length==0) continue;
			
			MyEducation e = new MyEducation();
			e.setMyUserId((Integer) obj[0]);
			e.setSchoolName((String) obj[1]);
			
			result.add(e);
		}
		
		return result;
	}

}
