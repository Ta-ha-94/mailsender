package com.codingsy.mailsender;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codingsy.mailsender.services.EmailService;

@SpringBootTest
public class EmailSenderTest {
	
	@Autowired
	private EmailService emailService;
	
//	@Test
//	void sendEmailTest() {
//		System.out.println("Testing...");
//		emailService.sendEmail("ans.taha94@gmail.com", "Email from spring boot app", "This is a testing email");
//	}
//	
//	@Test
//	void sendEmailWithHtmlTest() {
//		System.out.println("Testing...");
//		String html = "" +
//						"<h1 style='color:red; border:1px solid red;'>Welcome to Codingsy</h1>" +
//						"";
//		emailService.sendEmailWithHtml("ans.taha94@gmail.com", "Email from spring boot app", html);
//	}
	
//	@Test
//	void sendEmailWithFileTest() {
//		System.out.println("Testing...");
//		emailService.sendEmailWithFile("ans.taha94@gmail.com", "Emai with file", "This email contains file", new File("C:\\Codingsy\\Screenshots\\02-Set-up-JDK\\01-installer-download-image.png"));
//	}
	
	@Test
	void sendEmailWithFile() {
		System.out.println("Testing...");
		File file = new File("C:\\Codingsy\\Screenshots\\02-Set-up-JDK\\02-jdk-23-installation-image.png");
		try {
			emailService.sendEmailWithFile("ans.taha94@gmail.com", "Email from spring boot app again", "This is a testing email", new FileInputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
