package com.job528.profile.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.job528.common.DataDictionary.RemcommendTargetType;
import com.job528.profile.dao.IIpAddressDao;
import com.job528.profile.model.IpAddress;
import com.job528.util.dao.GenericDAOHibernateImpl;

public class IpAddressDao extends GenericDAOHibernateImpl  implements IIpAddressDao{

	@Override
	public void batchWriteIpAddress(List<IpAddress> ipList) {
		final int BATCH_SIZE = 500; //批处理记录数
		
		long s_time = System.currentTimeMillis();
		
		StringBuilder sql = new StringBuilder();
		
		Session s =  SessionFactoryUtils.getSession(getSessionFactory(), true);
		
		Connection conn = s.connection();
    	sql.append("insert into IpAddress values (?,?,?,?,?,?,?,?,?,?,?)");
    	
    	int insertCount = 0;
    	
    	int listSize = ipList.size();
    	
    	PreparedStatement ps = null;
    	try {
			ps = conn.prepareStatement(sql.toString());
			
			int len   = listSize % BATCH_SIZE;  //最后一次循环剩余的记录数量
			int count = listSize / BATCH_SIZE+1;  //需要循环的次数
			int lastBatchSize = BATCH_SIZE;
			for(int i=0; i<count; i++) {
					
				if(i == count-1) { //最后一次循环
					lastBatchSize = len;
				}
				
				for(int j=0; j<lastBatchSize; j++) {
					int listIndex = i*BATCH_SIZE+j; //list集合元素索引
					//System.out.println("listIndex=="+listIndex);
					IpAddress ip = ipList.get(listIndex);
					if(ip == null) continue;
					
					//设置参数
					ps.setString(1, ip.getStartIp());
					ps.setString(2, ip.getEndIp());
					ps.setString(3, ip.getIpLocation());
					ps.setString(4, ip.getProvince());
					ps.setString(5, ip.getCity());
					ps.setString(6, ip.getArea());
					ps.setBigDecimal(7, ip.getStartIpValue());
					ps.setBigDecimal(8, ip.getEndIpValue());
					ps.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
					ps.setTimestamp(10, new Timestamp(System.currentTimeMillis()));
					ps.setString(11, ip.getCountry());
					
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
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public String findCityByIp(BigDecimal ipValue) {
		final String sql = "select city from ipAddress where city !='' and startIpValue<=:ipValue and endipvalue >=:ipValue";
		final BigDecimal ip = ipValue;
		
		List<String> list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Query query = session.createSQLQuery(sql);
				query.setBigDecimal("ipValue", ip);
				return query.list();
			}
		});
		
		if(list==null || list.size()==0)
			return "";
		
		String city = (list.get(0)!=null ? (String)list.get(0) : "");
		
		return city;
	}
	
	

	

	 

}
