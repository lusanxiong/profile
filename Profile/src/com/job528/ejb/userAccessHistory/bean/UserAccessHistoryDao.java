package com.job528.ejb.userAccessHistory.bean;

import java.util.List;

import com.job528.ejb.dto.UserAccessHistoryDTO;
import com.job528.ejb.entity.UserAccessHistory;

/**
 * 用户访问历史记录接口
 * @author lusanxiong
 *
 */
public interface UserAccessHistoryDao {
	
	
	/**
	 * 添加用户访问历史记录
	 * 同一个访问用户一天只记录一次
	 * 
	 * @param UserAccessHistory
	 * 
	 * @return 返回空
	 */
	public void addUserAccessHistory(UserAccessHistory u);
	
	/**
	 * 查询用户访问历史记录
	 * @param userid
	 * @param findCount 查询数量
	 * 
	 * @return List<UserAccessHistoryDTO>
	 * 
	 */
	public List<UserAccessHistoryDTO> getUserAccessHistory(int userid,int findCount); 
		
}
