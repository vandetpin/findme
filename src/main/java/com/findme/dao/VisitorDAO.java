package com.findme.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.findme.domain.Professional;
import com.findme.domain.Visitor;

@Repository
public interface VisitorDAO extends CrudRepository<Visitor, Long> {
//	@Query("SELECT DISTINCT Visitor FROM Visitor v JOIN v.visitorAppointment vp WHERE v.id =:id AND vp.id.appointment.appStartTime >=:startDate AND vp.id.appointment.appEndTime <=:endDate ")
//	Visitor findByIdAndAppointmentStartDateAndEndDate(@Param("id") Long id,
//			@Param("startDate") Date startDate, @Param("endDate") Date endDate);
	
}
