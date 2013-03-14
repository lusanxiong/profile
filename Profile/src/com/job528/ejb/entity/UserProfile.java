package com.job528.ejb.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="UserProfile")
public class UserProfile implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private Integer userId;
	private String userName;
	private String headImage;
	private Integer attentionNumber;
	private Integer fansNumber;
	private Integer weiboNumber;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getHeadImage() {
		return headImage;
	}
	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}
	public Integer getAttentionNumber() {
		return attentionNumber;
	}
	public void setAttentionNumber(Integer attentionNumber) {
		this.attentionNumber = attentionNumber;
	}
	public Integer getFansNumber() {
		return fansNumber;
	}
	public void setFansNumber(Integer fansNumber) {
		this.fansNumber = fansNumber;
	}
	public Integer getWeiboNumber() {
		return weiboNumber;
	}
	public void setWeiboNumber(Integer weiboNumber) {
		this.weiboNumber = weiboNumber;
	}
	
	
}
