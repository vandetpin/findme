package com.findme.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.findme.domain.*;
import com.findme.json.JAppointmentDetail;
import com.findme.json.JVisitorAppointment;

public interface VisitorService {
	
	Iterable<Appointment> findByProfessional(Professional owner);
	Iterable<VisitorAppointment> findAll();
	Visitor create(Visitor visitor);
	Collection<JAppointmentDetail> findByVisitor(Long id);
	Collection<JAppointmentDetail> findByVisitor(Long id, Date startDate, Date endDate);
	
	
	
}
