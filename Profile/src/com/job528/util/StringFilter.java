package com.job528.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class StringFilter {
	private final static Logger log = Logger.getLogger(StringFilter.class);
	private static String[] smileArray = { "哦", "微笑", "憨笑", "嘻嘻", "思考", "愤怒", "抓狂", "委屈", "流泪", "使坏", "晕", "汗", "困了", "害羞", "失望", "赞", "暧昧", "得意", "骷髅", "囧", "睡", "调皮", "亲亲", "疑问", "闭嘴", "难过", "无语",
			"奋斗", "鄙视", "猪头"};

	public static String filterSimle(String prefix,String str) {
		if(isEmpty(str)){
			return "";
		}
		for(int i=0;i<smileArray.length;i++){
			str = str.replace("["+smileArray[i]+"]","<img src='"+prefix+(i+1)+".gif' alt='"+smileArray[i]+"'/>");
		}
		return str;
	}
	
	/**
	 * 转义单引号 ' -> \'
	 * @param str
	 * @return String
	 */
	public static String filterSingleMark(String str) {
		if(isEmpty(str)){
			return "";
		}
		return str.replace("'","\\'");
	}

	/**
	 * 过滤@me 提到我 正则匹配数字，字母，下划线，减号，中文
	 * 
	 * @param input
	 * @return
	 */
	public static String filterAtme(String input) {
		// 正则匹配数字，字母，下划线，减号，中文
		/*
		 * if(null != input && !"".equals(input.trim())){ input = input.trim();
		 * String regex = "(@([0-9a-zA-Z\\-_\\u4E00-\\u9FA5\\uF900-\\uFA2D]+))";
		 * returninput.replaceAll(regex,
		 * "<a href='/microblog/otherAction.do?nickName=$2'>$1</a>"); }
		 */
		if (isEmpty(input)) {
			return "";
		}
		String regex = "(@([0-9a-zA-Z\\-_\\u4E00-\\u9FA5\\uF900-\\uFA2D]+))";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input);
		while (m.find()) {
			String atStr = m.group(1);
			String str = m.group(2);
			String repStr = "<a href='/microblog/otherAction.do?nickName=" + urlEncoder(str) + "'>" + atStr + "</a>";
			input = input.replace(atStr, repStr);
		}
		return input;
	}

	/**
	 * 替换String中的URL，匹配必须是以http:// or https:// or ftp:// 开头
	 * 
	 * @param str
	 *            要替换的String
	 * @return 替换后的String
	 */
	final public static String filterURL(String str) {
		if (isEmpty(str)) {
			return "";
		} else {
			String regex = "((http://|https://|ftp://){1}[\\w\\.\\-/:?%&~=|,;#]+)";
			return str.replaceAll(regex, "<a href='$1' title='$1' target='_blank'>http://528.cn/url</a>");
		}
	}

	/**
	 * 编码字符串
	 * 
	 * @param str
	 * @return
	 */
	public static String urlEncoder(String str) {
		if (isEmpty(str)) {
			return "";
		}
		try {
			str = URLEncoder.encode(str, "utf-8");
		} catch (UnsupportedEncodingException e) {
			log.error("urlEncoder 出现异常：" + e.getMessage());
		}
		return str;
	}

	/**
	 * 判断是否为空字符串
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isEmpty(String str) {
		return null == str ? true : "".equals(str.trim()) ? true : false;
	}

	static {

	}
}
