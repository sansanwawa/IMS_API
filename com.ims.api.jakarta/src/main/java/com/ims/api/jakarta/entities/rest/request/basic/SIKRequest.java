package com.ims.api.jakarta.entities.rest.request.basic;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Id;
import javax.persistence.Temporal;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ims.api.jakarta.entities.embedded.InsertAccess;

@JsonInclude(JsonInclude.Include.NON_NULL) 
public class SIKRequest {


	@JsonProperty("SIKNumber")
	private String SIKNumber;
	
	@JsonProperty("MID")
	private String MID;
	
	@JsonProperty("TID")
	private String TID;
	
	@JsonProperty("requestType")
	private String requestType;
	
	
	@JsonProperty("requestDate")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date requestDate;
	
	@JsonProperty("EDCOwner")
	private String EDCOwner; //peruntukkanEDC
	

	@JsonProperty("BRIDebet")
	private String BRIDebet; //kartuDebetBRI
	
	
	@JsonProperty("BRICredit")
	private String BRICredit; //kartuKreditBRI
	
	
	@JsonProperty("brizzi")
	private String brizzi; //kartuBrizzi
	
	@JsonProperty("othersCard")
	private String othersCard; //kartuBankLain
	
	@JsonProperty("commType")
	private String commType; //jarkomEDC
	
	
	@JsonProperty("merchant")
	private String merchant;
	
	@JsonProperty("address")
	private String address;
	
	
	@JsonProperty("city")
	private String city;
	
	@JsonProperty("phoneNumber")
	private String phoneNumber;
	
	@JsonProperty("implementationDate")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date implementationDate;
	
	@JsonProperty("merchantGroup")
	private String merchantGroup;
 	
	@JsonProperty("workUnitRecommendation")
	@Column(name = "workUnitRecommendation")
	private String workUnitRecommendation; //ukerPerekomendasi
	
	@JsonProperty("eventPeriod")
	private String eventPeriod;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("dateStatus")
	private Date dateStatus;
	
	
	@JsonProperty("sn")
	private String SN;
	
	@JsonProperty("iccid")
	private String ICCID;
	
	@JsonProperty("pic")
	private String pic;
	
	
	@JsonProperty("refId")
	private String refId;

	public String getSIKNumber() {
		return SIKNumber;
	}

	public void setSIKNumber(String sIKNumber) {
		SIKNumber = sIKNumber;
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

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public String getEDCOwner() {
		return EDCOwner;
	}

	public void setEDCOwner(String eDCOwner) {
		EDCOwner = eDCOwner;
	}

	public String getBRIDebet() {
		return BRIDebet;
	}

	public void setBRIDebet(String bRIDebet) {
		BRIDebet = bRIDebet;
	}

	public String getBRICredit() {
		return BRICredit;
	}

	public void setBRICredit(String bRICredit) {
		BRICredit = bRICredit;
	}

	public String getBrizzi() {
		return brizzi;
	}

	public void setBrizzi(String brizzi) {
		this.brizzi = brizzi;
	}

	public String getOthersCard() {
		return othersCard;
	}

	public void setOthersCard(String othersCard) {
		this.othersCard = othersCard;
	}

	public String getCommType() {
		return commType;
	}

	public void setCommType(String commType) {
		this.commType = commType;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getImplementationDate() {
		return implementationDate;
	}

	public void setImplementationDate(Date implementationDate) {
		this.implementationDate = implementationDate;
	}

	public String getMerchantGroup() {
		return merchantGroup;
	}

	public void setMerchantGroup(String merchantGroup) {
		this.merchantGroup = merchantGroup;
	}

	public String getWorkUnitRecommendation() {
		return workUnitRecommendation;
	}

	public void setWorkUnitRecommendation(String workUnitRecommendation) {
		this.workUnitRecommendation = workUnitRecommendation;
	}

	public String getEventPeriod() {
		return eventPeriod;
	}

	public void setEventPeriod(String eventPeriod) {
		this.eventPeriod = eventPeriod;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDateStatus() {
		return dateStatus;
	}

	public void setDateStatus(Date dateStatus) {
		this.dateStatus = dateStatus;
	}

	public String getSN() {
		return SN;
	}

	public void setSN(String sN) {
		SN = sN;
	}

	public String getICCID() {
		return ICCID;
	}

	public void setICCID(String iCCID) {
		ICCID = iCCID;
	}

	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}
	
	
	
	
		
	
	
	

}
