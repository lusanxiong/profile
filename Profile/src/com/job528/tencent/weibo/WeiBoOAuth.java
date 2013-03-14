package com.job528.tencent.weibo;

import com.job528.util.PropertiesConfig;
import com.tencent.weibo.constants.OAuthConstants;
import com.tencent.weibo.oauthv2.OAuthV2;
import com.tencent.weibo.oauthv2.OAuthV2Client;
import com.tencent.weibo.utils.QStrOperate;
public class WeiBoOAuth {
	
	//初始化OAuthV2
	private  static OAuthV2 oAuth = new OAuthV2(PropertiesConfig.getValue("tencentClient_ID").trim(),PropertiesConfig.getValue("tencentClient_SERCRET").trim(),PropertiesConfig.getValue("tencentRedirect_URL").trim());
	
	//重定向到url让用户进行授权
	public  static  String generateAuthorizationURL() {
	        oAuth.setResponseType("code");
	        String queryString = QStrOperate.getQueryString(oAuth.getAuthorizationParamsList());              
	        String url=OAuthConstants.OAUTH_V2_AUTHORIZE_URL + "?"+queryString;	                
	        return url;
	    }


     //获取code 通过code换取accessToken令牌
	public static void getAccessToken(String responseData){
	        if(OAuthV2Client.parseAuthorization(responseData, oAuth)){
	            System.out.println("Parse Authorization Information Successfully");
	        }else{
	            System.out.println("Fail to Parse Authorization Information");
	            return ;
	           
	        }
	        
	        //检查是否正确取得授权码
	        if (oAuth.getStatus() == 2) {
	            System.out.println("Get Authorization Code failed!");
	            return ;
	        }
	        
	       //换取access token
	        oAuth.setGrantType("authorize_code");
	        try {
	            OAuthV2Client.accessToken(oAuth);
	         } catch (Exception e1) {
	             e1.printStackTrace();
	         }
	         //检查是否正确取得access token
	         if (oAuth.getStatus() == 3) {
	              System.out.println("Get Access Token failed!");
	              return ;
	          }
	         
	 }
	 public static String getToken(String responseData){
		   getAccessToken(responseData);
		   return oAuth.getAccessToken();
	 }
	 
	 
	  	
}
