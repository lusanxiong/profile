package com.job528.ejb.dto;

import java.io.Serializable;

/**
 * 草根名人信息
 * @author lusanxiong
 *
 */
public class HotFamousUserDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int fansNumber; //粉丝数量 
	private int myAttentionNumber; //我关注的用户数量
	private int weiboNumber;//发布的微博数量
	private String userName;//用户名
	private int jobfunctionId;//最近一次工作岗位ID
	private String userLastPost;//最近一次工作岗位名称
	private int userid;//用户ID
	private String nowLocation;//现居地ID
	private String nowLocationName;//现居地名称
	private String photo;//个人头像
	
	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getUserLastPost() {
		return userLastPost;
	}
	public void setUserLastPost(String userLastPost) {
		this.userLastPost = userLastPost;
	}
	public String getNowLocationName() {
		return nowLocationName;
	}
	public void setNowLocationName(String nowLocationName) {
		this.nowLocationName = nowLocationName;
	}
	public int getWeiboNumber() {
		return weiboNumber;
	}
	public void setWeiboNumber(int weiboNumber) {
		this.weiboNumber = weiboNumber;
	}
	public int getFansNumber() {
		return fansNumber;
	}
	public void setFansNumber(int fansNumber) {
		this.fansNumber = fansNumber;
	}
	public int getMyAttentionNumber() {
		return myAttentionNumber;
	}
	public void setMyAttentionNumber(int myAttentionNumber) {
		this.myAttentionNumber = myAttentionNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getJobfunctionId() {
		return jobfunctionId;
	}
	public void setJobfunctionId(int jobfunctionId) {
		this.jobfunctionId = jobfunctionId;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getNowLocation() {
		return nowLocation;
	}
	public void setNowLocation(String nowLocation) {
		this.nowLocation = nowLocation;
	}
	
	
	
}
