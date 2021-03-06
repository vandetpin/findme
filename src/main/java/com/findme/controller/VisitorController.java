package com.findme.controller;



import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.findme.domain.Address;
import com.findme.domain.UserAccount;
import com.findme.domain.Visitor;
import com.findme.exception.BusinessException;
import com.findme.exception.ObjectNotFoundException;
import com.findme.service.UploadService;
import com.findme.service.UserAccountService;
import com.findme.service.VisitorService;
import com.findme.utils.WebUtils;



@Controller
@RequestMapping("/visitors")
public class VisitorController {
	private static final Logger LOG = Logger.getLogger(VisitorController.class);

	@Autowired
	private VisitorService visitorService;
	
	@Autowired
	private UploadService uploadService;
	
	@Autowired
	private UserAccountService userAccountService;

	@RequestMapping(value="", method=RequestMethod.GET)
	public String getAll(Model model) {	
		String username = WebUtils.getCurrentUserName();
		Long visitorId = userAccountService.findUserByUsername(username).getId();
		Visitor visitor = visitorService.findById(visitorId);
		model.addAttribute("visitor", visitor);
		return "vistor_dashboard";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String visitorSignup() {
		return "visitorSignup";
	}
	
	//TODO add Spring validation
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String visitorSignup(final HttpServletRequest request, Visitor visitor, Address address, 
			UserAccount user, MultipartFile file) throws BusinessException {

		LOG.info(">>>>>>>>>>>> Visitor sign up >>>>>>>>>>>");
		// call upload service to upload image
		String profileImageUrl = uploadService.writeFile(request, file);
		
		visitor.setProfilePicture(profileImageUrl);
		visitor.setAddress(address);
		visitor.setUserAccount(user);
		
		
		visitorService.create(visitor);
		request.getSession().setAttribute(WebUtils.SUCCESS_MESSAGE, "Sign up successful, please login.");
		return "redirect:/login";
	}
	
	@RequestMapping(value="/register/{appointmentId}", method=RequestMethod.GET)
	public String regsiterAppointment(@PathVariable("appointmentId") Long appointmentId) throws ObjectNotFoundException, BusinessException {
		String username = WebUtils.getCurrentUserName();
		Long visitorId = userAccountService.findUserByUsername(username).getId();
		
		visitorService.registerAppoinment(visitorId, appointmentId);
		
		return "redirect:/visitors";
	}
	
	@RequestMapping(value="/appointment/cancel/{visitorId}/{appointmentId}", method=RequestMethod.GET)
	public String cancelAppointment(@PathVariable("appointmentId") Long appointmentId) throws ObjectNotFoundException, BusinessException {
		String username = WebUtils.getCurrentUserName();
		Long visitorId = userAccountService.findUserByUsername(username).getId();
		
		visitorService.deleteVisitorAppointmentByVisitorIdAndAppointmentId(visitorId, appointmentId);
		
		return "redirect:/visitors";
	}
	
	@RequestMapping(value="/connect/{professionalId}", method=RequestMethod.GET)
	public String connectProfessional(@PathVariable("professionalId") Long professionalId) throws BusinessException {
		String username = WebUtils.getCurrentUserName();
		Long visitorId = userAccountService.findUserByUsername(username).getId();
		
		visitorService.connectProfessional(visitorId, professionalId);
		
		return "redirect:/home/details/" + professionalId ;
	}
}
