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
	@NamedStoredProcedureQuery(name = "Usp_S_AlInGetAllAlertaIncidenciaByEmTaCo", 
	procedureName = "Usp_S_AlInGetAllAlertaIncidenciaByEmTaCo",
	resultClasses = AlertaIncidencia.class , 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "emId"),
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "taCoId")
	}),
	@NamedStoredProcedureQuery(name = "Usp_S_AlInGetAllAlertaIncidenciaByEmFecha", 
	procedureName = "Usp_S_AlInGetAllAlertaIncidenciaByEmFecha",
	resultClasses = Usp_S_AlInGetAllAlertaIncidenciaByEmFecha.class , 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "emId"),
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class,name = "fecha")
	})
})
public class AlertaIncidencia implements Serializable{
	@Id 
	@GeneratedValue
	private int AlInId;
	private int EmId;
	private Date AlInFecha;
	private String AlInDescripcion;
	private Boolean AlInTipo;
	private double AlInLatitud;
	private double AlInLongitud;
	private int UsId;
	private Date UsFechaReg;
	private int TaCoId;
	
	@JsonProperty("AlInId")
	public int getAlInId() {
		return AlInId;
	}
	public void setAlInId(int alInId) {
		AlInId = alInId;
	}
	@JsonProperty("EmId")
	public int getEmId() {
		return EmId;
	}
	public void setEmId(int emId) {
		EmId = emId;
	}
	@JsonProperty("AlInFecha")
	public Date getAlInFecha() {
		return AlInFecha;
	}
	public void setAlInFecha(Date alInFecha) {
		AlInFecha = alInFecha;
	}
	@JsonProperty("AlInDescripcion")
	public String getAlInDescripcion() {
		return AlInDescripcion;
	}
	public void setAlInDescripcion(String alInDescripcion) {
		AlInDescripcion = alInDescripcion;
	}
	@JsonProperty("AlInTipo")
	public Boolean getAlInTipo() {
		return AlInTipo;
	}
	public void setAlInTipo(Boolean alInTipo) {
		AlInTipo = alInTipo;
	}
	@JsonProperty("AlInLatitud")
	public double getAlInLatitud() {
		return AlInLatitud;
	}
	public void setAlInLatitud(double alInLatitud) {
		AlInLatitud = alInLatitud;
	}
	@JsonProperty("AlInLongitud")
	public double getAlInLongitud() {
		return AlInLongitud;
	}
	public void setAlInLongitud(double alInLongitud) {
		AlInLongitud = alInLongitud;
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
	@JsonProperty("TaCoId")
	public int getTaCoId() {
		return TaCoId;
	}
	public void setTaCoId(int taCoId) {
		TaCoId = taCoId;
	}
	
}
