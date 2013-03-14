package com.job528.util;

/**
 * 上传文件路径配置类
 * @author Sunday
 *
 */
public class Config {

	public static final class image {
		/**
		 * 上微博图片的保存目录
		 */
		public static final String imageDir = "/upload/image/weibo";
		/**
		 * 上传头像的保存目录
		 */
		public static final String headDir = "/upload/image/head";
		/**
		 * 上传图片的大小, 以m为单位
		 */
		public static final Integer size = 5; 
		/**
		 * 微博缩略图尺寸
		 */
		public static final Integer thumbnail=120;
		/**
		 * 头像缩略图尺寸
		 */
		public static final Integer headThumbnail=190;
		/**
		 * 微博中等图尺寸
		 */
		public static final Integer middle = 440;
		/**
		 * 头像剪切尺寸
		 */
		public static final Integer cutSize = 190;
		/**
		 * 头像中等图尺寸 
		 */
		public static final Integer headMiddle = 400;
		
		/**
		 * 默认头像
		 */
		public static final String DEFAULT_HEAD_IMAGE="/images/people.gif";
	}
	
	/**
	 * 微博配置
	 */
	public static final class weibo {
		public static final Integer pageSize = 9;
	}
	
	/**
	 * 评论配置
	 *
	 */
	public static final class comment {
		public static final Integer pageSize = 10;
	}
	
	public static final class message {
		public static final Integer pageSize = 20;
	}
	
	/**
	 * 模板配置
	 */
	public static final class template {
		/**
		 * 邀请模板
		 */
		public static final String invite="/template/invite.html";
		/**
		 * 注册模板
		 */
		public static final String register = "/template/register.html";
		/**
		 * 关注模板
		 */
		public static final String attention = "/template/attention.html";
	}
	
	/**
	 * 图片格式
	 * @author Sunday
	 */
	public static final class format {
		public final static String gif=".gif";
		public final static String png=".png";
		public final static String jpg=".jpg";
		public final static String jpeg=".jpeg";
	}
}
