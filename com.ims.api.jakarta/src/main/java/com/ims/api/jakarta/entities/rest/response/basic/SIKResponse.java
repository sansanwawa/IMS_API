package com.ims.api.jakarta.entities.rest.response.basic;


public class SIKResponse {

	private String SIKNumber;
	
	private String MID;
	
	private String TID;
	
	private String requestType;

	private String merchant;
	
	
	public String getMerchant() {
		return merchant;
	}

	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}

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
	
	 


}
