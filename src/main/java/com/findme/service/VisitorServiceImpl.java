package com.findme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.findme.dao.*;
import com.findme.domain.Appointment;
import com.findme.domain.Professional;
import com.findme.domain.VisitorAppointment;

public class VisitorServiceImpl implements VisitorService {
	
	@Autowired
	private VisitorDAO visitorDAO;

	@Override
	public Iterable<Appointment> findByProfessional(Professional owner) {		
		return null;
	}

	@Override
	public Iterable<VisitorAppointment> findAll() {		
		return null;
	}
	
	

}
