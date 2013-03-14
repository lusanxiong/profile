package com.job528.profile.service.impl;

import com.job528.profile.LoginInfo;
import com.job528.profile.dao.IMyResumeDao;
import com.job528.profile.dao.IUserDao;
import com.job528.profile.model.MyResume;
import com.job528.profile.model.MyUsers;
import com.job528.profile.service.IRelationshipService;
import com.job528.profile.service.IUserProfileService;
import com.job528.profile.service.IUserService;
import com.job528.profile.util.Group;
import com.job528.util.StrUtils;

public class UserServiceImpl implements IUserService {

	private IUserDao userDao;
	private IMyResumeDao resumeDao;
	private IRelationshipService relationshipService;
	private IUserProfileService userProfileService;
	@Override
	public MyUsers getAccountInfoByEmail(String email) {
		return null;
	}

	@Override
	public MyUsers getAccountInfoByUserId(Integer userId) {
		return null;
	}

	@Override
	public Integer login(String loginName, String pwd, String ip,
			LoginInfo loginInfo) {
		return null;
	}

	@Override
	public Integer updatePassword(Integer userId, String oldPwd, String newPwd) {
		return userDao.updatePassword(userId, oldPwd, newPwd);
	}

	@Override
	public boolean verificateMail(Integer myUserId, String email) {
		return false;
	}
	
	@Override
	public String getFriendCount(int userId) {
		int all = 0;
		int peer = relationshipService.getCountByUserId(userId, Group.Peer.getGroupId());
		int colleague = relationshipService.getCountByUserId(userId, Group.Colleague.getGroupId());
		int fellow = relationshipService.getCountByUserId(userId, Group.Fellow.getGroupId());
		int classmate = relationshipService.getCountByUserId(userId, Group.Classmate.getGroupId());
		int other = relationshipService.getCountByUserId(userId, Group.Other.getGroupId());
		all = peer + colleague + fellow + classmate + other;
		StringBuilder json = new StringBuilder();
		json.append("[{");
		json.append("\"ALL\":\"").append(all).append("\",");
		json.append("\"Peer\":\"").append(peer).append("\",");
		json.append("\"Colleague\":\"").append(colleague).append("\",");
		json.append("\"Fellow\":\"").append(fellow).append("\",");
		json.append("\"Classmate\":\"").append(classmate).append("\",");
		json.append("\"Other\":\"").append(other).append("\"");	
		json.append("}]");
		
		return json.toString();
	}
	
	@Override
	public void initUserInfoFristTime(int userId) {
		if(userId <= 0)
			return;
		MyResume resume = this.resumeDao.getResumesByuserId(userId);
		if(resume != null){
			String headImage = "/images/people.gif";
    		String userName = resume.getEmail()!="" ? resume.getEmail() : "未知";
    		if(!StrUtils.isNull(resume.getPerName())){
    			userName = resume.getPerName();
    		}
    		
    		if(!StrUtils.isNull(resume.getPhotoName())){
    			headImage = resume.getPhotoName();
    		}
    		
    		userProfileService.mergeUserProfile(userName, headImage, userId);
		}
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public IRelationshipService getRelationshipService() {
		return relationshipService;
	}

	public void setRelationshipService(IRelationshipService relationshipService) {
		this.relationshipService = relationshipService;
	}

	public IMyResumeDao getResumeDao() {
		return resumeDao;
	}

	public void setResumeDao(IMyResumeDao resumeDao) {
		this.resumeDao = resumeDao;
	}

	public IUserProfileService getUserProfileService() {
		return userProfileService;
	}

	public void setUserProfileService(IUserProfileService userProfileService) {
		this.userProfileService = userProfileService;
	}
	
	
}
