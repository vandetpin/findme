package com.findme.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.findme.domain.Visitor;

@Repository
public interface VisitorDAO extends CrudRepository<Visitor, Long> {
	
}
