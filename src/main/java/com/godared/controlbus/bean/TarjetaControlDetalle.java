package com.godared.controlbus.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TarjetaControlDetalle implements Serializable {
	@Id 
	@GeneratedValue
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
