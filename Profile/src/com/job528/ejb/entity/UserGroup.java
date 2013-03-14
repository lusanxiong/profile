package com.job528.ejb.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 组实体 
 * 
 * @author lusanxiong
 */

@Entity
@Table(name="UserGroup")
public class UserGroup implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String groupName;
	private Integer createUserId;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date createDate;
	
	public UserGroup() {
		
	}
	public UserGroup(String groupName, Integer createUserId, Timestamp createDate) {
		this.groupName = groupName;
		this.createUserId = createUserId;
		this.createDate = createDate;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Integer getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	@Override
	public String toString() {
		return "groupName="+groupName
		+"|createUserId="+ createUserId
		+"|createDate="+ createDate;
	}

}