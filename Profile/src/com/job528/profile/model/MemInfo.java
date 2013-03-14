package com.job528.profile.model;

import java.sql.Timestamp;

/**
 * MemInfo entity. @author MyEclipse Persistence Tools
 */

public class MemInfo implements java.io.Serializable {

	// Fields

	private Integer memId;
	private String memName;
	private String licenceNum;
	private Integer calling;
	private Integer properity;
	private Timestamp foundDate;
	private Integer registerFund;
	private Short currency;
	private Integer employeeNumber;
	private String memIntroduction;
	private String contactPerson;
	private String contactTelZ;
	private String contactTel;
	private String contactTelE;
	private Boolean telshowFlag;
	private String contactFaxZ;
	private String contactFax;
	private String contactFaxE;
	private Boolean faxShowFlag;
	private String email;
	private Boolean emailShowFlag;
	private String addressP;
	private String address;
	private String zipCode;
	private String homePage;
	private Boolean mailCode;
	private Boolean newsLetter;
	private String logoFileName;
	private Timestamp logoUpdateDate;
	private Boolean logoShowFlag;
	private Timestamp registerDate;
	private Timestamp updateDate;
	private Short registerby;
	private Integer updateFlag;

	// Constructors

	/** default constructor */
	public MemInfo() {
	}

	/** minimal constructor */
	public MemInfo(Integer memId, String memName, Integer calling,
			Integer properity, Timestamp foundDate, Integer registerFund,
			Short currency, Integer employeeNumber, Boolean telshowFlag,
			Boolean faxShowFlag, String email, Boolean emailShowFlag,
			String addressP, Boolean mailCode, Boolean newsLetter,
			String logoFileName, Boolean logoShowFlag, Timestamp registerDate,
			Timestamp updateDate, Short registerby) {
		this.memId = memId;
		this.memName = memName;
		this.calling = calling;
		this.properity = properity;
		this.foundDate = foundDate;
		this.registerFund = registerFund;
		this.currency = currency;
		this.employeeNumber = employeeNumber;
		this.telshowFlag = telshowFlag;
		this.faxShowFlag = faxShowFlag;
		this.email = email;
		this.emailShowFlag = emailShowFlag;
		this.addressP = addressP;
		this.mailCode = mailCode;
		this.newsLetter = newsLetter;
		this.logoFileName = logoFileName;
		this.logoShowFlag = logoShowFlag;
		this.registerDate = registerDate;
		this.updateDate = updateDate;
		this.registerby = registerby;
	}

	/** full constructor */
	public MemInfo(Integer memId, String memName, String licenceNum,
			Integer calling, Integer properity, Timestamp foundDate,
			Integer registerFund, Short currency, Integer employeeNumber,
			String memIntroduction, String contactPerson, String contactTelZ,
			String contactTel, String contactTelE, Boolean telshowFlag,
			String contactFaxZ, String contactFax, String contactFaxE,
			Boolean faxShowFlag, String email, Boolean emailShowFlag,
			String addressP, String address, String zipCode, String homePage,
			Boolean mailCode, Boolean newsLetter, String logoFileName,
			Timestamp logoUpdateDate, Boolean logoShowFlag,
			Timestamp registerDate, Timestamp updateDate, Short registerby,
			Integer updateFlag) {
		this.memId = memId;
		this.memName = memName;
		this.licenceNum = licenceNum;
		this.calling = calling;
		this.properity = properity;
		this.foundDate = foundDate;
		this.registerFund = registerFund;
		this.currency = currency;
		this.employeeNumber = employeeNumber;
		this.memIntroduction = memIntroduction;
		this.contactPerson = contactPerson;
		this.contactTelZ = contactTelZ;
		this.contactTel = contactTel;
		this.contactTelE = contactTelE;
		this.telshowFlag = telshowFlag;
		this.contactFaxZ = contactFaxZ;
		this.contactFax = contactFax;
		this.contactFaxE = contactFaxE;
		this.faxShowFlag = faxShowFlag;
		this.email = email;
		this.emailShowFlag = emailShowFlag;
		this.addressP = addressP;
		this.address = address;
		this.zipCode = zipCode;
		this.homePage = homePage;
		this.mailCode = mailCode;
		this.newsLetter = newsLetter;
		this.logoFileName = logoFileName;
		this.logoUpdateDate = logoUpdateDate;
		this.logoShowFlag = logoShowFlag;
		this.registerDate = registerDate;
		this.updateDate = updateDate;
		this.registerby = registerby;
		this.updateFlag = updateFlag;
	}

	// Property accessors

	public Integer getMemId() {
		return this.memId;
	}

	public void setMemId(Integer memId) {
		this.memId = memId;
	}

	public String getMemName() {
		return this.memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getLicenceNum() {
		return this.licenceNum;
	}

	public void setLicenceNum(String licenceNum) {
		this.licenceNum = licenceNum;
	}

	public Integer getCalling() {
		return this.calling;
	}

	public void setCalling(Integer calling) {
		this.calling = calling;
	}

	public Integer getProperity() {
		return this.properity;
	}

	public void setProperity(Integer properity) {
		this.properity = properity;
	}

	public Timestamp getFoundDate() {
		return this.foundDate;
	}

	public void setFoundDate(Timestamp foundDate) {
		this.foundDate = foundDate;
	}

	public Integer getRegisterFund() {
		return this.registerFund;
	}

	public void setRegisterFund(Integer registerFund) {
		this.registerFund = registerFund;
	}

	public Short getCurrency() {
		return this.currency;
	}

	public void setCurrency(Short currency) {
		this.currency = currency;
	}

	public Integer getEmployeeNumber() {
		return this.employeeNumber;
	}

	public void setEmployeeNumber(Integer employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getMemIntroduction() {
		return this.memIntroduction;
	}

	public void setMemIntroduction(String memIntroduction) {
		this.memIntroduction = memIntroduction;
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

	public Boolean getTelshowFlag() {
		return this.telshowFlag;
	}

	public void setTelshowFlag(Boolean telshowFlag) {
		this.telshowFlag = telshowFlag;
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

	public String getHomePage() {
		return this.homePage;
	}

	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}

	public Boolean getMailCode() {
		return this.mailCode;
	}

	public void setMailCode(Boolean mailCode) {
		this.mailCode = mailCode;
	}

	public Boolean getNewsLetter() {
		return this.newsLetter;
	}

	public void setNewsLetter(Boolean newsLetter) {
		this.newsLetter = newsLetter;
	}

	public String getLogoFileName() {
		return this.logoFileName;
	}

	public void setLogoFileName(String logoFileName) {
		this.logoFileName = logoFileName;
	}

	public Timestamp getLogoUpdateDate() {
		return this.logoUpdateDate;
	}

	public void setLogoUpdateDate(Timestamp logoUpdateDate) {
		this.logoUpdateDate = logoUpdateDate;
	}

	public Boolean getLogoShowFlag() {
		return this.logoShowFlag;
	}

	public void setLogoShowFlag(Boolean logoShowFlag) {
		this.logoShowFlag = logoShowFlag;
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

	public Short getRegisterby() {
		return this.registerby;
	}

	public void setRegisterby(Short registerby) {
		this.registerby = registerby;
	}

	public Integer getUpdateFlag() {
		return this.updateFlag;
	}

	public void setUpdateFlag(Integer updateFlag) {
		this.updateFlag = updateFlag;
	}

}