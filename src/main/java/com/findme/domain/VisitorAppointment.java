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
	private VisitorAppointmentId id = new VisitorAppointmentId();
	private Integer isApproved;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
}
