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
	@NamedStoredProcedureQuery(name = "Usp_D_PuCoDeEliminaByPuCo", 
	procedureName = "Usp_D_PuCoDeEliminaByPuCo",
	//resultClasses = Usp_S_RuGetAllRutaByEm.class , 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "puCoId")
	}),
	@NamedStoredProcedureQuery(name = "Usp_S_PuCoDeGetAllPuntoControlDetalleByPuCo", 
	procedureName = "Usp_S_PuCoDeGetAllPuntoControlDetalleByPuCo",
	resultClasses = PuntoControlDetalle.class , 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "puCoId")
	})
})
public class PuntoControlDetalle implements Serializable  {
	@Id 
	@GeneratedValue
	private int PuCoDeId;
	private int PuCoId;
	private double PuCoDeLatitud;
	private double PuCoDeLongitud;
	private String PuCoDeDescripcion;
	private Date PuCoDeHora;
	private int UsId;
	private Date UsFechaReg;
	
	@JsonProperty("PuCoDeId")
	public int getPuCoDeId() {
		return PuCoDeId;
	}
	public void setPuCoDeId(int puCoDeId) {
		PuCoDeId = puCoDeId;
	}
	@JsonProperty("PuCoId")
	public int getPuCoId() {
		return PuCoId;
	}
	public void setPuCoId(int puCoId) {
		PuCoId = puCoId;
	}
	@JsonProperty("PuCoDeLatitud")
	public double getPuCoDeLatitud() {
		return PuCoDeLatitud;
	}
	public void setPuCoDeLatitud(double puCoDeLatitud) {
		PuCoDeLatitud = puCoDeLatitud;
	}
	@JsonProperty("PuCoDeLongitud")
	public double getPuCoDeLongitud() {
		return PuCoDeLongitud;
	}
	public void setPuCoDeLongitud(double puCoDeLongitud) {
		PuCoDeLongitud = puCoDeLongitud;
	}
	@JsonProperty("PuCoDeDescripcion")
	public String getPuCoDeDescripcion() {
		return PuCoDeDescripcion;
	}
	public void setPuCoDeDescripcion(String puCoDeDescripcion) {
		PuCoDeDescripcion = puCoDeDescripcion;
	}
	@JsonProperty("PuCoDeHora")
	public Date getPuCoDeHora() {
		return PuCoDeHora;
	}
	public void setPuCoDeHora(Date puCoDeHora) {
		PuCoDeHora = puCoDeHora;
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
