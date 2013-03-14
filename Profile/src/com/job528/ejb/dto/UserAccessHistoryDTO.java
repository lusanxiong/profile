package com.job528.ejb.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户访问历史记录 数据传输对象
 * @author lusanxiong
 *
 */
public class UserAccessHistoryDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int accessUserId;     //访问用户ID
	private String accessUserName;//访问用户名称
	private String nowPlaceId;//访问用户现居地ID
	private String nowPlaceName;//访问用户现居地
	private int accessUserJobFunctionId;//访问用户职务名ID
	private int accessUserPost;//访问用户职务名名称
	private Date accessDate;//访问日期
	private String photo; //访问者头像
	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getAccessUserId() {
		return accessUserId;
	}
	public void setAccessUserId(int accessUserId) {
		this.accessUserId = accessUserId;
	}
	public String getAccessUserName() {
		return accessUserName;
	}
	public void setAccessUserName(String accessUserName) {
		this.accessUserName = accessUserName;
	}
	public String getNowPlaceId() {
		return nowPlaceId;
	}
	public void setNowPlaceId(String nowPlaceId) {
		this.nowPlaceId = nowPlaceId;
	}
	public String getNowPlaceName() {
		return nowPlaceName;
	}
	public void setNowPlaceName(String nowPlaceName) {
		this.nowPlaceName = nowPlaceName;
	}
	public int getAccessUserJobFunctionId() {
		return accessUserJobFunctionId;
	}
	public void setAccessUserJobFunctionId(int accessUserJobFunctionId) {
		this.accessUserJobFunctionId = accessUserJobFunctionId;
	}
	public int getAccessUserPost() {
		return accessUserPost;
	}
	public void setAccessUserPost(int accessUserPost) {
		this.accessUserPost = accessUserPost;
	}
	public Date getAccessDate() {
		return accessDate;
	}
	public void setAccessDate(Date accessDate) {
		this.accessDate = accessDate;
	}
	
	
	
	
}
