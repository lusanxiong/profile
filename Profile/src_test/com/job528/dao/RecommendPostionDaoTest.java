package com.job528.dao;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.job528.common.DataDictionary.RemcommendTargetType;
import com.job528.profile.dao.IRecommendPositionDao;
import com.job528.profile.model.RecommendPosition;
import com.job528.profile.service.IRecommendPositionService;
import com.job528.profile.vo.ExecuteResult;

public class RecommendPostionDaoTest extends SpringDao{
	static IRecommendPositionDao dao;
	
	@BeforeClass
	public void testInit() {
		dao = super.getRecommendPositionDao();
		System.out.println("dao=="+dao);
	}
	
	@Test
	public void testGetEmailsByUsersId() {
		String userId = "126,210,516,577,671,715,878,947,970,1126";
		String[] userIds =  userId.split(",");
		
		int[] ids = new int[userIds.length];
		for(int i=0; i<userIds.length; i++) {
			ids[i]=Integer.parseInt(userIds[i]);
			
		}
		List list = dao.getEmailsByUsersId(ids);
		System.out.println(list);
		String[] arr =  new String[list.size()];
		arr = (String[])list.toArray(arr);
		System.out.println("arr len="+arr.length);
		for(String s : arr) {
			System.out.println("s="+s);
		}
		
		List list2 = null;
		if(list2 != null && list2.size() !=0) {
			
		}
		System.out.println("test");
	}
	
	@Test
	public void testGetCount() {
		RecommendPosition rp = new RecommendPosition();
		rp.setRecommendUserId(25);
		//rp.setRecommendDate(new Date());
		rp.setRecommendTargetUserId(1);
		rp.setTargetType(RemcommendTargetType.FRIEND);
		System.out.println("count=="+dao.getCount(rp));
	}
	 
}
