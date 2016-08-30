package com.findme.controller;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.findme.service.ProfessionalService;

@Controller("adminController")
@RequestMapping("/admin")
public class AdminController {
	private static final Logger LOG = Logger.getLogger(AdminController.class);

	@Autowired
	private ProfessionalService professionalService;
	
	@RequestMapping(value="/professionals/{professionalId}/{isActive}", method=RequestMethod.GET)
	public String updateProfessionalStatus(@PathVariable("professionalId") Long professionalId, 
			@PathVariable("isActive") Boolean isActive){
		LOG.info(">>>>>>>>>>>> Update professional status >>>>>>>>>>>");
		LOG.info(String.format("Param[professionalId=%s, isActive=%s]", professionalId, isActive));

		professionalService.updateStatus(professionalId, isActive);
		
		return "redirect:/admin";
	}
	
}
