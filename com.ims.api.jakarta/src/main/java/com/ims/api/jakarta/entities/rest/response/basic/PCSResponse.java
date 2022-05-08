package com.ims.api.jakarta.entities.rest.response.basic;

public class PCSResponse{
	
	private int code;
	
	private String message;
	
	public PCSResponse() { }
	
	public PCSResponse(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
