package com.findme.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.findme.domain.Professional;
import com.findme.domain.Visitor;
import com.findme.json.JProfessional;
import com.findme.json.JVisitor;

public class ProfessionalMapper {
	public static Collection<JProfessional> map(Iterable<Professional> list) {
		if(list != null) {
			List<JProfessional> tos = new ArrayList<>();
			for(Professional from : list) {
				tos.add(map(from));
			}
			
			return tos;
		}
				
		return CollectionUtils.EMPTY_COLLECTION;
		
	}
	
	public static JProfessional map(Professional from) {
		JProfessional to = null;
		if(from != null) {
			to = new JProfessional();
			to.setId(from.getId());
			to.setFirstName(from.getFirstName());
			to.setLastName(from.getLastName());
		}
		
		return to;
	}
}
