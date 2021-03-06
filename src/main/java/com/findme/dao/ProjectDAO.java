package com.findme.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.findme.domain.Project;

@Repository
public interface ProjectDAO extends CrudRepository<Project, Integer> {
}
