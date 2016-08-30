package com.findme.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.findme.domain.Appointment;
import com.findme.domain.Professional;
import com.findme.domain.Visitor;

import java.lang.Long;
import java.util.List;

@Repository
public interface ProfessionalDAO extends CrudRepository<Professional, Long> {
	Iterable<Professional> findByFirstNameOrLastNameContaining(String firstName, String lastName);
	
	

	@Query("SELECT a FROM Professional p JOIN p.appointments a WHERE p.id =:id AND a.appStartTime >=:startDate AND a.appEndTime <=:endDate ")
	Iterable<Appointment> findByIdAndAppointmentStartDateAndEndDate(@Param("id") Long professionalId,
			@Param("startDate") Date startDate, @Param("endDate") Date endDate);
	
	@Query("SELECT DISTINCT v FROM Professional p JOIN p.visitors v WHERE p.id =:id AND v.firstName LIKE %:firstName% OR v.lastName LIKE %:lastName%")
	Iterable<Visitor> findVisitorByIdAndFirstNameOrLastNameContaining(@Param("id") Long professionalId, @Param("firstName") String visitorFirstName, @Param("lastName") String visitorLastName);
	
	@Query("SELECT DISTINCT a FROM Professional p JOIN p.appointments a WHERE p.id =:id AND a.appid =:appointmentId ")
	Appointment findAppointmentByIdAndAppointmentId(@Param("id") Long id, @Param("appointmentId") Long appointmentId);
	
	@Query("SELECT p FROM Professional p WHERE p.isActive = 1")
	Iterable<Professional> findAll();
	
	@Modifying
	@Query("UPDATE Professional p SET p.isActive =:isActive WHERE p.id =:id")
	void updateStatus(@Param(value="id") Long id, @Param(value="isActive") Boolean isActive);
	
	@Query("SELECT p FROM Professional p JOIN  p.visitors v WHERE v.id =:id AND p.isActive = true")
	Iterable<Professional> findByVisitorsId(@Param("id") Long id);
	
}
