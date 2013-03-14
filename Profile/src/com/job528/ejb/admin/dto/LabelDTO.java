package com.job528.ejb.admin.dto;

import java.util.Date;


public class LabelDTO {
	private int id;
	private String labelName;
	private Integer labelSort;
	private Date createDate;
	private Integer labelSource;
	private String labelSourceName;
	private Integer isDisplay;
	private String isDisplayName;
	
	
	public String getLabelSourceName() {
		return labelSourceName;
	}

	public void setLabelSourceName(String labelSourceName) {
		this.labelSourceName = labelSourceName;
	}

	public String getIsDisplayName() {
		return isDisplayName;
	}

	public void setIsDisplayName(String isDisplayName) {
		this.isDisplayName = isDisplayName;
	}

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

	public Integer getLabelSort() {
		return labelSort;
	}

	public void setLabelSort(Integer labelSort) {
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
