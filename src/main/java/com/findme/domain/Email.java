package com.findme.domain;

import java.io.Serializable;

public class Email implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String toEmail;
	private String subject;
	private String body;
	
	public String getToEmail() {
		return toEmail;
	}
	public String getSubject() {
		return subject;
	}
	public String getBody() {
		return body;
	}
	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
}
