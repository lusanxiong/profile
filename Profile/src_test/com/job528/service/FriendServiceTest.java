package com.job528.service;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.job528.common.DataDictionary.RecommendPositionMessageStatus;
import com.job528.profile.model.RecommendPosition;
import com.job528.profile.service.IFriendService;
import com.job528.profile.service.IMyResumeService;
import com.job528.profile.service.IRecommendPositionService;
import com.job528.profile.vo.ExecuteResult;
import com.job528.profile.vo.Experience;
import com.job528.profile.vo.Follower;
import com.job528.profile.vo.UserSearchCondition;
import com.job528.util.Pager;

public class FriendServiceTest extends SpringService{
	static IFriendService service;
	
	@BeforeClass
	public void testInit() {
		service = super.getiFriendService();
		System.out.println("service=="+service);
	}
	
	@Test
	public void testSearchUser() {
		UserSearchCondition ucondition = new UserSearchCondition();
		ucondition.setKeyword("");
		ucondition.setIntCity("");
		ucondition.setIntPost("");
		ucondition.setCalling("");
		ucondition.setCompany("");
		ucondition.setHomeCity("");
		ucondition.setHomeProvince("");
		ucondition.setSchool("");
		ucondition.setPlace("");
		ucondition.setUserLabel("宅男");
		
		long s_time = System.currentTimeMillis();
		Pager<Follower> follower = service.searchFriends(126, ucondition, 1, 100);
		System.out.println("speed time=="+(System.currentTimeMillis()-s_time));
		List<Follower> list = follower.getList();
		
		for(Follower f : list) {
			System.out.println("user=="+f.getUserInfo().getUid()+"=label="+f.getUserInfo().getUserLabelInfo());
		}
	}
	
	@Test
	public void t() {
		
	}
	
		
	
 
	
	 
}
