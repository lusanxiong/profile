package com.job528.service;


import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.util.Assert;

import com.job528.admin.label.service.IAdminLabelService;
import com.job528.ejb.admin.dto.LabelDTO;
import com.job528.profile.model.MySearcher;
import com.job528.profile.service.IApplyService;
import com.job528.util.Pager;

public class AdminLabelServiceTest extends SpringService {
	static IAdminLabelService service;
	
	@BeforeClass
	public void testInit() {
		//service = super.getAdminLabelService();
		System.out.println(service);
	}
	
	@Test
	public void testMySearcher() {
		/*//Pager<LabelI> list = service.getLabelInfo(1, 10, 1);
		List<List<LabelDTO>> l = list.getList();*/
		
		
	}
}
