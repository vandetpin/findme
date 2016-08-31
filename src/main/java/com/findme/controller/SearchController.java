package com.findme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.findme.domain.ProfessionalType;
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
	
	@RequestMapping(value="/advance", method=RequestMethod.GET) 
	public String advanceSearch(ModelMap model, @RequestParam(value="byname",required=false,defaultValue="") String byname, @RequestParam(value="byphone", required=false, defaultValue="") String byphone, @RequestParam(value="bytype",required=false, defaultValue="-1") Integer bytype) {			
		
		
		if(!StringUtils.isEmpty(byname) || !StringUtils.isEmpty(byphone) || bytype>0) {	
			System.out.println("code run");
			model.addAttribute("professionals",professionalService.advanceSearch(byname, byphone, bytype));
		} else {
			System.out.println("hello");
		}
		
		return "advancesearch";
		
		
	}
	
	
	
}
