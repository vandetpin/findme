package com.findme.json;

import java.util.Collection;

public class JProfessionalAppointment {
	private JProfessional professional;
	private Collection<JAppointmentDetail> appointments;
	
	public JProfessional getProfessional() {
		return professional;
	}
	public void setProfessional(JProfessional professional) {
		this.professional = professional;
	}
	public Collection<JAppointmentDetail> getAppointments() {
		return appointments;
	}
	public void setAppointments(Collection<JAppointmentDetail> appointments) {
		this.appointments = appointments;
	}
}
