package com.godared.controlbus.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Telefono implements Serializable{
	@Id 
	@GeneratedValue
	private int TeId;
	private int BuId;
	private String TeMarca;
	private String TeModelo;
	private String TeVersionAndroid;
	private Boolean TeActivo;
	private String TeImei;
	private int UsId;
	private Date UsFechaReg;
	
	@JsonProperty("TeId")
	public int getTeId() {
		return TeId;
	}
	public void setTeId(int teId) {
		TeId = teId;
	}
	@JsonProperty("BuId")
	public int getBuId() {
		return BuId;
	}
	public void setBuId(int buId) {
		BuId = buId;
	}
	@JsonProperty("TeMarca")
	public String getTeMarca() {
		return TeMarca;
	}
	public void setTeMarca(String teMarca) {
		TeMarca = teMarca;
	}
	@JsonProperty("TeModelo")
	public String getTeModelo() {
		return TeModelo;
	}
	public void setTeModelo(String teModelo) {
		TeModelo = teModelo;
	}
	@JsonProperty("TeVersionAndroid")
	public String getTeVersionAndroid() {
		return TeVersionAndroid;
	}
	public void setTeVersionAndroid(String teVersionAndroid) {
		TeVersionAndroid = teVersionAndroid;
	}
	@JsonProperty("TeActivo")
	public Boolean getTeActivo() {
		return TeActivo;
	}
	public void setTeActivo(Boolean teActivo) {
		TeActivo = teActivo;
	}
	@JsonProperty("TeImei")
	public String getTeImei() {
		return TeImei;
	}
	public void setTeImei(String teImei) {
		TeImei = teImei;
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
