package com.findme.service;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.repository.query.Param;

import com.findme.domain.Appointment;
import com.findme.domain.Professional;
import com.findme.domain.Visitor;
import com.findme.json.JAppointment;
import com.findme.json.JVisitorAppointment;

public interface ProfessionalService {
	Iterable<Professional> findAll();

	Iterable<Professional> findByFirstNameOrLastNameContaining(String firstName, String lastName);

	Collection<JAppointment> findByProfessional(Long professionalId);

	Collection<JAppointment> findByProfessional(Long professionalId, Date startDate, Date endDate);
	
	Professional findById(Long id);
	
	Collection<JVisitorAppointment> findVisitorByIdAndFirstNameOrLastNameContaining(Long professionalId, String visitorFirstName, String visitorLastName);
	
	Appointment findAppointmentByIdAndAppointmentId(Long id, Long appointmentId);

	Professional create(Professional professional);
	
	void updateStatus(Long id, Boolean isActive);
}
