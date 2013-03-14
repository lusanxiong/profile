package com.job528.service;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.util.Assert;

import com.job528.profile.model.MySearcher;
import com.job528.profile.service.IApplyService;

public class IApplyServiceTest extends SpringService {
	static IApplyService applyservice;
	
	@BeforeClass
	public void testInit() {
		applyservice = super.getIapplyService();
		System.out.println(applyservice);
	}
	
	@Test
	public void testMySearcher() {
		Assert.notNull(applyservice);
		MySearcher mysearcher = applyservice.getSearcherByUserId(1);
		
		Assert.notNull(mysearcher);
		
		int age = mysearcher.getAge();
		PrintBean.PrintBeanProperty(mysearcher);
	}
}
