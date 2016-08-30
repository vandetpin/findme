package com.findme.controller;



import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.findme.service.ProfessionalService;
import com.findme.service.UserAccountService;

@Controller("adminController")
@RequestMapping("/admin")
public class AdminController {
	private static final Logger LOG = Logger.getLogger(AdminController.class);

	@Autowired
	private ProfessionalService professionalService;
	
	@Autowired
	private UserAccountService userAccountService;
	
	@RequestMapping(value="/professionals/{professionalId}/{isActive}", method=RequestMethod.GET)
	public String updateProfessionalStatus(@PathVariable("professionalId") Long professionalId, 
			@PathVariable("isActive") Boolean isActive){
		LOG.info(">>>>>>>>>>>> Update professional status >>>>>>>>>>>");
		LOG.info(String.format("Param[professionalId=%s, isActive=%s]", professionalId, isActive));

		professionalService.updateStatus(professionalId, isActive);
		
		return "redirect:/admin";
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String homePage(ModelMap model, HttpSession session) {
		String username = ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
		com.findme.domain.User user = userAccountService.findUserByUsername(username);
		session.setAttribute("loggedUser", user);
		model.addAttribute("professionals",professionalService.findAll());
        return "home";
    }
	
}
