package com.job528.service;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.job528.common.DataDictionary.RecommendPositionMessageStatus;
import com.job528.ejb.dto.HotFamousUserDTO;
import com.job528.profile.model.RecommendPosition;
import com.job528.profile.service.IMyResumeService;
import com.job528.profile.service.IRecommendPositionService;
import com.job528.profile.service.IUserAccessHistoryService;
import com.job528.profile.service.IUserProfileService;
import com.job528.profile.vo.ExecuteResult;
import com.job528.profile.vo.Experience;
import com.job528.profile.vo.HotFamousUserInfoDTO;
import com.job528.profile.vo.UserAccessHistoryInfoDTO;

public class UserProfileServiceTest extends SpringService{
	static IUserProfileService service;
	
	@BeforeClass
	public void testInit() {
		service = super.getUserProfileService();
		System.out.println("service=="+service);
	}
	
	@Test
	public void testUserAccessHistoryService() {
		List<HotFamousUserInfoDTO> list = service.getHotFamousUserInfo(1, 10);
		System.out.println(list.size());
		for(HotFamousUserInfoDTO dto : list) {
			PrintBean.PrintBeanProperty(dto);
		}
	}
	
		
	
 
	
	 
}
