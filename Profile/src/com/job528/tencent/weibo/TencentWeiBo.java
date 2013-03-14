package com.job528.tencent.weibo;

import com.job528.profile.vo.TencentVo;
import com.job528.util.PropertiesConfig;
import com.tencent.weibo.api.TAPI;
import com.tencent.weibo.oauthv2.OAuthV2;


/**
 * 调用腾讯微博的接口
 * @author job
 *
 */
public class TencentWeiBo extends Thread{
	
	private TencentVo tv;
	public TencentWeiBo(TencentVo tv){
		this.tv = tv;
	}
	
    /**
     * 发表一条微博
     * @param accessToken
     * @param openid
     * @param content
     * @param clientIp(以分析用户所在地)
     * @return
     * @throws Exception
     */
	private  void  sendTencentWeiBo(String accessToken,String openId,String contect,String clientIP) throws Exception{
    	String format="json";
    	OAuthV2 oAuth = new OAuthV2(PropertiesConfig.getValue("tencentClient_ID").trim(),PropertiesConfig.getValue("tencentClient_SERCRET").trim(),PropertiesConfig.getValue("tencentRedirect_URL").trim());
		oAuth.setAccessToken(accessToken);
		oAuth.setClientIP(clientIP);
		oAuth.setOpenid(openId);		
		TAPI tapi = new TAPI(oAuth.getOauthVersion());		
		tapi.add(oAuth, format, contect, clientIP);
	}
	
	/**
	 * 发表带图片的微博
	 * @param accessToken
	 * @param openid
	 * @param content
	 * @param clientIp(以分析用户所在地)
	 * @param picpath 可以是本地图片路径 或 网络地址
	 */

	private void sendTencentWeiboPic(String accessToken,String openId,String content,String clientIP,String picpath ) throws Exception{
		String format="json";
    	OAuthV2 oAuth = new OAuthV2(PropertiesConfig.getValue("tencentClient_ID").trim(),PropertiesConfig.getValue("tencentClient_SERCRET").trim(),PropertiesConfig.getValue("tencentRedirect_URL").trim());
		oAuth.setAccessToken(accessToken);
		oAuth.setClientIP(clientIP);
		oAuth.setOpenid(openId);		
		TAPI tapi = new TAPI(oAuth.getOauthVersion());		
		tapi.addPic(oAuth, format, content, clientIP, picpath);
	}
	@Override
	public void run() {
		try {
			sendTencentWeiBo(tv.getAccessToken(),tv.getOpenid(),tv.getContent(),tv.getClientIp());
			//sendTencentWeiboPic(tv.getAccessToken(),tv.getOpenid(),tv.getContent(),tv.getClientIp(),tv.getImagePath());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
