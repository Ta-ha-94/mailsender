package com.codingsy.mailsender.controllers.api;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.codingsy.mailsender.services.EmailService;
import com.codingsy.mailsender.util.CustomResponse;
import com.codingsy.mailsender.util.EmailRequest;

@RestController
@RequestMapping(path = "/api/v1/email")
public class EmailController {
	
	private EmailService emailService;
	
	@Autowired
	public EmailController(EmailService emailService) {
		this.emailService = emailService;
	}
	
	//	send email
	@PostMapping("/send")
	public ResponseEntity<CustomResponse>  sendEmail(@RequestBody EmailRequest emailRequest){
		emailService.sendEmail(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getMessage());
		return ResponseEntity.ok(
					CustomResponse.builder().message("Email sent successfully!").httpStatus(HttpStatus.OK).success(true).build()
				);
	}
	
	//	send email with file
	@PostMapping("/send-with-file")
	public ResponseEntity<CustomResponse>  sendEmailWithFile(@RequestPart EmailRequest emailRequest, @RequestPart MultipartFile file){
		try {
			emailService.sendEmailWithFile(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getMessage(), file.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok(
					CustomResponse.builder().message("Email sent successfully!").httpStatus(HttpStatus.OK).success(true).build()
				);
	}
}
