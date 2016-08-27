package com.findme.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserRole {
	public static final String ROLE_ADMIN = "ROLE_ADMIN";
	public static final String ROLE_USER = "ROLE_USER";
	public static final String ROLE_VISITOR = "ROLE_VISITOR";
	public static final String ROLE_PROFESSIONAL = "ROLE_PROFESSIONAL";
	
	@Id
	@GeneratedValue
	private Long id;

	private String username;
	
	private String role;

	public UserRole() {
	}
	
	public UserRole(String username, String role) {
		super();
		this.username = username;
		this.role = role;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}