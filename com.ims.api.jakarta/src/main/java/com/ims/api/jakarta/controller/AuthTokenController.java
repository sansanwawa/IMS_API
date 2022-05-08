package com.ims.api.jakarta.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ims.api.jakarta.config.utils.JwtConfig;
import com.ims.api.jakarta.entities.rest.request.basic.JwtRequest;
import com.ims.api.jakarta.entities.rest.response.basic.JwtResponse;
import com.ims.api.jakarta.services.JwtUserDetailsService;

@RestController
public class AuthTokenController {

	private static final Logger logger = LogManager.getLogger(AuthTokenController.class);
	
	
	private final AtomicLong counter = new AtomicLong();	
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtConfig jwtTokenUtil;
	
	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(counter.getAndIncrement(),token));
	}
	
	
	
	private void authenticate(String username, String password) throws Exception {
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			logger.error("USER_DISABLED");
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			logger.error("INVALID_CREDENTIALS");
			throw new Exception("INVALID_CREDENTIALS", e);
		}
		
	}	

}
