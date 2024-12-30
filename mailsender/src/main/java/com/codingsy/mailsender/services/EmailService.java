package com.codingsy.mailsender.services;

import java.io.File;
import java.io.InputStream;

public interface EmailService {
	//	send email to single person
	void sendEmail(String to, String subject, String message);
	
	//	sned email to multiple people
	void sendEmail(String[] to, String subject,  String message);
	
	//	sned wmail with HTML
	void sendEmailWithHtml(String to, String subject, String message);
	
	//	sned wmail with File
	void sendEmailWithFile(String to, String subject, String message, File file);
	
	//	sned wmail with IS
	void sendEmailWithFile(String to, String subject, String message, InputStream is);
}
