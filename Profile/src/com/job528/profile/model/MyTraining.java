package com.job528.profile.model;

/**
 * MyTraining entity. @author MyEclipse Persistence Tools
 */

public class MyTraining implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer myUserId;
	private String beginDate;
	private String endDate;
	private String organization;
	private String course;
	private String certificate;

	// Constructors

	/** default constructor */
	public MyTraining() {
	}

	/** full constructor */
	public MyTraining(Integer id, Integer myUserId, String beginDate,
			String endDate, String organization, String course,
			String certificate) {
		this.id = id;
		this.myUserId = myUserId;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.organization = organization;
		this.course = course;
		this.certificate = certificate;
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

	public String getBeginDate() {
		return this.beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return this.endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getOrganization() {
		return this.organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getCourse() {
		return this.course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getCertificate() {
		return this.certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

}