package com.findme.service;


import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;


@Service
public class MockService {
	
	private static final Logger LOG = Logger.getLogger(MockService.class);
	
	@PostConstruct
	public void initData() {
	}
}
