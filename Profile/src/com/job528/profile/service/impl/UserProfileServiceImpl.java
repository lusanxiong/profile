package com.job528.profile.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.job528.ejb.dto.HotFamousUserDTO;
import com.job528.ejb.entity.Friend;
import com.job528.ejb.entity.UserProfile;
import com.job528.ejb.user.bean.UserProfileDao;
import com.job528.profile.dao.IMyEducationDao;
import com.job528.profile.dao.IMyWorkExpDao;
import com.job528.profile.model.MyResume;
import com.job528.profile.model.MyWorkExp;
import com.job528.profile.service.IUserProfileService;
import com.job528.profile.util.JobUtil;
import com.job528.profile.vo.HotFamousUserInfoDTO;
import com.job528.util.AreaUtil;

public class UserProfileServiceImpl implements IUserProfileService {

	private UserProfileDao userProfileDao;
	private IMyWorkExpDao workExpDao;
    private IMyEducationDao educationDao;

	@Override
	public UserProfile getUserProfileById(Integer userId) {
		return userProfileDao.getUserProfileById(userId);
	}

	@Override
	public Integer mergeUserProfile(String userName, String headImage, Integer userId) {
		return userProfileDao.mergeUserProfile(userName, headImage, userId);
	}
	

	@Override
	public Map<Integer, String> getWorkCallingNames(Integer userId) {
		List<MyWorkExp> myWorkExps = new ArrayList<MyWorkExp>();
		Map<Integer, String> callingMap = new HashMap<Integer, String>();
		myWorkExps = workExpDao.getMyWorkExpByUserId(userId);
		if(myWorkExps.size() <= 0)
			return callingMap;
		
		for(MyWorkExp workExp : myWorkExps){
			int calling = (workExp.getMemCalling() / 100) * 100;
			if(!callingMap.containsKey(calling)){
				callingMap.put(calling, JobUtil.getJobById(String.valueOf(calling)));
			}	
		}
		return callingMap;
	}
	
	
	@Override
	public List<String> getWorkCompanyNames(Integer userId) {
		List<MyWorkExp> myWorkCompany = new ArrayList<MyWorkExp>();
		List<String> companys = new ArrayList<String>();
		myWorkCompany = workExpDao.getMyWorkExpByUserId(userId);
		if(myWorkCompany.size() <= 0)
			return companys;
		
		for(MyWorkExp workExp : myWorkCompany){
			if(!companys.contains(workExp.getMemName())){
				companys.add(workExp.getMemName());
			}
		}
		return companys;
	}
	
	
	@Override
	public UserProfile getUserProfileByUserId(Integer userId) {
		return userProfileDao.getUserProfileById(userId);
	}
	
	@Override
	public void updateProfile(MyResume myResume) {
	    userProfileDao.mergeUserProfile(myResume.getPerName(), myResume.getPhotoName(), myResume.getMyUserId());
	}
	
	
	@Override
	public List<Friend> getHotUsers(Integer top, Integer userId) {
		// TODO Auto-generated method stub
		return userProfileDao.getHotUsers(top, userId);
	}
	
	public UserProfileDao getUserProfileDao() {
		return userProfileDao;
	}

	public void setUserProfileDao(UserProfileDao userProfileDao) {
		this.userProfileDao = userProfileDao;
	}
	
	public IMyWorkExpDao getWorkExpDao() {
		return workExpDao;
	}

	public void setWorkExpDao(IMyWorkExpDao workExpDao) {
		this.workExpDao = workExpDao;
	}

	public IMyEducationDao getEducationDao() {
		return educationDao;
	}

	public void setEducationDao(IMyEducationDao educationDao) {
		this.educationDao = educationDao;
	}

	@Override
	public List<HotFamousUserInfoDTO> getHotFamousUserInfo(int pageNo, int pageSize) {
		List<HotFamousUserDTO> list = userProfileDao.getHotFamousUsers(pageNo, pageSize);
		if(list==null || list.size()==0) return null;
		
		List<HotFamousUserInfoDTO> result = new ArrayList<HotFamousUserInfoDTO>(list.size());
		for(HotFamousUserDTO dto : list) {
			if(dto == null) continue;
			
			HotFamousUserInfoDTO e = new HotFamousUserInfoDTO();
			e.setFansNumber(dto.getFansNumber());
			e.setJobfunctionId(dto.getJobfunctionId());
			e.setMyAttentionNumber(dto.getMyAttentionNumber());
			e.setNowLocation(dto.getNowLocation());
			e.setPhoto(dto.getPhoto());
			e.setUserid(dto.getUserid());
			e.setUserName(dto.getUserName());
			e.setWeiboNumber(dto.getWeiboNumber());
			
			//职务名称
			e.setUserLastPost( JobUtil.getJobById(String.valueOf(dto.getJobfunctionId()))); 
			
			//现居地名称
			e.setNowLocationName( AreaUtil.getPCAById(dto.getNowLocation().toString()) );
			
			result.add(e);
		}
		return result;
	}	
}
