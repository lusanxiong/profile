package com.job528.invite;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SMTPAuthenticator extends Authenticator {
	private String user;

	private String password;

	public SMTPAuthenticator(String s, String s1) {
		user = s;
		password = s1;
	}
	
	public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(user, password);
	}
}
