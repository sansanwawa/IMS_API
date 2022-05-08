package com.ims.api.jakarta.entities.rest.request.basic;

import java.util.Date;

import javax.persistence.Column;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL) 
public class SIKCMRequest {
	
	
	@JsonProperty("ticketNumber")
	private String ticketNumber;
	
	@JsonProperty("TID")
	private String tid;
	
	@JsonProperty("MID")
	private String mid;

	@JsonProperty("merchant")
	private String merchant;
	
	@JsonProperty("address")
	private String address;
	
	@JsonProperty("requestDate")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date requestDate;
	
	@JsonProperty("agent")
	private String agent;
	
	@JsonProperty("case")
	private String cases;
	
	@JsonProperty("city")
	private String city;
	
	@JsonProperty("pic")
	private String pic;
	
	@JsonProperty("phoneNumber")
	private String phoneNumber;
	
	@JsonProperty("sn")
	private String sn;
	
	@JsonProperty("note")
	private String note;
	
	@Column(name = "dueDate")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date dueDate;


	
	
	
	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMerchant() {
		return merchant;
	}

	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public String getCases() {
		return cases;
	}

	public void setCases(String cases) {
		this.cases = cases;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	
	
	
	

}
