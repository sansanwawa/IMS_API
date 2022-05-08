package com.ims.api.jakarta.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.ims.api.jakarta.dao.listeners.TaskListeners;
import com.ims.api.jakarta.entities.embedded.InsertAccess;


//@EntityListeners(TaskListeners.class)


@Entity
@Table(name = "task")
@JsonInclude(JsonInclude.Include.NON_NULL) 
public class Task {
	
	private static final long serialVersionUID = 1L;
	 
	@Id 
	@GeneratedValue
	@Column(name = "taskId")
	private Long taskId;
	private int counterMerchant;
	private String SPKKey;
	private String SPKNumber;
	private String TID;
	private String MID;
	private String client;
	private String terminalName;
	private String address1;
	private String address2;
	private String city;
	private String PIC;
	private String phone;
	@Column(name = "SNOld", columnDefinition = "VARCHAR(50) DEFAULT '-' NOT NULL")
	private String SNOld = "-";
	private String SNNew;
	private String ICCIDOld;
	private String ICCIDNew;
	private String sn_photo;
	
	
	
	@Column(name = "mandiri_special", columnDefinition="TEXT")
	private String mandiri_special;
	
	 
	private String photo0;
	private String photo1;
	private String photo2;
	private String photo3;
	private String photo4;
	private String photo5;
	private String signature;
	private String testTransaksi;
	private String merchantCondition;
	private String EDCCondition;
	private String dongleCondition;
	private String reason;
	private String merchantInfo;
	private String EDCOtherBank;
	private String bankType; //mandiri, existing, bri
	private String taskType; //deploy, pullout, maintenance
	private String taskStatus;
	private String commType;	
	private String appVersion;
	private String creditCardResponseTime;
	private String debitCardResponseTime;	
	private String trainingAttendance;
	private String hasAnAdaptor;
	@Column(name = "batch_no")
	private Integer batch_no;
	
	@Column(name = "flag", columnDefinition = "VARCHAR(50) DEFAULT NULL")
	private String flag;
	
	@Column(name = "ticketID", columnDefinition = "VARCHAR(50) DEFAULT '-' NOT NULL")
	private String ticketID ="-";
	
	@Column(name = "taskDetail", columnDefinition = "VARCHAR(50) DEFAULT '-' NOT NULL")
	private String taskDetail = "-";
	
	
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@Column(name="dateTimeStatus")
	private Date dateTimeStatus;
	
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@Column(name="dueDate")
	private Date dueDate;
	//private String timeStatus;
	
	@Column(name = "longitude", columnDefinition="FLOAT DEFAULT 0 NOT NULL")
	private double longitude;
	@Column(name = "latitude", columnDefinition="FLOAT DEFAULT 0 NOT NULL")
	private double latitude;
	private String username;
	
	private String fieldSupportName;
	
	@Column(name = "taskUpdateDateTime")
	@Temporal(value = javax.persistence.TemporalType.TIMESTAMP)
	private Date taskUpdateDateTime;	
	 
	@Column(name = "servicePoint", columnDefinition = "VARCHAR(30) DEFAULT '-' NOT NULL")
	private String servicePoint;
	
	
	@Column(name = "kanwilIndopay", columnDefinition = "VARCHAR(30) DEFAULT '-' NOT NULL")
	private String kanwilIndopay;
	
	@Column(name = "additionalTid")
	private String additionalTid;
	
 
	@Embedded
	private InsertAccess insertAccess;
	
	@Column(name = "active", columnDefinition = "TINYINT(1) DEFAULT '1' NOT NULL")
	private boolean active = true;
 
	@Column(name = "isMerchantProblem", columnDefinition = "TINYINT(1) DEFAULT '0' NOT NULL")
	private boolean isMerchantProblem = false;
	
	@Column(name = "`case`")
	private String cases;
	
	@Column(name = "subCase")
	private String subCase;
	
	@Column(name = "note")
	private String note;
	
	@JsonIgnore
	@Column(name = "hitToClient", columnDefinition = "TINYINT(1) DEFAULT -1")
	private int hitToClient;	
	

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public int getCounterMerchant() {
		return counterMerchant;
	}

	public void setCounterMerchant(int counterMerchant) {
		this.counterMerchant = counterMerchant;
	}

	public String getSPKKey() {
		return SPKKey;
	}

	public void setSPKKey(String sPKKey) {
		SPKKey = sPKKey;
	}

	public String getSPKNumber() {
		return SPKNumber;
	}

	public void setSPKNumber(String sPKNumber) {
		SPKNumber = sPKNumber;
	}

	public String getTID() {
		return TID;
	}

	public void setTID(String tID) {
		TID = tID;
	}

	public String getMID() {
		return MID;
	}

	public void setMID(String mID) {
		MID = mID;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getTerminalName() {
		return terminalName;
	}

	public void setTerminalName(String terminalName) {
		this.terminalName = terminalName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPIC() {
		return PIC;
	}

	public void setPIC(String pIC) {
		PIC = pIC;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getICCIDOld() {
		return ICCIDOld;
	}

	public void setICCIDOld(String iCCIDOld) {
		ICCIDOld = iCCIDOld;
	}

	public String getICCIDNew() {
		return ICCIDNew;
	}

	public void setICCIDNew(String iCCIDNew) {
		ICCIDNew = iCCIDNew;
	}

	public String getSn_photo() {
		return sn_photo;
	}

	public void setSn_photo(String sn_photo) {
		this.sn_photo = sn_photo;
	}


	public String getMandiri_special() {
		return mandiri_special;
	}

	public void setMandiri_special(String mandiri_special) {
		this.mandiri_special = mandiri_special;
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

	public String getTestTransaksi() {
		return testTransaksi;
	}

	public void setTestTransaksi(String testTransaksi) {
		this.testTransaksi = testTransaksi;
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

	public String getDongleCondition() {
		return dongleCondition;
	}

	public void setDongleCondition(String dongleCondition) {
		this.dongleCondition = dongleCondition;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getMerchantInfo() {
		return merchantInfo;
	}

	public void setMerchantInfo(String merchantInfo) {
		this.merchantInfo = merchantInfo;
	}

	public String getEDCOtherBank() {
		return EDCOtherBank;
	}

	public void setEDCOtherBank(String eDCOtherBank) {
		EDCOtherBank = eDCOtherBank;
	}

	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public String getCommType() {
		return commType;
	}

	public void setCommType(String commType) {
		this.commType = commType;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getCreditCardResponseTime() {
		return creditCardResponseTime;
	}

	public void setCreditCardResponseTime(String creditCardResponseTime) {
		this.creditCardResponseTime = creditCardResponseTime;
	}

	public String getDebitCardResponseTime() {
		return debitCardResponseTime;
	}

	public void setDebitCardResponseTime(String debitCardResponseTime) {
		this.debitCardResponseTime = debitCardResponseTime;
	}

	public String getTrainingAttendance() {
		return trainingAttendance;
	}

	public void setTrainingAttendance(String trainingAttendance) {
		this.trainingAttendance = trainingAttendance;
	}

	public String getHasAnAdaptor() {
		return hasAnAdaptor;
	}

	public void setHasAnAdaptor(String hasAnAdaptor) {
		this.hasAnAdaptor = hasAnAdaptor;
	}

	public Integer getBatch_no() {
		return batch_no;
	}

	public void setBatch_no(Integer batch_no) {
		this.batch_no = batch_no;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getTicketID() {
		return ticketID;
	}

	public void setTicketID(String ticketID) {
		this.ticketID = ticketID;
	}

	public String getTaskDetail() {
		return taskDetail;
	}

	public void setTaskDetail(String taskDetail) {
		this.taskDetail = taskDetail;
	}

	public Date getDateTimeStatus() {
		return dateTimeStatus;
	}

	public void setDateTimeStatus(Date dateTimeStatus) {
		this.dateTimeStatus = dateTimeStatus;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFieldSupportName() {
		return fieldSupportName;
	}

	public void setFieldSupportName(String fieldSupportName) {
		this.fieldSupportName = fieldSupportName;
	}

	public Date getTaskUpdateDateTime() {
		return taskUpdateDateTime;
	}

	public void setTaskUpdateDateTime(Date taskUpdateDateTime) {
		this.taskUpdateDateTime = taskUpdateDateTime;
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

	public String getAdditionalTid() {
		return additionalTid;
	}

	public void setAdditionalTid(String additionalTid) {
		this.additionalTid = additionalTid;
	}

	public InsertAccess getInsertAccess() {
		return insertAccess;
	}

	public void setInsertAccess(InsertAccess insertAccess) {
		this.insertAccess = insertAccess;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isMerchantProblem() {
		return isMerchantProblem;
	}

	public void setMerchantProblem(boolean isMerchantProblem) {
		this.isMerchantProblem = isMerchantProblem;
	}


	public String getCases() {
		return cases;
	}

	public void setCases(String cases) {
		this.cases = cases;
	}

	public String getSubCase() {
		return subCase;
	}

	public void setSubCase(String subCase) {
		this.subCase = subCase;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getHitToClient() {
		return hitToClient;
	}

	public void setHitToClient(int hitToClient) {
		this.hitToClient = hitToClient;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	
	
	
	
	

}
