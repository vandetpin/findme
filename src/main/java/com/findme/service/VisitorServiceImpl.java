package com.findme.service;

import java.util.Collection;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.findme.dao.*;
import com.findme.domain.Appointment;
import com.findme.domain.Professional;
import com.findme.domain.UserAccount;
import com.findme.domain.UserRole;
import com.findme.domain.Visitor;
import com.findme.domain.VisitorAppointment;
import com.findme.exception.BusinessException;
import com.findme.exception.ObjectNotFoundException;
import com.findme.json.JAppointmentDetail;
import com.findme.mapper.AppointmentDetailMapper;
import com.google.common.collect.Iterables;


@Service
@Transactional
public class VisitorServiceImpl implements VisitorService {
	
	@Autowired
	private VisitorDAO visitorDAO;
	
	@Autowired
	private AppointmentDAO appointmentDAO;
	
	@Autowired
	private ProfessionalDAO professionalDAO;

	@Override
	public Iterable<Appointment> findByProfessional(Professional owner) {		
		return null;
	}

	@Override
	public Iterable<VisitorAppointment> findAll() {		
		return null;
	}

	@Override
	public Visitor create(Visitor visitor) {
		// Assign roles to visitor
		UserAccount user = visitor.getUserAccount();
		user.addRole(new UserRole(user.getUsername(), UserRole.ROLE_USER));
		user.addRole(new UserRole(user.getUsername(), UserRole.ROLE_VISITOR));
		user.setActive(true);
		visitor.setUserAccount(user);
		
		return visitorDAO.save(visitor);
	}

	@Override
	public Collection<JAppointmentDetail> findByVisitor(Long id) {
		return AppointmentDetailMapper.map(visitorDAO.findOne(id));
	}

	@Override
	public Collection<JAppointmentDetail> findByVisitor(Long id, Date startDate, Date endDate) {
		return AppointmentDetailMapper.map(visitorDAO.findOne(id));
//		return AppointmentDetailMapper.map(visitorDAO.findByIdAndAppointmentStartDateAndEndDate(id, startDate, endDate));
	}

	@Override
	public Visitor findById(Long id) {
		return visitorDAO.findOne(id);
	}

	@Override
	public void registerAppoinment(Long visitorId, Long appointmentId) throws ObjectNotFoundException, BusinessException {
		// appointment
		Appointment appointment = appointmentDAO.findOne(appointmentId);

		// visitor
		Visitor visitor = visitorDAO.findOne(visitorId);
		
		
		VisitorAppointment visitorAppointment = new VisitorAppointment();
		visitorAppointment.setAppointment(appointment);
		visitorAppointment.setVisitor(visitor);
		visitorAppointment.setCreatedDate(new Date());
		
		// the appointment need to be approved by the professional
		visitorAppointment.setIsApproved(false);
		
		visitor.getVisitorAppointment().add(visitorAppointment);
		
		//save
		visitorDAO.save(visitor);
		
		//TODO call send email to notify professional
		//using @Asyn
	}

}
