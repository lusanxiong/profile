package com.job528.service;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.job528.common.DataDictionary.RecommendPositionMessageStatus;
import com.job528.profile.model.RecommendPosition;
import com.job528.profile.service.IRecommendPositionService;
import com.job528.profile.vo.ExecuteResult;

public class RecommendPostionServiceTest extends SpringService{
	static IRecommendPositionService service;
	
	@BeforeClass
	public void testInit() {
		service = super.getIrecommendPositionService();
		System.out.println("service=="+service);
	}
	
	@Test
	public void testAddRecommendPositionMessage() {
		
		int[] userIds = new int[10];
		for(int i=1; i<userIds.length; i++) {
			userIds[i] = i;
			
		}
		
		RecommendPosition rp = new RecommendPosition();
		rp.setPositionId(22);
		rp.setRecommendJobName("test");
		rp.setRecommendMessageStatus(RecommendPositionMessageStatus.NO_READ);
		rp.setRecommendUserId(25);
		rp.setRecommendUserName("卢三雄");
		rp.setRecommendDate(new Date());
		ExecuteResult er = service.recommendPosition(userIds, rp);
		System.out.println(er);
		
	}
	
	/**
	 * 向站外好友推荐职位
	 */
	@Test
	public void testAddRecommendPositionOuterFriedn() {
		
		String[] friendsEmailList = new String[2];
		for(int i=0;i<friendsEmailList.length; i++) {
			friendsEmailList[i] = "sanxionglu@msn.cn";
		}
		
		RecommendPosition rp = new RecommendPosition();
		rp.setPositionId(22);
		rp.setRecommendJobName("test");
		rp.setRecommendMessageStatus(RecommendPositionMessageStatus.NO_READ);
		rp.setRecommendUserId(25);
		rp.setRecommendUserName("卢三雄");
		ExecuteResult er = service.recommendPositionToOuterFriend(friendsEmailList, "你在528的好友向你推荐了如下职位。", rp);
		System.out.println(er);
		
	}
	
	 
}
