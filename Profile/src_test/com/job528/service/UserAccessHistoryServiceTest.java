package com.job528.service;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.job528.common.DataDictionary.RecommendPositionMessageStatus;
import com.job528.profile.model.RecommendPosition;
import com.job528.profile.service.IMyResumeService;
import com.job528.profile.service.IRecommendPositionService;
import com.job528.profile.service.IUserAccessHistoryService;
import com.job528.profile.vo.ExecuteResult;
import com.job528.profile.vo.Experience;
import com.job528.profile.vo.UserAccessHistoryInfoDTO;

public class UserAccessHistoryServiceTest extends SpringService{
	static IUserAccessHistoryService service;
	
	@BeforeClass
	public void testInit() {
		service = super.getUserAccessHistoryService();
		System.out.println("service=="+service);
	}
	
	@Test
	public void testUserAccessHistoryService() {
		List<UserAccessHistoryInfoDTO> list = service.getUserAccessHistoryInfo(126);
		System.out.println(list.size());
	}
	
		
	
 
	
	 
}
