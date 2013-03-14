package com.job528.util;

import java.util.List;

/**
 * 通用分页类
 * 泛型，任意对象
 */
@SuppressWarnings("unused")
public class Pager<T> {
	private int pageSize = 1;		// 每页多少条
	private int pageNo = 1; 		// 第几页
	private int totalSize = 0;	// 总的记录数
	
	
	private List<T> list = null;	// 当前页的记录数
	
	public Pager() {
	}
	
	public Pager(int pageNo, int pageSize) {
		super();
		this.pageSize = pageSize;
		this.pageNo = pageNo;
	}


	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		if (this.pageNo > this.getTotalPages()) {
			this.pageNo = this.getTotalPages(); // 如果当前页大于最大页数，则等于最大页数
		}
		if(this.pageNo <= 0)
			this.pageNo = 1;
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		if (pageNo < 1) {
			this.pageNo = 1;
		} else {
			this.pageNo = pageNo;
		}
	}

	public int getTotalPages() {

		if(this.totalSize <= 0)
			return 0;
		if(this.pageSize >= this.totalSize)
			return 1;
		return  this.totalSize % this.pageSize == 0 ? (this.totalSize / this.pageSize) : (this.totalSize / this.pageSize + 1);
	}

	public boolean getHasNext(){
		if(this.pageNo < getTotalPages())
			return true;
		return false;
	}

	
	

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public List<T> getList() {
		if (null == list || list.size() < 1) {
			return null;
		} else {
			return list;
		}
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public String getPagerString(){
		int tatolPage = this.getTotalPages();
		if(tatolPage <= 1)
			return "";	
		
		int start = this.getPageNo() - 5 > 0 ? this.getPageNo() - 5 : 1;
		int end = (this.getPageNo() + 5) + ((5 - this.getPageNo()) > 0 ? 5 - this.getPageNo() : 0);
		end = end >= tatolPage  ? tatolPage : end;

		StringBuilder str = new StringBuilder();
		
		for(int i = start; i <= end; i++){
			if(i == this.getPageNo()){
				//当前页
				str.append("<span class=\"numbers\">").append(i).append("</span>");
			}else{
			    str.append("<span class=\"number\"><a href=\"javascript:void(0);\" onclick=\"goPage(").append(i).append(")\" >").append(i).append("</a></span>");
			}
		}
		return str.toString();
	}
	
	public static void main(String args[]){
		System.out.print(10/10);
		
		System.out.print(12/10);
		
	}
}
