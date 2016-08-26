package com.findme.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Appointment implements java.io.Serializable {
	
	@ManyToOne
	private Professional owner;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id.appointment")
	private Set<VisitorAppointment> visitorAppointment = new HashSet<VisitorAppointment>(0);
	
	
}
