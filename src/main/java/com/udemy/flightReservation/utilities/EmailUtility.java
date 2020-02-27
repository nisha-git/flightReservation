package com.udemy.flightReservation.utilities;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtility {
	
	@Value("${com.udemy.flightreservation.itinerary.email.body}")
	 private  String MAIL_BODY;

	@Value("${com.udemy.flightreservation.itinerary.email.subject}")
	private String MAIL_SUBJECT;

	private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtility.class);
	
	@Autowired
	private JavaMailSender sender;
	
	public void sendMail(String toAddress, String filePath) {
		LOGGER.info("inside sendMail()");
		MimeMessage mimeMessage = sender.createMimeMessage();
		
		try {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setTo(toAddress);
			mimeMessageHelper.setSubject(MAIL_SUBJECT);
			mimeMessageHelper.setText(MAIL_BODY);
			mimeMessageHelper.addAttachment("Itinereary", new File(filePath));
			
			sender.send(mimeMessage);
			
		} catch (MessagingException e) {
			LOGGER.error(e.toString());
		}
	}

}
