package com.example.controller;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
    public String sendSimpleEmail() throws MessagingException {
    	 
//        // Create a Simple MailMessage.
//        SimpleMailMessage message = new SimpleMailMessage();
//         
//        message.setTo("huydz20084@gmail.com"); // ng nhận
//        message.setSubject("Test Simple Email"); // title mail
//        message.setText("Hello, Im testing Simple Email"); // nội dung mail
//        // Send Message!
//        this.emailSender.send(message);
		
		
			 
	        MimeMessage message = emailSender.createMimeMessage();
	 
	        boolean multipart = true;
	         
	        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "UTF-8");
	         
	        String htmlMsg = "<table cellpadding='0' cellspacing='0' border='0' height='100%' width='100%' bgcolor='#F7F3F0'\n" + 
	        		"       style='border-collapse:collapse' >\n" + 
	        		"    <tbody>\n" + 
	        		"    <tr>\n" + 
	        		"        <td valign='top'>\n" + 
	        		"            <center style='width:100%'>\n" + 
	        		"\n" + 
	        		"\n" + 
	        		"                <div style='display:none;font-size:1px;line-height:1px;max-height:0px;max-width:0px;opacity:0;overflow:hidden;font-family:sans-serif'>\n" + 
	        		"\n" + 
	        		"                </div>\n" + 
	        		"\n" + 
	        		"\n" + 
	        		"                <div style='max-width:600px'>\n" + 
	        		"\n" + 
	        		"\n" + 
	        		"                    <table cellspacing='0' cellpadding='0' border='0' align='center' width='100%'\n" + 
	        		"                           style='max-width:600px;border-top:7px solid #d84800' bgcolor='#F7F3F0'>\n" + 
	        		"                        <tbody>\n" + 
	        		"                        <tr>\n" + 
	        		"                            <td style='text-align:center;padding:15px 0;font-family:sans-serif;font-weight:bold;color:#000000;font-size:30px'>\n" + 
	        		"                                Chú Ý\n" + 
	        		"                            </td>\n" + 
	        		"                        </tr>\n" + 
	        		"                        </tbody>\n" + 
	        		"                    </table>\n" + 
	        		"\n" + 
	        		"\n" + 
	        		"                    <table cellspacing='0' cellpadding='0' border='0' align='center' bgcolor='#FFFFFF' width='100%'\n" + 
	        		"                           style='max-width:600px;border-radius:5px'>\n" + 
	        		"\n" + 
	        		"\n" + 
	        		"                        <tbody>\n" + 
	        		"                        <tr>\n" + 
	        		"                            <td>\n" + 
	        		"                                <table cellspacing='0' cellpadding='0' border='0' width='100%'>\n" + 
	        		"                                    <tbody>\n" + 
	        		"                                    <tr>\n" + 
	        		"                                        <td style='padding:20px;line-height:24px;color:#555555;font-size:15px'>\n" + 
	        		"                                            <span style='font-family:sans-serif;font-weight:bold;font-size:20px'>Hi there!</span>\n" + 
	        		"                                            <hr color='#F7F3F0'>\n" + 
	        		"                                            <br>\n" + 
	        		"                                            Thanks for being my friend!!<br>\n" + 
	        		"                                            <br>\n" + 
	        		"                                            <p style='font-family:sans-serif;'>Your attention will be given to us. Thank you!:</p> <a\n" + 
	        		"                                                style='color:#d84800' href='https://www.google.com.vn/'>Touch Me</a>\n" + 
	        		"                                        </td>\n" + 
	        		"                                    </tr>\n" + 
	        		"                                    </tbody>\n" + 
	        		"                                </table>\n" + 
	        		"                            </td>\n" + 
	        		"         anhmaidensau               </tr>\n" + 
	        		"\n" + 
	        		"\n" + 
	        		"                        </tbody>\n" + 
	        		"                    </table>\n" + 
	        		"\n" + 
	        		"\n" + 
	        		"                    <br>\n" + 
	        		"                    <table cellspacing='0' cellpadding='0' border='0' align='left' width='100%'\n" + 
	        		"                           style='max-width:600px;border-radius:5px' bgcolor='#F7F3F0'>\n" + 
	        		"                        <tbody>\n" + 
	        		"                        <tr>\n" + 
	        		"                            <td style='padding:20px;width:100%;font-size:12px;font-family:sans-serif;line-height:19px;text-align:left;color:#525252'>\n" + 
	        		"\n" + 
	        		"                                <span>© 2018 Xam Thien Designer</span>\n" + 
	        		"                                <br><br>\n" + 
	        		"\n" + 
	        		"\n" + 
	        		"                            </td>\n" + 
	        		"                        </tr>\n" + 
	        		"                        </tbody>\n" + 
	        		"                    </table>\n" + 
	        		"\n" + 
	        		"\n" + 
	        		"                </div>\n" + 
	        		"            </center>\n" + 
	        		"        </td>\n" + 
	        		"    </tr>\n" + 
	        		"    </tbody>\n" + 
	        		"</table>";
	         
	        message.setContent(htmlMsg, "text/html");
	         
	        //helper.setTo("huydz20084@gmail.com");
	        helper.setTo(InternetAddress.parse("huydz20084@gmail.com,huydz20083@gmail.com"));
	        helper.setSubject("Test send HTML email");
	         
	     
	        this.emailSender.send(message);
 
        return "Email Sent!";
    }

}
