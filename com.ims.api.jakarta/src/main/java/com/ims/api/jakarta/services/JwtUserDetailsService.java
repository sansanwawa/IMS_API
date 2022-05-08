package com.ims.api.jakarta.services;

import java.util.ArrayList;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.ims.api.jakarta.dao.repository.ApiCredentialRepository;
import com.ims.api.jakarta.entities.ApiCredentials;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	
	private static final Logger logger = LogManager.getLogger(JwtUserDetailsService.class);
	
	
	@Autowired
	private ApiCredentialRepository apiDao;
	 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 
		
		Optional<ApiCredentials> credentials = apiDao.findById(username);
		if(credentials.isPresent()) {
			ApiCredentials cred = credentials.get();
			return new User(cred.getUsername(), cred.getPassword(), 
					new ArrayList<>());
		}else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		
		
	
	}


}
