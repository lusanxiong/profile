package com.job528.sina.weibo;

import com.job528.profile.vo.WeiboOauthDTO;

import weibo4j.Oauth;
import weibo4j.http.AccessToken;
import weibo4j.model.WeiboException;

/**     
 * 新浪微博Oauth2授权流程操作
 * 
 * 1、引导需要授权的用户到用户授权地址：
 *    https://api.weibo.com/oauth2/authorize?client_id=YOUR_CLIENT_ID&response_type=code&redirect_uri=YOUR_REGISTERED_REDIRECT_URI

 * 2、如果用户同意授权,页面跳转至 YOUR_REGISTERED_REDIRECT_URI/?code=CODE 
 *    
 * 3、 换取Access Token 
 *    https://api.weibo.com/oauth2/access_token?client_id=YOUR_CLIENT_ID&client_secret=YOUR_CLIENT_SECRET&grant_type=authorization_code&redirect_uri=YOUR_REGISTERED_REDIRECT_URI&code=CODE
 *    
 * 4、返回值 
 *    { "access_token":"SlAV32hkKG", "expires_in":3600 } 
 * 
 * @author sanxionglu
 *
 */
public class Oauth2 {
	
	
	/*
	 * 第一步：获取引导需要授权的用户到用户授权地址
	 *
	 * 请求方式支持GET/POST
	 */
	public static String getAuthorizationURL() throws WeiboException{
		Oauth oauth = new Oauth();
		String url = oauth.authorize("code");
		url = url != null ? url : "";
		
		//url = URLEncodeUtils.encodeURL(url);
		return url;
	}
	
	/*
	 * 第三步：在回调页重新发送请求，换取AccessToken
	 * 调用的是Oauth2.0 JAVA SDK 中的API
	 */
	public static WeiboOauthDTO getAccessTokenByCode(String code) {
		Oauth oauth = new Oauth();
		
		AccessToken at = null;
		try {
			at = oauth.getAccessTokenByCode(code);
		} catch (WeiboException e) {
			e.printStackTrace();
			OauthLog.logError("获取AccessToken出错!参数:code="+code, e);
		}
		
		if(at == null) 
			return new WeiboOauthDTO();
		
		//获取新浪UserID
		String sinaUserId = SinaAccount.getUid(at.getAccessToken());
		
		WeiboOauthDTO w = new WeiboOauthDTO();
		w.setAccessToken(at.getAccessToken());
		w.setSinaUserId(sinaUserId);
		w.setExpireIn(at.getExpireIn());
	 
		return w;
	}
	
	public static void main(String[] args) {
		getAccessTokenByCode("bcb99a3a24a603a9f611232bb97c5785");
		
	}
}
