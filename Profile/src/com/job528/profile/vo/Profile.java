package com.job528.profile.vo;

import java.util.List;

import com.job528.ejb.entity.UserProfile;
import com.job528.profile.model.MyUsers;

public class Profile {

	private UserProfile userProfile;
	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	private MyUsers userInfo;
	
	private Resume resume;
	
	private List<Education> education;
	
	private List<Experience> experience;
	
	public MyUsers getUserInfo() {
		return userInfo;
	}
	
	public void setUserInfo(MyUsers userInfo) {
		this.userInfo = userInfo;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public List<Education> getEducation() {
		return education;
	}

	public void setEducation(List<Education> education) {
		this.education = education;
	}

	public List<Experience> getExperience() {
		return experience;
	}

	public void setExperience(List<Experience> experience) {
		this.experience = experience;
	}	
	
	
}
