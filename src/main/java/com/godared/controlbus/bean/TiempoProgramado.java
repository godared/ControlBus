package com.godared.controlbus.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class TiempoProgramado implements Serializable {
	@Id 
	@GeneratedValue
	private int TiPrId;
	private int BuId;
	private int TiSaId;
	private int UsId;
	private Date UsFechaReg;
	
	@JsonProperty("TiPrId")
	public int getTiPrId() {
		return TiPrId;
	}
	public void setTiPrId(int tiPrId) {
		TiPrId = tiPrId;
	}
	@JsonProperty("BuId")
	public int getBuId() {
		return BuId;
	}
	public void setBuId(int buId) {
		BuId = buId;
	}
	@JsonProperty("TiSaId")
	public int getTiSaId() {
		return TiSaId;
	}
	public void setTiSaId(int tiSaId) {
		TiSaId = tiSaId;
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
