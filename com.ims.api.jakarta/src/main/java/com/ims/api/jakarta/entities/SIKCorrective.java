package com.ims.api.jakarta.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.ims.api.jakarta.entities.embedded.InsertAccess;

@Entity
@Table(name="bri_sik_corrective")
@JsonInclude(JsonInclude.Include.NON_NULL) 
public class SIKCorrective {

	@Id
	@Column(name = "tiketNumber")
	private String tiketNumber;
	
	@Column(name = "TID")
	private String tid;
	
	@Column(name = "MID")
	private String mid;

	@Column(name = "merchantName")
	private String merchantName;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "requestDate")
	@Temporal(value = javax.persistence.TemporalType.TIMESTAMP)
	private Date requestDate;
	
	@Column(name = "agent")
	private String agent;
	
	@Column(name = "`case`")
	private String cases;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "pic")
	private String pic;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	@Column(name = "sn")
	private String sn;
	
	@Column(name = "note")
	private String note;
	
	@Column(name = "dueDate")
	@Temporal(value = javax.persistence.TemporalType.TIMESTAMP)
	private Date dueDate;
	
	@Column(name = "client", columnDefinition = "VARCHAR(8)")
	private String client;
	
	
	@Column(name = "servicePoint")
	private String servicePoint;
	
	@Column(name = "kanwilIndopay")
	private String kanwilIndopay;

	@Column(name = "`status`")
	private String status;
	
	
	
	@Embedded
	private InsertAccess insertAccess;

	public String getTiketNumber() {
		return tiketNumber;
	}

	public void setTiketNumber(String tiketNumber) {
		this.tiketNumber = tiketNumber;
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

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
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

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public InsertAccess getInsertAccess() {
		return insertAccess;
	}

	public void setInsertAccess(InsertAccess insertAccess) {
		this.insertAccess = insertAccess;
	}

	public String getServicePoint() {
		return servicePoint;
	}

	public void setServicePoint(String servicePoint) {
		this.servicePoint = servicePoint;
	}

	public String getKanwilIndopay() {
		return kanwilIndopay;
	}

	public void setKanwilIndopay(String kanwilIndopay) {
		this.kanwilIndopay = kanwilIndopay;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}	
	
	
	
	
	
	
	
}
