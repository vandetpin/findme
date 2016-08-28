package com.findme.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.findme.dao.UserAccountDAO;
import com.findme.domain.Professional;
import com.findme.domain.User;
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

	@Override
	public UserAccount findByUsername(String username) {
		return userAccountDAO.findByUsername(username);
	}

	@Override
	public User findUserByUsername(String username) {
		UserAccount account = userAccountDAO.findByUsername(username);
		if(account != null) {
			return account.getUser();
		}
		
		return null;
	}

}
