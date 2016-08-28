package com.findme.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.findme.domain.Appointment;
import com.findme.domain.Professional;
import com.findme.service.AppointmentService;
import com.findme.service.ProfessionalService;
import com.findme.service.UserAccountService;

@Controller
@RequestMapping("/professionals")
public class ProfessionalController {
	private static final Logger LOG = Logger.getLogger(ProfessionalController.class);

	@Autowired
	private ProfessionalService professionalService;
	
	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private UserAccountService userAccountService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String getAll(Model model) {	
		String username = ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
		Long professionalId = userAccountService.findUserByUsername(username).getId();
		Professional professional = professionalService.findById(professionalId);
		model.addAttribute("professional", professional);
		System.out.println(professional.getFirstName());
		return "professional_dashboard";
	}
	
	@RequestMapping(value="/appointment/add", method=RequestMethod.POST)
	public String addProfessional(HttpServletRequest request, Appointment appointment) {	
		System.out.println(appointment.getName());
		return "professional_dashboard";
	}
}
