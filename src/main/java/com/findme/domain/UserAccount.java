package com.findme.domain;


import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UserAccount {
	
	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true)
	private String username;
	
	private String password;

	private boolean isActive;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	private Set<UserRole> roles = new HashSet<>();

	public UserAccount() {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Set<UserRole> getRoles() {
		return Collections.unmodifiableSet(roles);
	}

	public void addRole(UserRole role) {
		roles.add(role);
	}
	
	public void removeRole(UserRole role) {
		roles.remove(role);
	}

}
