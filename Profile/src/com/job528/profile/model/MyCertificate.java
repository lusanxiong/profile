package com.job528.profile.model;

import java.sql.Timestamp;

/**
 * MyCertificate entity. @author MyEclipse Persistence Tools
 */

public class MyCertificate implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer myUserId;
	private Integer cerOrder;
	private String cerNo;
	private String cerName;
	private Timestamp awardDate;
	private String description;
	private String organization;
	private String fileName;
	private Boolean sendFlag;

	// Constructors

	/** default constructor */
	public MyCertificate() {
	}

	/** minimal constructor */
	public MyCertificate(Integer id, Integer myUserId, Timestamp awardDate,
			String fileName, Boolean sendFlag) {
		this.id = id;
		this.myUserId = myUserId;
		this.awardDate = awardDate;
		this.fileName = fileName;
		this.sendFlag = sendFlag;
	}

	/** full constructor */
	public MyCertificate(Integer id, Integer myUserId, Integer cerOrder,
			String cerNo, String cerName, Timestamp awardDate,
			String description, String organization, String fileName,
			Boolean sendFlag) {
		this.id = id;
		this.myUserId = myUserId;
		this.cerOrder = cerOrder;
		this.cerNo = cerNo;
		this.cerName = cerName;
		this.awardDate = awardDate;
		this.description = description;
		this.organization = organization;
		this.fileName = fileName;
		this.sendFlag = sendFlag;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMyUserId() {
		return this.myUserId;
	}

	public void setMyUserId(Integer myUserId) {
		this.myUserId = myUserId;
	}

	public Integer getCerOrder() {
		return this.cerOrder;
	}

	public void setCerOrder(Integer cerOrder) {
		this.cerOrder = cerOrder;
	}

	public String getCerNo() {
		return this.cerNo;
	}

	public void setCerNo(String cerNo) {
		this.cerNo = cerNo;
	}

	public String getCerName() {
		return this.cerName;
	}

	public void setCerName(String cerName) {
		this.cerName = cerName;
	}

	public Timestamp getAwardDate() {
		return this.awardDate;
	}

	public void setAwardDate(Timestamp awardDate) {
		this.awardDate = awardDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOrganization() {
		return this.organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Boolean getSendFlag() {
		return this.sendFlag;
	}

	public void setSendFlag(Boolean sendFlag) {
		this.sendFlag = sendFlag;
	}

}