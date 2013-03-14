package com.job528.common;

/**
 * 公用数据字典类
 * 
 * @author:sanxionglu
 * 
 */
public class DataDictionary {
	/*
	 * 岗位类别
	 */
	public enum JobFunction {
		EMPTY(0); //岗位类别为空,值为0
		
		private int jobFunctionId;
		private JobFunction(int jobFunctionId) {
			this.jobFunctionId = jobFunctionId;
		}
		
		@Override
        public String toString() {
			return String.valueOf(this.jobFunctionId);
        }
	}
	
	/*
	 * 微博同步状态
	 */
	public enum WeiboActive {
		ACTIVE_NO(0), //未同步
		ACTIVE_ING(1), //同步中
		ACTIVE_PAUSE(2); //暂停同步
		
		private int status;
		private WeiboActive(int status) {
			this.status = status;
		}
		
		@Override
		public String toString() {
			return String.valueOf(this.status);
		}
		
		/*
		 * 获取同步状态名称
		 */
		public static String getName(int status) {
			String name = "";
			if(ACTIVE_NO.toString().equals(String.valueOf(status))) {
				name = "未同步";
			}
			
			if(ACTIVE_ING.toString().equals(String.valueOf(status))) {
				name = "同步中";
			}
			
			if(ACTIVE_PAUSE.toString().equals(String.valueOf(status))) {
				name = "暂停中 ";
			}
			
			return name;
		}
		
		/*
		 * 判断输入项是否为同步状态中的一种
		 */
		public boolean isActive(String status) {
			return false;
		}
	}
	
	/*
	 * 微博同步状态
	 */
	public enum WeiboService {
		SINA_WEIBO(1), //新浪微博
		TENCENT_WEIBO(2); //腾讯微博
		
		private int type;
		private WeiboService(int type) {
			this.type = type;
		}
		
		@Override
		public String toString() {
			return String.valueOf(this.type);
		}
		
		/*
		 * 获取微博服务商名称
		 */
		public static String getName(int type) {
			String name = "";
			 
			if(SINA_WEIBO.toString().equals(String.valueOf(type))) {
				name = "新浪微博";
			}
			if(TENCENT_WEIBO.toString().equals(String.valueOf(type))) {
				name = "腾讯微博";
			}
			
			return name;
		}
	}
	
	/*
	 * 好友推荐职位，推荐目标分类
	 */
	public enum RemcommendTargetType {
		FRIEND(0), //推荐目标为站内好友
		OUTER_FRIEND(1); //推荐目标为站外好友
		
		private int targetType;
		private RemcommendTargetType(int targetType) {
			this.targetType = targetType;
		}
		
		@Override
		public String toString() {
			return String.valueOf(this.targetType);
		}
	}
	
	/**
	 * 推荐职位站内信状态
	 */
	public enum RecommendPositionMessageStatus {
		NO_READ(0), //未读
		ALREAD_READ(1), //已读
		IGNORE_READ(2); //忽略信息
		
		private int status;
		private RecommendPositionMessageStatus(int status) {
			this.status = status;
		}
		
		@Override
		public String toString() {
			return String.valueOf(this.status);
		}
	}
	
	/**
	 * httpSession中存放的属性名称
	 */
	public enum SessionAttrName {
		SINA_ACTIVE("weiboActive"), //新浪微博同步状态
		SINA_ACESS_TOKEN("accessToken"), //新浪微博访问令牌
		USERID("userId"), //528用户ID
		SINA_USERID("sinaUserId"),//新浪用户ID
		
		TENCENT_ACTIVE("active"), //腾讯微博同步状态
		TENCENT_ACESS_TOKEN("tencentAccessToken"), //腾讯微博令牌
		TENCENT_OPENID("openid"),//腾讯用户唯一标识
		
		USER_OPEN_HISTORY_URL("userHistoryUrl"),//用户上次访问的路径.
		IS_READ_DATABASE("isReadDatabase");//session中的属性值是否已经从数据库读取。
		
		private String name;
		private SessionAttrName(String name) {
			this.name = name;
		}
		
		@Override
		public String toString() {
			return name;
		}
	}
	
	/**
	 * 系统中内置的好友分类
	 * @param args
	 */
	public enum FriendType {
		FELLOW(3), //老乡3
		OCCUPATION(1), //同行1
		CLASSMATE(4), //同学4
		WORKER(2); //同事2
		
		private int type;
		private FriendType(int type) {
			this.type = type;
		}
		
		@Override
		public String toString() {
			return String.valueOf(type);
		}
		
		public static String getDescription(FriendType type) {
			if(type.toString().equals(FELLOW.toString())) {
				return "我们同乡";
			}
			
			if(type.toString().equals(WORKER.toString())) {
				return "我们同事";
			}
			
			if(type.toString().equals(CLASSMATE.toString())) {
				return "我们同一学校";
			}
			
			if(type.toString().equals(OCCUPATION.toString())) {
				return "我们同行";
			}
			
			return "其它";
		}
		static int FOURR = 4; //排序值
		static int THREE = 3;
		static int SECOND = 2;
		static int ONE = 1;
		
		/**
		 *好友在页面上展示的顺序
		 * @param friendType
		 * @return
		 */
		public static int getFriendTypeSortValue(int friendType) {
			if(friendType == Integer.parseInt(WORKER.toString())) {
				return FOURR;
			}
			
			if(friendType == Integer.parseInt(CLASSMATE.toString())) {
				return THREE;
			}
			
			if(friendType == Integer.parseInt(OCCUPATION.toString())) {
				return SECOND;
			}
			
			if(friendType == Integer.parseInt(FELLOW.toString())) {
				return ONE;
			}
			
			return 0;
		}
	}
	
	/**
	 * 自定义RESULT返回类型
	 * @param args
	 */
	public enum ActionResult {
		JSON_SUCCESS("jsonSuccess"); //返回json格式时
		
		private String name;
		private ActionResult(String name) {
			this.name = name;
		}
		
		@Override
		public String toString() {
			return String.valueOf(name);
		}
		
	 
	}
	
	
}
