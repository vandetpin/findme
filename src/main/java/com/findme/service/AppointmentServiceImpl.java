package com.findme.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.findme.dao.AppointmentDAO;
import com.findme.domain.Appointment;

public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired
	AppointmentDAO appointmentDAO;

	public Iterable<Appointment> findAll() {
		return appointmentDAO.findAll();
	}

}
