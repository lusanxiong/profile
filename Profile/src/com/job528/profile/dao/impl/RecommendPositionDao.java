package com.job528.profile.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.job528.common.DataDictionary.RemcommendTargetType;
import com.job528.profile.dao.IRecommendPositionDao;
import com.job528.profile.model.RecommendPosition;
import com.job528.util.DateUtil;
import com.job528.util.dao.GenericDAOHibernateImpl;

public class RecommendPositionDao extends GenericDAOHibernateImpl implements IRecommendPositionDao {
	
	/*
	 * 批量插入记录
	 * @see com.job528.profile.dao.IRecommendPositionDao#saveRecommendPosition(int[], com.job528.profile.model.RecommendPosition)
	 */
	@Override
	public int saveRecommendPosition(int[] recommendUserIds,
			RecommendPosition rp, String[] outerFriendsEmail) {
		int batchSize = 500; //批处理记录数
		
		long s_time = System.currentTimeMillis();
		
		StringBuilder sql = new StringBuilder();
		
		Session s =  SessionFactoryUtils.getSession(getSessionFactory(), true);
		Connection conn = s.connection();
    	sql.append("insert into RecommendPosition values (?,?,?,?,?,?,?,?,?)");
    	
    	int insertCount = 0;
    	PreparedStatement ps = null;
    	try {
			ps = conn.prepareStatement(sql.toString());
			
			int len   = recommendUserIds.length % batchSize;  //最后一次循环剩余的数量
			int count = recommendUserIds.length/batchSize+1;  
			int lastBatchSize = batchSize;
			for(int i=0; i<count; i++) {
					
				if(i == count-1) { //最后一次循环
					lastBatchSize = len;
				}
				
				for(int j=0; j<lastBatchSize; j++) {
					ps.setInt(1, rp.getRecommendUserId());
					ps.setInt(2, recommendUserIds[ i*batchSize+j ]);
					ps.setString(3, rp.getRecommendJobName());
					ps.setInt(4, rp.getPositionId());
					ps.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
					ps.setInt(6, rp.getRecommendMessageStatus().NO_READ.ordinal());
					ps.setInt(7, rp.getTargetType().ordinal());
					
					if(rp.getTargetType().ordinal() == RemcommendTargetType.FRIEND.ordinal()) {
						ps.setString(8, rp.getTargetEmail());
					}else {
						ps.setString(8, outerFriendsEmail[ i*batchSize+j ]);
					}
					
					ps.setString(9, rp.getRecommendUserName());
					ps.addBatch(); 
				}
				
				int[] c = ps.executeBatch(); //从缓冲区中发送sql及其参数到数据库中并且执行.
				insertCount = insertCount+c.length;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				if(ps != null) {
					ps.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("speed time="+(System.currentTimeMillis()-s_time));
	    return insertCount;
	}

	@Override
	public int getCount(RecommendPosition rp) {
		if(rp == null) return 0;
		
		//where 条件sql语句
		StringBuilder conditionSql = new StringBuilder();
		Map<String, Object> param = new HashMap<String, Object>();
		if(rp.getRecommendUserId()!= 0) {
			conditionSql.append(" and recommendUserId=:recommendUserId");
			param.put("recommendUserId", rp.getRecommendUserId());
		}
		
		if(rp.getRecommendDate() != null) {
			conditionSql.append(" and convert(varchar,recommendDate,112)=:date");
			String date = DateUtil.dateToStringNew(rp.getRecommendDate());
			param.put("date", date);
		}
		
		if(rp.getRecommendTargetUserId() != 0) {
			conditionSql.append(" and recommendTargetUserId=:recommendTargetUserId");
			param.put("recommendTargetUserId", rp.getRecommendTargetUserId());
		}
		
		if(rp.getTargetType() != null) {
			conditionSql.append(" and TargetType=:targetType");
			param.put("targetType", rp.getTargetType().ordinal());
		}
		
	    Session session = this.getCurrentSession();
	    Query query = session.createSQLQuery("select count(0) from recommendPosition where 1=1 "+conditionSql.toString());
	    for(Map.Entry<String, Object> p : param.entrySet()) {
	    	query.setParameter(p.getKey(), p.getValue());
	    }
	    
		return (Integer)query.uniqueResult(); 
	}
	
	public static void main(String[] args) {
		/*char[] c = "我e，".toCharArray();
		for(char ch : c) {
			String s = String.valueOf(ch);
			System.out.println(s.getBytes().length);
		}*/
		StringBuilder sb = new StringBuilder();
		sb.append("abdc,");
		sb.deleteCharAt(sb.toString().length()-1);
		System.out.println(sb.toString());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getEmailsByUsersId(int[] usersId) {
		Session session = this.getCurrentSession();
		if(usersId == null || usersId.length == 0)
			return null;
		
		
		String querySql = "select email from my_users where myUserId in (";
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<usersId.length; i++) {
			sb.append("?").append(",");
		}
		sb.deleteCharAt(sb.toString().length()-1);
		querySql = querySql + sb.toString()+")";
		
		Query query = session.createSQLQuery(querySql);
		for(int i=0; i<usersId.length; i++) {
			query.setParameter(i, usersId[i]);
		}
		
		List list = query.list();
		return list;
	}

}
