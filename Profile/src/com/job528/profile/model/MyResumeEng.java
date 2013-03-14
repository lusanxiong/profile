package com.job528.profile.model;

import java.sql.Timestamp;

/**
 * MyResumeEng entity. @author MyEclipse Persistence Tools
 */

public class MyResumeEng implements java.io.Serializable {

	// Fields

	private Integer resId;
	private Integer myUserId;
	private String perName;
	private Short sex;
	private String nationality;
	private Timestamp birthday;
	private Short cardType;
	private String idcardNum;
	private Short height;
	private Short maritalStatus;
	private String hometown;
	private String location;
	private String selfDescription;
	private Short degreeId;
	private String degreeScript;
	private String relationPhone;
	private String mobileNum;
	private String bpnumber;
	private String imnum;
	private String email;
	private String homepage;
	private String address;
	private String zipCode;
	private String techTitle;
	private Short computerLevel;
	private String computerSkills;
	private Integer toefl;
	private Integer japanLevel;
	private Integer engLevel;
	private Integer gre;
	private Integer gmat;
	private Integer ielts;
	private Short fltwoLevel;
	private String flother;
	private String otherSkills;
	private String interesting;
	private String workExprienceGr;
	private Short jobFunction1;
	private Short jobFunction2;
	private Short jobFunction3;
	private String jobSeeking1;
	private String jobSeeking2;
	private String jobSeeking3;
	private String jobLocation1;
	private String jobLocation2;
	private String jobLocation3;
	private Integer salary;
	private Boolean salaryNegotiable;
	private Boolean houseNeeded;
	private String checkinDate;
	private String otherRequirement;
	private String careerDirection;
	private String major;
	private Short workedComNumber;
	private Short workedYear;
	private Short workedMonth;
	private Timestamp registerDate;
	private Timestamp updateDate;
	private Short checkFlag;

	// Constructors

	/** default constructor */
	public MyResumeEng() {
	}

	/** minimal constructor */
	public MyResumeEng(Integer resId, Integer myUserId, String perName,
			Short sex, String nationality, Timestamp birthday, Short cardType,
			String idcardNum, Short height, Short maritalStatus,
			String hometown, String location, String selfDescription,
			Short degreeId, String degreeScript, String relationPhone,
			String mobileNum, String bpnumber, String imnum, String email,
			String homepage, String address, String zipCode, String techTitle,
			Short computerLevel, String computerSkills, Integer toefl,
			Integer japanLevel, Integer engLevel, Integer gre, Integer gmat,
			Integer ielts, Short fltwoLevel, String otherSkills,
			String interesting, String workExprienceGr, Short jobFunction1,
			Short jobFunction2, Short jobFunction3, String jobSeeking1,
			String jobSeeking2, String jobSeeking3, String jobLocation1,
			String jobLocation2, String jobLocation3, Integer salary,
			Boolean salaryNegotiable, Boolean houseNeeded, String checkinDate,
			String otherRequirement, String careerDirection,
			Short workedComNumber, Short workedYear, Short workedMonth,
			Timestamp registerDate, Timestamp updateDate, Short checkFlag) {
		this.resId = resId;
		this.myUserId = myUserId;
		this.perName = perName;
		this.sex = sex;
		this.nationality = nationality;
		this.birthday = birthday;
		this.cardType = cardType;
		this.idcardNum = idcardNum;
		this.height = height;
		this.maritalStatus = maritalStatus;
		this.hometown = hometown;
		this.location = location;
		this.selfDescription = selfDescription;
		this.degreeId = degreeId;
		this.degreeScript = degreeScript;
		this.relationPhone = relationPhone;
		this.mobileNum = mobileNum;
		this.bpnumber = bpnumber;
		this.imnum = imnum;
		this.email = email;
		this.homepage = homepage;
		this.address = address;
		this.zipCode = zipCode;
		this.techTitle = techTitle;
		this.computerLevel = computerLevel;
		this.computerSkills = computerSkills;
		this.toefl = toefl;
		this.japanLevel = japanLevel;
		this.engLevel = engLevel;
		this.gre = gre;
		this.gmat = gmat;
		this.ielts = ielts;
		this.fltwoLevel = fltwoLevel;
		this.otherSkills = otherSkills;
		this.interesting = interesting;
		this.workExprienceGr = workExprienceGr;
		this.jobFunction1 = jobFunction1;
		this.jobFunction2 = jobFunction2;
		this.jobFunction3 = jobFunction3;
		this.jobSeeking1 = jobSeeking1;
		this.jobSeeking2 = jobSeeking2;
		this.jobSeeking3 = jobSeeking3;
		this.jobLocation1 = jobLocation1;
		this.jobLocation2 = jobLocation2;
		this.jobLocation3 = jobLocation3;
		this.salary = salary;
		this.salaryNegotiable = salaryNegotiable;
		this.houseNeeded = houseNeeded;
		this.checkinDate = checkinDate;
		this.otherRequirement = otherRequirement;
		this.careerDirection = careerDirection;
		this.workedComNumber = workedComNumber;
		this.workedYear = workedYear;
		this.workedMonth = workedMonth;
		this.registerDate = registerDate;
		this.updateDate = updateDate;
		this.checkFlag = checkFlag;
	}

	/** full constructor */
	public MyResumeEng(Integer resId, Integer myUserId, String perName,
			Short sex, String nationality, Timestamp birthday, Short cardType,
			String idcardNum, Short height, Short maritalStatus,
			String hometown, String location, String selfDescription,
			Short degreeId, String degreeScript, String relationPhone,
			String mobileNum, String bpnumber, String imnum, String email,
			String homepage, String address, String zipCode, String techTitle,
			Short computerLevel, String computerSkills, Integer toefl,
			Integer japanLevel, Integer engLevel, Integer gre, Integer gmat,
			Integer ielts, Short fltwoLevel, String flother,
			String otherSkills, String interesting, String workExprienceGr,
			Short jobFunction1, Short jobFunction2, Short jobFunction3,
			String jobSeeking1, String jobSeeking2, String jobSeeking3,
			String jobLocation1, String jobLocation2, String jobLocation3,
			Integer salary, Boolean salaryNegotiable, Boolean houseNeeded,
			String checkinDate, String otherRequirement,
			String careerDirection, String major, Short workedComNumber,
			Short workedYear, Short workedMonth, Timestamp registerDate,
			Timestamp updateDate, Short checkFlag) {
		this.resId = resId;
		this.myUserId = myUserId;
		this.perName = perName;
		this.sex = sex;
		this.nationality = nationality;
		this.birthday = birthday;
		this.cardType = cardType;
		this.idcardNum = idcardNum;
		this.height = height;
		this.maritalStatus = maritalStatus;
		this.hometown = hometown;
		this.location = location;
		this.selfDescription = selfDescription;
		this.degreeId = degreeId;
		this.degreeScript = degreeScript;
		this.relationPhone = relationPhone;
		this.mobileNum = mobileNum;
		this.bpnumber = bpnumber;
		this.imnum = imnum;
		this.email = email;
		this.homepage = homepage;
		this.address = address;
		this.zipCode = zipCode;
		this.techTitle = techTitle;
		this.computerLevel = computerLevel;
		this.computerSkills = computerSkills;
		this.toefl = toefl;
		this.japanLevel = japanLevel;
		this.engLevel = engLevel;
		this.gre = gre;
		this.gmat = gmat;
		this.ielts = ielts;
		this.fltwoLevel = fltwoLevel;
		this.flother = flother;
		this.otherSkills = otherSkills;
		this.interesting = interesting;
		this.workExprienceGr = workExprienceGr;
		this.jobFunction1 = jobFunction1;
		this.jobFunction2 = jobFunction2;
		this.jobFunction3 = jobFunction3;
		this.jobSeeking1 = jobSeeking1;
		this.jobSeeking2 = jobSeeking2;
		this.jobSeeking3 = jobSeeking3;
		this.jobLocation1 = jobLocation1;
		this.jobLocation2 = jobLocation2;
		this.jobLocation3 = jobLocation3;
		this.salary = salary;
		this.salaryNegotiable = salaryNegotiable;
		this.houseNeeded = houseNeeded;
		this.checkinDate = checkinDate;
		this.otherRequirement = otherRequirement;
		this.careerDirection = careerDirection;
		this.major = major;
		this.workedComNumber = workedComNumber;
		this.workedYear = workedYear;
		this.workedMonth = workedMonth;
		this.registerDate = registerDate;
		this.updateDate = updateDate;
		this.checkFlag = checkFlag;
	}

	// Property accessors

	public Integer getResId() {
		return this.resId;
	}

	public void setResId(Integer resId) {
		this.resId = resId;
	}

	public Integer getMyUserId() {
		return this.myUserId;
	}

	public void setMyUserId(Integer myUserId) {
		this.myUserId = myUserId;
	}

	public String getPerName() {
		return this.perName;
	}

	public void setPerName(String perName) {
		this.perName = perName;
	}

	public Short getSex() {
		return this.sex;
	}

	public void setSex(Short sex) {
		this.sex = sex;
	}

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Timestamp getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public Short getCardType() {
		return this.cardType;
	}

	public void setCardType(Short cardType) {
		this.cardType = cardType;
	}

	public String getIdcardNum() {
		return this.idcardNum;
	}

	public void setIdcardNum(String idcardNum) {
		this.idcardNum = idcardNum;
	}

	public Short getHeight() {
		return this.height;
	}

	public void setHeight(Short height) {
		this.height = height;
	}

	public Short getMaritalStatus() {
		return this.maritalStatus;
	}

	public void setMaritalStatus(Short maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getHometown() {
		return this.hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSelfDescription() {
		return this.selfDescription;
	}

	public void setSelfDescription(String selfDescription) {
		this.selfDescription = selfDescription;
	}

	public Short getDegreeId() {
		return this.degreeId;
	}

	public void setDegreeId(Short degreeId) {
		this.degreeId = degreeId;
	}

	public String getDegreeScript() {
		return this.degreeScript;
	}

	public void setDegreeScript(String degreeScript) {
		this.degreeScript = degreeScript;
	}

	public String getRelationPhone() {
		return this.relationPhone;
	}

	public void setRelationPhone(String relationPhone) {
		this.relationPhone = relationPhone;
	}

	public String getMobileNum() {
		return this.mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getBpnumber() {
		return this.bpnumber;
	}

	public void setBpnumber(String bpnumber) {
		this.bpnumber = bpnumber;
	}

	public String getImnum() {
		return this.imnum;
	}

	public void setImnum(String imnum) {
		this.imnum = imnum;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomepage() {
		return this.homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getTechTitle() {
		return this.techTitle;
	}

	public void setTechTitle(String techTitle) {
		this.techTitle = techTitle;
	}

	public Short getComputerLevel() {
		return this.computerLevel;
	}

	public void setComputerLevel(Short computerLevel) {
		this.computerLevel = computerLevel;
	}

	public String getComputerSkills() {
		return this.computerSkills;
	}

	public void setComputerSkills(String computerSkills) {
		this.computerSkills = computerSkills;
	}

	public Integer getToefl() {
		return this.toefl;
	}

	public void setToefl(Integer toefl) {
		this.toefl = toefl;
	}

	public Integer getJapanLevel() {
		return this.japanLevel;
	}

	public void setJapanLevel(Integer japanLevel) {
		this.japanLevel = japanLevel;
	}

	public Integer getEngLevel() {
		return this.engLevel;
	}

	public void setEngLevel(Integer engLevel) {
		this.engLevel = engLevel;
	}

	public Integer getGre() {
		return this.gre;
	}

	public void setGre(Integer gre) {
		this.gre = gre;
	}

	public Integer getGmat() {
		return this.gmat;
	}

	public void setGmat(Integer gmat) {
		this.gmat = gmat;
	}

	public Integer getIelts() {
		return this.ielts;
	}

	public void setIelts(Integer ielts) {
		this.ielts = ielts;
	}

	public Short getFltwoLevel() {
		return this.fltwoLevel;
	}

	public void setFltwoLevel(Short fltwoLevel) {
		this.fltwoLevel = fltwoLevel;
	}

	public String getFlother() {
		return this.flother;
	}

	public void setFlother(String flother) {
		this.flother = flother;
	}

	public String getOtherSkills() {
		return this.otherSkills;
	}

	public void setOtherSkills(String otherSkills) {
		this.otherSkills = otherSkills;
	}

	public String getInteresting() {
		return this.interesting;
	}

	public void setInteresting(String interesting) {
		this.interesting = interesting;
	}

	public String getWorkExprienceGr() {
		return this.workExprienceGr;
	}

	public void setWorkExprienceGr(String workExprienceGr) {
		this.workExprienceGr = workExprienceGr;
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

	public String getJobSeeking1() {
		return this.jobSeeking1;
	}

	public void setJobSeeking1(String jobSeeking1) {
		this.jobSeeking1 = jobSeeking1;
	}

	public String getJobSeeking2() {
		return this.jobSeeking2;
	}

	public void setJobSeeking2(String jobSeeking2) {
		this.jobSeeking2 = jobSeeking2;
	}

	public String getJobSeeking3() {
		return this.jobSeeking3;
	}

	public void setJobSeeking3(String jobSeeking3) {
		this.jobSeeking3 = jobSeeking3;
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

	public Integer getSalary() {
		return this.salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Boolean getSalaryNegotiable() {
		return this.salaryNegotiable;
	}

	public void setSalaryNegotiable(Boolean salaryNegotiable) {
		this.salaryNegotiable = salaryNegotiable;
	}

	public Boolean getHouseNeeded() {
		return this.houseNeeded;
	}

	public void setHouseNeeded(Boolean houseNeeded) {
		this.houseNeeded = houseNeeded;
	}

	public String getCheckinDate() {
		return this.checkinDate;
	}

	public void setCheckinDate(String checkinDate) {
		this.checkinDate = checkinDate;
	}

	public String getOtherRequirement() {
		return this.otherRequirement;
	}

	public void setOtherRequirement(String otherRequirement) {
		this.otherRequirement = otherRequirement;
	}

	public String getCareerDirection() {
		return this.careerDirection;
	}

	public void setCareerDirection(String careerDirection) {
		this.careerDirection = careerDirection;
	}

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Short getWorkedComNumber() {
		return this.workedComNumber;
	}

	public void setWorkedComNumber(Short workedComNumber) {
		this.workedComNumber = workedComNumber;
	}

	public Short getWorkedYear() {
		return this.workedYear;
	}

	public void setWorkedYear(Short workedYear) {
		this.workedYear = workedYear;
	}

	public Short getWorkedMonth() {
		return this.workedMonth;
	}

	public void setWorkedMonth(Short workedMonth) {
		this.workedMonth = workedMonth;
	}

	public Timestamp getRegisterDate() {
		return this.registerDate;
	}

	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}

	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public Short getCheckFlag() {
		return this.checkFlag;
	}

	public void setCheckFlag(Short checkFlag) {
		this.checkFlag = checkFlag;
	}

}