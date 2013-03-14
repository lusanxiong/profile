package com.job528.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;

import com.job528.profile.model.IpAddress;
import com.job528.profile.service.IIpAddressService;

public class IpAddressServiceTest extends SpringService {
	static IIpAddressService service;
	
	@BeforeClass
	public void testInit() {
		service = super.getIpAddressService();
		System.out.println(service);
	}
	
	@Test
	public void testMySearcher() {
		/*//Pager<LabelI> list = service.getLabelInfo(1, 10, 1);
		List<List<LabelDTO>> l = list.getList();*/
		Random r = new Random();
		List<IpAddress> list = new ArrayList<IpAddress>();
		IpAddress e = new IpAddress();
		e.setArea("奉新"+r.nextInt());
		e.setCity("宜春1"+r.nextInt());
		e.setCountry("中国"+r.nextInt());
		e.setEndIp("10.20.20.20");
		//e.setEndIpValue(20000L);
		e.setIpLocation("江西省宜春市"+r.nextInt());
		e.setProvince("江西省"+r.nextInt());
		e.setStartIp("10.10.10.10");
		//e.setStartIpValue(10000L);
	 
		
		list.add(e);
		service.batchInsertIpAddress(list);
		
	}
}
