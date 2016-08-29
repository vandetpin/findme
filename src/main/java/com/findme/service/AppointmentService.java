package com.findme.service;

import com.findme.domain.Appointment;

public interface AppointmentService {

	Iterable<Appointment> findAll();
	void create(Appointment appointment);
	void updateStatus(Long id, Integer status);
	
}
