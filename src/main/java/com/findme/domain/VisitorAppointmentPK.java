package com.findme.domain;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class VisitorAppointmentPK implements java.io.Serializable {
	
	@ManyToOne
	private Visitor visitor;
	@ManyToOne
	private Appointment appointment;
	
	public VisitorAppointmentPK() {
	}
	
	public Visitor getVisitor() {
		return visitor;
	}



	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}



	public Appointment getAppointment() {
		return appointment;
	}



	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appointment == null) ? 0 : appointment.hashCode());
		result = prime * result + ((visitor == null) ? 0 : visitor.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VisitorAppointmentPK other = (VisitorAppointmentPK) obj;
		if (appointment == null) {
			if (other.appointment != null)
				return false;
		} else if (!appointment.equals(other.appointment))
			return false;
		if (visitor == null) {
			if (other.visitor != null)
				return false;
		} else if (!visitor.equals(other.visitor))
			return false;
		return true;
	}
	
}
