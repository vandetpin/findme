package com.findme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.findme.dao.AppointmentDAO;
import com.findme.domain.Appointment;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired
	AppointmentDAO appointmentDAO;

	public Iterable<Appointment> findAll() {
		return appointmentDAO.findAll();
	}
	
	public Iterable<Appointment> findById(Long id) {
		return null;
	}

	@Override
	public void create(Appointment appointment) {
		// Save
		appointmentDAO.save(appointment);
	}

}
