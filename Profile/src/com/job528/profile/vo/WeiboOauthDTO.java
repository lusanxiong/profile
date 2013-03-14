package com.job528.profile.vo;

/**
 * 微博授权dto
 * @author lusanxiong
 *
 */
public class WeiboOauthDTO {
	
	private String accessToken; //访问令牌
	private String sinaUserId;  //新浪userId
	private String expireIn;   //访问令牌过期时间
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getSinaUserId() {
		return sinaUserId;
	}
	public void setSinaUserId(String sinaUserId) {
		this.sinaUserId = sinaUserId;
	}
	public String getExpireIn() {
		return expireIn;
	}
	public void setExpireIn(String expireIn) {
		this.expireIn = expireIn;
	}
	
	
}
