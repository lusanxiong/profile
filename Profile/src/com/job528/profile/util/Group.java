package com.job528.profile.util;


public enum Group {
	
	/**
	 * 无分组, 0
	 */
	ALL("全部", 0),
	
	/**
	 * 同行, 1
	 */
	Peer("同行", 1),
	/**
	 * 同事, 2
	 */
	Colleague("同事", 2),
	
	/**
	 * 同乡, 3
	 */
	Fellow("同乡", 3),
	/**
	 * 同学, 4
	 */
	Classmate("同学", 4),
	/**
	 * 其他
	 */
	Other("其他", 5),
	
	/**
	 * 其他
	 */
	NO("未分组", 9);

	
	

	private String groupName;
	private int groupId;
	
	private Group(String groupName, int groupId) {
		this.groupId = groupId;
		this.groupName = groupName;
	}

	

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String toString(){
		return this.groupName;
	}
	
	
	public static Group getGroupById(int groupId) {
		switch (groupId) {
		case 0:
			return Group.ALL;
		case 1:
			return Group.Peer;
		case 2:
			return Group.Colleague;
		case 3:
			return Group.Fellow;
		case 4:
			return Group.Classmate;
		case 5:
			return Group.Other;
		case 9:
		default:
			return Group.NO;
		}
	}
}