package com.godared.controlbus.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Georeferencia implements Serializable {
	@Id 
	@GeneratedValue
	private int GeId;
	private int TaCoId;
	private double GeLatitud;
	private double GeLongitud;
	private Date GeFechaHora;
	private int UsId;
	private Date UsFechaReg;
	
	@JsonProperty("GeId")
	public int getGeId() {
		return GeId;
	}
	public void setGeId(int geId) {
		GeId = geId;
	}
	@JsonProperty("TaCoId")
	public int getTaCoId() {
		return TaCoId;
	}
	public void setTaCoId(int taCoId) {
		TaCoId = taCoId;
	}
	@JsonProperty("GeLatitud")
	public double getGeLatitud() {
		return GeLatitud;
	}
	public void setGeLatitud(double geLatitud) {
		GeLatitud = geLatitud;
	}
	@JsonProperty("GeLongitud")
	public double getGeLongitud() {
		return GeLongitud;
	}
	public void setGeLongitud(double geLongitud) {
		GeLongitud = geLongitud;
	}
	@JsonProperty("GeFechaHora")
	public Date getGeFechaHora() {
		return GeFechaHora;
	}
	public void setGeFechaHora(Date geFechaHora) {
		GeFechaHora = geFechaHora;
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
