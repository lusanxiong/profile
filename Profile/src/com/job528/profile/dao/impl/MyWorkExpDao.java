package com.job528.profile.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.job528.profile.dao.IMyWorkExpDao;
import com.job528.profile.model.MyWorkExp;
import com.job528.util.dao.GenericDAOHibernateImpl;

import edu.emory.mathcs.backport.java.util.Arrays;

public class MyWorkExpDao extends GenericDAOHibernateImpl implements IMyWorkExpDao {

	@Override
	public List<MyWorkExp> getMyWorkExpByUserId(Integer userId) {		
		String hql = "FROM MyWorkExp where myuserid =:userId order by endDate desc";	
		Query query = getCurrentSession().createQuery(hql);  
		query.setParameter("userId", userId);
		return query.list();
	}
	
	@Override
	public List<MyWorkExp> getMyWorkExpById(Integer id,Integer userId) {
		String hql = "FROM MyWorkExp where id=:id and myuserid =:userId";	
		Query query = getCurrentSession().createQuery(hql);  
		query.setParameter("id", id);
		query.setParameter("userId", userId);
		return query.list();
	}
	
	@Override
	public void delelte(MyWorkExp myWorkExp) {
		super.remove(MyWorkExp.class,myWorkExp.getId());
		
	}

	@Override
	public void saveOrUpdate(MyWorkExp myWorkExp) {
		super.saveOrUpdate(myWorkExp);	
	}

	@Override
	public MyWorkExp getLastMyWorkExp(Integer userId) {
		String sql = "select top 1 * FROM My_WorkExp where myuserid =:userId order by endDate desc";	
		Query query = getCurrentSession().createSQLQuery(sql).addEntity(MyWorkExp.class);
		query.setParameter("userId", userId);
		MyWorkExp myWorkExp = (MyWorkExp)query.uniqueResult();
		//return query.list();
		
		return myWorkExp;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MyWorkExp> getUsersLastMyWorkExp(List<Integer> userIds) {
		
		String sql = "select w.MyUserID,JobFunctionID from my_workexp w,"+
				                       "(select myuserid,max(enddate) enddate from my_workexp where myuserid in (:userIdList)" +
				                        "group by myuserid) t " +
				              "where t.myuserid=w.myuserid and t.enddate=w.enddate";
		Query query = getCurrentSession().createSQLQuery(sql) ;
		
		query.setParameterList("userIdList", userIds);
		
		//处理返回结果
		List<MyWorkExp> result = new ArrayList<MyWorkExp>();
		
		List<Object[]> list = (List<Object[]>)query.list();
		for(int i=0; i<list.size(); i++) {
			Object[] obj = list.get(i);
			if(obj == null) continue;;
			
			MyWorkExp workExp = new MyWorkExp();
			workExp.setMyUserId((Integer)obj[0]);
			workExp.setJobFunctionId((Integer)obj[1]);
			
			result.add(workExp);
		}
		
		return result;
	}

	@Override
	public List<MyWorkExp> getUsersMyWorkExpInfo(List<Integer> userIds) {
		String sql = "select MyUserID,MemName,MemCalling from my_workexp where MyUserID in(:userIdList)";
		Query query = getCurrentSession().createSQLQuery(sql);
		query.setParameterList("userIdList", userIds);
		
		List<Object[]> list = (List<Object[]>) query.list();
		
		List<MyWorkExp> result = new ArrayList<MyWorkExp>(list.size());
		for(Object[] obj : list){
			if(obj == null || obj.length == 0) continue;
			
			MyWorkExp e = new MyWorkExp();
			e.setMyUserId((Integer)obj[0]);
			e.setMemName((String)obj[1]);
			e.setMemCalling((Integer)obj[2]);
			
			result.add(e);
		}
		
		return result;
	}
	
	
}
