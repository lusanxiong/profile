package com.job528.util.email;

public class Email {
	
	/**
	 * 邮件类型
	 * 
	 */
	public enum MailType {
		RECOMMEND_FRIEND(0), //向站内好友推荐职位 邮件
		RECOMMEND_OUTER_FRIEND(1); //向站外好友推荐职位 邮件
		
		private int type;
		private MailType(int type) {
			this.type = type;
		}
		
		@Override
        public String toString() {
			return String.valueOf(String.valueOf(this.type));
        }
		
	}
	
}
