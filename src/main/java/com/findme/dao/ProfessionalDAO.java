package com.findme.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.findme.domain.Appointment;
import com.findme.domain.Professional;
import com.findme.domain.ProfessionalType;
import com.findme.domain.Visitor;

import java.lang.Long;

@Repository
public interface ProfessionalDAO extends CrudRepository<Professional, Long> {
	
	@Query("SELECT p FROM Professional p WHERE p.isActive = 1 AND (p.firstName LIKE %:firstName% OR p.lastName LIKE %:lastName% )")
	Iterable<Professional> findByFirstNameOrLastNameContaining(@Param("firstName") String firstName, @Param("lastName") String lastName);
	
	

	@Query("SELECT a FROM Professional p JOIN p.appointments a WHERE p.id =:id AND a.appStartTime >=:startDate AND a.appEndTime <=:endDate ")
	Iterable<Appointment> findByIdAndAppointmentStartDateAndEndDate(@Param("id") Long professionalId,
			@Param("startDate") Date startDate, @Param("endDate") Date endDate);
	
	@Query("SELECT DISTINCT v FROM Professional p JOIN p.visitors v WHERE p.id =:id AND v.firstName LIKE %:firstName% OR v.lastName LIKE %:lastName%")
	Iterable<Visitor> findVisitorByIdAndFirstNameOrLastNameContaining(@Param("id") Long professionalId, @Param("firstName") String visitorFirstName, @Param("lastName") String visitorLastName);

	@Query("SELECT DISTINCT v FROM Professional p JOIN p.visitors v JOIN v.visitorAppointment va JOIN va.id.appointment a WHERE p.id =:id AND a.name LIKE %:appointmentName%")
	Iterable<Visitor> findVisitorByIdAndAppointmentNameContaining(@Param("id") Long professionalId, @Param("appointmentName") String appointmentName);

	
	@Query("SELECT DISTINCT a FROM Professional p JOIN p.appointments a WHERE p.id =:id AND a.appid =:appointmentId ")
	Appointment findAppointmentByIdAndAppointmentId(@Param("id") Long id, @Param("appointmentId") Long appointmentId);
	
	@Query("SELECT p FROM Professional p WHERE p.isActive = 1")
	Iterable<Professional> findAll();
	
	@Query("SELECT p FROM Professional p")
	Iterable<Professional> findAllByAllStatus();
	
	@Modifying
	@Query("UPDATE Professional p SET p.isActive =:isActive WHERE p.id =:id")
	void updateStatus(@Param(value="id") Long id, @Param(value="isActive") Boolean isActive);
	
	@Query("SELECT p FROM Professional p JOIN  p.visitors v WHERE v.id =:id AND p.isActive = true")
	Iterable<Professional> findByVisitorsId(@Param("id") Long id);
	
	@Query("SELECT p FROM Professional p WHERE p.isActive = 1 AND (p.firstName LIKE %:firstName% OR p.lastName LIKE %:lastName% OR p.phoneNumber LIKE %:phone% )")
	Iterable<Professional> findByFirstNameOrLastNameOrPhoneContaining(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("phone") String phone);


	// First Name LastName Phone Type
	@Query("SELECT p FROM Professional p WHERE p.isActive = 1 AND (p.firstName LIKE %:firstName% OR p.lastName LIKE %:lastName% OR p.phoneNumber LIKE %:phone%  OR p.type=:type)")
	Iterable<Professional> findByFirstNameOrLastNameOrPhoneOrTypeContaining(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("phone") String phone, @Param("type") ProfessionalType type);


	// First Name Last Name Type
	@Query("SELECT p FROM Professional p WHERE p.isActive = 1 AND (p.firstName LIKE %:firstName% OR p.lastName LIKE %:lastName%   OR p.type=:type)")
	Iterable<Professional> findByFirstNameOrLastNameOrTypeContaining(@Param("firstName") String firstName, @Param("lastName") String lastName,  @Param("type") ProfessionalType type);



	// Phone
	@Query("SELECT p FROM Professional p WHERE p.isActive = 1 AND (p.phoneNumber LIKE %:phone% )")
	Iterable<Professional> findByPhoneContaining(@Param("phone") String phone);

	// Phone Type
	@Query("SELECT p FROM Professional p WHERE p.isActive = 1 AND (p.phoneNumber LIKE %:phone% OR p.type=:type)")
	Iterable<Professional> findByPhoneOrTypeContaining(@Param("phone") String phone,@Param("type") ProfessionalType type);


	// Type
	@Query("SELECT p FROM Professional p WHERE p.isActive = 1 AND p.type=:type")
	Iterable<Professional> findByType(@Param("type") ProfessionalType type);

	@Query("SELECT DISTINCT p FROM Professional p JOIN p.visitors v WHERE v.id =:visitorId")
	Iterable<Professional> findByVisitorId(@Param(value="visitorId") Long visitorId);
	
}
