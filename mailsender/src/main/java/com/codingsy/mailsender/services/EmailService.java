package com.codingsy.mailsender.services;

import java.io.File;

public interface EmailService {
	//	send email to single person
	void sendEmail(String to, String subject, String message);
	
	//	sned email to multiple people
	void sendEmail(String[] to, String subject,  String message);
	
	//	sned wmail with HTML
	void sendEmailWithHtml(String to, String subject, String message);
	
	//	sned wmail with HTML
	void sendEmailWithFile(String to, String subject, String message, File file);
}
