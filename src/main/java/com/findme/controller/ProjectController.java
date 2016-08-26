package com.findme.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.findme.service.ProjectService;


@Controller
@RequestMapping("/projects")
public class ProjectController {
	private static final Logger LOG = Logger.getLogger(ProjectController.class);
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String getAll(Model model) {
		LOG.info(">>>>> list project >>>>>>");
		model.addAttribute("projects", projectService.findAll());
		return "projectList";
	}
}
