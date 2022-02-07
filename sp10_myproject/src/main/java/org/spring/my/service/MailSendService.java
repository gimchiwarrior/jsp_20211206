package org.spring.my.service;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

public interface MailSendService {
	public boolean sendAuthMail(String userid, String email);
}
