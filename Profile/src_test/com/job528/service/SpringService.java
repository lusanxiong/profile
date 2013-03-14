package com.job528.service;


import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import com.job528.profile.service.IApplyService;
import com.job528.profile.service.IFriendService;
import com.job528.profile.service.IIpAddressService;
import com.job528.profile.service.IMyResumeService;
import com.job528.profile.service.IRecommendPositionService;
import com.job528.profile.service.ISessionService;
import com.job528.profile.service.IUserAccessHistoryService;
import com.job528.profile.service.IUserProfileService;
import com.job528.profile.service.IUserService;
import com.job528.profile.service.IWeiboService;
import com.job528.profile.service.IWeiboTokenService;


/*
 * 单元测试服务类
 * 
 * 继承AbstractDependencyInjectionSpringContextTests类
 * 只要定义成员变量和setter,getter方法，就可以得到该类的对象引用。
 */
public class SpringService extends AbstractDependencyInjectionSpringContextTests {
	IApplyService iapplyService;
	IUserService iuserService;
	IWeiboService iweiboService;
	IWeiboTokenService iweiboTokenService;
	IRecommendPositionService irecommendPositionService;
	ISessionService isessionService;
	IMyResumeService resumeService;
	IUserAccessHistoryService userAccessHistoryService;
	IUserProfileService userProfileService;
	IIpAddressService ipAddressService;
	IFriendService iFriendService;
	
	
	
	public IFriendService getiFriendService() {
		return iFriendService;
	}

	public void setiFriendService(IFriendService iFriendService) {
		this.iFriendService = iFriendService;
	}

	public IIpAddressService getIpAddressService() {
		return ipAddressService;
	}

	public void setIpAddressService(IIpAddressService ipAddressService) {
		this.ipAddressService = ipAddressService;
	}

 

	public IUserProfileService getUserProfileService() {
		return userProfileService;
	}

	public void setUserProfileService(IUserProfileService userProfileService) {
		this.userProfileService = userProfileService;
	}

	public IUserAccessHistoryService getUserAccessHistoryService() {
		return userAccessHistoryService;
	}

	public void setUserAccessHistoryService(
			IUserAccessHistoryService userAccessHistoryService) {
		this.userAccessHistoryService = userAccessHistoryService;
	}

	public IMyResumeService getResumeService() {
		return resumeService;
	}

	public void setResumeService(IMyResumeService resumeService) {
		this.resumeService = resumeService;
	}

	public IRecommendPositionService getIrecommendPositionService() {
		return irecommendPositionService;
	}

	public void setIrecommendPositionService(
			IRecommendPositionService irecommendPositionService) {
		this.irecommendPositionService = irecommendPositionService;
	}

	public IWeiboTokenService getIweiboTokenService() {
		return iweiboTokenService;
	}

	public void setIweiboTokenService(IWeiboTokenService iweiboTokenService) {
		this.iweiboTokenService = iweiboTokenService;
	}

	public IApplyService getIapplyService() {
		return iapplyService;
	}
	
	public IWeiboService getIweiboService() {
		return iweiboService;
	}

	public void setIweiboService(IWeiboService iweiboService) {
		this.iweiboService = iweiboService;
	}

	public void setIapplyService(IApplyService iapplyService) {
		this.iapplyService = iapplyService;
	}

    public IUserService getIuserService() {
		return iuserService;
	}

	public void setIuserService(IUserService iuserService) {
		this.iuserService = iuserService;
	} 

	public ISessionService getIsessionService() {
		return isessionService;
	}

	public void setIsessionService(ISessionService isessionService) {
		this.isessionService = isessionService;
	}

	@Override
	public String[] getConfigLocations() {
        String[] configLocations = {"classpath:spring/applicationContext.xml"};
        return configLocations;
    } 
}
