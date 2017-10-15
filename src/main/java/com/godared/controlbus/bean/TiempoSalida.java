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
	@NamedStoredProcedureQuery(name = "Usp_S_TiSaGetAllTiempoSalidaByEm", 
	procedureName = "Usp_S_TiSaGetAllTiempoSalidaByEm",
	resultClasses = TiempoSalida.class , 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "emId")
	})
})
public class TiempoSalida implements Serializable {
	@Id 
	@GeneratedValue
	private int TiSaId;
	private String TiSaNombre;
	private String TiSaValor;
	private int UsId;
	private Date UsFechaReg;
	private int SuEmId;
	
	@JsonProperty("TiSaId")
	public int getTiSaId() {
		return TiSaId;
	}
	public void setTiSaId(int tiSaId) {
		TiSaId = tiSaId;
	}
	@JsonProperty("TiSaNombre")
	public String getTiSaNombre() {
		return TiSaNombre;
	}
	public void setTiSaNombre(String tiSaNombre) {
		TiSaNombre = tiSaNombre;
	}
	@JsonProperty("TiSaValor")
	public String getTiSaValor() {
		return TiSaValor;
	}
	public void setTiSaValor(String tiSaValor) {
		TiSaValor = tiSaValor;
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
	@JsonProperty("SuEmId")
	public int getSuEmId() {
		return SuEmId;
	}
	public void setSuEmId(int suEmId) {
		SuEmId = suEmId;
	}
	

}
