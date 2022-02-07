package org.spring.my.service;

import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.stereotype.Service;

@Service
public class MailSendServiceImpl implements MailSendService{
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public boolean sendAuthMail(String email, String userid) {
		// TODO Auto-generated method stub
		
		StringBuffer content = new StringBuffer();
		content.append(userid + "님 반갑습니다. 저희 사이트 가입을 환영합니다.<br>"
				+ "아래의 링크를 누르시면 이메일 확인 인증절차가 완료됩니다.<br>"
				+ "이메일 확인 인증을 하지않으시면 로그인이 불가능합니다.");
		content.append("<a href='http://localhost:8081/my/member/mailConfirm?userid=" + userid
				+"'>이메일 인증 확인</a>");
		
		MimeMessage mimeMsg = javaMailSender.createMimeMessage();
		
		try {
			mimeMsg.setSubject("회원가입 인증 이메일","utf-8");
			mimeMsg.setText(content.toString(),"utf-8","html");
			mimeMsg.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			javaMailSender.send(mimeMsg);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
