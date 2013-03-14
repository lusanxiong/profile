package com.job528.ejb.entity;

import java.io.Serializable;

/**
 *@author tanggh
 */
public class LabelResult implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer resultCode;
	private Integer labelId;
	
	public Integer getResultCode() {
		return resultCode;
	}
	public void setResultCode(Integer resultCode) {
		this.resultCode = resultCode;
	}
	public Integer getLabelId() {
		return labelId;
	}
	public void setLabelId(Integer labelId) {
		this.labelId = labelId;
	}
}
