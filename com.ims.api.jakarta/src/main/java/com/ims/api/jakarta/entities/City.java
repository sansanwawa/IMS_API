package com.ims.api.jakarta.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="listcity")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class City {
	
	
	@Id
	@Column(name = "cityName")
	private String cityName;
	
	
	@JsonIgnore
	@Column(name = "cityIndopay")
	private String cityIndopay;
	
	@JsonIgnore
	@Column(name = "coverageCity")
	private String coverageCity;
	
	@JsonIgnore
	@Column(name = "servicePoint", columnDefinition = "VARCHAR(30) DEFAULT '-' NOT NULL")
	private String servicePoint;
	
	@JsonIgnore
	@Column(name = "kanwil")
	private String kanwil;
	
	@JsonIgnore
	@Column(name = "kanwilIndopay", columnDefinition = "VARCHAR(30) DEFAULT '-' NOT NULL")
	private String kanwilIndopay;
	
	@Column(name = "province")
	private String province;
	
	@JsonIgnore
	@Column(name = "active", columnDefinition = "TINYINT(1) DEFAULT '1' NOT NULL")
	private boolean active = true;

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityIndopay() {
		return cityIndopay;
	}

	public void setCityIndopay(String cityIndopay) {
		this.cityIndopay = cityIndopay;
	}

	public String getCoverageCity() {
		return coverageCity;
	}

	public void setCoverageCity(String coverageCity) {
		this.coverageCity = coverageCity;
	}

	public String getServicePoint() {
		return servicePoint;
	}

	public void setServicePoint(String servicePoint) {
		this.servicePoint = servicePoint;
	}

	public String getKanwil() {
		return kanwil;
	}

	public void setKanwil(String kanwil) {
		this.kanwil = kanwil;
	}

	public String getKanwilIndopay() {
		return kanwilIndopay;
	}

	public void setKanwilIndopay(String kanwilIndopay) {
		this.kanwilIndopay = kanwilIndopay;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
	
}
