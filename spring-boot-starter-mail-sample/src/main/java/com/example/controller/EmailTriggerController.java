package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class EmailTriggerController {
    
	
	@Autowired
    private JavaMailSender emailSender;

	@ResponseBody
    @RequestMapping("/send")
    public String sendSimpleEmail() {
    	 
        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();
         
        message.setTo("huydz20084@gmail.com"); // ng nhận
        message.setSubject("Test Simple Email"); // title mail
        message.setText("Hello, Im testing Simple Email"); // nội dung mail
 
        // Send Message!
        this.emailSender.send(message);
 
        return "Email Sent!";
    }

}
