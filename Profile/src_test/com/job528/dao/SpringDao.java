package com.job528.dao;


import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import com.job528.profile.dao.IIpAddressDao;
import com.job528.profile.dao.IMyEducationDao;
import com.job528.profile.dao.IMyResumeDao;
import com.job528.profile.dao.IMyWorkExpDao;
import com.job528.profile.dao.IRecommendPositionDao;
import com.job528.profile.service.IApplyService;
import com.job528.profile.service.IRecommendPositionService;
import com.job528.profile.service.IUserService;
import com.job528.profile.service.IWeiboService;
import com.job528.profile.service.IWeiboTokenService;


/*
 * 单元测试服务类
 * 
 * 继承AbstractDependencyInjectionSpringContextTests类
 * 只要定义成员变量和setter,getter方法，就可以得到该类的对象引用。
 */
public class SpringDao extends AbstractDependencyInjectionSpringContextTests {
	IRecommendPositionDao RecommendPositionDao;
	IMyWorkExpDao myWorkExpDao;
	IMyEducationDao myEducationDao;
	IMyResumeDao myResumeDao;
	IIpAddressDao iPAddressDao;
	

	public IIpAddressDao getiPAddressDao() {
		return iPAddressDao;
	}

	public void setiPAddressDao(IIpAddressDao iPAddressDao) {
		this.iPAddressDao = iPAddressDao;
	}

	public IMyResumeDao getMyResumeDao() {
		return myResumeDao;
	}

	public void setMyResumeDao(IMyResumeDao myResumeDao) {
		this.myResumeDao = myResumeDao;
	}

	public IMyEducationDao getMyEducationDao() {
		return myEducationDao;
	}

	public void setMyEducationDao(IMyEducationDao myEducationDao) {
		this.myEducationDao = myEducationDao;
	}



	public IRecommendPositionDao getRecommendPositionDao() {
		return RecommendPositionDao;
	}



	public void setRecommendPositionDao(IRecommendPositionDao recommendPositionDao) {
		RecommendPositionDao = recommendPositionDao;
	}

	public IMyWorkExpDao getMyWorkExpDao() {
		return myWorkExpDao;
	}



	public void setMyWorkExpDao(IMyWorkExpDao myWorkExpDao) {
		this.myWorkExpDao = myWorkExpDao;
	}



	@Override
	public String[] getConfigLocations() {
        String[] configLocations = {"classpath:spring/applicationContext.xml"};
        return configLocations;
    } 
}
