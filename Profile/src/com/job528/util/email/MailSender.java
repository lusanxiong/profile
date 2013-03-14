package com.job528.util.email;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.apache.log4j.Logger;

import com.sun.mail.smtp.SMTPTransport;
import com.sun.swing.internal.plaf.synth.resources.synth;

import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;

/**
 * 
 * @author Sunday
 * MailSender
 */
public class MailSender {
	private final static Object lock = new Object();
	
	private final static Logger log = Logger.getLogger(MailSender.class);
	private static Session sendMailSession; //只有一个发件人只需认证权一次.
	private static boolean IsAuthCompleteSession = false;
	
	private static MailConfig mailConfig;  //邮件配置信息
	private MailBody mailBody; //发送邮件主体

	public MailSender() {
		mailConfig = MailConfig.getInstance(); 
	}
	
	public void setMailBody(MailBody mailBody) {
		this.mailBody = mailBody;
	}
	
	/**
	 * 发送邮件
	 * @return
	 */
	public boolean sendMail(){
		SMTPTransport transport = null;
		
		//判断mailConfig是否初始化完成,如果没有初始化完成,等待第一个线程完成初始化工作.
		while(true) {
			if(mailConfig.getMailConfigInitStatus()) {
				break;
			}
		}
		
		//判断发送邮件服务器授权认证是否完成
		sendMailSession = getSendMailSession();
		while(true) {
			if(getIsAuthCompleteSession()) {
				break;
			}
		}
		
		boolean isSend = false;
		try {
			// SMTPTransport用来发送邮件。
			//sendMailSession = mailConfig.getSendMailSession();
			System.out.println("sendMailSession="+sendMailSession);
			transport =  (SMTPTransport) sendMailSession.getTransport("smtp");
			transport.connect();
//			transport.connect(mailConfig.getServerName(),mailConfig.getServerEmail(),mailConfig.getServerEmailPwd());

			Message newMessage = new MimeMessage(sendMailSession);
			InternetAddress senderName = null;
			try {
				senderName = new InternetAddress(mailConfig.getServerEmail(),MimeUtility.encodeText(mailConfig.getSenderName(),"gb2312","b"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			newMessage.setFrom(senderName);
			newMessage.setRecipient(Message.RecipientType.TO,new InternetAddress(mailBody.getToEmail()));// 设置发送目标邮件
			newMessage.setSubject(mailBody.getMailTitle());// 设置邮件标题
			newMessage.setSentDate(new Date()); //设置发送日期
			 
			// 使用MimeMultipart和MimeBodyPart才能发HTML格式邮件。
			BodyPart bodyPart = new MimeBodyPart();
			bodyPart.setContent(mailBody.getMailContent(), mailConfig.getContentType()); // 发一个HTML格式的
			
			Multipart mp = new MimeMultipart();
			mp.addBodyPart(bodyPart);

			newMessage.setContent(mp);
			Transport.send(newMessage);
//			transport.sendMessage(newMessage, newMessage.getAllRecipients());
			transport.close(); //发送邮件后关闭连接
			isSend = true;
		} catch (MessagingException e) {
			StringBuilder sb = new StringBuilder();
			log.error("发送邮件出现异常："+e.getMessage()+"邮件信息:");
			e.printStackTrace();
		}  
		return isSend;
	}
	
	/**
	 * smtp 邮件服务器授权认证,只需认证一次
	 */
	private static void smtpAuth() {
		
		//认证
		SMTPAuthenticator auth = new SMTPAuthenticator(mailConfig.getServerEmail(),mailConfig.getServerEmailPwd()); // ，用户名，密码。
		auth.getPasswordAuthentication();
		
		//与服务器建立Session的参数设置
		Properties props = new Properties();
		props.put("mail.smtp.host", mailConfig.getServerName()); // SMTP服务器。
		props.put("mail.smtp.auth", "true"); // 将这个参数设为true，让服务器进行认证。
		
		synchronized (lock) {
			if(IsAuthCompleteSession) {
				return;
			}
			Session session = Session.getInstance(props,auth); // 建立连接。
			try {
				session.getTransport("smtp");
			} catch (NoSuchProviderException e) {
				e.printStackTrace();
			}
			sendMailSession = session;
			IsAuthCompleteSession = true;
		}
	}
	
	private static boolean getIsAuthCompleteSession() {
		synchronized (lock) {
			return IsAuthCompleteSession;
		}
	}
	
	public  Session getSendMailSession() {
		synchronized (lock) {
			if(sendMailSession == null) {
				smtpAuth();
			}
			return sendMailSession;
		}
	}

}
