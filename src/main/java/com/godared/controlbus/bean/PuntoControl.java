package com.godared.controlbus.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class PuntoControl implements Serializable {
	@Id 
	@GeneratedValue
	private int PuCoId;
	private int RuId;
	private Date PuCoTiempoBus;
	private String PuCoClase;
	private int  UsId;
	private Date UsFechaReg;
	
	@JsonProperty("PuCoId")
	public int getPuCoId() {
		return PuCoId;
	}
	public void setPuCoId(int puCoId) {
		PuCoId = puCoId;
	}
	@JsonProperty("RuId")
	public int getRuId() {
		return RuId;
	}
	public void setRuId(int ruId) {
		RuId = ruId;
	}
	@JsonProperty("PuCoTiempoBus")
	public Date getPuCoTiempoBus() {
		return PuCoTiempoBus;
	}
	public void setPuCoTiempoBus(Date puCoTiempoBus) {
		PuCoTiempoBus = puCoTiempoBus;
	}
	@JsonProperty("PuCoClase")
	public String getPuCoClase() {
		return PuCoClase;
	}
	public void setPuCoClase(String puCoClase) {
		PuCoClase = puCoClase;
	}
	@JsonProperty("UsId")
	public int getUsId() {
		return UsId;
	}
	public void setUsId(int usId) {
		UsId = usId;
	}
	@JsonProperty("UsFechaReg")
	public Date getUsFechaReg() {
		return UsFechaReg;
	}
	public void setUsFechaReg(Date usFechaReg) {
		UsFechaReg = usFechaReg;
	}
	
}
