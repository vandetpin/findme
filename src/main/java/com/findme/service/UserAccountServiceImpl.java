package com.findme.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.findme.dao.UserAccountDAO;
import com.findme.domain.UserAccount;

@Service
@Transactional
public class UserAccountServiceImpl implements UserAccountService {

	@Autowired
	private UserAccountDAO userAccountDAO;
	
	@Override
	public UserAccount findOne(Long id) {
		return userAccountDAO.findOne(id);
	}

}
