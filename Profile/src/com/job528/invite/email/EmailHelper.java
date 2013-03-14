package com.job528.invite.email;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.naming.NamingException;


import com.job528.invite.MailBody;
import com.job528.invite.MailSender;
import com.job528.util.Config;
import com.job528.util.MyFileReader;

/**
 * 发送邮件帮助类
 * @author Sunday
 *
 */
public class EmailHelper {

	public static void sendInvite(List<String> list,String userName,String root) throws MessagingException, NamingException {
		MailBody mailBody = new MailBody();
		mailBody.setMailTitle("528招聘网邀请");
		mailBody.setMailContent(new MyFileReader().readFileToString(root+Config.template.invite).replace("#userName#",userName));
		MailSender sender = new MailSender();
		sender.setMailBody(mailBody);

		if (null != list) {
			for (String email : list) {
				mailBody.setToEmail(email);
				sender.send();
			}
		}
	}
}
