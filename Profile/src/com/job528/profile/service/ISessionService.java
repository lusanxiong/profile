package com.job528.profile.service;

import java.util.Map;

import com.job528.common.DataDictionary.SessionAttrName;

/**
 * 用户session服务
 * @author lusanxiong
 *
 */
public interface ISessionService {
	
	/**
	 * 获取该用户session需要存放的全部数据
	 * 
	 * @param userId
	 * @return
	 */
	public Map<SessionAttrName, Object> getUserSessionData(int userId);
}
