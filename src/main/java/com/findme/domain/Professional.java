package com.findme.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("PROFESSIONAL")
public class Professional extends User{

	private boolean isActive;
	
	@Enumerated(EnumType.ORDINAL)
	private ProfessionalType type;
	
	@ElementCollection
	private List<Comment> comments;
	
	@OneToMany(mappedBy="owner")
	private List<Appointment> appointments;
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "ProfessionalVisitor", joinColumns = 
			@JoinColumn(name = "professionalId", nullable = false, updatable = false) ,
			inverseJoinColumns = @JoinColumn(name = "visitorId", nullable = false, updatable = false))
	private List<Visitor> visitors = new ArrayList<Visitor>(); 
	
	public Professional(){}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public ProfessionalType getType() {
		return type;
	}

	public void setType(ProfessionalType type) {
		this.type = type;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public List<Visitor> getVisitors() {
		return visitors;
	}

	public void setVisitors(List<Visitor> visitors) {
		this.visitors = visitors;
	}
	
}
