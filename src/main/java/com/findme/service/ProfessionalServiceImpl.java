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
import com.findme.domain.ProfessionalType;
import com.findme.domain.UserAccount;
import com.findme.domain.UserRole;
import com.findme.domain.Visitor;
import com.findme.json.JAppointment;
import com.findme.json.JProfessionalAppointment;
import com.findme.json.JVisitorAppointment;
import com.findme.mapper.AppointmentMapper;
import com.findme.mapper.ProfessionalAppointmentMapper;
import com.findme.mapper.VisitorAppointmentMapper;

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

	@Override
	public Professional findById(Long id) {
		return professionalDAO.findOne(id);
	}

	@Override
	public Collection<JVisitorAppointment> findVisitorByIdAndFirstNameOrLastNameContaining(Long professionalId,
			String visitorFirstName, String visitorLastName) {
		return VisitorAppointmentMapper.map(professionalDAO.findVisitorByIdAndFirstNameOrLastNameContaining(
				professionalId, visitorFirstName, visitorLastName));
	}

	@Override
	public Appointment findAppointmentByIdAndAppointmentId(Long id, Long appointmentId) {
		return professionalDAO.findAppointmentByIdAndAppointmentId(id, appointmentId);
	}
	
	@Override
	public Professional create(Professional professional) {
		// Assign roles to professional
		UserAccount user = professional.getUserAccount();
		user.addRole(new UserRole(user.getUsername(), UserRole.ROLE_USER));
		user.addRole(new UserRole(user.getUsername(), UserRole.ROLE_PROFESSIONAL));
		user.setActive(true);
		
		// professional should be verify and allow by Admin user
		professional.setActive(false);
		professional.setUserAccount(user);
		
		return professionalDAO.save(professional);
	}
	
	@Override
	public void updateStatus(Long id, Boolean isActive) {
		professionalDAO.updateStatus(id, isActive);
	}

	@Override
	public Collection<JProfessionalAppointment> findProfessionalByVisitorId(Long id) {
		return ProfessionalAppointmentMapper.map(professionalDAO.findByVisitorsId(id));
	}
	
	
}
