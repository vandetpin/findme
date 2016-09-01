package com.findme.service.jms;
import javax.jms.*;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.findme.domain.Email;

@Service
public class JMSEmailSender {
	@Autowired
    private JmsTemplate jmsTemplate;
    
    private Logger LOG = Logger.getLogger(JMSEmailSender.class);
    
    public void send(final Email email) {
        jmsTemplate.send(new MessageCreator() {
              public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(email);
              }
        });
        
        LOG.info(">>>>> Calling JMS Email Service >>>>>>>>");
        LOG.info(String.format("To email=%s, subject=%s", email.getToEmail(), email.getSubject()));
    }

}
