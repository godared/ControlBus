package com.godared.controlbus.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.godared.controlbus.TimeZona;
@Entity
public class ProgramacionBase implements Serializable {
	@Id 
	@GeneratedValue
	private int PrBaId;
	private int EmId;
	private String PrBaDescripcion;
	private Date PrBaFecha;
	private Date PrBaFechaInicio;
	private Date PrBaFechaFin;
	private String PrBaDiasIncluidos;
	private int UsId;
	private Date UsFechaReg;
	private String PrBaHoraBase;
	
	@JsonProperty("PrBaId")
	public int getPrBaId() {
		return PrBaId;
	}	
	public void setPrBaId(int prBaId) {
		PrBaId = prBaId;
	}
	@JsonProperty("EmId")
	public int getEmId() {
		return EmId;
	}
	public void setEmId(int emId) {
		EmId = emId;
	}
	@JsonProperty("PrBaDescripcion")
	public String getPrBaDescripcion() {
		return PrBaDescripcion;
	}
	public void setPrBaDescripcion(String prBaDescripcion) {
		PrBaDescripcion = prBaDescripcion;
	}
	@JsonProperty("PrBaFecha")
	public Date getPrBaFecha() {
		return PrBaFecha;
	}
	public void setPrBaFecha(Date prBaFecha) {
		PrBaFecha = prBaFecha;
	}
	@JsonProperty("PrBaFechaInicio")
	public Date getPrBaFechaInicio() {
		return PrBaFechaInicio;
	}
	public void setPrBaFechaInicio(Date prBaFechaInicio) {
		PrBaFechaInicio = prBaFechaInicio;
	}
	@JsonProperty("PrBaFechaFin")
	public Date getPrBaFechaFin() {
		return PrBaFechaFin;
	}
	public void setPrBaFechaFin(Date prBaFechaFin) {
		PrBaFechaFin = prBaFechaFin;
	}
	@JsonProperty("PrBaDiasIncluidos")
	public String getPrBaDiasIncluidos() {
		return PrBaDiasIncluidos;
	}
	public void setPrBaDiasIncluidos(String prBaDiasIncluidos) {
		PrBaDiasIncluidos = prBaDiasIncluidos;
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
	@JsonProperty("PrBaHoraBase")
	public String getPrBaHoraBase() {
		return PrBaHoraBase;
	}
	public void setPrBaHoraBase(String prBaHoraBase) {
		PrBaHoraBase = prBaHoraBase;
	}	
	
	
}
