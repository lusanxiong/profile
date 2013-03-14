package com.job528.sina.weibo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.job528.util.StringUtil;

import weibo4j.Weibo;
import weibo4j.http.Response;
import weibo4j.model.PostParameter;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONException;
import weibo4j.org.json.JSONObject;
import weibo4j.util.WeiboConfig;

/**
 * 
 * 调用新浪微薄接口类
 */
public class SinaWeibo implements Callable<String>{
	private String access_token;
	private String status;
	
	/**
	 * Oauth2.0授权之后，调用新浪微博接口，发送一条新微博
	 * 
	 * @return idstr :字符串型微博ID 
	 * @param  access_token:访问令牌
	 * @param  status:发送的微博内容，不超过140字
	 * 
	 * @see <a href="http://open.weibo.com/wiki/2/statuses/update">account/update</a>
	 */
	public String callSendWeibo() throws WeiboException{
		Weibo weibo = new Weibo();
		
		if(access_token == null || "".equals(access_token))
			return "";
		
		if(status == null || "".equals(status))
			return "";
		
		int len = StringUtil.getChineseLength(status);
		if(len > 140) {
			return "";
		}
		
		//post 方式请求参数
		PostParameter[] postParam = new PostParameter[]{
				new PostParameter("access_token", access_token),
				new PostParameter("status",status)
		};
		
		//接口URL
		String url = WeiboConfig.getValue("baseURL")+"statuses/update.json";
		JSONObject json = null;
		try {
			weibo.setToken(access_token);
			Response resp = Weibo.client.post(url,postParam, true);
			json = resp.asJSONObject();
		} catch (WeiboException e) {
			e.printStackTrace();
			OauthLog.logError("向新浪发送微博失败!", e);
			throw new WeiboException(e.getError());
		}
		
		String idstr = "";
		try {
			idstr = json.getString("idstr");  //字符串型微博ID 
		} catch (JSONException e) {
			e.printStackTrace();
			OauthLog.logError("获取新浪微博ID fauilre!", e);
		}
		
		return (idstr = idstr != null ? idstr : "");
	}
	
	/*
	 * 统计微博字数
	 * 其中汉字算一个字数,英文2个字母算一个字数.
	 */
	public static int statictisWeiboLength(String text) {
         String Reg = "^[\u4e00-\u9fa5]{1}$";//匹配中文正则表达试
         int result=0;
         int result_num = 0;
         for(int i=0;i<text.length();i++){
	          String b = Character.toString(text.charAt(i));
	          if( b.matches(Reg) ) {
	        	  result++;
	          }else {
	        	  result_num++;
	          }
         }
         return result+(result_num/2);
	}
	
	
	
	public void sendWeibo() throws Exception{
		ExecutorService es = Executors.newSingleThreadExecutor(); 
		try {
			Future<String> feture = es.submit(this);
			feture.get();//获取结果或者监听异常情况
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
	
	public String getAccess_token() {
		return access_token;
	}


	public void setAccess_token(String accessToken) {
		access_token = accessToken;
	}

	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String call() throws Exception {
		String idStr = callSendWeibo();
		return idStr;
	}
}
