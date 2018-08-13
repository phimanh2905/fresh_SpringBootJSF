package com.example.MailConfig;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
 
@Configuration
public class MailConfig {
	@Value("${sender.mail.host}")
	private String sender_host;
	
	@Value("${sender.mail.port}")
	private int sender_port;
	
	@Value("${mail.transport.protocol}")
	private String mail_protcol;
	
	@Value("${mail.smtp.auth}")
	private String smtp_auth;
	
	@Value("${mail.smtp.starttls.enable}")
	private String smtp_starttls_enable;
	
	@Value("${mail.debug}")
	private String mail_debug;
	
	@Value("${spring.mail.username}")
	private String username;
	
	@Value("${spring.mail.password}")
	private String pass;
	
	
	@Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(sender_host);
        mailSender.setPort(sender_port);
 
        mailSender.setUsername(username);
        mailSender.setPassword(pass);
 
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", mail_protcol);
        props.put("mail.smtp.auth", smtp_auth);
        props.put("mail.smtp.starttls.enable", smtp_starttls_enable);
        props.put("mail.debug", mail_debug);
//        props.put ("mail.smtp.socketFactory.port", sender_port); 
//        props.put ("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
//        props.put ("mail.smtp.socketFactory.fallback", "false"); 
 
        return mailSender;
    }

}
