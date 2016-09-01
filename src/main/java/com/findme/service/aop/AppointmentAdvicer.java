package com.findme.service.aop;

import javax.transaction.Transactional;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.findme.dao.AppointmentDAO;
import com.findme.dao.ProfessionalDAO;
import com.findme.domain.Appointment;
import com.findme.domain.Professional;
import com.findme.exception.BusinessError;
import com.findme.exception.BusinessException;
import com.findme.exception.ObjectNotFoundException;
import com.google.common.collect.Iterables;

@Service
@Aspect
public class AppointmentAdvicer {
	@Autowired
	private ProfessionalDAO professionalDAO; 
	
	@Autowired
	private AppointmentDAO appointmentDAO;
	
	@Transactional
	@Before("execution(* com.findme.service.ProfessionalServiceImpl.approveAppointment(Long, Long)) && args(visitorId, appointmentId) || "
			+ "execution(* com.findme.service.VisitorServiceImpl.registerAppoinment(Long, Long)) && args(visitorId, appointmentId)")
	public void validateApprovedOrRegisterAppointment(Long visitorId, Long appointmentId) throws ObjectNotFoundException, BusinessException {
		// check if the appointment is valid
		Appointment appointment = appointmentDAO.findOne(appointmentId);
		if(appointment == null ) BusinessError.APPOINTMENT_NOT_FOUND.throwException(); 

		// check if the visitor has a connection with the professional
		Iterable<Professional> professionals = professionalDAO.findByVisitorId(visitorId);
		if(Iterables.size(professionals) <= 0) 
			BusinessError.VISITOR_HAS_NO_CONNECTION_WITH_OWNER_OF_THE_APPOINTMENT.throwException();
	}
	
	@Transactional
	@Before("execution(* com.findme.service.VisitorServiceImpl.registerAppoinment(Long, Long)) && args(visitorId, appointmentId)")
	public void validateRegisterAppointment(Long visitorId, Long appointmentId) throws ObjectNotFoundException, BusinessException {
		// check if the appointment is valid
		Appointment appointment = appointmentDAO.findOne(appointmentId);
		if(appointment != null && appointment.getCapacity() <= appointment.getVisitorAppointment().size() ) 
			BusinessError.APPOINTMENT_REACH_LIMIT.throwException();
	}
	
	
	
}
