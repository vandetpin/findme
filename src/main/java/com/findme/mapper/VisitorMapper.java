package com.findme.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.findme.domain.Visitor;
import com.findme.json.JVisitor;

public class VisitorMapper {
	public static Collection<JVisitor> map(Iterable<Visitor> list) {
		if(list != null) {
			List<JVisitor> tos = new ArrayList<>();
			for(Visitor from : list) {
				tos.add(map(from));
			}
			
			return tos;
		}
				
		return CollectionUtils.EMPTY_COLLECTION;
		
	}
	
	public static JVisitor map(Visitor from) {
		JVisitor to = null;
		if(from != null) {
			to = new JVisitor();
			to.setId(from.getId());
			to.setFirstName(from.getFirstName());
			to.setLastName(from.getLastName());
		}
		
		return to;
	}
}
