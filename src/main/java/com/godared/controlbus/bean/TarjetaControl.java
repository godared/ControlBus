package com.godared.controlbus.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
public class TarjetaControl implements Serializable{
	@Id 
	@GeneratedValue
	private int TaCoId;
	private int PuCoId;
	private int RuId;
	private int BuId;
	private Date TaCoFecha;
	private Date TaCoHoraSalida;
	private float TaCoCuota;
	private int UsId;
	private Date UsFechaReg;
	
	@JsonProperty("TaCoId")
	public int getTaCoId() {
		return TaCoId;
	}
	public void setTaCoId(int taCoId) {
		TaCoId = taCoId;
	}
	@JsonProperty("PuCoId")
	public int getPuCoId() {
		return PuCoId;
	}
	public void setPuCoId(int puCoId) {
		PuCoId = puCoId;
	}
	@JsonProperty("RuId")
	public int getRuId() {
		return RuId;
	}
	public void setRuId(int ruId) {
		RuId = ruId;
	}
	@JsonProperty("BuId")
	public int getBuId() {
		return BuId;
	}
	public void setBuId(int buId) {
		BuId = buId;
	}
	@JsonProperty("TaCoFecha")
	public Date getTaCoFecha() {
		return TaCoFecha;
	}
	public void setTaCoFecha(Date taCoFecha) {
		TaCoFecha = taCoFecha;
	}
	@JsonProperty("TaCoHoraSalida")
	public Date getTaCoHoraSalida() {
		return TaCoHoraSalida;
	}
	public void setTaCoHoraSalida(Date taCoHoraSalida) {
		TaCoHoraSalida = taCoHoraSalida;
	}
	@JsonProperty("TaCoCuota")
	public float getTaCoCuota() {
		return TaCoCuota;
	}
	public void setTaCoCuota(float taCoCuota) {
		TaCoCuota = taCoCuota;
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
