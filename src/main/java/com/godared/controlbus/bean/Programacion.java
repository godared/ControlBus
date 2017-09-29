package com.godared.controlbus.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.godared.controlbus.TimeZona;
@Entity
public class Programacion implements Serializable {
	@Id 
	@GeneratedValue
	private int PrId;
	private int EmId;
	private int PrCantidadBuses;
	private String PrDescripcion;
	private Date PrFecha;
	private Date PrFechaInicio;
	private Date PrFechaFin;
	private String PrTipo;
	private Boolean PrAleatorio;
	private int UsId;
	private Date UsFechaReg;
	
	@JsonProperty("PrId")
	public int getPrId() {
		return PrId;
	}
	public void setPrId(int prId) {
		PrId = prId;
	}
	@JsonProperty("EmId")
	public int getEmId() {
		return EmId;
	}
	public void setEmId(int emId) {
		EmId = emId;
	}
	@JsonProperty("PrCantidadBuses")
	public int getPrCantidadBuses() {
		return PrCantidadBuses;
	}
	public void setPrCantidadBuses(int prCantidadBuses) {
		PrCantidadBuses = prCantidadBuses;
	}
	@JsonProperty("PrDescripcion")
	public String getPrDescripcion() {
		return PrDescripcion;
	}
	public void setPrDescripcion(String prDescripcion) {
		PrDescripcion = prDescripcion;
	}
	@JsonProperty("PrFecha")
	public Date getPrFecha() {
		TimeZona timeZona=new TimeZona();
		Date dateCovertida=null;
		dateCovertida=timeZona.CalcularTimeZone(PrFecha,true);
		return dateCovertida;
		
	}
	public void setPrFecha(Date prFecha) {
		PrFecha = prFecha;
	}
	@JsonProperty("PrFechaInicio")
	public Date getPrFechaInicio() {
		TimeZona timeZona=new TimeZona();
		Date dateCovertida=null;
		dateCovertida=timeZona.CalcularTimeZone(PrFechaInicio,true);
		return dateCovertida;
		//return PrFechaInicio;
	}
	public void setPrFechaInicio(Date prFechaInicio) {
		PrFechaInicio = prFechaInicio;
	}
	@JsonProperty("PrFechaFin")
	public Date getPrFechaFin() {
		TimeZona timeZona=new TimeZona();
		Date dateCovertida=null;
		dateCovertida=timeZona.CalcularTimeZone(PrFechaFin,true);
		return dateCovertida;
		
	}
	public void setPrFechaFin(Date prFechaFin) {
		PrFechaFin = prFechaFin;
	}
	@JsonProperty("PrTipo")
	public String getPrTipo() {
		return PrTipo;
	}
	public void setPrTipo(String prTipo) {
		PrTipo = prTipo;
	}
	@JsonProperty("PrAleatorio")
	public Boolean getPrAleatorio() {
		return PrAleatorio;
	}
	public void setPrAleatorio(Boolean prAleatorio) {
		PrAleatorio = prAleatorio;
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
		TimeZona timeZona=new TimeZona();
		Date dateCovertida=null;
		dateCovertida=timeZona.CalcularTimeZone(UsFechaReg,true);
		return dateCovertida;
		
	}
	public void setUsFechaReg(Date usFechaReg) {
		UsFechaReg = usFechaReg;
	}
}
