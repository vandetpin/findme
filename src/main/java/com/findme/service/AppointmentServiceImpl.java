package com.findme.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.findme.dao.AppointmentDAO;
import com.findme.domain.Appointment;
import com.findme.json.JAppointment;
import com.findme.json.JVisitorAppointment;
import com.findme.mapper.AppointmentMapper;

@Service
@Transactional
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

	@Override
	public void updateStatus(Long id,Integer status) {
		appointmentDAO.updateStatus(id, status);
	}

	@Override
	public Iterable<Appointment> findByProfessionalIdAndAppointmentStatus(Long id, int status) {
		return appointmentDAO.findByProfessionalIdANDAppointmentStatus(id, status);
	}

}
