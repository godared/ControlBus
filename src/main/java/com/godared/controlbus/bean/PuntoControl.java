package com.godared.controlbus.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.godared.controlbus.TimeZona;

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
	private String PuCoDescripcion;
	private Boolean PuCoActivo;
	
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
		TimeZona timeZona=new TimeZona();
		Date dateCovertida=null;
		dateCovertida=timeZona.CalcularTimeZone(puCoTiempoBus,false);
		PuCoTiempoBus = dateCovertida;
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
		TimeZona timeZona=new TimeZona();
		Date dateCovertida=null;
		dateCovertida=timeZona.CalcularTimeZone(UsFechaReg,true);
		return dateCovertida;
		
	}
	public void setUsFechaReg(Date usFechaReg) {
		UsFechaReg = usFechaReg;
	}
	@JsonProperty("PuCoDescripcion")
	public String getPuCoDescripcion() {
		return PuCoDescripcion;
	}
	public void setPuCoDescripcion(String puCoDescripcion) {
		PuCoDescripcion = puCoDescripcion;
	}
	@JsonProperty("PuCoActivo")
	public Boolean getPuCoActivo() {
		return PuCoActivo;
	}
	public void setPuCoActivo(Boolean puCoActivo) {
		PuCoActivo = puCoActivo;
	}
	
	
	
}
