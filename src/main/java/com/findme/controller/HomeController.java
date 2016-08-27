package com.findme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.findme.service.ProfessionalService;

@Controller
public class HomeController {
	
	@Autowired
	ProfessionalService professionalService;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
    public String homePage(ModelMap model) {
		model.addAttribute("professionals",professionalService.findAll());
        return "home";
    }
	
	
	
}
