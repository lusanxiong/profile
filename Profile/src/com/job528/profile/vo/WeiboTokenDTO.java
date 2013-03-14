package com.job528.profile.vo;

public class WeiboTokenDTO {
	private Integer userId;            //528用户ID
	private String sinaUserId;         //新浪微博用户ID
	private String token;              //新浪微博用户 访问令牌
	
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getSinaUserId() {
		return this.sinaUserId;
	}

	public void setSinaUserId(String sinaUserId) {
		this.sinaUserId = sinaUserId;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
