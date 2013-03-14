package com.job528.profile.dao.impl;

import java.util.List;

import org.hibernate.Query;

import com.job528.profile.dao.IApplyDao;
import com.job528.profile.model.MyFavouriate;
import com.job528.profile.model.MyRecommendJob;
import com.job528.profile.model.MySearcher;
import com.job528.profile.model.PubHistory;
import com.job528.util.dao.GenericDAOHibernateImpl;

public class ApplyDao extends GenericDAOHibernateImpl implements IApplyDao {

	@Override
	public List<Object[]> getUserApplyJob(int resId, int start, int pageSize) {
		String sql =
			" select a.id,a.MemId, a.PosId,"
				+ " a.ApplyNumber, a.InviteFlag, a.MemFlag, c.PosState, "
				+ " b.MemName, c.PosName, c.JobLocation, a.InsertDate, "
				+ " c.EndValidDate,a.MemMemo,a.MemReply "
				+ " from pub_History a , mem_info b , mem_position c"
				+ " where a.PerFlag = 0  and a.MemID = b.MemID"
				+ " and a.PosId = c.PosId and a.MyUserID =? "
				+ " order by a.InsertDate desc ";
		
		return super.queryByNativeSQL(sql, start, pageSize, new Object[]{resId}, null);

	}
	
	@Override
	public List<Object[]> getUserFavouriteJob(int userId, int start, int pageSize) {
		String sql =
			" select a.id,a.MyUserID, a.OperateDate,a.Note, a.MemID,a.MemName,"
				+ " c.PosID,c.posName, c.JobLocation, c.ReqWorkyear, c.ReqDegreeID "
				+ " from My_Favouriate a "
				+ " left outer join mem_position c on a.PosId = c.PosId "
				+ " where myUserID=?"
				+ " order by a.OperateDate desc ";
		
		return super.queryByNativeSQL(sql, start, pageSize, new Object[]{userId}, null);

	}

	@Override
	public List<Object[]> getUserInviteJob(int resId, int start, int pageSize) {
		String sql =
			" select a.id,a.MemId, a.PosId,"
				+ " a.ApplyNumber, a.InviteFlag, a.MemFlag, c.PosState, "
				+ " b.MemName, isnull(c.PosName,''), c.JobLocation, a.InsertDate, "
				+ " c.EndValidDate,a.MemMemo,a.MemReply "
				+ " from pub_History a join mem_info b on a.MemID = b.MemID join mem_position c on a.PosId = c.PosId "
				+ " where a.PerFlag <> 1 and a.InviteFlag = 1 "
				+ " and a.MyUserID =? "
				+ " order by a.InsertDate desc ";
		return super.queryByNativeSQL(sql, start, pageSize, new Object[]{resId}, null);
	}

	@Override
	public List<Object[]> getUserRecommendMeJobs(int userId, int start,
			int pageSize) {
		String sql =
			" select a.id,a.MemId, a.PosId,"
				+ " b.MemName, isnull(c.PosName,'') as PosName, c.JobLocation, c.Salary, c.PostDate,a.userId"
				+ " from My_RecommendJob a inner join mem_info b on a.MemID = b.MemID inner join mem_position c on a.PosId = c.PosId "
				+ " where a.isRead = 0 and a.tragetId =? "
				+ " order by a.recDate desc ";
		return super.queryByNativeSQL(sql, start, pageSize, new Object[]{userId}, null);
	
	}

	@Override
	public void saveOrUpdateMySearcher(MySearcher searcher) {
		super.saveOrUpdate(searcher);
		
	}

	@Override
	public List<MySearcher> getSearchersByUserId(Integer userId, Integer id) {
		String hql = "FROM MySearcher where myuserid =:userId ";
		if(id > 0){
			hql += " and ID=:id ";	
		}
		Query query = getCurrentSession().createQuery(hql);  
		query.setParameter("userId", userId);
		if(id > 0){
		    query.setParameter("id", id);
		}
		return query.list();
	}

	@Override
	public MySearcher getSearcherByUserId(Integer id) {
		return super.load(MySearcher.class, id);
	}

	@Override
	public void deleteMySearcher(Integer id) {
		super.remove(MySearcher.class, id);
	}

	@Override
	public int getUserApplyJobCount(int resId) {
		String sql = "select count(id) from pub_History where PerFlag = 0 and MyUserID =? ";
		List<Object[]> result = super.queryByNativeSQL(sql, new Object[]{resId});
	    if(result != null && result.size() >0){
	    	Object obj = result.get(0);
	    	return Integer.parseInt(obj.toString());
	    }
		return 0;
	}

	@Override
	public int getFavouriteJobCount(int userId) {
		String sql = "select count(id) from My_Favouriate where MyUserID =? ";
		List<Object[]> result = super.queryByNativeSQL(sql, new Object[]{userId});
	    if(result != null && result.size() >0){
	    	Object obj = result.get(0);
	    	return Integer.parseInt(obj.toString());
	    }
		return 0;
	}

	@Override
	public void delUserFavouriteJob(int favId) {
		String hql = "delete from " + MyFavouriate.class.getName() + " where id=:id";	
		Query query = getCurrentSession().createQuery(hql);  
		query.setParameter("id", favId);
		query.executeUpdate();
	}

	@Override
	public void delPubHistoryById(int id) {
		String hql = "delete from " + PubHistory.class.getName() + " where id=:id";	
		Query query = getCurrentSession().createQuery(hql);  
		query.setParameter("id", id);
		query.executeUpdate();
	}

	@Override
	public int getInviteJobCount(int resId) {
		String sql = " select count(a.id) "
		+ " from pub_History a join mem_info b on a.MemID = b.MemID join mem_position c on a.PosId = c.PosId "
		+ " where a.PerFlag <> 1 and a.InviteFlag = 1 "
		+ " and a.MyUserID =? ";;
		List<Object[]> result = super.queryByNativeSQL(sql, new Object[]{resId});
	    if(result != null && result.size() >0){
	    	Object obj = result.get(0);
	    	return Integer.parseInt(obj.toString());
	    }
		return 0;
	}

	@Override
	public int getRecommendMeJobsCount(int userId) {
		String sql = "select count(id) from My_RecommendJob where isRead = 0 and tragetId =? ";
		List<Object[]> result = super.queryByNativeSQL(sql, new Object[]{userId});
	    if(result != null && result.size() >0){
	    	Object obj = result.get(0);
	    	return Integer.parseInt(obj.toString());
	    }
		return 0;
	}

	@Override
	public void delRecommendJobById(int id) {
		String hql = "delete from " + MyRecommendJob.class.getName() + " where id=:id";	
		Query query = getCurrentSession().createQuery(hql);  
		query.setParameter("id", id);
		query.executeUpdate();
	}

}
