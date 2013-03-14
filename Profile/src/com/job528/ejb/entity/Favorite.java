package com.job528.ejb.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name="Favorite")
public class Favorite implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer userId;
	private BigInteger weiboId;
	
	@Column(insertable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	public Favorite() {
	}

	public Integer getId() {
		return this.id;
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

	public BigInteger getWeiboId() {
		return weiboId;
	}

	public void setWeiboId(BigInteger weiboId) {
		this.weiboId = weiboId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int hashCode() {
		return (this.id == null) ? 0 : this.id.hashCode();
	}

	public boolean equals(Object object) {
		if (object instanceof Favorite) {
			final Favorite obj = (Favorite) object;
			return (this.id != null) ? this.id.equals(obj.id)
					: (obj.id == null);
		}
		return false;
	}

}
