package com.findme.service;

import java.util.Collection;

import com.findme.domain.Appointment;
import com.findme.json.JAppointment;
import com.findme.json.JVisitorAppointment;

public interface AppointmentService {

	Iterable<Appointment> findAll();
	void create(Appointment appointment);
	void updateStatus(Long id, Integer status);
	Iterable<Appointment> findByProfessionalIdAndAppointmentStatus(Long id, int status);
}
