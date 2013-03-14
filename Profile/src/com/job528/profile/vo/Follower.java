package com.job528.profile.vo;

import com.job528.ejb.entity.Friend;
import com.job528.lucene.bean.UserInfo;
import com.job528.profile.util.Group;
import com.job528.profile.util.ResumeUtil;
import com.job528.util.StrUtils;

public class Follower {

	private UserInfo userInfo;
	
	private Friend friend;

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Friend getFriend() {
		return friend;
	}

	public void setFriend(Friend friend) {
		this.friend = friend;
	}
	
	
	public String getSchool(){
		
		if(this.userInfo == null) 
			return "";
		if(StrUtils.isNull(this.userInfo.getSchool()))
			return "";
		
		String schs[] = this.userInfo.getSchool().split(",");
		return schs.length >=1 ? schs[0] : "";
		
		//return this.userInfo != null ? this.userInfo.getSchool() : "";
	}
	
	public String getSpeciality(){
		if(this.userInfo == null) 
			return "";
		if(StrUtils.isNull(this.userInfo.getSpeciality()))
			return "";
		
		String sqe[] = this.userInfo.getSpeciality().split(",");
		return sqe.length >=1 ? sqe[0] : "";
		//return this.userInfo != null ? this.userInfo.getSpeciality() : "";
	}
	
	public String getIntroduction(){

        if(this.userInfo == null || StrUtils.isNull(this.userInfo.getIntroduction())){
        	return "暂无介绍...";
        }
		return this.userInfo.getIntroduction();
	}
	
	
	public int getFollewsNum(){
		if(this.friend == null)
			return 0;
		return this.friend.getUserProfile() != null ? this.friend.getUserProfile().getAttentionNumber() : 0;
	}
	
	
	public int getFansNum(){
		if(this.friend == null)
			return 0;
		return this.friend.getUserProfile() != null ? this.friend.getUserProfile().getFansNumber() : 0;
	}
	
	public int getMessageNum(){
		if(this.friend == null)
			return 0;
		return this.friend.getUserProfile() != null ? this.friend.getUserProfile().getWeiboNumber() : 0;
	}
	
	public boolean getFollowEach(){
		if(this.friend == null)
			return false;
		if(this.friend.getFlag() == 2 || this.friend.getFlag() == 7){
			return true;
		}
		return false;
	}
	
	
	public String getGroupName(){
		if(this.friend == null)
			return "";
		return Group.getGroupById(this.friend.getGroupId()).getGroupName();
	}
	
	
	public String getUhead(){
		if(this.userInfo == null) 
			return ResumeUtil.defaultHeadImg;
		if(StrUtils.isNull(this.userInfo.getPhoto()))
			return ResumeUtil.defaultHeadImg;
		return this.userInfo.getPhoto();
	}
	
	public String getPlace(){
		if(this.userInfo == null) 
			return "";
		if(StrUtils.isNull(this.userInfo.getPlace()))
			return "";
		return this.userInfo.getPlace().replace(",", " ");
	}
	
//	public static void main(String args[]){
//		String str = "  ffff fff   ";
//		System.out.print(str + "gggg");
//		System.out.print(str.trim() + "gggg------");
//	}
	
	
}
