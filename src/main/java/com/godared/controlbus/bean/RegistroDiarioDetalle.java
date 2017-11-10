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
	@NamedStoredProcedureQuery(name = "Usp_S_ReDiDeGetAllRegistroDiarioDetalleByReDi", 
	procedureName = "Usp_S_ReDiDeGetAllRegistroDiarioDetalleByReDi",
	resultClasses = RegistroDiarioDetalle.class , 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "reDiId")
	})
})
public class RegistroDiarioDetalle implements Serializable {
	@Id 
	@GeneratedValue
	private int ReDiDeId;
	private int ReDiId;
	private int ReDiDeNroVuelta;
	private String ReDiDeNombreVuelta;
	private String ReDiDeEstado;
	private int UsId;
	private Date UsFechaReg;
	
	@JsonProperty("ReDiDeId")
	public int getReDiDeId() {
		return ReDiDeId;
	}
	public void setReDiDeId(int reDiDeId) {
		ReDiDeId = reDiDeId;
	}
	@JsonProperty("ReDiId")
	public int getReDiId() {
		return ReDiId;
	}
	public void setReDiId(int reDiId) {
		ReDiId = reDiId;
	}
	@JsonProperty("ReDiDeNroVuelta")
	public int getReDiDeNroVuelta() {
		return ReDiDeNroVuelta;
	}
	public void setReDiDeNroVuelta(int reDiDeNroVuelta) {
		ReDiDeNroVuelta = reDiDeNroVuelta;
	}
	@JsonProperty("ReDiDeNombreVuelta")
	public String getReDiDeNombreVuelta() {
		return ReDiDeNombreVuelta;
	}
	public void setReDiDeNombreVuelta(String reDiDeNombreVuelta) {
		ReDiDeNombreVuelta = reDiDeNombreVuelta;
	}
	@JsonProperty("ReDiDeEstado")
	public String getReDiDeEstado() {
		return ReDiDeEstado;
	}
	public void setReDiDeEstado(String reDiDeEstado) {
		ReDiDeEstado = reDiDeEstado;
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
