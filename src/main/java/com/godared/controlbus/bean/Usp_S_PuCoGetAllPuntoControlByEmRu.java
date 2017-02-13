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
	@NamedStoredProcedureQuery(name = "Usp_S_PuCoGetAllPuntoControlByEmRu", 
	procedureName = "Usp_S_PuCoGetAllPuntoControlByEmRu",
	resultClasses = Usp_S_PuCoGetAllPuntoControlByEmRu.class , 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "emId"),
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "ruId")
	})
})
public class Usp_S_PuCoGetAllPuntoControlByEmRu implements Serializable{
	@Id
	private int PuCoId;
	private int RuId;
	private int EmId;
	private Date PuCoTiempoBus;
	private String PuCoClase;
	private String RuDescripcion;
	
	@JsonProperty("PuCoId")
	public int getPuCoId() {
		return PuCoId;
	}
	@JsonProperty("RuId")
	public int getRuId() {
		return RuId;
	}
	@JsonProperty("EmId")
	public int getEmId() {
		return EmId;
	}
	@JsonProperty("PuCoTiempoBus")
	public Date getPuCoTiempoBus() {
		return PuCoTiempoBus;
	}
	@JsonProperty("PuCoClase")
	public String getPuCoClase() {
		return PuCoClase;
	}
	@JsonProperty("RuDescripcion")
	public String getRuDescripcion() {
		return RuDescripcion;
	}
	
	
		
	
}
