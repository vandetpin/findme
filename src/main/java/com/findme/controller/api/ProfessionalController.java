package com.findme.controller.api;

import java.text.ParseException;
import java.util.Collection;
import java.util.Date;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.findme.json.JAppointment;
import com.findme.json.JProfessionalAppointment;
import com.findme.json.JVisitorAppointment;
import com.findme.service.ProfessionalService;
import com.findme.service.UserAccountService;
import com.findme.utils.Formatter;
import com.findme.utils.WebUtils;

@Controller("professionalControllerAPI")
@RequestMapping("/professionals")
public class ProfessionalController {
	private static final Logger LOG = Logger.getLogger(ProfessionalController.class);

	@Autowired
	private ProfessionalService professionalService;
	
	@Autowired
	private UserAccountService userAccountService;
	
	
	/**
	 * Get List appointments by professional
	 * 
	 * @param startDate optional 'yyyy-MM-dd HH:mm:ss'
	 * @param startDate optional 'yyyy-MM-dd HH:mm:ss'
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value="/api/appointments", method=RequestMethod.GET)
	public ResponseEntity<Collection<JAppointment>> getAppointmentById(
			@RequestParam(value="startDate", required = false) String requestStartDate, @RequestParam(value="endDate", required = false) String requestEndDate) throws ParseException {
		
		//TODO do a generic method get professionalId
		String username = ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
		Long professionalId = userAccountService.findUserByUsername(username).getId();
		
		//TODO apply Spring validation
		if(!StringUtils.isEmpty(requestEndDate) && !StringUtils.isEmpty(requestStartDate)) {
			Date startDate = Formatter.dateTimeFormat.parse(requestStartDate);
			Date endDate = Formatter.dateTimeFormat.parse(requestEndDate);
			
			return new ResponseEntity<>(professionalService.findByProfessional(professionalId, startDate, endDate), HttpStatus.OK);
		}
		
		return new ResponseEntity<>(professionalService.findByProfessional(professionalId), HttpStatus.OK);
		
	}
	
	/**
	 * 
	 * Search professional's client by their firstName, lastName
	 * 
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	@RequestMapping(value="/api/visitors", method=RequestMethod.GET)
	public ResponseEntity<Collection<JVisitorAppointment>> getVisitorByFirstNameOrLastName(
			@RequestParam(value="firstName") String visitorFirstName, 
			@RequestParam(value="lastName") String visitorLastName) {
		
		//TODO do a generic method get professionalId
		String username = ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
		Long professionalId = userAccountService.findUserByUsername(username).getId();
		
		return new ResponseEntity<>(professionalService.findVisitorByIdAndFirstNameOrLastNameContaining(professionalId, visitorFirstName, visitorLastName), HttpStatus.OK);
	} 
	
}
