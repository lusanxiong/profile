package com.job528.service;

import java.math.BigInteger;

import org.junit.BeforeClass;
import org.junit.Test;

import com.job528.ejb.entity.Weibo;
import com.job528.ejb.entity.WeiboResult;
import com.job528.profile.service.IWeiboService;

public class IWeiboServiceTest extends SpringService {
	static IWeiboService weiboService;
	
	@BeforeClass
	public void testinit() {
		weiboService = super.getIweiboService();
	}
	
	@Test
	public void testGetWeibo() {
		System.out.println("weiboService="+weiboService);
		BigInteger b = BigInteger.valueOf(22);
		WeiboResult wr = weiboService.getWeiboById(b);;
		Weibo wb = wr.getWeibo();
		PrintBean.PrintBeanProperty(wb);
	}
}
