package com.job528.profile.model;

import java.sql.Date;

/**
 * MySearcher entity. @author MyEclipse Persistence Tools
 */

public class MySearcher implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer myUserId;
	private String searcherName;
	private Date registerDate;
	private String jobLocation1;
	private String jobLocation2;
	private String jobLocation3;
	private Short jobFunction1;
	private Short jobFunction2;
	private Short jobFunction3;
	private Integer positionPostDate;
	private String keyword;
	private Integer keywordType;
	private Integer degreeId1;
	private Integer degreeId2;
	private Integer workedYear1;
	private Integer workedYear2;
	private Short sex;
	private Short age;
	private Boolean subscibeFlag;
	private String email;
	private Integer calling1;
	private Integer calling2;
	private Integer calling3;
	private Integer otherflag;
	private Boolean phoneOrder;
	private String mobileNum;

	// Constructors

	/** default constructor */
	public MySearcher() {
	}

	/** minimal constructor */
	public MySearcher(Integer id, Integer myUserId, String searcherName,
			Date registerDate, String jobLocation1, String jobLocation2,
			String jobLocation3, Short jobFunction1, Short jobFunction2,
			Short jobFunction3, Integer positionPostDate, String keyword,
			Integer keywordType, Integer degreeId1, Integer degreeId2,
			Integer workedYear1, Integer workedYear2, Short sex, Short age,
			Boolean subscibeFlag, String email, Integer calling1,
			Integer calling2, Integer calling3, Integer otherflag,
			Boolean phoneOrder) {
		this.id = id;
		this.myUserId = myUserId;
		this.searcherName = searcherName;
		this.registerDate = registerDate;
		this.jobLocation1 = jobLocation1;
		this.jobLocation2 = jobLocation2;
		this.jobLocation3 = jobLocation3;
		this.jobFunction1 = jobFunction1;
		this.jobFunction2 = jobFunction2;
		this.jobFunction3 = jobFunction3;
		this.positionPostDate = positionPostDate;
		this.keyword = keyword;
		this.keywordType = keywordType;
		this.degreeId1 = degreeId1;
		this.degreeId2 = degreeId2;
		this.workedYear1 = workedYear1;
		this.workedYear2 = workedYear2;
		this.sex = sex;
		this.age = age;
		this.subscibeFlag = subscibeFlag;
		this.email = email;
		this.calling1 = calling1;
		this.calling2 = calling2;
		this.calling3 = calling3;
		this.otherflag = otherflag;
		this.phoneOrder = phoneOrder;
	}

	/** full constructor */
	public MySearcher(Integer id, Integer myUserId, String searcherName,
			Date registerDate, String jobLocation1, String jobLocation2,
			String jobLocation3, Short jobFunction1, Short jobFunction2,
			Short jobFunction3, Integer positionPostDate, String keyword,
			Integer keywordType, Integer degreeId1, Integer degreeId2,
			Integer workedYear1, Integer workedYear2, Short sex, Short age,
			Boolean subscibeFlag, String email, Integer calling1,
			Integer calling2, Integer calling3, Integer otherflag,
			Boolean phoneOrder, String mobileNum) {
		this.id = id;
		this.myUserId = myUserId;
		this.searcherName = searcherName;
		this.registerDate = registerDate;
		this.jobLocation1 = jobLocation1;
		this.jobLocation2 = jobLocation2;
		this.jobLocation3 = jobLocation3;
		this.jobFunction1 = jobFunction1;
		this.jobFunction2 = jobFunction2;
		this.jobFunction3 = jobFunction3;
		this.positionPostDate = positionPostDate;
		this.keyword = keyword;
		this.keywordType = keywordType;
		this.degreeId1 = degreeId1;
		this.degreeId2 = degreeId2;
		this.workedYear1 = workedYear1;
		this.workedYear2 = workedYear2;
		this.sex = sex;
		this.age = age;
		this.subscibeFlag = subscibeFlag;
		this.email = email;
		this.calling1 = calling1;
		this.calling2 = calling2;
		this.calling3 = calling3;
		this.otherflag = otherflag;
		this.phoneOrder = phoneOrder;
		this.mobileNum = mobileNum;
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

	public String getSearcherName() {
		return this.searcherName;
	}

	public void setSearcherName(String searcherName) {
		this.searcherName = searcherName;
	}

	public Date getRegisterDate() {
		return this.registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public String getJobLocation1() {
		return this.jobLocation1;
	}

	public void setJobLocation1(String jobLocation1) {
		this.jobLocation1 = jobLocation1;
	}

	public String getJobLocation2() {
		return this.jobLocation2;
	}

	public void setJobLocation2(String jobLocation2) {
		this.jobLocation2 = jobLocation2;
	}

	public String getJobLocation3() {
		return this.jobLocation3;
	}

	public void setJobLocation3(String jobLocation3) {
		this.jobLocation3 = jobLocation3;
	}

	public Short getJobFunction1() {
		return this.jobFunction1;
	}

	public void setJobFunction1(Short jobFunction1) {
		this.jobFunction1 = jobFunction1;
	}

	public Short getJobFunction2() {
		return this.jobFunction2;
	}

	public void setJobFunction2(Short jobFunction2) {
		this.jobFunction2 = jobFunction2;
	}

	public Short getJobFunction3() {
		return this.jobFunction3;
	}

	public void setJobFunction3(Short jobFunction3) {
		this.jobFunction3 = jobFunction3;
	}

	public Integer getPositionPostDate() {
		return this.positionPostDate;
	}

	public void setPositionPostDate(Integer positionPostDate) {
		this.positionPostDate = positionPostDate;
	}

	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getKeywordType() {
		return this.keywordType;
	}

	public void setKeywordType(Integer keywordType) {
		this.keywordType = keywordType;
	}

	public Integer getDegreeId1() {
		return this.degreeId1;
	}

	public void setDegreeId1(Integer degreeId1) {
		this.degreeId1 = degreeId1;
	}

	public Integer getDegreeId2() {
		return this.degreeId2;
	}

	public void setDegreeId2(Integer degreeId2) {
		this.degreeId2 = degreeId2;
	}

	public Integer getWorkedYear1() {
		return this.workedYear1;
	}

	public void setWorkedYear1(Integer workedYear1) {
		this.workedYear1 = workedYear1;
	}

	public Integer getWorkedYear2() {
		return this.workedYear2;
	}

	public void setWorkedYear2(Integer workedYear2) {
		this.workedYear2 = workedYear2;
	}

	public Short getSex() {
		return this.sex;
	}

	public void setSex(Short sex) {
		this.sex = sex;
	}

	public Short getAge() {
		return this.age;
	}

	public void setAge(Short age) {
		this.age = age;
	}

	public Boolean getSubscibeFlag() {
		return this.subscibeFlag;
	}

	public void setSubscibeFlag(Boolean subscibeFlag) {
		this.subscibeFlag = subscibeFlag;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCalling1() {
		return this.calling1;
	}

	public void setCalling1(Integer calling1) {
		this.calling1 = calling1;
	}

	public Integer getCalling2() {
		return this.calling2;
	}

	public void setCalling2(Integer calling2) {
		this.calling2 = calling2;
	}

	public Integer getCalling3() {
		return this.calling3;
	}

	public void setCalling3(Integer calling3) {
		this.calling3 = calling3;
	}

	public Integer getOtherflag() {
		return this.otherflag;
	}

	public void setOtherflag(Integer otherflag) {
		this.otherflag = otherflag;
	}

	public Boolean getPhoneOrder() {
		return this.phoneOrder;
	}

	public void setPhoneOrder(Boolean phoneOrder) {
		this.phoneOrder = phoneOrder;
	}

	public String getMobileNum() {
		return this.mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

}