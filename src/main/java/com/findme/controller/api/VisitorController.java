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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.findme.dao.ProfessionalDAO;
import com.findme.json.JAppointment;
import com.findme.json.JAppointmentDetail;
import com.findme.json.JProfessionalAppointment;
import com.findme.json.JVisitorAppointment;
import com.findme.service.ProfessionalService;
import com.findme.service.UserAccountService;
import com.findme.service.VisitorService;
import com.findme.utils.Formatter;
import com.findme.utils.WebUtils;

@Controller("visitorControllerAPI")
@RequestMapping("/visitors")
public class VisitorController {
	private static final Logger LOG = Logger.getLogger(VisitorController.class);

	@Autowired
	private VisitorService visitorService;
	
	@Autowired
	private UserAccountService userAccountService;
	
	@Autowired
	private ProfessionalService professionalService;
	
	/**
	 * Get List appointments of a client
	 * 
	 * @param startDate optional 'yyyy-MM-dd HH:mm:ss'
	 * @param startDate optional 'yyyy-MM-dd HH:mm:ss'
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value="/api/appointments", method=RequestMethod.GET)
	public ResponseEntity<Collection<JAppointmentDetail>> getAppointmentById(
			@RequestParam(value="startDate", required = false) String requestStartDate, 
			@RequestParam(value="endDate", required = false) String requestEndDate) throws ParseException {
		
		//TODO do a generic method get professionalId
		String username = ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
		Long userId = userAccountService.findUserByUsername(username).getId();
		
		//TODO apply Spring validation
		if(!StringUtils.isEmpty(requestEndDate) && !StringUtils.isEmpty(requestStartDate)) {
			Date startDate = Formatter.dateTimeFormat.parse(requestStartDate);
			Date endDate = Formatter.dateTimeFormat.parse(requestEndDate);
			
			return new ResponseEntity<>(visitorService.findByVisitor(userId, startDate, endDate), HttpStatus.OK);
		}
		
		return new ResponseEntity<>(visitorService.findByVisitor(userId), HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value="/api/professionals", method=RequestMethod.GET)
	public ResponseEntity<Collection<JProfessionalAppointment>> getProfessionalByVisitor(){
		String username = WebUtils.getCurrentUserName();
		Long visitorId = userAccountService.findUserByUsername(username).getId();
		return new ResponseEntity<>(professionalService.findProfessionalByVisitorId(visitorId), HttpStatus.OK);
	}
}
