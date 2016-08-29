package com.findme.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.findme.domain.Appointment;
import com.findme.domain.Professional;
import com.findme.domain.Status;
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
		return "professional_dashboard";
	}
	
	@RequestMapping(value="/appointment/add", method = RequestMethod.POST)
	public String addProfessional(HttpServletRequest request, Appointment appointment) {	
		String username = ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
		Long professionalId = userAccountService.findUserByUsername(username).getId();
		Professional professional = professionalService.findById(professionalId);
		appointment.setOwner(professional);
		appointment.setStatus(1);
		appointmentService.create(appointment);
		return "redirect:/professionals";
	}
	
	@RequestMapping(value="/appointment/{id}/{status}", method = RequestMethod.POST)
	public String editAppointmentStatus(HttpServletRequest request, @PathVariable Long id, @PathVariable int status) {
		String username = ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
		Long professionalId = userAccountService.findUserByUsername(username).getId();
		Professional professional = professionalService.findById(professionalId);
		//appointmentService.find
		return "redirect:/professionals";
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,false));
	}
}
