package com.findme.service;


import com.findme.domain.Project;

public interface ProjectService {
	Project save(Project project);
	Iterable<Project> findAll();
}
