package com.findme.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.findme.domain.Appointment;

@Repository
public interface AppointmentDAO extends CrudRepository<Appointment, Long> {
}
