package com.findme.service.aop;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.findme.dao.ProfessionalDAO;
import com.findme.domain.Professional;
import com.google.common.collect.Iterables;

@Service
@Aspect
public class ProfessionalAdvicer {
	private final Logger LOG = Logger.getLogger(ProfessionalAdvicer.class);
	
	@Autowired
	private ProfessionalDAO professionalDAO; 
	
	@Transactional
	@Around("execution(* com.findme.service.ProfessionalServiceImpl.findAllIncludedRelationshipWithVisitor(..)) || "
			+ "execution(* com.findme.service.ProfessionalServiceImpl.advanceSearchIncludedRelationshipWithVisitor(..)) ||" 
			+ "execution(* com.findme.service.ProfessionalServiceImpl.findByFirstNameOrLastNameContainingIncludedRelationshipWithVisitor(..))")
public Iterable<Professional> addConnectionStatus(ProceedingJoinPoint pjp) throws Throwable {
		
		LOG.info(">>>>>>>>>>> Start professional advicer >>>>>>>>>>>>>");
		LOG.info(">>>>>>>>>>> addConnectionStatus advice >>>>>>>>>>>>>");
		// all profs
		Iterable<Professional> allProfs = (Iterable<Professional>) pjp.proceed();
		
		// get List of professionals of visitor
		Long visitorId = (Long)pjp.getArgs()[0];
		Iterable<Professional> connectedProfs = professionalDAO.findByVisitorId(visitorId);
		
		for(Professional p : allProfs) {
			if(Iterables.contains(connectedProfs, p)) {
				p.setConnected(true);
			} else {
				p.setConnected(false);
			}
		}
		
		return allProfs;
	}
}
