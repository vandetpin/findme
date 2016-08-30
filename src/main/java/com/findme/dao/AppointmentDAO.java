package com.findme.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.findme.domain.Appointment;
import com.findme.domain.Professional;

@Repository
public interface AppointmentDAO extends CrudRepository<Appointment, Long> {
	@Modifying
	@Query("UPDATE Appointment a SET a.status =:status WHERE a.appid =:id")
	void updateStatus(@Param(value="id") Long id, @Param(value="status") Integer status);
	
	@Query("SELECT a FROM Appointment a JOIN a.owner p WHERE p.id =:id AND a.status =:status")
	Iterable<Appointment> findByProfessionalIdANDAppointmentStatus(@Param("id") Long id, @Param("status") int status);
	
}
