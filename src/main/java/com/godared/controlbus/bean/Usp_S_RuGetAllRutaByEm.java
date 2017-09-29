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
	@NamedStoredProcedureQuery(name = "Usp_S_RuGetAllRutaByEm", 
	procedureName = "Usp_S_RuGetAllRutaByEm",
	resultClasses = Usp_S_RuGetAllRutaByEm.class , 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "emId")
	})
})
public class Usp_S_RuGetAllRutaByEm implements Serializable {
	@Id
	private int RuId;
	private String EmConsorcio;
	private int EmTipo;
	private String RuDescripcion;
	private Date RuFechaCreacion;
	private float RuKilometro;
	
	@JsonProperty("RuId")
	public int getRuId() {
		return RuId;
	}
	@JsonProperty("EmConsorcio")
	public String getEmConsorcio() {
		return EmConsorcio;
	}
	@JsonProperty("EmTipo")
	public int getEmTipo() {
		return EmTipo;
	}
	@JsonProperty("RuDescripcion")
	public String getRuDescripcion() {
		return RuDescripcion;
	}
	@JsonProperty("RuFechaCreacion")
	public Date getRuFechaCreacion() {
		TimeZona timeZona=new TimeZona();
		Date dateCovertida=null;
		dateCovertida=timeZona.CalcularTimeZone(RuFechaCreacion,true);
		return dateCovertida;
	}
	@JsonProperty("RuKilometro")
	public float getRuKilometro() {
		return RuKilometro;
	}
	
	
	
}
