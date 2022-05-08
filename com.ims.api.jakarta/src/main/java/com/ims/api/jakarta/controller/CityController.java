package com.ims.api.jakarta.controller;


import java.util.concurrent.atomic.AtomicLong;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ims.api.jakarta.dao.repository.CityRepository;
import com.ims.api.jakarta.entities.rest.response.basic.IMSBasicResponse;

 

@RestController
public class CityController {

	private final AtomicLong counter = new AtomicLong();	
	
	private static final Logger logger = LogManager.getLogger(CityController.class);
	
	
	@Autowired
	private CityRepository cityDao;
	  
	
	@PostMapping("/city/all")
	public IMSBasicResponse getcities() {
		logger.info("load a city.....");
		boolean isSucces = true;
		return new IMSBasicResponse(isSucces, counter.incrementAndGet(),cityDao.findAll());
	}
	
	 
	 
	
	
}
