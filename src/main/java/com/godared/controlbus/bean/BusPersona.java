package com.godared.controlbus.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.godared.controlbus.TimeZona;

@Entity
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "Usp_D_EmPeEliminaByBu", 
	procedureName = "Usp_D_EmPeEliminaByBu",	
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "buId")
	})
})
public class BusPersona implements Serializable{
	@Id 
	@GeneratedValue
	private int BuPeId;
	private int BuId;
	private String BuPeTipo;
	private int UsId;
	private Date UsFechaReg;
	private int EmPeId;
	
	@JsonProperty("BuPeId")
	public int getBuPeId() {
		return BuPeId;
	}
	public void setBuPeId(int buPeId) {
		BuPeId = buPeId;
	}
	@JsonProperty("BuId")
	public int getBuId() {
		return BuId;
	}
	public void setBuId(int buId) {
		BuId = buId;
	}
	@JsonProperty("BuPeTipo")
	public String getBuPeTipo() {
		return BuPeTipo;
	}
	public void setBuPeTipo(String buPeTipo) {
		BuPeTipo = buPeTipo;
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
	@JsonProperty("EmPeId")
	public int getEmPeId() {
		return EmPeId;
	}
	public void setEmPeId(int emPeId) {
		EmPeId = emPeId;
	}
	
	
	
}
