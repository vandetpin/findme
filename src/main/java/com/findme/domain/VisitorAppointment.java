package com.findme.domain;

import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@AssociationOverrides({
		@AssociationOverride(name = "id.visitor",
			joinColumns = @JoinColumn(name = "visitorId")),
		@AssociationOverride(name = "pk.appointment",
			joinColumns = @JoinColumn(name = "appointmentId")) })
public class VisitorAppointment implements java.io.Serializable {
	@EmbeddedId
	private VisitorAppointmentPK id = new VisitorAppointmentPK();
	private Integer isApproved;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	public VisitorAppointment(){}

	public VisitorAppointmentPK getId() {
		return id;
	}

	public void setId(VisitorAppointmentPK id) {
		this.id = id;
	}

	public Integer getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(Integer isApproved) {
		this.isApproved = isApproved;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public Visitor getVisitor() {
		return getId().getVisitor();
	}
	
	public void setVisitor(Visitor visitor) {
		getId().setVisitor(visitor);
	}
	
	public Appointment getAppointment() {
		return getId().getAppointment();
	}
	
	public void setAppointment(Appointment appointment) {
		getId().setAppointment(appointment);
	}
	
}
