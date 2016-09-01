package com.findme.service;

import java.util.Collection;
import java.util.Date;


import com.findme.domain.Appointment;
import com.findme.domain.Professional;
import com.findme.exception.BusinessException;
import com.findme.exception.ObjectNotFoundException;
import com.findme.json.JAppointment;
import com.findme.json.JProfessionalAppointment;
import com.findme.json.JVisitorAppointment;

public interface ProfessionalService {
	Iterable<Professional> findAll();
	
	Iterable<Professional> findByAllStatus();
	
	Iterable<Professional> findAllIncludedRelationshipWithVisitor(Long visitorId);

	Iterable<Professional> findByFirstNameOrLastNameContaining(String firstName, String lastName);

	Collection<JAppointment> findByProfessional(Long professionalId);

	Collection<JAppointment> findByProfessional(Long professionalId, Date startDate, Date endDate);
	
	Professional findById(Long id);
	
	Collection<JVisitorAppointment> findVisitorByIdAndFirstNameOrLastNameContaining(Long professionalId, String visitorFirstName, String visitorLastName);
	
	Collection<JVisitorAppointment> findVisitorByIdAndAppointmentNameContaining(Long professionalId, String appointmentName);
	
	Appointment findAppointmentByIdAndAppointmentId(Long id, Long appointmentId);

	Professional create(Professional professional);
	
	void updateStatus(Long id, Boolean isActive);
	
	Collection<JProfessionalAppointment> findProfessionalByVisitorId(Long id);

	void approveAppointment(Long visitorId, Long appointmentId) throws ObjectNotFoundException, BusinessException;
	void acceptVisitorRequested(Long visitorId);

	Iterable<Professional> advanceSearch(String byname,  String  byphone , Integer bytype);
	
	Iterable<Professional> advanceSearchIncludedRelationshipWithVisitor(Long visitorId, String byname,  String  byphone , Integer bytype);
}
