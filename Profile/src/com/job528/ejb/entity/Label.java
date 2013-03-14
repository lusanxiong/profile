package com.job528.ejb.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name = "Label")
public class Label implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String labelName;
	private int labelSort;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	private Integer labelSource;
	private Integer isDisplay;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	public int getLabelSort() {
		return labelSort;
	}

	public void setLabelSort(int labelSort) {
		this.labelSort = labelSort;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getLabelSource() {
		return labelSource;
	}

	public void setLabelSource(Integer labelSource) {
		this.labelSource = labelSource;
	}

	public Integer getIsDisplay() {
		return isDisplay;
	}

	public void setIsDisplay(Integer isDisplay) {
		this.isDisplay = isDisplay;
	}

}
