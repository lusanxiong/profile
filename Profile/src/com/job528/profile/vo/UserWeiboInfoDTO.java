package com.job528.profile.vo;

import java.io.Serializable;

/**
 * 用户微博信息传输对象
 * @author lusanxiong
 *
 */
public class UserWeiboInfoDTO implements Serializable{
	//private static final long serialVersionUID = 1L;
	private String weiboUserId;        //用户在微博服务商的用户ID
	private int    active;             //用户同步状态
	
	private String activeName;             //用户同步状态名称
	private int    userId;             //528用户ID
	private int    weiboServiceType;   //微博服务商类型（新浪，腾讯）
	private String weiboServiceName;   //微博服务商类型（新浪，腾讯）
	private String weiboServicePhoto;   //微博服务商图标（新浪，腾讯）
	private String updateTime;         //最后一次操作时间
	
	public String getWeiboServicePhoto() {
		return weiboServicePhoto;
	}
	public void setWeiboServicePhoto(String weiboServicePhoto) {
		this.weiboServicePhoto = weiboServicePhoto;
	}
	public String getWeiboUserId() {
		return weiboUserId;
	}
	public void setWeiboUserId(String weiboUserId) {
		this.weiboUserId = weiboUserId;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String getActiveName() {
		return activeName;
	}
	public void setActiveName(String activeName) {
		this.activeName = activeName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getWeiboServiceType() {
		return weiboServiceType;
	}
	public void setWeiboServiceType(int weiboServiceType) {
		this.weiboServiceType = weiboServiceType;
	}
	public String getWeiboServiceName() {
		return weiboServiceName;
	}
	public void setWeiboServiceName(String weiboServiceName) {
		this.weiboServiceName = weiboServiceName;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
}
