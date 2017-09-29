package com.godared.controlbus.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.godared.controlbus.TimeZona;
@Entity
public class Empresa implements Serializable {
	@Id 
	@GeneratedValue
	private int EmId;
	private String EmConsorcio; 
	private Boolean EmTipo;	
	private int UsId; 
	private Date UsFechaReg;
	@JsonProperty("EmId")
	public int getEmId() {
		return EmId;
	}
	public void setEmId(int emId) {
		EmId = emId;
	}
	@JsonProperty("EmConsorcio")
	public String getEmConsorcio() {
		return EmConsorcio;
	}
	public void setEmConsorcio(String emConsorcio) {
		EmConsorcio = emConsorcio;
	}
	@JsonProperty("EmTipo")
	public Boolean getEmTipo() {
		return EmTipo;
	}
	public void setEmTipo(Boolean emTipo) {
		EmTipo = emTipo;
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
		TimeZona timeZona=new TimeZona();
		Date dateCovertida=null;
		dateCovertida=timeZona.CalcularTimeZone(UsFechaReg,true);
		return dateCovertida;
	}
	public void setUsFechaReg(Date usFechaReg) {
		UsFechaReg = usFechaReg;
	} 
	
}
