package com.godared.controlbus.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.godared.controlbus.TimeZona;

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
	private String PrDiasIncluidos;
	
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
		TimeZona timeZona=new TimeZona();
		Date dateCovertida=null;
		dateCovertida=timeZona.CalcularTimeZone(PrFecha,true);
		return dateCovertida;
	}
	@JsonProperty("PrFechaInicio")
	public Date getPrFechaInicio() {
		TimeZona timeZona=new TimeZona();
		Date dateCovertida=null;
		dateCovertida=timeZona.CalcularTimeZone(PrFechaInicio,true);
		return dateCovertida;
	}
	@JsonProperty("PrFechaFin")
	public Date getPrFechaFin() {
		TimeZona timeZona=new TimeZona();
		Date dateCovertida=null;
		dateCovertida=timeZona.CalcularTimeZone(PrFechaFin,true);
		return dateCovertida;
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
	@JsonProperty("PrDiasIncluidos")
	public String getPrDiasIncluidos() {
		return PrDiasIncluidos;
	}
	
	
}
