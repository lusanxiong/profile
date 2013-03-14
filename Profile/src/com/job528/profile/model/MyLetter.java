package com.job528.profile.model;

/**
 * MyLetter entity. @author MyEclipse Persistence Tools
 */

public class MyLetter implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer myUserId;
	private Short chChoose;
	private String chLetter1;
	private String chLetter2;
	private String chLetter3;

	// Constructors

	/** default constructor */
	public MyLetter() {
	}

	/** full constructor */
	public MyLetter(Integer id, Integer myUserId, Short chChoose,
			String chLetter1, String chLetter2, String chLetter3) {
		this.id = id;
		this.myUserId = myUserId;
		this.chChoose = chChoose;
		this.chLetter1 = chLetter1;
		this.chLetter2 = chLetter2;
		this.chLetter3 = chLetter3;
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

	public Short getChChoose() {
		return this.chChoose;
	}

	public void setChChoose(Short chChoose) {
		this.chChoose = chChoose;
	}

	public String getChLetter1() {
		return this.chLetter1;
	}

	public void setChLetter1(String chLetter1) {
		this.chLetter1 = chLetter1;
	}

	public String getChLetter2() {
		return this.chLetter2;
	}

	public void setChLetter2(String chLetter2) {
		this.chLetter2 = chLetter2;
	}

	public String getChLetter3() {
		return this.chLetter3;
	}

	public void setChLetter3(String chLetter3) {
		this.chLetter3 = chLetter3;
	}

}