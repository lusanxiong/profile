package com.job528.profile.vo;


import com.job528.ejb.entity.Friend;
import com.job528.lucene.bean.UserInfo;

/**
 * 
 * @author fanglinpeng
 *
 */
public class Friends {

	private UserInfo userInfo;
	

	private Friend friend;
	
	private RelationShip relationShip;

	private Group group;



	public Friend getFriend() {
		return friend;
	}

	public void setFriend(Friend friend) {
		this.friend = friend;
	}


	public RelationShip getRelationShip() {
		return relationShip;
	}

	public void setRelationShip(RelationShip relationShip) {
		this.relationShip = relationShip;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	
	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	

	/**
	 * 好友关系
	 * 
	 * @author fanglinpeng
	 * 
	 */
	public enum RelationShip {
		/**
		 * 我关注的,1
		 */
		Attention("我关注的",1),

		/**
		 * 关注我的,2
		 */
		BeAttention("关注我的",2),

		/**
		 * 可能认识的(无关系),0
		 */
		May("可能认识的",0);
		
		private String relationShipName;

		private int relationShipId;
		
		private RelationShip(String relationShipName, int relationShipId){
			this.relationShipId = relationShipId;
			this.relationShipName = relationShipName;
		}
		
		public String getRelationShipName() {
			return relationShipName;
		}

		public void setRelationShipName(String relationShipName) {
			this.relationShipName = relationShipName;
		}

		public int getRelationShipId() {
			return relationShipId;
		}

		public void setRelationShipId(int relationShipId) {
			this.relationShipId = relationShipId;
		}
		
		public String toString(){
			return this.relationShipName;
		}
		
		
		public static RelationShip getRelationShipById(int relationShipId) {
			switch (relationShipId) {
			case 0:
				return RelationShip.May;
			case 1:
				return RelationShip.Attention;
			case 2:
				return RelationShip.BeAttention;
			default:
				return RelationShip.May;
			}
		}
	}

	/**
	 * 好友分组
	 * 
	 * @author fanglinpeng
	 * 
	 */
	public enum Group {
		
		/**
		 * 无分组, 0
		 */
		NO("无分组", 0),
		
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
		Other("其他", 5);

		
		

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
			default:
				return Group.NO;
			}
		}
	}
}
