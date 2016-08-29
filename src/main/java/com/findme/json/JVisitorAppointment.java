package com.findme.json;

import java.io.Serializable;
import java.util.Collection;


public class JVisitorAppointment implements Serializable{
	private JVisitor visitor;
	private Collection<JAppointmentDetail> appointments;
	
	public JVisitor getVisitor() {
		return visitor;
	}
	public void setVisitor(JVisitor visitor) {
		this.visitor = visitor;
	}
	public Collection<JAppointmentDetail> getAppointments() {
		return appointments;
	}
	public void setAppointments(Collection<JAppointmentDetail> appointments) {
		this.appointments = appointments;
	}
}
