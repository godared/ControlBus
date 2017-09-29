package com.godared.controlbus.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
public class Usuario implements Serializable {
	@Id 
	@GeneratedValue
	private int UsId;
	private int EmPeId;
	private String UsUserName;
	private String UsPassword;
	private Boolean UsActivo;
	private int UsId2;
	private Date UsFechaReg;
	
	@JsonProperty("UsId")
	public int getUsId() {
		return UsId;
	}
	public void setUsId(int usId) {
		UsId = usId;
	}
	@JsonProperty("EmPeId")
	public int getEmPeId() {
		return EmPeId;
	}
	public void setEmPeId(int emPeId) {
		EmPeId = emPeId;
	}
	@JsonProperty("UsUserName")
	public String getUsUserName() {
		return UsUserName;
	}
	public void setUsUserName(String usUserName) {
		UsUserName = usUserName;
	}
	@JsonProperty("UsPassword")
	public String getUsPassword() {
		return UsPassword;
	}
	public void setUsPassword(String usPassword) {
		UsPassword = usPassword;
	}
	@JsonProperty("UsActivo")
	public Boolean getUsActivo() {
		return UsActivo;
	}
	public void setUsActivo(Boolean usActivo) {
		UsActivo = usActivo;
	}
	@JsonProperty("UsId2")
	public int getUsId2() {
		return UsId2;
	}
	public void setUsId2(int usId2) {
		UsId2 = usId2;
	}
	@JsonProperty("UsFechaReg")
	public Date getUsFechaReg() {
		return UsFechaReg;
	}
	public void setUsFechaReg(Date usFechaReg) {
		UsFechaReg = usFechaReg;
	}
	
	 
}
