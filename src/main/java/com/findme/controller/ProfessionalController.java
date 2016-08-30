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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.findme.domain.Address;
import com.findme.domain.Appointment;
import com.findme.domain.Professional;
import com.findme.domain.ProfessionalType;
import com.findme.domain.Status;
import com.findme.domain.UserAccount;
import com.findme.domain.Visitor;
import com.findme.exception.BusinessException;
import com.findme.service.AppointmentService;
import com.findme.service.ProfessionalService;
import com.findme.service.UploadService;
import com.findme.service.UserAccountService;
import com.findme.utils.WebUtils;

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
	
	@Autowired
	private UploadService uploadService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String getAll(Model model) {	
		String username = WebUtils.getCurrentUserName();
		Long professionalId = userAccountService.findUserByUsername(username).getId();
		Professional professional = professionalService.findById(professionalId);
		model.addAttribute("professional", professional);
		return "professional_dashboard";
	}
	
	@RequestMapping(value="/appointment/add", method = RequestMethod.POST)
	public String addProfessional(HttpServletRequest request, Appointment appointment) {	
		String username = WebUtils.getCurrentUserName();
		Long professionalId = userAccountService.findUserByUsername(username).getId();
		Professional professional = professionalService.findById(professionalId);
		appointment.setOwner(professional);
		appointment.setStatus(1);
		appointmentService.create(appointment);
		return "redirect:/professionals";
	}
	
	@RequestMapping(value="/appointment/{id}/{status}", method = RequestMethod.GET)
	public String editAppointmentStatus(HttpServletRequest request, @PathVariable("id") Long appointmentId, @PathVariable Integer status) {
		String username = WebUtils.getCurrentUserName();
		Long professionalId = userAccountService.findUserByUsername(username).getId();
		
		//check if the appointment found in the professional
		Appointment appoinment = professionalService.findAppointmentByIdAndAppointmentId(professionalId, appointmentId);
		if(appoinment != null) {
			appointmentService.updateStatus(appointmentId, status);
		}
		
		return "redirect:/professionals";
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,false));
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup() {
		return "professionalSignup";
	}
	
	//TODO add Spring validation
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(final HttpServletRequest request, Professional professional, Address address, 
			UserAccount user, MultipartFile file, @RequestParam("professionalType") Integer professionalType) throws BusinessException {

		LOG.info(">>>>>>>>>>>> Professional sign up >>>>>>>>>>>");
		// call upload service to upload image
		String profileImageUrl = uploadService.writeFile(request, file);
		
		professional.setType(ProfessionalType.valueOf(professionalType));
		professional.setProfilePicture(profileImageUrl);
		professional.setAddress(address);
		professional.setUserAccount(user);
		
		
		professionalService.create(professional);
		request.getSession().setAttribute(WebUtils.SUCCESS_MESSAGE, "Sign up successful, please login.");
		return "redirect:/login";
	}
}
