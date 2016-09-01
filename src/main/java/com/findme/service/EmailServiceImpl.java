package com.findme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.findme.domain.Email;
import com.findme.service.jms.JMSEmailSender;

@Service
public class EmailServiceImpl implements EmailService {
	@Autowired
	private JMSEmailSender jmsEmailSender;
	
	
	@Override
	@Async
	public void sendMail(Email email) {
		jmsEmailSender.send(email);
	}

}
