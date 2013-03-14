package com.job528.invite;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.apache.log4j.Logger;

import com.sun.mail.smtp.SMTPTransport;

/**
 * 
 * @author Sunday
 * MailSender
 */
public class MailSender implements Runnable{
	private final static Logger log = Logger.getLogger(MailSender.class);
	
	private MailConfig mailConfig;  //邮件配置信息
	private MailBody mailBody; //发送邮件主体
	

	public MailSender() {
		mailConfig = MailConfig.getInstance(); 
	}
	
	public void setMailBody(MailBody mailBody) {
		this.mailBody = mailBody;
	}
	
	/**
	 * 发送邮件
	 * @param mailManager
	 */
	public void send(){
		Thread mailThread = new Thread(this);
		mailThread.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			log.error("发送邮件，线程出现异常："+e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void run() {
		sendMail();
	}
		
	
	/**
	 * 发送邮件
	 * @return
	 */
	private boolean sendMail(){
		SMTPTransport transport = null;
		Session sendMailSession ;
		boolean isSend = false;
		try {
			// SMTPTransport用来发送邮件。
			sendMailSession = mailConfig.getSendMailSession();
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
			log.error("发送邮件出现异常："+e.getMessage());
			e.printStackTrace();
		}  
		return isSend;
	}

}
