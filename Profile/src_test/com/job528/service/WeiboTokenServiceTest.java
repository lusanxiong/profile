package com.job528.service;

import java.util.List;
import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;

import com.job528.ejb.entity.WeiboToken;
import com.job528.profile.service.IWeiboTokenService;
import com.job528.profile.vo.UserWeiboInfoDTO;

public class WeiboTokenServiceTest extends SpringService{
	static IWeiboTokenService weiboTokenService;
	
	@BeforeClass
	public void testInit() {
		weiboTokenService = super.getIweiboTokenService();
		System.out.println("weiboTokenService=="+weiboTokenService);
	}
	
	@Test
	public void testsynWeibo() {
		Random ro = new Random();
		WeiboToken wt = new WeiboToken();
		/*wt.setUserId(ro.nextInt());
		wt.setSinaUserId(String.valueOf(ro.nextInt()));
		wt.setToken("testesttest");*/
		
		wt.setUserId(5707186);
		wt.setSinaUserId("1594734255");
		wt.setToken("2.00PO2vjBaeayWC5cc5989ab5G5JC7E");
		wt.setTokenSecret("");
		int i = 0;
		wt.setActive(i);
		
		int id = 0;
		try {
			id = weiboTokenService.weiboSyn(wt);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("weiboToken id="+id);
		
	}
	
	@Test
	public void testUpdateWeiboTokenStatus() {
		String sinaUserId = "1111";
		int count = weiboTokenService.pauseSynWeibo(sinaUserId);
		System.out.println("update count =="+count);
	}
	
	@Test
	public void testIsActiveForUser() {
		String sinaUserId = "1111";
		boolean flag = weiboTokenService.isActvieForUser(sinaUserId);
		System.out.println("is active =="+flag);
	}
	
	@Test
	public void testDelWeiboToken() {
		int userId = 1111;
		String sinaUserId = "8888";
		int count = weiboTokenService.delSynWeibo(userId, sinaUserId);
		
		System.out.println("delete count =="+count);
	}
	
	@Test
	public void testGetWeiboTokenInfo() {
		int userId = weiboTokenService.getWeiboTokenInfo("sddf");
		System.out.println("userId=="+userId);
	}
	
	@Test
	public void testGetUserWeiboInfo() {
		int userId = 1;
			
		List<UserWeiboInfoDTO> list = weiboTokenService.getUserWeiboInfoList(userId);
		for(UserWeiboInfoDTO dto : list) {
			//System.out.println("weibouserId=="+dto.getWeiboUserId());
			PrintBean.PrintBeanProperty(dto);
		}
	}
}
