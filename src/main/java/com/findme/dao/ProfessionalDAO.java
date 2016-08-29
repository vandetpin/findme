package com.findme.dao;

import java.util.Date;

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
	
}
