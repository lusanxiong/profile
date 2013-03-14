package com.job528.ejb.entity;

public class Param {

	private Integer pageIndex;
	private Integer pageSize;
	private String table;
	private String field;
	private String queryField;
	private String where;
	private String order;
	
	
	public Integer getPageIndex() {
		return pageIndex==null?1:pageIndex<1?1:pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Integer getPageSize() {
		return pageSize==null?1:pageSize<1?1:pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	public String getField() {
		return field==null?"*":field.trim();
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getQueryField() {
		return queryField==null?getField():queryField;
	}
	public void setQueryField(String queryField) {
		this.queryField = queryField;
	}
	public String getWhere() {
		return where==null?"":where.trim();
	}
	public void setWhere(String where) {
		this.where = where;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}

	
}
