package com.findme.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.findme.domain.Professional;
import com.findme.domain.User;
import com.findme.service.ProfessionalService;
import com.findme.service.UserAccountService;
import com.findme.utils.WebUtils;

@Controller
public class HomeController {
	private static final Logger LOG = Logger.getLogger(HomeController.class);
	 
	@Autowired
	ProfessionalService professionalService;
	
	@Autowired
	private UserAccountService userAccountService;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
    public String homePage(ModelMap model, HttpSession session) {
		String username = WebUtils.getCurrentUserName();
		Iterable<Professional> allProfs = professionalService.findAll();
		
		if(username != null){
			if(username.equals("admin")) {
				session.setAttribute("loggedAdmin", "admin");
			}else{
				User user = userAccountService.findUserByUsername(username);
				session.setAttribute("loggedUser", user);
				allProfs = professionalService.findAllIncludedRelationshipWithVisitor(user.getId());
			}
		}
		model.addAttribute("professionals", allProfs);
        return "home";
    }
	
	
	@RequestMapping(value="/home/details/{id}", method=RequestMethod.GET)
	public String detailsById(ModelMap model, @PathVariable("id") Long id) {
		model.addAttribute("professional",professionalService.findById(id));
		model.addAttribute("totalClient",professionalService.findByProfessional(id));
		return "details";
	}
	
	
	
	
}
