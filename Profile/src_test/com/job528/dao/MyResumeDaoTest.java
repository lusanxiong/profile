package com.job528.dao;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.job528.common.DataDictionary.RemcommendTargetType;
import com.job528.profile.dao.IMyEducationDao;
import com.job528.profile.dao.IMyResumeDao;
import com.job528.profile.dao.IMyWorkExpDao;
import com.job528.profile.dao.IRecommendPositionDao;
import com.job528.profile.model.MyEducation;
import com.job528.profile.model.MyWorkExp;
import com.job528.profile.model.RecommendPosition;
import com.job528.profile.service.IRecommendPositionService;
import com.job528.profile.vo.ExecuteResult;
import com.job528.service.PrintBean;

import edu.emory.mathcs.backport.java.util.Arrays;

public class MyResumeDaoTest extends SpringDao{
	static IMyResumeDao dao;
	
	@BeforeClass
	public void testInit() {
		dao = super.getMyResumeDao();
		System.out.println("dao=="+dao);
	}
	
	@Test
	public void testGetUsersLastEducation() {
		long s_time = System.currentTimeMillis();
		Integer[] userids = new Integer[]{5540869
			,5597643
			,5688377
			,5693950
			,5562117
			,5638742
			,5675665
			,5695516
			,5487058
			,4800888
			,5674268
			,5702486
			,2559359
			,5533730
			,2264343
			,5576395
			,5604613
			,5610355
			,5638573
			,5653020
			,5681238
			,5686980
			,5507078
			,5541038
			,5660159
			,5682635
			,5080229
			,5553750
			,5703883
			,5520849
			,881916
			,5583703
			,5617494
			,5617663
			,5651623
			,5674099};
		
		/*List<Integer> userIds = Arrays.asList(userids);
		List<Integer> list = dao.getNoAttenationUsers(5674099, userIds);
		
		System.out.println("time=="+(System.currentTimeMillis()-s_time)+"ms");
		System.out.println("list=="+list);*/
		
	}
	
	 
}
