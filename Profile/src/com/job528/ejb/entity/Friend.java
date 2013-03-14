package com.job528.ejb.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Friend implements Serializable {
	
	private Integer userId;
	private Integer groupId;
	private Integer flag;
	private UserProfile userProfile;
	
	public Friend() {
	}
	
	public Friend(Integer userId,Integer groupId,Integer flag) {
		this.userId = userId;
		this.groupId = groupId;
		this.flag = flag;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
}
