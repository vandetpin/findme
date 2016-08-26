package com.findme.service;

import java.text.ParseException;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.findme.domain.Project;
import com.findme.domain.Status;
import com.findme.utils.Formatter;


@Service
public class MockService {
	
	private static final Logger LOG = Logger.getLogger(MockService.class);
	
	@Autowired
	private ProjectService projectService;
	
	@PostConstruct
	public void initData() throws ParseException {
		LOG.info(">>>>>>>>>>>>>> Start mocking data >>>>>>>>>>>>>>>>");
		initProject(); 
		LOG.info(">>>>>>>>>>>>>> Done mocking project >>>>>>>>>>>>>");
	}
	
	
	public Project createProject1() throws ParseException{
		
		Project project = new Project();
		project.setImageUrl("http://www.mychildsafety.net/image-files/child_safety.jpg");
		project.setDescription("Child Safety");
		project.setStatus(Status.INPROGRESS);
		project.setExpectedStartDate(Formatter.simpleDateFormat.parse("2016-09-10"));
		project.setExpectedEndDate(Formatter.simpleDateFormat.parse("2016-10-10"));
		project.setLocation("Farefield");
		
		
		return projectService.save(project);
	}
	
	public Project createProject2() throws ParseException{
		
		Project project = new Project();
		project.setImageUrl("https://image.freepik.com/free-vector/green-city_23-2147516165.jpg");
		project.setDescription("Green City");
		project.setStatus(Status.PENDDING);
		project.setExpectedStartDate(Formatter.simpleDateFormat.parse("2016-12-10"));
		project.setExpectedEndDate(Formatter.simpleDateFormat.parse("2017-10-10"));
		project.setLocation("Cambodia");
		
		
		return projectService.save(project); 
	}
	
	@Transactional
	public void initProject() throws ParseException {
		createProject1();
		createProject2();
	}
}
