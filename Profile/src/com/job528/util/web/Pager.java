package com.job528.util.web;


public class Pager{

	/**
	 * 每页多少条记录
	 */
	private int pageSize = 20;

	/**
	 * 当前页
	 */
	private int pageIndex = 1;
	
	
	/**
	 * 总页数
	 */
	private int dataCount = 0;
	
	
	
	
	

	public int getDataCount() {
		return dataCount;
	}

	public void setDataCount(int dataCount) {
		this.dataCount = dataCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if(pageSize <= 0)
			this.pageSize = 20;
		else
		    this.pageSize = pageSize;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		if(pageIndex <= 0)
			this.pageIndex = 1;
		else
		    this.pageIndex = pageIndex;
	}

	public int getTotalIndex() {
		if(this.pageSize > this.dataCount){
			this.pageSize = this.dataCount;
		}
		//获取总页数。
		return this.dataCount%pageSize==0?this.dataCount/pageSize:this.dataCount/pageSize+1;
	}

	public int getStartIndex(){
		return pageSize*(pageIndex-1);
	}
	
	public boolean getHasNextPage(){
		return pageIndex < getTotalIndex();
	}
}
