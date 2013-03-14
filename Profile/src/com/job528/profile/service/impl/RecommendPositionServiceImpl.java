package com.job528.profile.service.impl;


import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.job528.common.Constants;
import com.job528.common.DataDictionary.RemcommendTargetType;
import com.job528.profile.dao.impl.RecommendPositionDao;
import com.job528.profile.model.RecommendPosition;
import com.job528.profile.service.IRecommendPositionService;
import com.job528.profile.vo.ExecuteResult;
import com.job528.util.config.PropertiesUtil;
import com.job528.util.email.TasksBuffer;


public class RecommendPositionServiceImpl implements IRecommendPositionService{
	private RecommendPositionDao recommendPositionDao;
	
	
	@Override
	public ExecuteResult recommendPosition(int[] recommendTargetUserIds,
			RecommendPosition rp) {
		
		if(recommendTargetUserIds.length == 0) {
			return  new ExecuteResult(false,"请至少选择一位好友进行推荐!","");
		}
		
		boolean flag = isMaxForUserCount(rp.getRecommendUserId(),recommendTargetUserIds.length,RemcommendTargetType.FRIEND);
		if(!flag) {
			int maxUserCount = configMaxUserCount();
			return  new ExecuteResult(false,"一天之内推荐的好友数量不能超过"+maxUserCount+"位!","");
		}
		
		ExecuteResult er = null;
		
		rp.setTargetType(RemcommendTargetType.FRIEND);
		rp.setTargetEmail("");
		int insertCount = recommendPositionDao.saveRecommendPosition(recommendTargetUserIds, rp,null);
		if(insertCount !=0 && insertCount == recommendTargetUserIds.length) {
			er = new ExecuteResult(true,"你已成功向"+String.valueOf(insertCount)+"位好友推荐了该职位!","");
		}else {
			er = new ExecuteResult(false,"推荐职位失败!","");
		}
		
		if(er.isFlag() && configIsSendMail()) {
			
			//发送邮件
			try {
				sendEmailToFriend(recommendTargetUserIds,rp);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return er;
	}

	@Override
	public ExecuteResult recommendPositionToOuterFriend(
			String[] friendsEmailList, String emailContent,RecommendPosition rp) {
		
		ExecuteResult er = null;
		if(friendsEmailList.length == 0) {
			return new ExecuteResult(false,"请至少选择一位好友进行推荐!","");
		}
		
		boolean flag = isMaxForUserCount(rp.getRecommendUserId(),friendsEmailList.length,RemcommendTargetType.OUTER_FRIEND);
		if(!flag) {
			int maxUserCount = configMaxUserCount();
			return new ExecuteResult(false,"一天之内推荐的好友数量不能超过"+maxUserCount+"位!","");
		}
		
		rp.setTargetType(RemcommendTargetType.OUTER_FRIEND);
		int insertCount = recommendPositionDao.saveRecommendPosition(new int[friendsEmailList.length], rp,friendsEmailList);
		if(insertCount !=0 && insertCount == friendsEmailList.length) {
			er = new ExecuteResult(true,"你已成功向"+String.valueOf(insertCount)+"位好友推荐了该职位!","");
		}else {
			er = new ExecuteResult(false,"推荐职位失败!","");
		}
			
		//向站外好友发送邮件
		try {
			sendEmailToOuterFriend(friendsEmailList,rp);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return er;
	}
	
	/*
	 * 向站内好友发送邮件 
	 */
	private void sendEmailToFriend(int[] recommendTargetUserIds,RecommendPosition rp) {
		
		//获取站内好友email地址
		List<String> list = recommendPositionDao.getEmailsByUsersId(recommendTargetUserIds);
		if(list == null || list.size() == 0) {
			return ;
		}
		
		String[] emailAdressList = (String[])list.toArray(new String[list.size()]);
		addNewEmailToTaskQueque(emailAdressList,rp);
	}
	
	/*
	 * 向站外好友发送邮件
	 */
	private void sendEmailToOuterFriend(String[] friendsEmailList,RecommendPosition rp) {
		addNewEmailToTaskQueque(friendsEmailList,rp);
	}
	
	/**
	 * 添加新邮件到发送队列中
	 */
	private void addNewEmailToTaskQueque(String[] emailAdressList, RecommendPosition rp) {
		LinkedList<String[]> list = new LinkedList<String[]>();
		String[] emailInfo = new String[6];
		for(int i=0; i<emailAdressList.length; i++) {
			emailInfo = new String[6];
			emailInfo[0] = rp.getRecommendUserName(); //发件人名称
			emailInfo[1] = ""; //收件人名称
			emailInfo[2] = emailAdressList[i]; //收件人EMAIL
			emailInfo[3] = String.valueOf(rp.getPositionId()); //推荐职位id
			emailInfo[4] = rp.getRecommendJobName(); //推荐岗位名称
			emailInfo[5] = String.valueOf(rp.getTargetType().ordinal()); //推荐岗位名称
		}
		
		TasksBuffer.setTaskBuffer(list);
	}
	
	
	/*
	 * 用户推荐职位时推荐的好友数量是否大于配置文件中指定的数量．
	 * 
	 * @return true: 代表没有超过．可以进行职位的推荐
	 *         false:代表已经超过了指定数量，不能给好友推荐职位．
	 */
	private boolean isMaxForUserCount(int recommendUserId,int targetUserCount,RemcommendTargetType targetType) {
		
		int alreadyRecommendUserCount = getAlreadyRecommendUserCount(recommendUserId,targetType);
		int maxUserCount = configMaxUserCount();
		
		if((alreadyRecommendUserCount+targetUserCount) > maxUserCount) {
			return false;
		}
		
		return true;
	}
	
	/*
	 * 得到已经推荐的好友数量
	 */
	public int getAlreadyRecommendUserCount(int recommendUserId,RemcommendTargetType targetType) {
		RecommendPosition rps = new RecommendPosition();
		rps.setRecommendUserId(recommendUserId);
		rps.setRecommendDate(new Date());//统计当天的
		rps.setTargetType(targetType);
		
		//已经推荐过职位的好友数量
		int count = recommendPositionDao.getCount(rps);
		
		return count;
	}
	
	
	/*
	 * 获取配置文件中配置的允许推荐的最大好友数量
	 * @return
	 */
	private static int configMaxUserCount() {
		String maxCount = PropertiesUtil.getValue(Constants.RECOMMEND_POSITIONS_USER_COUNT_KEY);
		if(maxCount == null || "".equals(maxCount)) {
			maxCount = Constants.RECOMMEND_POSITIONS_USER_COUNT_VALUE;
		}
		
		return Integer.parseInt(maxCount);
	}
	
	/*
	 * 获取配置文件中配置的向站内好友推荐职位是否同时发送EMAIL
	 * @return
	 */
	private static boolean configIsSendMail() {
		String isSendStatus = PropertiesUtil.getValue(Constants.IS_SENDMAIL_KEY);
		if(isSendStatus == null || "".equals(isSendStatus)) {
			isSendStatus = Constants.IS_SENDMAIL_VALUE;
		}
		
		return Boolean.parseBoolean(isSendStatus);
	}
	


	public RecommendPositionDao getRecommendPositionDao() {
		return recommendPositionDao;
	}

	public void setRecommendPositionDao(RecommendPositionDao recommendPositionDao) {
		this.recommendPositionDao = recommendPositionDao;
	}
	
	public static void main(String[] args) {
		System.out.println(configIsSendMail());
		System.out.println(configMaxUserCount());
	}

	
	

}
