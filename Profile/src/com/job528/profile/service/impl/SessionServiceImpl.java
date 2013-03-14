package com.job528.profile.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.job528.common.DataDictionary.SessionAttrName;
import com.job528.common.DataDictionary.WeiboService;
import com.job528.ejb.dto.UserWeiboDTO;
import com.job528.ejb.weiboToken.bean.WeiboTokenDao;
import com.job528.profile.service.ISessionService;

public class SessionServiceImpl implements ISessionService{
	private WeiboTokenDao weiboTokenDao;

	@Override
	public Map<SessionAttrName, Object> getUserSessionData(int userId) {
		if(userId <= 0) 
			return null;
		
		Map<SessionAttrName, Object> sessionMap = new HashMap<SessionAttrName, Object>(10);
		sessionMap.put(SessionAttrName.IS_READ_DATABASE, true);
		
		//获取用户同步相关信息
		List<UserWeiboDTO> userWeiboList = getUserWeiboInfo(userId);
		if(userWeiboList==null || userWeiboList.size()==0)
			return sessionMap;
		
		for(UserWeiboDTO dto : userWeiboList) {
			if(dto == null) continue;
			int serviceType = dto.getWeiboServiceType();
			
			//新浪微博
			if(WeiboService.SINA_WEIBO.toString().equals(String.valueOf(serviceType))) {
				sessionMap.put(SessionAttrName.SINA_ACESS_TOKEN, dto.getAccessToken());
				sessionMap.put(SessionAttrName.SINA_ACTIVE, dto.getActive());
				sessionMap.put(SessionAttrName.SINA_USERID, dto.getWeiboUserId());
			}
			
			//腾讯微博
			if(WeiboService.TENCENT_WEIBO.toString().equals(String.valueOf(serviceType))) {
				sessionMap.put(SessionAttrName.TENCENT_ACESS_TOKEN, dto.getAccessToken());
				sessionMap.put(SessionAttrName.TENCENT_ACTIVE, dto.getActive());
				sessionMap.put(SessionAttrName.TENCENT_OPENID, dto.getWeiboUserId());
			}
		}
		return sessionMap;
	}
	
	
	/*
	 * 获取用户微博同步相关信息
	 */
	private List<UserWeiboDTO> getUserWeiboInfo(int userId) {
		List<UserWeiboDTO> list = null;
		try {
			list = weiboTokenDao.getUserWeiboList(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public WeiboTokenDao getweiboTokenDao() {
		return weiboTokenDao;
	}
	public void setweiboTokenDao(WeiboTokenDao weiboTokenDao) {
		this.weiboTokenDao = weiboTokenDao;
	}
}
