package com.job528.ejb.dto;

import java.io.Serializable;


/**
 * 用户微博数据传输对象
 * @author lusanxiong
 *
 */
public class UserWeiboDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String weiboUserId;        //用户在微博服务商的用户ID
	private int    active;             //用户同步状态
	private int userId;                //528用户ID
	private int    weiboServiceType;   //微博服务商类型（新浪，腾讯）
	private String accessToken;        //访问令牌
	private String updateTime;         //最后一次操作时间
	
	
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
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
}
