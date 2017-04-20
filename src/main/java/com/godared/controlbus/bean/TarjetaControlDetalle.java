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
	@NamedStoredProcedureQuery(name = "Usp_D_TaCoDeEliminaByTaCo", 
	procedureName = "Usp_D_TaCoDeEliminaByTaCo",
	//resultClasses = Usp_S_RuGetAllRutaByEm.class , 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "taCoId")
	}),
	@NamedStoredProcedureQuery(name = "Usp_S_TaCoDeGetAllTarjetaControlDetalleByTaCo", 
	procedureName = "Usp_S_TaCoDeGetAllTarjetaControlDetalleByTaCo",
	resultClasses = TarjetaControlDetalle.class , 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "taCoId")
	})
})
public class TarjetaControlDetalle implements Serializable {
	@Id 
	@GeneratedValue
	private int TaCoDeId;
	private int TaCoId;
	private int PuCoDeId;
	private Date TaCoDeFecha;
	private Date TaCoDeHora;
	private double TaCoDeLatitud; 
	private double TaCoDeLongitud;
	private Date TaCoDeTiempo;
	private String TaCoDeDescripcion;
	private int  UsId;
	private Date UsFechaReg;
	
	@JsonProperty("TaCoDeId")
	public int getTaCoDeId() {
		return TaCoDeId;
	}
	public void setTaCoDeId(int taCoDeId) {
		TaCoDeId = taCoDeId;
	}
	@JsonProperty("TaCoId")
	public int getTaCoId() {
		return TaCoId;
	}
	public void setTaCoId(int taCoId) {
		TaCoId = taCoId;
	}
	@JsonProperty("PuCoDeId")
	public int getPuCoDeId() {
		return PuCoDeId;
	}
	public void setPuCoDeId(int puCoDeId) {
		PuCoDeId = puCoDeId;
	}
	@JsonProperty("TaCoDeFecha")
	public Date getTaCoDeFecha() {
		return TaCoDeFecha;
	}
	public void setTaCoDeFecha(Date taCoDeFecha) {
		TaCoDeFecha = taCoDeFecha;
	}
	@JsonProperty("TaCoDeHora")
	public Date getTaCoDeHora() {
		return TaCoDeHora;
	}
	public void setTaCoDeHora(Date taCoDeHora) {
		TaCoDeHora = taCoDeHora;
	}
	@JsonProperty("TaCoDeLatitud")
	public double getTaCoDeLatitud() {
		return TaCoDeLatitud;
	}
	public void setTaCoDeLatitud(double taCoDeLatitud) {
		TaCoDeLatitud = taCoDeLatitud;
	}
	@JsonProperty("TaCoDeLongitud")
	public double getTaCoDeLongitud() {
		return TaCoDeLongitud;
	}
	public void setTaCoDeLongitud(double taCoDeLongitud) {
		TaCoDeLongitud = taCoDeLongitud;
	}
	@JsonProperty("TaCoDeTiempo")
	public Date getTaCoDeTiempo() {
		return TaCoDeTiempo;
	}
	public void setTaCoDeTiempo(Date taCoDeTiempo) {
		TaCoDeTiempo = taCoDeTiempo;
	}
	@JsonProperty("TaCoDeDescripcion")
	public String getTaCoDeDescripcion() {
		return TaCoDeDescripcion;
	}
	public void setTaCoDeDescripcion(String taCoDeDescripcion) {
		TaCoDeDescripcion = taCoDeDescripcion;
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
