package com.job528.invite;

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


/**
 * 邮件配置信息
 * @author sunday
 *
 */
public class MailConfig {
	private final static Logger log = Logger.getLogger(MailConfig.class);
	private static MailConfig mailConfig;
	private Session sendMailSession ;
	private String senderName; //发件人
	private String serverName ; //邮件服务器
	private String serverEmail ; //验证邮箱地址
	private String serverEmailPwd ; //验证邮箱密码
	private String contentType ; //邮件编码格式
	


	private MailConfig(){
	}
	
	public static MailConfig getInstance(){
		if(null == mailConfig){
			mailConfig = init();
		}
		return mailConfig;
	}
	
	
	/**
	 * 初始化mail-config.xml文件中的信息到MailConfig
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static MailConfig init(){
		mailConfig = new MailConfig();
//		XMLManager m= new XMLManager();
		try {
			String configPath = StringUtil.getWebRootFilePath(StringUtil.class)+"classes/mail-config.xml";
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
		//认证
		SMTPAuthenticator auth = new SMTPAuthenticator(mailConfig.getServerEmail(),mailConfig.getServerEmailPwd()); // ，用户名，密码。
		auth.getPasswordAuthentication();
		
		//与服务器建立Session的参数设置
		Properties props = new Properties();
		props.put("mail.smtp.host", mailConfig.getServerName()); // SMTP服务器。
		props.put("mail.smtp.auth", "true"); // 将这个参数设为true，让服务器进行认证。
		Session session = Session.getInstance(props,auth); // 建立连接。
		try {
			session.getTransport("smtp");
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		}
		mailConfig.setSendMailSession(session);
		return mailConfig;
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
	
	public Session getSendMailSession() {
		return sendMailSession;
	}

	public void setSendMailSession(Session sendMailSession) {
		this.sendMailSession = sendMailSession;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	
}
