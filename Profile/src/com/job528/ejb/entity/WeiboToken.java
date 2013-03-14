package com.job528.ejb.entity;

import java.util.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * WeiboToken entity. 
 * 
 * 微博同步实体
 * @author lusanxiong
 */
@Entity
@Table(name="WeiboToken")
public class WeiboToken implements java.io.Serializable {

	// Fields
	
	private static final long serialVersionUID = 1L;
	
	private int id;                    //主键ID
	private Integer userId;            //528用户ID
	private String sinaUserId;         //新浪微博用户ID
	private String token;              //新浪微博用户 访问令牌
	private String tokenSecret;        
	private Integer active;            //同步状态
	
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date operationDate;   //操作时间

	// Constructors
	public WeiboToken() {
	}

	public WeiboToken(Integer userId, String sinaUserId, String token,
			String tokenSecret, Integer active, Date operationDate) {
		this.userId = userId;
		this.sinaUserId = sinaUserId;
		this.token = token;
		this.tokenSecret = tokenSecret;
		this.active = active;
		this.operationDate = operationDate;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getTokenSecret() {
		return this.tokenSecret;
	}

	public void setTokenSecret(String tokenSecret) {
		this.tokenSecret = tokenSecret;
	}

	public Integer getActive() {
		return this.active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public Date getOperationDate() {
		return this.operationDate;
	}

	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}

}