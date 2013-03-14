package com.job528.util.email;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.mail.NoSuchProviderException;
import javax.mail.Session;

import org.apache.log4j.Logger;
import org.jdom.Element;
import org.jdom.JDOMException;

import com.job528.util.StringUtil;
import com.job528.util.XMLUtils;
import com.sun.swing.internal.plaf.synth.resources.synth;


/**
 * 邮件配置信息
 * @author sunday
 *
 */
public class MailConfig {
	private final static Logger log = Logger.getLogger(MailConfig.class);
	private static MailConfig mailConfig;
	
	private String senderName; //发件人
	private String serverName ; //邮件服务器
	private String serverEmail ; //验证邮箱地址
	private String serverEmailPwd ; //验证邮箱密码
	private String contentType ; //邮件编码格式
	private static boolean isInitComplete = false; //mailConfig 是否初始化完成
	


	private MailConfig(){
	}
	
	public synchronized static MailConfig getInstance(){
		if(null == mailConfig){
			init();
		}
		return mailConfig;
	}
	
	
	/**
	 * 初始化mail-config.xml文件中的信息到MailConfig
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private synchronized static void init(){
		if(isInitComplete) {
			return ;
		}
		
		mailConfig = new MailConfig();
//		XMLManager m= new XMLManager();
		try {
			String configPath = StringUtil.getWebRootFilePath(StringUtil.class)+"classes/mail-config.xml";
			System.out.println("configPsfsfs:"+configPath);
			Element root = XMLUtils.getRootElement(configPath);
			List<Element> list =  root.getChildren();
			if(null != list && list.size()>0){
				Element mail = list.get(0);  //只读取第一节点
				mailConfig.setServerName(mail.getChild("serverName").getText().trim());
				mailConfig.setServerEmail(mail.getChild("serverEmail").getText().trim());
				mailConfig.setServerEmailPwd(mail.getChild("serverEmailPwd").getText().trim());
				mailConfig.setSenderName(mail.getChild("senderName").getText().trim());
				mailConfig.setContentType(mail.getChild("contentType").getText().trim());
			}
		} catch (JDOMException e1) {
			log.error("读取邮件配置JDOMException："+e1.getMessage());
			e1.printStackTrace();
		} catch (IOException e1) {
			log.error("读取邮件配置IOException："+e1.getMessage());
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		isInitComplete = true; //初始化完成
	}
	
	
	public synchronized boolean getMailConfigInitStatus() {
		return isInitComplete;
	}
	
	
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	public String getServerEmail() {
		return serverEmail;
	}
	public void setServerEmail(String serverEmail) {
		this.serverEmail = serverEmail;
	}
	public String getServerEmailPwd() {
		return serverEmailPwd;
	}
	public void setServerEmailPwd(String serverEmailPwd) {
		this.serverEmailPwd = serverEmailPwd;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	
}
