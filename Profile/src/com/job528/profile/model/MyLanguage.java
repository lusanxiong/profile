package com.job528.profile.model;

/**
 * MyLanguage entity. @author MyEclipse Persistence Tools
 */

public class MyLanguage implements java.io.Serializable {

	// Fields

	private Integer languageId;
	private Integer resId;
	private Integer myUserId;
	private Integer languageTyep;
	private Integer mastery;
	private Integer literacy;
	private Integer listenAndSpeak;
	private Integer chEn;

	// Constructors

	/** default constructor */
	public MyLanguage() {
	}

	/** minimal constructor */
	public MyLanguage(Integer languageId, Integer resId, Integer myUserId) {
		this.languageId = languageId;
		this.resId = resId;
		this.myUserId = myUserId;
	}

	/** full constructor */
	public MyLanguage(Integer languageId, Integer resId, Integer myUserId,
			Integer languageTyep, Integer mastery, Integer literacy,
			Integer listenAndSpeak, Integer chEn) {
		this.languageId = languageId;
		this.resId = resId;
		this.myUserId = myUserId;
		this.languageTyep = languageTyep;
		this.mastery = mastery;
		this.literacy = literacy;
		this.listenAndSpeak = listenAndSpeak;
		this.chEn = chEn;
	}

	// Property accessors

	public Integer getLanguageId() {
		return this.languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

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

	public Integer getLanguageTyep() {
		return this.languageTyep;
	}

	public void setLanguageTyep(Integer languageTyep) {
		this.languageTyep = languageTyep;
	}

	public Integer getMastery() {
		return this.mastery;
	}

	public void setMastery(Integer mastery) {
		this.mastery = mastery;
	}

	public Integer getLiteracy() {
		return this.literacy;
	}

	public void setLiteracy(Integer literacy) {
		this.literacy = literacy;
	}

	public Integer getListenAndSpeak() {
		return this.listenAndSpeak;
	}

	public void setListenAndSpeak(Integer listenAndSpeak) {
		this.listenAndSpeak = listenAndSpeak;
	}

	public Integer getChEn() {
		return this.chEn;
	}

	public void setChEn(Integer chEn) {
		this.chEn = chEn;
	}

}