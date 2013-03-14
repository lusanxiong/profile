package com.job528.profile.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * IpAddress entity. @author MyEclipse Persistence Tools
 */

@Entity
@Table(name="IpAddress")
public class IpAddress implements java.io.Serializable {

	//private static final long serialVersionUID = 1L;
	
	// Fields
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String startIp; //IP地址段开始
	private String endIp; //IP地址段结束
	private String ipLocation;//Ip地址地区详细信息
	private String province; //IP地址所在省份
	private String city; //IP地址所在城市
	private String area; //IP地址所在地区
	private BigDecimal startIpValue; //IP地址段开始数字值
	private BigDecimal endIpValue; //IP地址段结束 转换成数数字值
	private String country;//IP所在国家
	
	
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date createDate;      


	@Temporal(value=TemporalType.TIMESTAMP)
	private Date updateDate;    
	// Constructors

	/** default constructor */
	public IpAddress() {
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/** full constructor */
	public IpAddress(String startIp, String endIp, String ipLocation,
			String province, String city, String area, BigDecimal startIpValue,
			BigDecimal endIpValue) {
		this.startIp = startIp;
		this.endIp = endIp;
		this.ipLocation = ipLocation;
		this.province = province;
		this.city = city;
		this.area = area;
		this.startIpValue = startIpValue;
		this.endIpValue = endIpValue;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStartIp() {
		return this.startIp;
	}

	public void setStartIp(String startIp) {
		this.startIp = startIp;
	}

	public String getEndIp() {
		return this.endIp;
	}

	public void setEndIp(String endIp) {
		this.endIp = endIp;
	}

	public String getIpLocation() {
		return this.ipLocation;
	}

	public void setIpLocation(String ipLocation) {
		this.ipLocation = ipLocation;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public BigDecimal getStartIpValue() {
		return this.startIpValue;
	}

	public void setStartIpValue(BigDecimal startIpValue) {
		this.startIpValue = startIpValue;
	}

	public BigDecimal getEndIpValue() {
		return this.endIpValue;
	}

	public void setEndIpValue(BigDecimal endIpValue) {
		this.endIpValue = endIpValue;
	}

}