package com.findme.json;

import java.io.Serializable;

public class JAppointmentDetail implements Serializable{
    private JAppointment appointment;
	private Boolean isApproved;
	
	public JAppointment getAppointment() {
		return appointment;
	}
	public void setAppointment(JAppointment appointment) {
		this.appointment = appointment;
	}
	public Boolean getIsApproved() {
		return isApproved;
	}
	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}
	
	
}
