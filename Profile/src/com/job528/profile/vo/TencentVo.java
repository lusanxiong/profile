package com.job528.profile.vo;

public class TencentVo {
	
	private String accessToken; //访问令牌
	
	private String content; //要发送的微博内容
	
	private int active; //微博同步状态
	
	private String openid; //腾讯微博唯一标识
	
	private String clientIp;//用户客户端ip
	
	private String imagePath ;//图片路径
	
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getClientIp() {
		return clientIp;
	}
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

}
