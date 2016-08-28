package com.findme.service;

import com.findme.domain.User;
import com.findme.domain.UserAccount;

public interface UserAccountService {
	UserAccount findOne(Long id);
	UserAccount findByUsername(String username);
	User findUserByUsername(String username);
	
}
