package com.findme.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.findme.domain.Visitor;
import com.findme.domain.VisitorAppointment;
import com.findme.json.JAppointmentDetail;
import com.findme.json.JVisitorAppointment;

public final class AppointmentDetailMapper {
	public static Collection<JAppointmentDetail> map(Visitor from) {
		if(from == null) return CollectionUtils.EMPTY_COLLECTION;
		
		List<JAppointmentDetail> apps = new ArrayList<>();
		for(VisitorAppointment vp : from.getVisitorAppointment()) {
			JAppointmentDetail appointmentDetail = new JAppointmentDetail();
			appointmentDetail.setAppointment(AppointmentMapper.map(vp.getAppointment()));
			appointmentDetail.setIsApproved(vp.getIsApproved());
			apps.add(appointmentDetail);
		}
		
		return apps;
	}
		
}
