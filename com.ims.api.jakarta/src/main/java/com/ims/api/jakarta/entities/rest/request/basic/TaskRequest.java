package com.ims.api.jakarta.entities.rest.request.basic;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL) 
public class TaskRequest {


	@JsonProperty("taskId")
	private Long taskId;
		
	@JsonProperty("ticketID")
	private String ticketID;
	
	@JsonProperty("MID")
	private String MID;
		
	@JsonProperty("TID")
	private String TID;

	@JsonProperty("taskType")
	private String taskType;

	@JsonProperty("page")
	private Integer page;

	
	@JsonProperty("taskInMonth")
	private Integer taskInMonth;
	
	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getTicketID() {
		return ticketID;
	}

	public void setTicketID(String ticketID) {
		this.ticketID = ticketID;
	}

	public String getMID() {
		return MID;
	}

	public void setMID(String mID) {
		MID = mID;
	}

	public String getTID() {
		return TID;
	}

	public void setTID(String tID) {
		TID = tID;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getTaskInMonth() {
		return taskInMonth;
	}

	public void setTaskInMonth(Integer taskInMonth) {
		this.taskInMonth = taskInMonth;
	}
	

}
