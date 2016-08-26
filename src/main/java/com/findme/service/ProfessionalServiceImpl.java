package com.findme.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.findme.dao.ProfessionalDAO;
import com.findme.domain.Professional;

@Service
@Transactional
public class ProfessionalServiceImpl implements ProfessionalService {
	
	@Autowired
	private ProfessionalDAO professionalDAO; 
	
	@Override
	public Iterable<Professional> findAll() {
		return professionalDAO.findAll();
	}

}
