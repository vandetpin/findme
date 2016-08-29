package com.findme.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.findme.domain.Visitor;
import com.findme.domain.VisitorAppointment;
import com.findme.json.JAppointmentDetail;
import com.findme.json.JVisitorAppointment;

public final class VisitorAppointmentMapper {
	public static Collection<JVisitorAppointment> map(Iterable<Visitor> list) {
		if(list != null) {
			List<JVisitorAppointment> tos = new ArrayList<>();
			for(Visitor from : list) {
				tos.add(map(from));
			}
			
			return tos;
		}
				
		return CollectionUtils.EMPTY_COLLECTION;
		
	}
	
	public static JVisitorAppointment map(Visitor from) {
		JVisitorAppointment to = null;
		if(from != null) {
			to = new JVisitorAppointment();
			to.setVisitor(VisitorMapper.map(from));
			
			List<JAppointmentDetail> apps = new ArrayList<>();
			for(VisitorAppointment vp : from.getVisitorAppointment()) {
				JAppointmentDetail appointmentDetail = new JAppointmentDetail();
				appointmentDetail.setAppointment(AppointmentMapper.map(vp.getAppointment()));
				appointmentDetail.setIsApproved(vp.getIsApproved());
				apps.add(appointmentDetail);
			}
			
			to.setAppointments(apps);
		}
		
		return to;
	}
	
}
