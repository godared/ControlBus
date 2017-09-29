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
	@NamedStoredProcedureQuery(name = "Usp_D_EmPeEliminaBySuEm", 
	procedureName = "Usp_D_EmPeEliminaBySuEm",	
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "suEmId")
	})
})
public class EmpresaPersona  implements Serializable{
	@Id 
	@GeneratedValue
	private int EmPeId;
	private int SuEmId;
	private int PeId;	
	private String EmPeTipo;
	private int UsId;
	private Date UsFechaReg;
	
	@JsonProperty("EmPeId")
	public int getEmPeId() {
		return EmPeId;
	}
	public void setEmPeId(int emPeId) {
		EmPeId = emPeId;
	}
	@JsonProperty("SuEmId")
	public int getSuEmId() {
		return SuEmId;
	}
	public void setSuEmId(int suEmId) {
		SuEmId = suEmId;
	}
	@JsonProperty("PeId")
	public int getPeId() {
		return PeId;
	}
	public void setPeId(int peId) {
		PeId = peId;
	}
	@JsonProperty("EmPeTipo")
	public String getEmPeTipo() {
		return EmPeTipo;
	}
	public void setEmPeTipo(String emPeTipo) {
		EmPeTipo = emPeTipo;
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
