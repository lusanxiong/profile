package com.job528.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.job528.common.DataDictionary.RemcommendTargetType;
import com.job528.profile.dao.IIpAddressDao;
import com.job528.profile.dao.IMyEducationDao;
import com.job528.profile.dao.IMyWorkExpDao;
import com.job528.profile.dao.IRecommendPositionDao;
import com.job528.profile.model.IpAddress;
import com.job528.profile.model.MyEducation;
import com.job528.profile.model.MyWorkExp;
import com.job528.profile.model.RecommendPosition;
import com.job528.profile.service.IRecommendPositionService;
import com.job528.profile.vo.ExecuteResult;
import com.job528.service.PrintBean;
import com.job528.util.IP.IpUtil;

import edu.emory.mathcs.backport.java.util.Arrays;

public class IIPAddressDaoTest extends SpringDao{
	static IIpAddressDao dao;
	
	@BeforeClass
	public void testInit() {
		dao = super.getiPAddressDao();
		System.out.println("dao=="+dao);
	}
	
	@Test
	public void testGetUsersLastEducation() {
		List<IpAddress> list = new ArrayList<IpAddress>();
		IpAddress e = new IpAddress();
		e.setArea("奉新");
		e.setCity("宜春");
		e.setCountry("中国");
		e.setEndIp("10.20.20.20");
		e.setEndIpValue(new BigDecimal("200"));
		e.setIpLocation("江西省宜春市");
		e.setProvince("江西省");
		e.setStartIp("10.10.10.10");
		e.setStartIpValue(new BigDecimal("20000"));
	 
		
		list.add(e);
		
		dao.batchWriteIpAddress(list);
		
	}
	
	@Test
	public void testFindCity() {
		String ip = "119.145.36.169";
		BigDecimal b = IpUtil.convertIpValue(ip);
		System.out.println("ip =="+b);
		String city = dao.findCityByIp(b);
		
		System.out.println("IIPAddressDaoTest.testFindCity()=="+city);
	}
	
	 
}
