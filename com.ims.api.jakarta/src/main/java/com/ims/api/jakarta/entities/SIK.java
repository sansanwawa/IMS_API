package com.ims.api.jakarta.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ims.api.jakarta.dao.listeners.SIKListeners;
import com.ims.api.jakarta.dao.listeners.TaskListeners;
import com.ims.api.jakarta.entities.embedded.InsertAccess;

//@EntityListeners(SIKListeners.class)
@Entity
@Table(name="brisik")
@JsonInclude(JsonInclude.Include.NON_NULL) 
public class SIK {
 

	@Id
	@Column(name = "SIKKey", columnDefinition = "VARCHAR(80)")
	private String SIKKey;
	
	@JsonProperty("noSIK")
	@Column(name = "noSIK", columnDefinition = "VARCHAR(50)")
	private String noSIK;
	
	@JsonProperty("MID")
	@Column(name = "MID", columnDefinition = "VARCHAR(15)")
	private String MID;
	
	@JsonProperty("TID")
	@Column(name = "TID", columnDefinition = "VARCHAR(8)")
	private String TID;
	
	
	@JsonProperty("statusJOB")
	@Column(name = "statusJOB", columnDefinition = "VARCHAR(15)")
	private String statusJOB;
	
	
	@JsonProperty("tglRequest")
	@Column(name = "tglRequest")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date tglRequest;
	
	
	
	@JsonProperty("peruntukkanEDC")
	@Column(name = "peruntukkanEDC")
	private String peruntukkanEDC;
	

	@JsonProperty("kartuDebetBRI")
	@Column(name = "kartuDebetBRI")
	private String kartuDebetBRI;
	
	@JsonProperty("kartuKreditBRI")
	@Column(name = "kartuKreditBRI")
	private String kartuKreditBRI;
	
	
	@JsonProperty("kartuBrizzi")
	@Column(name = "kartuBrizzi")
	private String kartuBrizzi;
	
	@JsonProperty("kartuBankLain")
	@Column(name = "kartuBankLain")
	private String kartuBankLain;
	
	@JsonProperty("jarkomEDC")
	@Column(name = "jarkomEDC")
	private String jarkomEDC;
	
	
	@JsonProperty("merchant")
	@Column(name = "merchant")
	private String merchant;
	
	@JsonProperty("alamat")
	@Column(name = "alamat")
	private String alamat;
	
	
	@JsonProperty("kota")
	@Column(name = "kota") //kota is comes from original data
	private String kota;

	@Column(name = "city") 
	private String city;
	
	
	@JsonProperty("telp")
	@Column(name = "telp")
	private String telp;
	
	@JsonProperty("tglImplementasi")
	@Column(name = "tglImplementasi")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date tglImplementasi;
	
	@JsonProperty("groupMerchant")
	@Column(name = "groupMerchant")
	private String group;
	
	
	@JsonProperty("kanwil")
	@Column(name = "kanwil")
	private String kanwil;
	
	@JsonProperty("ukerPerekomendasi")
	@Column(name = "ukerPerekomendasi")
	private String ukerPerekomendasi;
	
	@JsonProperty("periodeEvent")
	@Column(name = "periodeEvent")
	private String periodeEvent;
	
	@JsonProperty("status")
	@Column(name = "status")
	private String status;
	
	@JsonProperty("dateStatus")
	@Column(name = "dateStatus")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dateStatus;
	
	
	@JsonProperty("SerialNumber")
	@Column(name = "SerialNumber", columnDefinition = "VARCHAR(30) DEFAULT NULL")
	private String SN;
	
	@JsonProperty("ICCID")
	@Column(name = "ICCID", columnDefinition = "VARCHAR(30) DEFAULT NULL")
	private String ICCID;
	
	
	@Column(name = "client")
	private String client;
	
	
	@Column(name = "servicePoint")
	private String servicePoint;
	
	@Column(name = "kanwilIndopay")
	private String kanwilIndopay;

	
	@Column(name = "refId",columnDefinition = "VARCHAR(20) DEFAULT NULL")
	private String refId;
	
	@Column(name = "PIC")
	private String PIC;
	
	@Embedded
	private InsertAccess insertAccess;
	
	
	
	public String getSIKKey() {
		return SIKKey;
	}
	public void setSIKKey(String sIKKey) {
		SIKKey = sIKKey;
	}
	public String getNoSIK() {
		return noSIK;
	}
	public void setNoSIK(String noSIK) {
		this.noSIK = noSIK;
	}
	
	public String getMID() {
		return MID;
	}
	public void setMID(String MID) {
		this.MID = MID;
	}
	public String getTID() {
		return TID;
	}
	public void setTID(String tID) {
		TID = tID;
	}
	public String getStatusJOB() {
		return statusJOB;
	}
	public void setStatusJOB(String statusJOB) {
		this.statusJOB = statusJOB;
	}
	public Date getTglRequest() {
		return tglRequest;
	}
	public void setTglRequest(Date tglRequest) {
		this.tglRequest = tglRequest;
	}
	public String getPeruntukkanEDC() {
		return peruntukkanEDC;
	}
	public void setPeruntukkanEDC(String peruntukkanEDC) {
		this.peruntukkanEDC = peruntukkanEDC;
	}
	public String getKartuDebetBRI() {
		return kartuDebetBRI;
	}
	public void setKartuDebetBRI(String kartuDebetBRI) {
		this.kartuDebetBRI = kartuDebetBRI;
	}
	public String getKartuKreditBRI() {
		return kartuKreditBRI;
	}
	public void setKartuKreditBRI(String kartuKreditBRI) {
		this.kartuKreditBRI = kartuKreditBRI;
	}
	public String getKartuBrizzi() {
		return kartuBrizzi;
	}
	public void setKartuBrizzi(String kartuBrizzi) {
		this.kartuBrizzi = kartuBrizzi;
	}
	public String getKartuBankLain() {
		return kartuBankLain;
	}
	public void setKartuBankLain(String kartuBankLain) {
		this.kartuBankLain = kartuBankLain;
	}
	public String getJarkomEDC() {
		return jarkomEDC;
	}
	public void setJarkomEDC(String jarkomEDC) {
		this.jarkomEDC = jarkomEDC;
	}
	public String getMerchant() {
		return merchant;
	}
	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public String getKota() {
		return kota;
	}
	public void setKota(String kota) {
		this.kota = kota;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTelp() {
		return telp;
	}
	public void setTelp(String telp) {
		this.telp = telp;
	}
	public Date getTglImplementasi() {
		return tglImplementasi;
	}
	public void setTglImplementasi(Date tglImplementasi) {
		this.tglImplementasi = tglImplementasi;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getKanwil() {
		return kanwil;
	}
	public void setKanwil(String kanwil) {
		this.kanwil = kanwil;
	}
	public String getUkerPerekomendasi() {
		return ukerPerekomendasi;
	}
	public void setUkerPerekomendasi(String ukerPerekomendasi) {
		this.ukerPerekomendasi = ukerPerekomendasi;
	}
	public String getPeriodeEvent() {
		return periodeEvent;
	}
	public void setPeriodeEvent(String periodeEvent) {
		this.periodeEvent = periodeEvent;
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
	public InsertAccess getInsertAccess() {
		return insertAccess;
	}
	public void setInsertAccess(InsertAccess insertAccess) {
		this.insertAccess = insertAccess;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
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
	public String getRefId() {
		return refId;
	}
	public void setRefId(String refId) {
		this.refId = refId;
	}
	public String getPIC() {
		return PIC;
	}
	public void setPIC(String pIC) {
		PIC = pIC;
	}
	 
	
	
	
}
