package com.job528.profile.model;

/**
 * MyEducationEng entity. @author MyEclipse Persistence Tools
 */

public class MyEducationEng implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer myUserId;
	private Short degreeId;
	private String degreeName;
	private String beginDate;
	private String endDate;
	private String schoolName;
	private String speciality;
	private String certificate;

	// Constructors

	/** default constructor */
	public MyEducationEng() {
	}

	/** full constructor */
	public MyEducationEng(Integer id, Integer myUserId, Short degreeId,
			String degreeName, String beginDate, String endDate,
			String schoolName, String speciality, String certificate) {
		this.id = id;
		this.myUserId = myUserId;
		this.degreeId = degreeId;
		this.degreeName = degreeName;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.schoolName = schoolName;
		this.speciality = speciality;
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

	public Short getDegreeId() {
		return this.degreeId;
	}

	public void setDegreeId(Short degreeId) {
		this.degreeId = degreeId;
	}

	public String getDegreeName() {
		return this.degreeName;
	}

	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
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

	public String getSchoolName() {
		return this.schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSpeciality() {
		return this.speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getCertificate() {
		return this.certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

}