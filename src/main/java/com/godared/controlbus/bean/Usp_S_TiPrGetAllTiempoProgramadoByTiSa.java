package com.godared.controlbus.bean;

import java.io.Serializable;

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
	@NamedStoredProcedureQuery(name = "Usp_S_TiPrGetAllTiempoProgramadoByTiSa", 
	procedureName = "Usp_S_TiPrGetAllTiempoProgramadoByTiSa",
	resultClasses = Usp_S_TiPrGetAllTiempoProgramadoByTiSa.class , 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "tiSaId")
	})
})
public class Usp_S_TiPrGetAllTiempoProgramadoByTiSa implements Serializable {
	@Id
	@GeneratedValue
	private int TiPrId;
	private int BuId;
	private String BuPlaca;
	private String BuDescripcion;
	private String BuMarca;
	private int TiSaId;
	
	@JsonProperty("TiPrId")
	public int getTiPrId() {
		return TiPrId;
	}
	public void setTiPrId(int tiPrId) {
		TiPrId = tiPrId;
	}
	@JsonProperty("BuId")
	public int getBuId() {
		return BuId;
	}
	public void setBuId(int buId) {
		BuId = buId;
	}
	@JsonProperty("BuPlaca")
	public String getBuPlaca() {
		return BuPlaca;
	}
	public void setBuPlaca(String buPlaca) {
		BuPlaca = buPlaca;
	}
	@JsonProperty("BuDescripcion")
	public String getBuDescripcion() {
		return BuDescripcion;
	}
	public void setBuDescripcion(String buDescripcion) {
		BuDescripcion = buDescripcion;
	}
	@JsonProperty("BuMarca")
	public String getBuMarca() {
		return BuMarca;
	}
	public void setBuMarca(String buMarca) {
		BuMarca = buMarca;
	}
	@JsonProperty("TiSaId")
	public int getTiSaId() {
		return TiSaId;
	}
	public void setTiSaId(int tiSaId) {
		TiSaId = tiSaId;
	}
	
}
