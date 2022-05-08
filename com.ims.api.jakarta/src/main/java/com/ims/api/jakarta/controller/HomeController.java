package com.ims.api.jakarta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ims.api.jakarta.entities.SIK;
import com.ims.api.jakarta.entities.rest.response.basic.IMSBasicResponse;

@Controller
public class HomeController {

	@GetMapping("/")
	public String index() {
		//loaded index.html
		return "index";
	}
	
	

}
