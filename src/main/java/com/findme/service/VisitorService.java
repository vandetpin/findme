package com.findme.service;

import java.util.List;

import com.findme.domain.*;

public interface VisitorService {
	
	Iterable<Appointment> findByProfessional(Professional owner);
	Iterable<VisitorAppointment> findAll();
	
	
	
}
