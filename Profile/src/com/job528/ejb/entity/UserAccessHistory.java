package com.job528.ejb.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * UserAccessHistory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="UserAccessHistory")
public class UserAccessHistory implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int userId; //用户ID
	private int accessUserId; //访问用户ID
	private String accessUserIp; //访问用户IP
	
	@Temporal(TemporalType.TIMESTAMP) 
	private Date accessDate;  //访问用户时间

	// Constructors

	/** default constructor */
	public UserAccessHistory() {
	}

	/** full constructor */
	public UserAccessHistory(int userId, int accessUserId,
			String accessUserIp, Date accessDate) {
		this.userId = userId;
		this.accessUserId = accessUserId;
		this.accessUserIp = accessUserIp;
		this.accessDate = accessDate;
	}

	// Property accessors

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAccessUserId() {
		return this.accessUserId;
	}

	public void setAccessUserId(int accessUserId) {
		this.accessUserId = accessUserId;
	}

	public String getAccessUserIp() {
		return this.accessUserIp;
	}

	public void setAccessUserIp(String accessUserIp) {
		this.accessUserIp = accessUserIp;
	}

	public Date getAccessDate() {
		return this.accessDate;
	}

	public void setAccessDate(Date accessDate) {
		this.accessDate = accessDate;
	}

}