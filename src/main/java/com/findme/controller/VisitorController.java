package com.findme.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.findme.service.VisitorService;

@Controller
@RequestMapping("/visitors")
public class VisitorController {
	private static final Logger LOG = Logger.getLogger(VisitorController.class);

	@Autowired
	private VisitorService visitorService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String getAll(Model model) {	
		
		return "vistor_dashboard";
	}
}
