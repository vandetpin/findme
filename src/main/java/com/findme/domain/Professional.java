package com.findme.domain;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("Professional")
public class Professional extends User{

	private boolean isActive;
	
	@Enumerated
	private ProfessionalType type;
	
	@ElementCollection
	private List<Comment> comments;
	
	@OneToMany(mappedBy="professional")
	private List<Appointment> appointment;
	
	
	public Professional(){}
}
