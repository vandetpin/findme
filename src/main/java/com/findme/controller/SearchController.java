package com.findme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.findme.service.ProfessionalService;

@Controller
public class SearchController {
	
	@Autowired
	ProfessionalService professionalService;
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
    public String homePage(ModelMap model, @RequestParam("s") String s) {	
		
		System.out.println(s);
		model.addAttribute("professionals",professionalService.findByFirstNameOrLastNameContaining(s, s));
		
		
        return "search";
    }
	
	@RequestMapping(value="/search/advance", method=RequestMethod.GET) 
	public String advanceSearch(ModelMap model, @RequestParam("byname") String byname, @RequestParam("bycity") String bycity, @RequestParam("bytype") String bytype) {			
		return "advancesearch";
	}
	
	
	
}
