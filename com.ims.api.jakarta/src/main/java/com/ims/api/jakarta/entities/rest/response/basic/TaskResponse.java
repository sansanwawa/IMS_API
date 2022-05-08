package com.ims.api.jakarta.entities.rest.response.basic;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.ims.api.jakarta.entities.embedded.InsertAccess;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskResponse {

	private String taskID;
	private String merchant;
	private String MID;
	private String TID;
	private String taskType;
	private String photo0;
	private String photo1;
	private String photo2;
	private String photo3;
	private String photo4;
	private String photo5;
	private String signature;
	private String ticketID;
	private String longitude;
	private String latitude;
	private String SNOld;
	private String SNNew;
	private String taskStatus;
	private String note;
	private String taskDetail;
	private String merchantCondition;
	private String EDCCondition;
	private String merchantInfo;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date dateTimeStatus;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date insertTime;
	
	private String pdf;
	
	
	
	public String getTaskID() {
		return taskID;
	}
	public void setTaskID(String taskID) {
		this.taskID = taskID;
	}
	public String getMerchant() {
		return merchant;
	}
	public void setMerchant(String merchant) {
		this.merchant = merchant;
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
	public String getPhoto0() {
		return photo0;
	}
	public void setPhoto0(String photo0) {
		this.photo0 = photo0;
	}
	public String getPhoto1() {
		return photo1;
	}
	public void setPhoto1(String photo1) {
		this.photo1 = photo1;
	}
	public String getPhoto2() {
		return photo2;
	}
	public void setPhoto2(String photo2) {
		this.photo2 = photo2;
	}
	public String getPhoto3() {
		return photo3;
	}
	public void setPhoto3(String photo3) {
		this.photo3 = photo3;
	}
	public String getPhoto4() {
		return photo4;
	}
	public void setPhoto4(String photo4) {
		this.photo4 = photo4;
	}
	public String getPhoto5() {
		return photo5;
	}
	public void setPhoto5(String photo5) {
		this.photo5 = photo5;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getTicketID() {
		return ticketID;
	}
	public void setTicketID(String ticketID) {
		this.ticketID = ticketID;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getSNOld() {
		return SNOld;
	}
	public void setSNOld(String sNOld) {
		SNOld = sNOld;
	}
	public String getSNNew() {
		return SNNew;
	}
	public void setSNNew(String sNNew) {
		SNNew = sNNew;
	}
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getTaskDetail() {
		return taskDetail;
	}
	public void setTaskDetail(String taskDetail) {
		this.taskDetail = taskDetail;
	}
	public String getMerchantCondition() {
		return merchantCondition;
	}
	public void setMerchantCondition(String merchantCondition) {
		this.merchantCondition = merchantCondition;
	}
	public String getEDCCondition() {
		return EDCCondition;
	}
	public void setEDCCondition(String eDCCondition) {
		EDCCondition = eDCCondition;
	}
	public String getMerchantInfo() {
		return merchantInfo;
	}
	public void setMerchantInfo(String merchantInfo) {
		this.merchantInfo = merchantInfo;
	}
	public String getTaskType() {
		return taskType;
	}
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
	public Date getDateTimeStatus() {
		return dateTimeStatus;
	}
	public void setDateTimeStatus(Date dateTimeStatus) {
		this.dateTimeStatus = dateTimeStatus;
	}
	public Date getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
	public String getPdf() {
		return pdf;
	}
	public void setPdf(String pdf) {
		this.pdf = pdf;
	}
	
	
	

}
