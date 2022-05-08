package com.ims.api.jakarta.config;

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ims.api.jakarta.entities.rest.response.basic.IMSBasicResponse;

/**
 * 
 * @author sandy
 * @Component need to be added,if not @Autowired could not work well
 */

@Component
public class JwtAuthenticationEntryPoint  implements AuthenticationEntryPoint, Serializable {
	
	private static final long serialVersionUID = -7858869558953243875L;
	private final AtomicLong counter = new AtomicLong();	
	
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {
		
		  ObjectMapper mapper = new ObjectMapper();
		  IMSBasicResponse IMSResponse = new IMSBasicResponse(false, counter.incrementAndGet(),authException.getMessage());
		  String message = mapper.writeValueAsString(IMSResponse);
		
		  response.setContentType("application/json");
	      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	      response.getOutputStream().println(message);
		
	}

	  
}