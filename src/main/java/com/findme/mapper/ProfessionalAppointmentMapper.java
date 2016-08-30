package com.findme.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.findme.domain.Appointment;
import com.findme.domain.Professional;
import com.findme.json.JAppointmentDetail;
import com.findme.json.JProfessionalAppointment;

public class ProfessionalAppointmentMapper {
	public static Collection<JProfessionalAppointment> map(Iterable<Professional> list) {
		if(list != null) {
			List<JProfessionalAppointment> tos = new ArrayList<>();
			for(Professional from : list) {
				tos.add(map(from));
			}
			return tos;
		}
		return CollectionUtils.EMPTY_COLLECTION;
	}
	
	public static JProfessionalAppointment map(Professional from) {
		JProfessionalAppointment to = null;
		if(from != null) {
			to = new JProfessionalAppointment();
			to.setProfessional(ProfessionalMapper.map(from));
			List<JAppointmentDetail> apps = new ArrayList<>();
			for(Appointment vp : from.getAppointments()) {
				JAppointmentDetail appointmentDetail = new JAppointmentDetail();
				appointmentDetail.setAppointment(AppointmentMapper.map(vp));
				apps.add(appointmentDetail);
			}
			to.setAppointments(apps);
		}
		return to;
	}
}
