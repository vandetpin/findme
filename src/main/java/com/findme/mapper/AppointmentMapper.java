package com.findme.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.findme.domain.Appointment;
import com.findme.json.JAppointment;

public final class AppointmentMapper {
	public static Collection<JAppointment> map(Iterable<Appointment> list) {
		if(list != null) {
			List<JAppointment> tos = new ArrayList<>();
			for(Appointment from : list) {
				tos.add(map(from));
			}
			
			return tos;
		}
				
		return CollectionUtils.EMPTY_COLLECTION;
		
	}
	
	public static JAppointment map(Appointment from) {
		JAppointment to = null;
		if(from != null) {
			to = new JAppointment();
			to.setCapacity(from.getCapacity());
			to.setDescription(from.getDescription());
			to.setEndDate(from.getAppEndTime());
			to.setStartDate(from.getAppStartTime());
			to.setId(from.getAppid());
			to.setName(from.getName());
			to.setStatus(from.getStatus());
			
			// professional
			to.setProfessional(ProfessionalMapper.map(from.getOwner()));
		}
		
		return to;
	}
		
	
}
