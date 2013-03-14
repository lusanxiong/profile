package com.job528.profile.model;

import java.sql.Timestamp;

/**
 * MemPosition entity. @author MyEclipse Persistence Tools
 */

public class MemPosition implements java.io.Serializable {

	// Fields

	private Integer posId;
	private Integer memId;
	private Integer jobFunction1;
	private Integer jobFunction2;
	private Integer jobFunction3;
	private String posName;
	private Integer calling;
	private Integer deptId;
	private Integer candidatesNum;
	private Timestamp endValidDate;
	private String jobLocation;
	private String posDescription;
	private Integer salary;
	private Integer salary1;
	private Integer reqDegreeId;
	private Short reqWorkyear;
	private Short reqSex;
	private Short reqAge1;
	private Short reqAge2;
	private String reqLocation;
	private String examNotice;
	private String examAddress;
	private Integer examPaperId;
	private Integer fltDegreeId;
	private Integer fltWorkyear;
	private String contactPerson;
	private String contactTelZ;
	private String contactTel;
	private String contactTelE;
	private Boolean telShowFlag;
	private String contactFaxZ;
	private String contactFax;
	private String contactFaxE;
	private Boolean faxShowFlag;
	private String email;
	private Boolean emailShowFlag;
	private Boolean emailCodeFlag;
	private Boolean emailAttachFile;
	private String addressP;
	private String address;
	private String zipCode;
	private Short posState;
	private Timestamp registerDate;
	private Timestamp postDate;
	private Integer hitCounter;
	private Short registerBy;
	private Timestamp updateDate;
	private Integer postFlag;
	private Integer sortIndex;
	private Integer autoBack;
	private Integer modelId;
	private Integer applyNum;

	// Constructors

	/** default constructor */
	public MemPosition() {
	}

	/** minimal constructor */
	public MemPosition(Integer posId, Integer memId, String posName,
			Integer candidatesNum, Timestamp endValidDate, String jobLocation,
			String posDescription, Integer salary, Integer salary1,
			Integer reqDegreeId, Short reqWorkyear, Short reqSex,
			String reqLocation, Integer examPaperId, Integer fltDegreeId,
			Integer fltWorkyear, Boolean telShowFlag, Boolean faxShowFlag,
			Boolean emailShowFlag, Boolean emailCodeFlag,
			Boolean emailAttachFile, String addressP, Short posState,
			Timestamp registerDate, Timestamp postDate, Integer hitCounter,
			Short registerBy, Timestamp updateDate) {
		this.posId = posId;
		this.memId = memId;
		this.posName = posName;
		this.candidatesNum = candidatesNum;
		this.endValidDate = endValidDate;
		this.jobLocation = jobLocation;
		this.posDescription = posDescription;
		this.salary = salary;
		this.salary1 = salary1;
		this.reqDegreeId = reqDegreeId;
		this.reqWorkyear = reqWorkyear;
		this.reqSex = reqSex;
		this.reqLocation = reqLocation;
		this.examPaperId = examPaperId;
		this.fltDegreeId = fltDegreeId;
		this.fltWorkyear = fltWorkyear;
		this.telShowFlag = telShowFlag;
		this.faxShowFlag = faxShowFlag;
		this.emailShowFlag = emailShowFlag;
		this.emailCodeFlag = emailCodeFlag;
		this.emailAttachFile = emailAttachFile;
		this.addressP = addressP;
		this.posState = posState;
		this.registerDate = registerDate;
		this.postDate = postDate;
		this.hitCounter = hitCounter;
		this.registerBy = registerBy;
		this.updateDate = updateDate;
	}

	/** full constructor */
	public MemPosition(Integer posId, Integer memId, Integer jobFunction1,
			Integer jobFunction2, Integer jobFunction3, String posName,
			Integer calling, Integer deptId, Integer candidatesNum,
			Timestamp endValidDate, String jobLocation, String posDescription,
			Integer salary, Integer salary1, Integer reqDegreeId,
			Short reqWorkyear, Short reqSex, Short reqAge1, Short reqAge2,
			String reqLocation, String examNotice, String examAddress,
			Integer examPaperId, Integer fltDegreeId, Integer fltWorkyear,
			String contactPerson, String contactTelZ, String contactTel,
			String contactTelE, Boolean telShowFlag, String contactFaxZ,
			String contactFax, String contactFaxE, Boolean faxShowFlag,
			String email, Boolean emailShowFlag, Boolean emailCodeFlag,
			Boolean emailAttachFile, String addressP, String address,
			String zipCode, Short posState, Timestamp registerDate,
			Timestamp postDate, Integer hitCounter, Short registerBy,
			Timestamp updateDate, Integer postFlag, Integer sortIndex,
			Integer autoBack, Integer modelId, Integer applyNum) {
		this.posId = posId;
		this.memId = memId;
		this.jobFunction1 = jobFunction1;
		this.jobFunction2 = jobFunction2;
		this.jobFunction3 = jobFunction3;
		this.posName = posName;
		this.calling = calling;
		this.deptId = deptId;
		this.candidatesNum = candidatesNum;
		this.endValidDate = endValidDate;
		this.jobLocation = jobLocation;
		this.posDescription = posDescription;
		this.salary = salary;
		this.salary1 = salary1;
		this.reqDegreeId = reqDegreeId;
		this.reqWorkyear = reqWorkyear;
		this.reqSex = reqSex;
		this.reqAge1 = reqAge1;
		this.reqAge2 = reqAge2;
		this.reqLocation = reqLocation;
		this.examNotice = examNotice;
		this.examAddress = examAddress;
		this.examPaperId = examPaperId;
		this.fltDegreeId = fltDegreeId;
		this.fltWorkyear = fltWorkyear;
		this.contactPerson = contactPerson;
		this.contactTelZ = contactTelZ;
		this.contactTel = contactTel;
		this.contactTelE = contactTelE;
		this.telShowFlag = telShowFlag;
		this.contactFaxZ = contactFaxZ;
		this.contactFax = contactFax;
		this.contactFaxE = contactFaxE;
		this.faxShowFlag = faxShowFlag;
		this.email = email;
		this.emailShowFlag = emailShowFlag;
		this.emailCodeFlag = emailCodeFlag;
		this.emailAttachFile = emailAttachFile;
		this.addressP = addressP;
		this.address = address;
		this.zipCode = zipCode;
		this.posState = posState;
		this.registerDate = registerDate;
		this.postDate = postDate;
		this.hitCounter = hitCounter;
		this.registerBy = registerBy;
		this.updateDate = updateDate;
		this.postFlag = postFlag;
		this.sortIndex = sortIndex;
		this.autoBack = autoBack;
		this.modelId = modelId;
		this.applyNum = applyNum;
	}

	// Property accessors

	public Integer getPosId() {
		return this.posId;
	}

	public void setPosId(Integer posId) {
		this.posId = posId;
	}

	public Integer getMemId() {
		return this.memId;
	}

	public void setMemId(Integer memId) {
		this.memId = memId;
	}

	public Integer getJobFunction1() {
		return this.jobFunction1;
	}

	public void setJobFunction1(Integer jobFunction1) {
		this.jobFunction1 = jobFunction1;
	}

	public Integer getJobFunction2() {
		return this.jobFunction2;
	}

	public void setJobFunction2(Integer jobFunction2) {
		this.jobFunction2 = jobFunction2;
	}

	public Integer getJobFunction3() {
		return this.jobFunction3;
	}

	public void setJobFunction3(Integer jobFunction3) {
		this.jobFunction3 = jobFunction3;
	}

	public String getPosName() {
		return this.posName;
	}

	public void setPosName(String posName) {
		this.posName = posName;
	}

	public Integer getCalling() {
		return this.calling;
	}

	public void setCalling(Integer calling) {
		this.calling = calling;
	}

	public Integer getDeptId() {
		return this.deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getCandidatesNum() {
		return this.candidatesNum;
	}

	public void setCandidatesNum(Integer candidatesNum) {
		this.candidatesNum = candidatesNum;
	}

	public Timestamp getEndValidDate() {
		return this.endValidDate;
	}

	public void setEndValidDate(Timestamp endValidDate) {
		this.endValidDate = endValidDate;
	}

	public String getJobLocation() {
		return this.jobLocation;
	}

	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}

	public String getPosDescription() {
		return this.posDescription;
	}

	public void setPosDescription(String posDescription) {
		this.posDescription = posDescription;
	}

	public Integer getSalary() {
		return this.salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Integer getSalary1() {
		return this.salary1;
	}

	public void setSalary1(Integer salary1) {
		this.salary1 = salary1;
	}

	public Integer getReqDegreeId() {
		return this.reqDegreeId;
	}

	public void setReqDegreeId(Integer reqDegreeId) {
		this.reqDegreeId = reqDegreeId;
	}

	public Short getReqWorkyear() {
		return this.reqWorkyear;
	}

	public void setReqWorkyear(Short reqWorkyear) {
		this.reqWorkyear = reqWorkyear;
	}

	public Short getReqSex() {
		return this.reqSex;
	}

	public void setReqSex(Short reqSex) {
		this.reqSex = reqSex;
	}

	public Short getReqAge1() {
		return this.reqAge1;
	}

	public void setReqAge1(Short reqAge1) {
		this.reqAge1 = reqAge1;
	}

	public Short getReqAge2() {
		return this.reqAge2;
	}

	public void setReqAge2(Short reqAge2) {
		this.reqAge2 = reqAge2;
	}

	public String getReqLocation() {
		return this.reqLocation;
	}

	public void setReqLocation(String reqLocation) {
		this.reqLocation = reqLocation;
	}

	public String getExamNotice() {
		return this.examNotice;
	}

	public void setExamNotice(String examNotice) {
		this.examNotice = examNotice;
	}

	public String getExamAddress() {
		return this.examAddress;
	}

	public void setExamAddress(String examAddress) {
		this.examAddress = examAddress;
	}

	public Integer getExamPaperId() {
		return this.examPaperId;
	}

	public void setExamPaperId(Integer examPaperId) {
		this.examPaperId = examPaperId;
	}

	public Integer getFltDegreeId() {
		return this.fltDegreeId;
	}

	public void setFltDegreeId(Integer fltDegreeId) {
		this.fltDegreeId = fltDegreeId;
	}

	public Integer getFltWorkyear() {
		return this.fltWorkyear;
	}

	public void setFltWorkyear(Integer fltWorkyear) {
		this.fltWorkyear = fltWorkyear;
	}

	public String getContactPerson() {
		return this.contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactTelZ() {
		return this.contactTelZ;
	}

	public void setContactTelZ(String contactTelZ) {
		this.contactTelZ = contactTelZ;
	}

	public String getContactTel() {
		return this.contactTel;
	}

	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}

	public String getContactTelE() {
		return this.contactTelE;
	}

	public void setContactTelE(String contactTelE) {
		this.contactTelE = contactTelE;
	}

	public Boolean getTelShowFlag() {
		return this.telShowFlag;
	}

	public void setTelShowFlag(Boolean telShowFlag) {
		this.telShowFlag = telShowFlag;
	}

	public String getContactFaxZ() {
		return this.contactFaxZ;
	}

	public void setContactFaxZ(String contactFaxZ) {
		this.contactFaxZ = contactFaxZ;
	}

	public String getContactFax() {
		return this.contactFax;
	}

	public void setContactFax(String contactFax) {
		this.contactFax = contactFax;
	}

	public String getContactFaxE() {
		return this.contactFaxE;
	}

	public void setContactFaxE(String contactFaxE) {
		this.contactFaxE = contactFaxE;
	}

	public Boolean getFaxShowFlag() {
		return this.faxShowFlag;
	}

	public void setFaxShowFlag(Boolean faxShowFlag) {
		this.faxShowFlag = faxShowFlag;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEmailShowFlag() {
		return this.emailShowFlag;
	}

	public void setEmailShowFlag(Boolean emailShowFlag) {
		this.emailShowFlag = emailShowFlag;
	}

	public Boolean getEmailCodeFlag() {
		return this.emailCodeFlag;
	}

	public void setEmailCodeFlag(Boolean emailCodeFlag) {
		this.emailCodeFlag = emailCodeFlag;
	}

	public Boolean getEmailAttachFile() {
		return this.emailAttachFile;
	}

	public void setEmailAttachFile(Boolean emailAttachFile) {
		this.emailAttachFile = emailAttachFile;
	}

	public String getAddressP() {
		return this.addressP;
	}

	public void setAddressP(String addressP) {
		this.addressP = addressP;
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

	public Short getPosState() {
		return this.posState;
	}

	public void setPosState(Short posState) {
		this.posState = posState;
	}

	public Timestamp getRegisterDate() {
		return this.registerDate;
	}

	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}

	public Timestamp getPostDate() {
		return this.postDate;
	}

	public void setPostDate(Timestamp postDate) {
		this.postDate = postDate;
	}

	public Integer getHitCounter() {
		return this.hitCounter;
	}

	public void setHitCounter(Integer hitCounter) {
		this.hitCounter = hitCounter;
	}

	public Short getRegisterBy() {
		return this.registerBy;
	}

	public void setRegisterBy(Short registerBy) {
		this.registerBy = registerBy;
	}

	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getPostFlag() {
		return this.postFlag;
	}

	public void setPostFlag(Integer postFlag) {
		this.postFlag = postFlag;
	}

	public Integer getSortIndex() {
		return this.sortIndex;
	}

	public void setSortIndex(Integer sortIndex) {
		this.sortIndex = sortIndex;
	}

	public Integer getAutoBack() {
		return this.autoBack;
	}

	public void setAutoBack(Integer autoBack) {
		this.autoBack = autoBack;
	}

	public Integer getModelId() {
		return this.modelId;
	}

	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}

	public Integer getApplyNum() {
		return this.applyNum;
	}

	public void setApplyNum(Integer applyNum) {
		this.applyNum = applyNum;
	}

}