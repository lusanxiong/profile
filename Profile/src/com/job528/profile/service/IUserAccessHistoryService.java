package com.job528.profile.service;


import java.util.List;

import com.job528.ejb.entity.UserAccessHistory;
import com.job528.profile.vo.ExecuteResult;
import com.job528.profile.vo.UserAccessHistoryInfoDTO;

/**
 * 用户访问历史记录服务
 * @author lusanxiong
 *
 */
public interface IUserAccessHistoryService {
	
	/**
	 * 记录用户访问的历史记录
	 * 
	 * 一天只记录一次
	 * 
	 * @return 添加是否成功
	 */
	public ExecuteResult addUserAccessHistory(UserAccessHistory u);
	
	/**
	 * 获取单个用户访问历史记录
	 * 
	 * @param userid;
	 * @return List<UserAccessHistoryInfoDTO>
	 * 
	 */
	public List<UserAccessHistoryInfoDTO> getUserAccessHistoryInfo(int userid);
	
}
