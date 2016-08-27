package com.findme.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.findme.domain.Professional;

@Repository
public interface ProfessionalDAO extends CrudRepository<Professional, Long> {
	Iterable<Professional> findByFirstNameOrLastNameContaining(String firstName, String lastName);
}
