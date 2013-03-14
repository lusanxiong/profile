package com.job528.dao;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.job528.common.DataDictionary.RemcommendTargetType;
import com.job528.profile.dao.IMyWorkExpDao;
import com.job528.profile.dao.IRecommendPositionDao;
import com.job528.profile.model.MyWorkExp;
import com.job528.profile.model.RecommendPosition;
import com.job528.profile.service.IRecommendPositionService;
import com.job528.profile.vo.ExecuteResult;
import com.job528.service.PrintBean;

import edu.emory.mathcs.backport.java.util.Arrays;

public class MyWorkExpDaoTest extends SpringDao{
	static IMyWorkExpDao dao;
	
	@BeforeClass
	public void testInit() {
		dao = super.getMyWorkExpDao();
		System.out.println("dao=="+dao);
	}
	
	@Test
	public void testGetLastWorkExp() {
		int userid = 16;
		MyWorkExp workExp = dao.getLastMyWorkExp(userid);
		PrintBean.PrintBeanProperty(workExp);
		System.out.println("endDate=="+workExp.getEndDate());
	}
 
	@Test
	public void testGetUsersLastWorkExp() {
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
		/*List<MyWorkExp> list = dao.getUsersLastMyWorkExp(userids);
		
		System.out.println("list=="+list.size());
		for(MyWorkExp workExp : list) {
			PrintBean.PrintBeanProperty(workExp);
		}*/
		
	}
	
	@Test
	public void testGetUsersWorkExpInfo() {
		Integer[] userids = new Integer[]{
				699088, 374199, 674729, 2561117, 2485164, 2485131, 4106918};
			List<Integer> UserIds = Arrays.asList(userids);
			List<MyWorkExp> list = dao.getUsersMyWorkExpInfo(UserIds);
			
			System.out.println("list=="+list.size());
			for(MyWorkExp workExp : list) {
				PrintBean.PrintBeanProperty(workExp);
			}
	}
	 
}
