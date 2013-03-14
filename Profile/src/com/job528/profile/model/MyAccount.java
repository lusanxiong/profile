package com.job528.profile.model;

import java.sql.Timestamp;

/**
 * MyAccount entity. @author MyEclipse Persistence Tools
 */

public class MyAccount implements java.io.Serializable {

	// Fields

	private Integer accountId;
	private Integer myUserId;
	private String password;
	private Double balance;
	private Timestamp lastPayDate;
	private Timestamp regDate;

	// Constructors

	/** default constructor */
	public MyAccount() {
	}

	/** minimal constructor */
	public MyAccount(Integer accountId, Integer myUserId, Double balance,
			Timestamp lastPayDate, Timestamp regDate) {
		this.accountId = accountId;
		this.myUserId = myUserId;
		this.balance = balance;
		this.lastPayDate = lastPayDate;
		this.regDate = regDate;
	}

	/** full constructor */
	public MyAccount(Integer accountId, Integer myUserId, String password,
			Double balance, Timestamp lastPayDate, Timestamp regDate) {
		this.accountId = accountId;
		this.myUserId = myUserId;
		this.password = password;
		this.balance = balance;
		this.lastPayDate = lastPayDate;
		this.regDate = regDate;
	}

	// Property accessors

	public Integer getAccountId() {
		return this.accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Integer getMyUserId() {
		return this.myUserId;
	}

	public void setMyUserId(Integer myUserId) {
		this.myUserId = myUserId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getBalance() {
		return this.balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Timestamp getLastPayDate() {
		return this.lastPayDate;
	}

	public void setLastPayDate(Timestamp lastPayDate) {
		this.lastPayDate = lastPayDate;
	}

	public Timestamp getRegDate() {
		return this.regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

}