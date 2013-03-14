package com.job528.service;

import org.junit.BeforeClass;
import org.junit.Test;

import com.job528.profile.service.ISessionService;

public class SessionServiceTest extends SpringService{
	static ISessionService service;
	
	@BeforeClass
	public void testInit() {
		service = super.getIsessionService();
		System.out.println("service=="+service);
	}
	
	@Test
	public void testsynWeibo() {
		 service.getUserSessionData(126);
	}
	
	 
}
