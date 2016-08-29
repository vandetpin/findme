package com.findme.json;

import java.io.Serializable;

public class JAppointmentDetail implements Serializable{
    private JAppointment appointment;
	private Integer isApproved;
	
	public JAppointment getAppointment() {
		return appointment;
	}
	public void setAppointment(JAppointment appointment) {
		this.appointment = appointment;
	}
	public Integer getIsApproved() {
		return isApproved;
	}
	public void setIsApproved(Integer isApproved) {
		this.isApproved = isApproved;
	}
	
	
}
