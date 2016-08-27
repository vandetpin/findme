package com.findme.service;

import com.findme.domain.Professional;

public interface ProfessionalService {
	Iterable<Professional> findAll();
	Iterable<Professional> findByFirstNameOrLastNameContaining(String firstName, String lastName);
}
