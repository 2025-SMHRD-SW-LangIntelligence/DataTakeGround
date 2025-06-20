package com.smhrd.ta.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "occur")
public class OccurEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String occurId;
	
	@Column(nullable = false)
    private String location;
	public String getOccurId() {
		return occurId;
	}
	public void setOccurId(String occurId) {
		this.occurId = occurId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getSagoDate() {
		return sagoDate;
	}
	public void setSagoDate(String sagoDate) {
		this.sagoDate = sagoDate;
	}
	public String getSinkWidth() {
		return sinkWidth;
	}
	public void setSinkWidth(String sinkWidth) {
		this.sinkWidth = sinkWidth;
	}
	public String getSinkExtend() {
		return sinkExtend;
	}
	public void setSinkExtend(String sinkExtend) {
		this.sinkExtend = sinkExtend;
	}
	public String getSinkDepth() {
		return sinkDepth;
	}
	public void setSinkDepth(String sinkDepth) {
		this.sinkDepth = sinkDepth;
	}
	public String getBedId() {
		return bedId;
	}
	public void setBedId(String bedId) {
		this.bedId = bedId;
	}
	public String getSagoDetail() {
		return sagoDetail;
	}
	public void setSagoDetail(String sagoDetail) {
		this.sagoDetail = sagoDetail;
	}
	public String getSagoImgUrl() {
		return sagoImgUrl;
	}
	public void setSagoImgUrl(String sagoImgUrl) {
		this.sagoImgUrl = sagoImgUrl;
	}
	public String getSagoNewsUrl() {
		return sagoNewsUrl;
	}
	public void setSagoNewsUrl(String sagoNewsUrl) {
		this.sagoNewsUrl = sagoNewsUrl;
	}
	public String getDeathCnt() {
		return deathCnt;
	}
	public void setDeathCnt(String deathCnt) {
		this.deathCnt = deathCnt;
	}
	public String getInjuryCnt() {
		return injuryCnt;
	}
	public void setInjuryCnt(String injuryCnt) {
		this.injuryCnt = injuryCnt;
	}
	public String getVehicleCnt() {
		return vehicleCnt;
	}
	public void setVehicleCnt(String vehicleCnt) {
		this.vehicleCnt = vehicleCnt;
	}
	public String getTrStatus() {
		return trStatus;
	}
	public void setTrStatus(String trStatus) {
		this.trStatus = trStatus;
	}
	public String getTrMethod() {
		return trMethod;
	}
	public void setTrMethod(String trMethod) {
		this.trMethod = trMethod;
	}
	public String getTrFnDate() {
		return trFnDate;
	}
	public void setTrFnDate(String trFnDate) {
		this.trFnDate = trFnDate;
	}
	private String latitude;
	private String longitude;
	
	@Column(nullable = false)
    private String sagoDate;
	
    private String sinkWidth;
    private String sinkExtend;
    private String sinkDepth;
	
	@Column(nullable = false)
    private String bedId;
    private String sagoDetail;
    private String sagoImgUrl;
    private String sagoNewsUrl;
    private String deathCnt;
    private String injuryCnt;
    private String vehicleCnt;
    private String trStatus;
    private String trMethod;
    private String trFnDate;
}
