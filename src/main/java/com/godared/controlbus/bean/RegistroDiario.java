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
	@NamedStoredProcedureQuery(name = "Usp_S_ReDiGetAllRegistroDiarioByEm", 
	procedureName = "Usp_S_ReDiGetAllRegistroDiarioByEm",
	resultClasses = RegistroDiario.class , 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "emId")
	})
})
public class RegistroDiario implements Serializable {
	@Id 
	@GeneratedValue
	private int ReDiId;
	private int EmId;
	private Date ReDiFeha;
	private short ReDiTotalVuelta;
	private Date ReDiTiempoVuelta;
	private int UsId;
	private Date UsFechaReg;
	
	@JsonProperty("ReDiId")
	public int getReDiId() {
		return ReDiId;
	}
	public void setReDiId(int reDiId) {
		ReDiId = reDiId;
	}
	@JsonProperty("EmId")
	public int getEmId() {
		return EmId;
	}
	public void setEmId(int emId) {
		EmId = emId;
	}
	@JsonProperty("ReDiFeha")
	public Date getReDiFeha() {
		return ReDiFeha;
	}
	public void setReDiFeha(Date reDiFeha) {
		ReDiFeha = reDiFeha;
	}
	@JsonProperty("ReDiTotalVuelta")
	public short getReDiTotalVuelta() {
		return ReDiTotalVuelta;
	}
	public void setReDiTotalVuelta(short reDiTotalVuelta) {
		ReDiTotalVuelta = reDiTotalVuelta;
	}
	@JsonProperty("ReDiTiempoVuelta")
	public Date getReDiTiempoVuelta() {
		return ReDiTiempoVuelta;
	}
	public void setReDiTiempoVuelta(Date reDiTiempoVuelta) {
		ReDiTiempoVuelta = reDiTiempoVuelta;
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
