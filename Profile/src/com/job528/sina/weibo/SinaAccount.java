package com.job528.sina.weibo;

import weibo4j.Account;
import weibo4j.Weibo;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;

/*
 * 新浪微博账户
 */
public class SinaAccount {
	
	/**
	 * 
	 * 获取新浪微博账户 用户ID
	 */
	public static String getUid(String access_token) {
		Weibo weibo = new Weibo();
		
		JSONObject uid = null;
		try {
			weibo.setToken(access_token);
			Account am = new Account();
			uid = am.getUid();
		} catch (WeiboException e) {
			OauthLog.logError("获取新浪用户ID出错，参数accesToken="+access_token, e);
			e.printStackTrace();
		}
		
		String userid = "";
		if(uid != null){
			try {
				userid = uid.getString("uid");
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		
		return userid ; 
	}
	
	public static void main(String[] args) {
		/*String access_token = "2.00PO2vjBcnW4lCc7635a8202c3qD1D";
		String uid = getUid(access_token);
		System.out.println(uid);*/
	}
}
