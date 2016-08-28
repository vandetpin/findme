package com.findme.service;

import java.util.Collection;
import java.util.Date;

import com.findme.domain.Appointment;
import com.findme.domain.Professional;
import com.findme.json.JAppointment;

public interface ProfessionalService {
	Iterable<Professional> findAll();

	Iterable<Professional> findByFirstNameOrLastNameContaining(String firstName, String lastName);

	Collection<JAppointment> findByProfessional(Long professionalId);

	Collection<JAppointment> findByProfessional(Long professionalId, Date startDate, Date endDate);
	
	Professional findById(Long id);
}
