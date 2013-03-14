package com.job528.ejb.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@SuppressWarnings("serial")
@Entity
@Table(name="TencentToken")
public class TencentToken implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;                    //主键ID
	private Integer userId;            //528用户ID
	private String tencentUserId;      //腾讯微博用户ID
	private String token;              //用户 访问令牌
	private Integer active;            //同步状态
		
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date operationDate;   //操作时间

	public Date getOperationDate() {
		return operationDate;
	}
	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getTencentUserId() {
		return tencentUserId;
	}
	public void setTencentUserId(String tencentUserId) {
		this.tencentUserId = tencentUserId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}
	       
	
}
