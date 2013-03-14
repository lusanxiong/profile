package com.job528.service;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.job528.common.DataDictionary.RecommendPositionMessageStatus;
import com.job528.profile.model.RecommendPosition;
import com.job528.profile.service.IMyResumeService;
import com.job528.profile.service.IRecommendPositionService;
import com.job528.profile.vo.ExecuteResult;
import com.job528.profile.vo.Experience;

public class MyResumeServiceTest extends SpringService{
	static IMyResumeService service;
	
	@BeforeClass
	public void testInit() {
		service = super.getResumeService();
		System.out.println("service=="+service);
	}
	
	@Test
	public void testgetUsersLastWorkExp() {
		
		Integer[] userids = new Integer[]{898324
				 };
		 
		
		/*List<Experience> list = service.getUsersLastWorkExp(userids);
		for(Experience e : list) {
			System.out.println("uid="+e.getMyWorkExp().getMyUserId()+"==post="+e.getPost()+"jobfunctionId="+e.getMyWorkExp().getJobFunctionId());
		}*/
		
		
	}
	@Test
	public void t() {
		
	}
	
		
	
 
	
	 
}
