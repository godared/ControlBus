package com.godared.controlbus.bean;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "Usp_S_PrGetAllProgramacionByEm", 
	procedureName = "Usp_S_PrGetAllProgramacionByEm",
	resultClasses = Usp_S_PrGetAllProgramacionByEm.class , 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "emId"),
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "anio")
	})
})
public class Usp_S_PrGetAllProgramacionByEm implements Serializable {
	@Id
	private int prId;
	private String prDescripcion;
	private int PrCantidadBuses;
	private Date PrFecha;
	private Date PrFechaInicio;
	private Date PrFechaFin;
	private short dias;
	private String PrTipo; 
	private Boolean PrAleatorio;	
	private String EmConsorcio;
	
	@JsonProperty("prId")
	public int getPrId() {
		return prId;
	}
	@JsonProperty("prDescripcion")
	public String getPrDescripcion() {
		return prDescripcion;
	}
	@JsonProperty("PrCantidadBuses")
	public int getPrCantidadBuses() {
		return PrCantidadBuses;
	}
	@JsonProperty("PrFecha")
	public Date getPrFecha() {
		return PrFecha;
	}
	@JsonProperty("PrFechaInicio")
	public Date getPrFechaInicio() {
		return PrFechaInicio;
	}
	@JsonProperty("PrFechaFin")
	public Date getPrFechaFin() {
		return PrFechaFin;
	}
	@JsonProperty("dias")
	public short getDias() {
		return dias;
	}
	@JsonProperty("PrTipo")
	public String getPrTipo() {
		return PrTipo;
	}
	@JsonProperty("PrAleatorio")
	public Boolean getPrAleatorio() {
		return PrAleatorio;
	}
	@JsonProperty("EmConsorcio")
	public String getEmConsorcio() {
		return EmConsorcio;
	}
	
	
	
}