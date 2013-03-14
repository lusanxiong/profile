package com.job528.profile.dao.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;


import com.job528.profile.dao.IMyResumeDao;
import com.job528.profile.model.MyResume;
import com.job528.profile.model.MyUsers;
import com.job528.util.dao.GenericDAOHibernateImpl;

/**
 * A data access object (DAO) providing persistence and search support for
 * MyResume entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.job528.profile.MyResume
 * @author MyEclipse Persistence Tools
 */

public class MyResumeDao extends GenericDAOHibernateImpl implements IMyResumeDao {
	private static final Log log = LogFactory.getLog(MyResumeDao.class);

	@Override
	public List<MyResume> getResumesByIds(List<Integer> ids) {
		String hql = "FROM MyResume where MyUserId in (:idList)";
		
		Query query = getCurrentSession().createQuery(hql);  
		query.setParameterList("idList", ids);
		return query.list();
	}


	@Override
	public MyResume getResumesByuserId(Integer userId) {
		String hql = "FROM MyResume where MyUserId =:id order by updateDate desc";
		Query query = getCurrentSession().createQuery(hql);  
		query.setParameter("id", userId);
		List<MyResume> resumes = query.list();
		if(resumes != null && resumes.size() > 0)
			return resumes.get(0);
		return null;
	} 
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MyResume> getUsersResume(List<Integer> userIds) {
		String sql = "select hometown,MyUserId from my_resume where MyUserId in (:useridList)";
		Query query = getCurrentSession().createSQLQuery(sql);
		query.setParameterList("useridList", userIds);
		
		List<Object[]> list = (List<Object[]>)query.list();
		if(list == null || list.size() == 0) return null;
		int size = list.size();
		
		//处理返回结果
		List<MyResume> result = new ArrayList<MyResume>(size);
		for(int i=0; i<size; i++) {
			Object[] obj = list.get(i);
			if(obj == null || obj.length == 0) continue;
			
			MyResume myResume = new MyResume();
			
			myResume.setHometown((String) obj[0]);
			myResume.setMyUserId((Integer) obj[1]);
			result.add(myResume);
		}
		return result;
	} 


	@Override
	public void saveOrUpdate(MyResume myResume) {
		super.saveOrUpdate(myResume);	
	}
	
	@Override
	public Map<Integer, ?> applyPosition(Integer resId,String postId, boolean reApply){
		
		String sql = "{?=call  Apply_position_batch(?,?,?,?,?,?,?,?,?,?) }";
		Map inParamsIdxAndValue = new HashMap(3);
		inParamsIdxAndValue.put(Integer.valueOf(9), resId);
		inParamsIdxAndValue.put(Integer.valueOf(10), postId);
		inParamsIdxAndValue.put(Integer.valueOf(11), reApply ? 1 :0);
    	
    	Map<Integer, Integer> outParamsIdxAndType = new HashMap(8);
    	outParamsIdxAndType.put(Integer.valueOf(1), Integer.valueOf(java.sql.Types.NUMERIC));
    	outParamsIdxAndType.put(Integer.valueOf(2), Integer.valueOf(java.sql.Types.VARCHAR));
    	outParamsIdxAndType.put(Integer.valueOf(3), Integer.valueOf(java.sql.Types.NUMERIC));
    	outParamsIdxAndType.put(Integer.valueOf(4), Integer.valueOf(java.sql.Types.NUMERIC));
    	outParamsIdxAndType.put(Integer.valueOf(5), Integer.valueOf(java.sql.Types.NUMERIC));
    	outParamsIdxAndType.put(Integer.valueOf(6), Integer.valueOf(java.sql.Types.VARCHAR));
    	outParamsIdxAndType.put(Integer.valueOf(7), Integer.valueOf(java.sql.Types.VARCHAR));
    	outParamsIdxAndType.put(Integer.valueOf(8), Integer.valueOf(java.sql.Types.VARCHAR));
    	
    	Map<Integer, ?> resultMap = super.execProcedure(sql, inParamsIdxAndValue, outParamsIdxAndType);
    	
		return resultMap;
	}


	@Override
	public MyUsers getMyUserByUserId(Integer userId) {
		String hql = "FROM MyUsers where MyUserId =:id ";
		Query query = getCurrentSession().createQuery(hql);  
		query.setParameter("id", userId);
		List<MyUsers> users = query.list();
		if(users != null && users.size() > 0)
			return users.get(0);
		return null;
	}


	@SuppressWarnings("deprecation")
	@Override
	public Map<Integer, ?> getMyResumeSurvey(Integer userId) {
		String sql = "{call  ResumeSurvey(?,?,?,?,?,?,?,?,?,?)}";
		Map inParamsIdxAndValue = new HashMap(1);
		inParamsIdxAndValue.put(Integer.valueOf(1), userId);
		Map<Integer, Integer> outParamsIdxAndType = new HashMap(9);
		outParamsIdxAndType.put(Integer.valueOf(2), Integer.valueOf(java.sql.Types.INTEGER));
		outParamsIdxAndType.put(Integer.valueOf(3), Integer.valueOf(java.sql.Types.INTEGER));
		outParamsIdxAndType.put(Integer.valueOf(4), Integer.valueOf(java.sql.Types.INTEGER));
		outParamsIdxAndType.put(Integer.valueOf(5), Integer.valueOf(java.sql.Types.INTEGER));
		outParamsIdxAndType.put(Integer.valueOf(6), Integer.valueOf(java.sql.Types.INTEGER));
		outParamsIdxAndType.put(Integer.valueOf(7), Integer.valueOf(java.sql.Types.INTEGER));
		outParamsIdxAndType.put(Integer.valueOf(8), Integer.valueOf(java.sql.Types.INTEGER));
		outParamsIdxAndType.put(Integer.valueOf(9), Integer.valueOf(java.sql.Types.INTEGER));
		outParamsIdxAndType.put(Integer.valueOf(10), Integer.valueOf(java.sql.Types.INTEGER));
		
		return super.execProcedure(sql, inParamsIdxAndValue, outParamsIdxAndType);
	}


	@Override
	public Map<Integer, ?> loginQuery(String userName, String pwd, String ip) {
		String sql = "{?=call  P_MY_LOGIN(?,?,?,?,?,?,?,?,?,?,?,?,?) }";
		Map inParamsIdxAndValue = new HashMap(3);
		inParamsIdxAndValue.put(Integer.valueOf(12), userName);
		inParamsIdxAndValue.put(Integer.valueOf(13), pwd);
		inParamsIdxAndValue.put(Integer.valueOf(14), ip);
    	
    	Map<Integer, Integer> outParamsIdxAndType = new HashMap(11);
    	outParamsIdxAndType.put(Integer.valueOf(1), Integer.valueOf(java.sql.Types.INTEGER));
    	outParamsIdxAndType.put(Integer.valueOf(2), Integer.valueOf(java.sql.Types.INTEGER));
    	outParamsIdxAndType.put(Integer.valueOf(3), Integer.valueOf(java.sql.Types.VARCHAR));
    	outParamsIdxAndType.put(Integer.valueOf(4), Integer.valueOf(java.sql.Types.INTEGER));
    	outParamsIdxAndType.put(Integer.valueOf(5), Integer.valueOf(java.sql.Types.INTEGER));
    	outParamsIdxAndType.put(Integer.valueOf(6), Integer.valueOf(java.sql.Types.VARCHAR));
    	outParamsIdxAndType.put(Integer.valueOf(7), Integer.valueOf(java.sql.Types.VARCHAR));
    	outParamsIdxAndType.put(Integer.valueOf(8), Integer.valueOf(java.sql.Types.VARCHAR));
    	outParamsIdxAndType.put(Integer.valueOf(9), Integer.valueOf(java.sql.Types.INTEGER));
    	outParamsIdxAndType.put(Integer.valueOf(10), Integer.valueOf(java.sql.Types.TINYINT));
    	outParamsIdxAndType.put(Integer.valueOf(11), Integer.valueOf(java.sql.Types.INTEGER));
    	
    	
    	Map<Integer, ?> resultMap = super.execProcedure(sql, inParamsIdxAndValue, outParamsIdxAndType);
    	
		return resultMap;
	}


	@Override
	public void saveOrUpdateUser(MyUsers user) {
		super.saveOrUpdate(user);
	}


	@Override
	public MyUsers getMyUserByEmail(String email) {
		String hql = "FROM MyUsers where email =:email";
		Query query = getCurrentSession().createQuery(hql);  
		query.setParameter("email", email);
		List<MyUsers> users = query.list();
		if(users != null && users.size() > 0)
			return users.get(0);
		return null;
	}


	@Override
	public MyUsers getMyUserByEmailNotUser(Integer myUserId, String email) {
		String hql = "FROM MyUsers where myUserId !=:myUserId and email =:email";
		Query query = getCurrentSession().createQuery(hql);  
		query.setParameter("myUserId", myUserId);
		query.setParameter("email", email);
		List<MyUsers> users = query.list();
		if(users != null && users.size() > 0)
			return users.get(0);
		return null;
	}
 


	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getAttenationUsers(int myUserId,List<Integer> userIds) {
		
		String sql = "select userid from weibo.dbo.relationship where otheruserid in (:userIdList) and userid=:myUserId";
		Query query = getCurrentSession().createSQLQuery(sql);
		query.setParameterList("userIdList", userIds);
		query.setParameter("myUserId", myUserId);
		
		List<Integer> list = (List<Integer>)query.list();
	 
		return list;
	}
 
	
	@Override
	public Integer getScore(Integer userId) {
		String sql = "{?=call getScore(?)}";
		Map inParamsIdxAndValue = new HashMap(1);
		inParamsIdxAndValue.put(2, userId);
		Map<Integer, Integer> outParamsIdxAndType = new HashMap(1);
		outParamsIdxAndType.put(1, Integer.valueOf(java.sql.Types.INTEGER));
		Map<Integer, ?> resultMap = super.execProcedure(sql, inParamsIdxAndValue, outParamsIdxAndType);
		if((null != resultMap) && (!resultMap.isEmpty())){
			return Integer.valueOf(resultMap.get(1).toString());
		}
		return 0;
	}
 
}