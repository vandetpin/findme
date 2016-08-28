package com.findme.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.findme.dao.ProfessionalDAO;
import com.findme.domain.Appointment;
import com.findme.domain.Professional;
import com.findme.json.JAppointment;
import com.findme.mapper.AppointmentMapper;

@Service
@Transactional
public class ProfessionalServiceImpl implements ProfessionalService {
	
	@Autowired
	private ProfessionalDAO professionalDAO; 
	
	@Override
	public Iterable<Professional> findAll() {
		return professionalDAO.findAll();
	}

	@Override
	public Iterable<Professional> findByFirstNameOrLastNameContaining(String firstName, String lastName) {		
		return professionalDAO.findByFirstNameOrLastNameContaining(firstName, lastName);
	}

	@Override
	public Collection<JAppointment> findByProfessional(Long professionalId) {
		Professional prof = professionalDAO.findOne(professionalId);
		if(prof != null && !CollectionUtils.isEmpty(prof.getAppointments()) ) {
			return AppointmentMapper.map(prof.getAppointments());
		}
		
		return CollectionUtils.EMPTY_COLLECTION;
	}

	@Override
	public Collection<JAppointment> findByProfessional(Long professionalId, Date startDate, Date endDate) {
		return AppointmentMapper.map(professionalDAO.findByIdAndAppointmentStartDateAndEndDate(professionalId, startDate, endDate));
	}

	

}
