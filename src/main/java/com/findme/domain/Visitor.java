package com.findme.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("Visitor")
public class Visitor extends User{

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id.visitor", cascade=CascadeType.ALL)
	private Set<VisitorAppointment> visitorAppointment = new HashSet<VisitorAppointment>(0);

	public Visitor() {
		
	}

	public Set<VisitorAppointment> getVisitorAppointment() {
		return visitorAppointment;
	}

	public void setVisitorAppointment(Set<VisitorAppointment> visitorAppointment) {
		this.visitorAppointment = visitorAppointment;
	}
	
	
	
}
