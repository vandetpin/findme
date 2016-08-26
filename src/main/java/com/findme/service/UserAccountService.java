package com.findme.service;

import com.findme.domain.UserAccount;

interface UserAccountService {
	UserAccount findOne(Long id);
}
