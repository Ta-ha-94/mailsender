package com.codingsy.mailsender.services;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService{
	
	private JavaMailSender javaMailSender;
	private Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);
	
	public EmailServiceImpl(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@Override
	public void sendEmail(String to, String subject, String message) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(to);
		mailMessage.setSubject(subject);
		mailMessage.setText(message);
		mailMessage.setFrom("business.codingsy@gmail.com");
		
		javaMailSender.send(mailMessage);
		logger.info("Email has been sent..");
		
	}

	@Override
	public void sendEmail(String[] to, String subject, String message) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(to);
		mailMessage.setSubject(subject);
		mailMessage.setText(message);
		mailMessage.setFrom("business.codingsy@gmail.com");
		
		javaMailSender.send(mailMessage);
		logger.info("Email has been sent..");		
	}

	@Override
	public void sendEmailWithHtml(String to, String subject, String htmlContent) {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setFrom("business.codingsy@gmail.com");
			helper.setText(htmlContent, true);
			
			javaMailSender.send(mimeMessage);
			logger.info("Email has been sent..");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void sendEmailWithFile(String to, String subject, String message, File file) {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setFrom("business.codingsy@gmail.com");
			helper.setText(message);
			
			FileSystemResource fileSystemResource = new FileSystemResource(file);
			helper.addAttachment(fileSystemResource.getFilename(), file);
			
			javaMailSender.send(mimeMessage);
			logger.info("Email has been sent..");
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
