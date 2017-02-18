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
@Entity
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "Usp_S_TaCoGetAllTarjetaControlByEmPuCo", 
	procedureName = "Usp_S_TaCoGetAllTarjetaControlByEmPuCo",
	resultClasses = Usp_S_TaCoGetAllTarjetaControlByEmPuCo.class , 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "emId"),
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "puCoId")
	})
})
public class Usp_S_TaCoGetAllTarjetaControlByEmPuCo implements Serializable {
	@Id
	private int TaCoId;
	private String PuCoClase;
	private String BuPlaca;
	private String BuDescripcion;
	private Date TaCoFecha;
	private Date TaCoHoraSalida;	
	private int BuId;
	private int PuCoId;
	
	@JsonProperty("TaCoId")
	public int getTaCoId() {
		return TaCoId;
	}
	@JsonProperty("PuCoClase")
	public String getPuCoClase() {
		return PuCoClase;
	}
	@JsonProperty("BuPlaca")
	public String getBuPlaca() {
		return BuPlaca;
	}
	@JsonProperty("BuDescripcion")
	public String getBuDescripcion() {
		return BuDescripcion;
	}
	@JsonProperty("TaCoFecha")
	public Date getTaCoFecha() {
		return TaCoFecha;
	}
	@JsonProperty("TaCoHoraSalida")
	public Date getTaCoHoraSalida() {
		return TaCoHoraSalida;
	}
	@JsonProperty("BuId")
	public int getBuId() {
		return BuId;
	}
	@JsonProperty("PuCoId")
	public int getPuCoId() {
		return PuCoId;
	}
	
}
