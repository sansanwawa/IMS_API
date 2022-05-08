package com.ims.api.jakarta.entities.rest.response.basic;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class IMSBasicResponse {
	
	private Long id;
	private Long total;
	private String message;
	private Object data;
	private List datas;
	
	
	private boolean success;
	
	public IMSBasicResponse(boolean success, Long id, String message) {
		this.success = success;
		this.id = id;
		this.message = message;
	}
	
	public IMSBasicResponse(boolean success, Long id, Object obj) {
		this.success = success;
		this.id = id;
		this.data = obj;
	}

	public IMSBasicResponse(boolean success, Long id, List objs) {
		this.success = success;
		this.id = id;
		this.datas = objs;
	}
	
	public IMSBasicResponse(boolean success, Long id, List objs, Long total) {
		this.success = success;
		this.id = id;
		this.datas = objs;
		this.total = total;
	}
	
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public List getDatas() {
		return datas;
	}

	public void setDatas(List datas) {
		this.datas = datas;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	
	
 	
	/*
	public String toString(){
		return String.format("id=%d success=%s message=%s", id, String.valueOf(success) , message);  
	}  
	 */
}
