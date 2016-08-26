package com.findme.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("VISITOR")
public class Visitor extends User{

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id.visitor", cascade=CascadeType.ALL)
	private Set<VisitorAppointment> visitorAppointment = new HashSet<VisitorAppointment>(0);

	@ManyToMany
	private List<Professional> professionals = new ArrayList<Professional>();

	public Visitor() {}

	public List<Professional> getProfessionals() {
		return professionals;
	}

	public void setProfessionals(List<Professional> professionals) {
		this.professionals = professionals;
	}

	public Set<VisitorAppointment> getVisitorAppointment() {
		return visitorAppointment;
	}

	public void setVisitorAppointment(Set<VisitorAppointment> visitorAppointment) {
		this.visitorAppointment = visitorAppointment;
	}
	
}
