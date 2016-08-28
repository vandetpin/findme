package com.findme.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.findme.domain.UserAccount;

@Repository
public interface UserAccountDAO extends CrudRepository<UserAccount, Long> {
	UserAccount findByUsername(String username);
}
