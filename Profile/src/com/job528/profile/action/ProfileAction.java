package com.job528.profile.action;


import java.util.ArrayList;
import java.util.List;

import com.job528.ejb.entity.Label;
import com.job528.ejb.entity.UserAccessHistory;
import com.job528.ejb.entity.UserProfile;
import com.job528.profile.model.MyEducation;
import com.job528.profile.model.MyResume;
import com.job528.profile.model.MyWorkExp;
import com.job528.profile.service.ILabelService;
import com.job528.profile.service.IMyResumeService;
import com.job528.profile.service.IRelationshipService;
import com.job528.profile.service.IUserAccessHistoryService;
import com.job528.profile.service.IUserProfileService;
import com.job528.profile.vo.Education;
import com.job528.profile.vo.Experience;
import com.job528.profile.vo.Profile;
import com.job528.profile.vo.Resume;
import com.job528.util.StringUtil;

@SuppressWarnings("serial")
public class ProfileAction extends ResumeAction {

	private Profile profile;
	private Integer flag;
	private IUserProfileService userProfileService;
	private IMyResumeService resumeService;
	private IRelationshipService relationshipService;
	private IUserAccessHistoryService userAccessHistoryService;
	private ILabelService labelService;
	private List<Label> labels;

	public String execute() {
		profile = new Profile();
		if(!StringUtil.isValidStr(request.getParameter("uid"))){
			return ERROR;
		}
		int userId = Integer.parseInt(request.getParameter("uid"));
		
		flag = relationshipService.getRelationshipFlag(getUserId(), userId); //获取用户关系
		
		UserProfile userProfile = userProfileService.getUserProfileById(userId);
		if(userProfile == null){
			userProfile = new UserProfile();
			userProfile.setAttentionNumber(0);
			userProfile.setFansNumber(0);
			userProfile.setWeiboNumber(0);
		}
		profile.setUserProfile(userProfile);
		
		MyResume myResume = resumeService.getResumeByUserId(userId);
		Resume resume = new Resume();
		resume.setMyResume(myResume);
		profile.setResume(resume);
		
		if(myResume.getResumeStatus() != 1 && myResume.getResumeStatus() != 3){
			List<MyWorkExp> workExps = resumeService.getWorkExpByUserId(userId);
			List<Experience> experience = new ArrayList<Experience>();
			if(workExps != null){
				for(MyWorkExp wexp : workExps){
					Experience exp = new Experience();
					exp.setMyWorkExp(wexp);
					experience.add(exp);
				}
			}
			
			profile.setExperience(experience);
			
			List<MyEducation> educations = resumeService.getEducationByUserId(userId);
			List<Education> education = new ArrayList<Education>();
			if(educations != null){
				for(MyEducation mEdu : educations){
					Education edu = new Education();
					edu.setMyEducation(mEdu);
					education.add(edu);
				}
			}
			profile.setEducation(education);
		}
		
		//根据id查询用户个人标签
		labels = labelService.getLabelById(userId);
		
		//记录用户历史访问情况
		recordUserAccessHistory(userId);
		return SUCCESS;
	}
	
	/**
	 * 记录用户访问的历史记录
	 * 
	 * 一天只记录一次
	 * @return
	 */
	private void recordUserAccessHistory(int userId) {
		int accessUserId = this.getLoginInfo().getLoginUserId();
		String accessUserIp = request.getRemoteAddr();
		
		UserAccessHistory u = new UserAccessHistory();
		u.setUserId(userId);
		u.setAccessUserId(accessUserId);
		u.setAccessUserIp(accessUserIp);
		try {
			userAccessHistoryService.addUserAccessHistory(u);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	//--------------------------------------
	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public IUserProfileService getUserProfileService() {
		return userProfileService;
	}

	public void setUserProfileService(IUserProfileService userProfileService) {
		this.userProfileService = userProfileService;
	}
	
	public IMyResumeService getResumeService() {
		return resumeService;
	}

	public void setResumeService(IMyResumeService resumeService) {
		this.resumeService = resumeService;
	}

	public void setRelationshipService(IRelationshipService relationshipService) {
		this.relationshipService = relationshipService;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public IUserAccessHistoryService getUserAccessHistoryService() {
		return userAccessHistoryService;
	}

	public void setUserAccessHistoryService(
			IUserAccessHistoryService userAccessHistoryService) {
		this.userAccessHistoryService = userAccessHistoryService;
	}

	public void setLabelService(ILabelService labelService) {
		this.labelService = labelService;
	}

	public List<Label> getLabels() {
		return labels;
	}

	public void setLabels(List<Label> labels) {
		this.labels = labels;
	}
	
}
