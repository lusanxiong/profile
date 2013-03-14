package com.job528.profile.vo;

public class SendWeiboDTO {
	private String accessToken; //访问令牌
	private String content; //要发送的微博内容
	private int weiboActive; //微博同步状态
	private String sinaUserId; //新浪用户ID
	private String fileURL; //要发送的微博图片URL
	
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getWeiboActive() {
		return weiboActive;
	}
	public void setWeiboActive(int weiboActive) {
		this.weiboActive = weiboActive;
	}
	public String getSinaUserId() {
		return sinaUserId;
	}
	public void setSinaUserId(String sinaUserId) {
		this.sinaUserId = sinaUserId;
	}
	public String getFileURL() {
		return fileURL;
	}
	public void setFileURL(String fileURL) {
		this.fileURL = fileURL;
	}
}
