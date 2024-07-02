package com.kh.mail;

import java.util.Properties;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;


//직접 도구를 생성해서 이메일을 보내보자

/*
 *Email Protocol
 *SMTP
 *이메일을 전송할 때 사용하는 프로토콜
 *
 *POP
 *이메일 서버에 도착한 메일을 클라이언트로 가져올 때 사용하는 프로토콜
 *
 *IMAP
 *이메일 서버에 직접 접속하여 이메일을 확인할 때 사용하는 프로토콜
 *(gmail의 SMTP를 이용하기위해서는 IMAP를 사용으로 해줘야한다.)
 */
public class Test1 {
	public static void main(String[] args) {
		
		//MIME 형식의 메일을 보내기 위해서는 JavaMailSender인터페이스를 사용한다.
		//계정설정
		
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		sender.setHost("smtp.gmail.com");
		sender.setPort(587);
		sender.setUsername("khjone0524@gmail.com");
		sender.setPassword("dlyc msuc nwzq vmhw");
		
		//옵션설정
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", true);
		
		sender.setJavaMailProperties(prop);
		
		//메시지생성
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("이메일 전송 테스트");
		message.setText("이메일을 테스트하도록 하겠습니다");
		
		String[] to = {"khjone0524@gmail.com"};
		message.setTo(to);
		
		String[] cc = {"khjone0524@gmail.com"};
		message.setCc(cc);
		
		sender.send(message);
	}
}
