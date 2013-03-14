package com.job528.profile.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.job528.profile.dao.IUserDao;
import com.job528.util.dao.GenericDAOHibernateImpl;

public class UserDao extends GenericDAOHibernateImpl implements IUserDao {

	@Override
	public Integer updatePassword(Integer userId, String oldPwd, String newPwd) {
		String sql = "{?=call  p_my_update_pwd(?,?,?)}";
		Map inParamsIdxAndValue = new HashMap(3);
		inParamsIdxAndValue.put(Integer.valueOf(2), userId);
		inParamsIdxAndValue.put(Integer.valueOf(3), oldPwd);
		inParamsIdxAndValue.put(Integer.valueOf(4), newPwd);
		
		Map<Integer, Integer> outParamsIdxAndType = new HashMap(1);
    	outParamsIdxAndType.put(Integer.valueOf(1), Integer.valueOf(java.sql.Types.INTEGER));
    	
    	Map<Integer, ?> resultMap = super.execProcedure(sql, inParamsIdxAndValue, outParamsIdxAndType);
		
    	if(resultMap == null || resultMap.size() <=0)
    		return 2;
    	return Integer.parseInt(resultMap.get(Integer.valueOf(1)).toString());
	}

}
