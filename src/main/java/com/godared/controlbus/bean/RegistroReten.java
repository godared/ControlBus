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

@Entity
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "Usp_S_ReReGetAllRegistroRetenByReDiDe", 
	procedureName = "Usp_S_ReReGetAllRegistroRetenByReDiDe",
	resultClasses = RegistroReten.class , 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "reDiDeId")
	})
})
public class RegistroReten implements Serializable {
	@Id 
	@GeneratedValue
	private int ReReId;
	private int ReDiDeId;
	private int PrDeId;
	private Date ReReTiempo;
	private int UsId;
	private Date UsFechaReg;
	
	@JsonProperty("ReReId")
	public int getReReId() {
		return ReReId;
	}
	public void setReReId(int reReId) {
		ReReId = reReId;
	}
	@JsonProperty("ReDiDeId")
	public int getReDiDeId() {
		return ReDiDeId;
	}
	public void setReDiDeId(int reDiDeId) {
		ReDiDeId = reDiDeId;
	}
	@JsonProperty("PrDeId")
	public int getPrDeId() {
		return PrDeId;
	}
	public void setPrDeId(int prDeId) {
		PrDeId = prDeId;
	}
	@JsonProperty("ReReTiempo")
	public Date getReReTiempo() {
		return ReReTiempo;
	}
	public void setReReTiempo(Date reReTiempo) {
		ReReTiempo = reReTiempo;
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
