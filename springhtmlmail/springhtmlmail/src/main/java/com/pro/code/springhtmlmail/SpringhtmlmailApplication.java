package com.pro.code.springhtmlmail;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pro.code.springhtmlmail.dto.MailRequest;
import com.pro.code.springhtmlmail.dto.MailResponse;
import com.pro.code.springhtmlmail.service.EmailService;

@SpringBootApplication
@RestController
public class SpringhtmlmailApplication {
	
	@Autowired
	private EmailService service;
	
	@PostMapping("/sendingEmail")
	public MailResponse sendEmail(@RequestBody MailRequest request) {
		DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); 
		LocalDateTime now = LocalDateTime.now();  
		Map<String, Object> model = new HashMap<>();
		model.put("Name", request.getName());
		model.put("time", now);
		return service.sendEmail(request, model);

	}

	public static void main(String[] args) {
		SpringApplication.run(SpringhtmlmailApplication.class, args);
	}

}
