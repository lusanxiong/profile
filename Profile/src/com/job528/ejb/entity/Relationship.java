package com.job528.ejb.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name="Relationship")
public class Relationship implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
 	private Long id;
 	private Integer userId;
 	private Integer otherUserId;
	private Integer flag;
 	private Integer isRead;
 	private Integer groupId=0; //默认为0 ,未分组
 	
 	@Column(insertable=false)
 	private Date joinDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getOtherUserId() {
		return otherUserId;
	}

	public void setOtherUserId(Integer otherUserId) {
		this.otherUserId = otherUserId;
	}
	
	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Integer getIsRead() {
		return isRead;
	}

	public void setIsRead(Integer isRead) {
		this.isRead = isRead;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
 	
 	
}
