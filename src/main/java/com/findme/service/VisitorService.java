package com.findme.service;

import java.util.Collection;
import java.util.Date;


import com.findme.domain.*;
import com.findme.exception.BusinessException;
import com.findme.exception.ObjectNotFoundException;
import com.findme.json.JAppointmentDetail;


public interface VisitorService {
	
	Iterable<Appointment> findByProfessional(Professional owner);
	Iterable<VisitorAppointment> findAll();
	Visitor create(Visitor visitor);
	Collection<JAppointmentDetail> findByVisitor(Long id);
	Collection<JAppointmentDetail> findByVisitor(Long id, Date startDate, Date endDate);
	Visitor findById(Long id);
	void registerAppoinment(Long visitorId, Long appointmentId) throws ObjectNotFoundException, BusinessException;
	void deleteVisitorAppointmentByVisitorIdAndAppointmentId(Long visitorId, Long appointmentId);
}
