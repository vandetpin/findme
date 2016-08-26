package com.findme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.findme.dao.ProjectDAO;
import com.findme.domain.Project;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDAO projectDAO;
	
	@Override
	public Project save(Project project) {
		return projectDAO.save(project);
	}
	
	@Override
	public Iterable<Project> findAll() {
		return projectDAO.findAll();
	}

}
