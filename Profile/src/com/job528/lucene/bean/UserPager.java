package com.job528.lucene.bean;

import java.util.List;

public class UserPager {
	
	private int pageSize = 10;		// 每页多少条
	private int pageNo = 1; 		// 第几页
	private int totalPages = 10;	// 总的页数
	private int totalSize = 100;	// 总的记录数
	
	private List<UserInfo> userInfo = null;	// 当前页的记录数

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	

	
	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public List<UserInfo> getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(List<UserInfo> userInfo) {
		this.userInfo = userInfo;
	}

}
