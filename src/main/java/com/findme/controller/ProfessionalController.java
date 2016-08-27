package com.findme.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.findme.service.ProfessionalService;

@Controller
@RequestMapping("/professional")
public class ProfessionalController {
	private static final Logger LOG = Logger.getLogger(ProfessionalController.class);

	@Autowired
	private ProfessionalService professionalService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String getAll(Model model) {	
		
		return "professional_dashboard";
	}
}
