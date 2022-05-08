package com.ims.api.jakarta.entities.rest.response.basic;

import java.io.Serializable;

public class JwtResponse extends IMSBasicResponse implements Serializable {
	
	private static final long serialVersionUID = -8091879091924046844L;
	
	private final String jwttoken;
	
	
	public JwtResponse(Long id, boolean success, String message,String jwttoken) {
		super(success, id, message);
		this.jwttoken = jwttoken;
	}

 	
	public JwtResponse(Long id, String jwttoken) {
		super(true, id, "Token has been generated!");
		this.jwttoken = jwttoken;
	}
	
	
	public String getToken() {
		return this.jwttoken;
	}

}
