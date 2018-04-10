package com.godared.controlbus.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Usp_S_AlInGetAllAlertaIncidenciaByEmFecha implements Serializable {
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
	private int BuId;
	private String BuPlaca;
	
	@JsonProperty("AlInId")
	public int getAlInId() {
		return AlInId;
	}
	@JsonProperty("EmId")
	public int getEmId() {
		return EmId;
	}
	@JsonProperty("AlInFecha")
	public Date getAlInFecha() {
		return AlInFecha;
	}
	@JsonProperty("AlInDescripcion")
	public String getAlInDescripcion() {
		return AlInDescripcion;
	}
	@JsonProperty("AlInTipo")
	public Boolean getAlInTipo() {
		return AlInTipo;
	}
	@JsonProperty("AlInLatitud")
	public double getAlInLatitud() {
		return AlInLatitud;
	}
	@JsonProperty("AlInLongitud")
	public double getAlInLongitud() {
		return AlInLongitud;
	}
	@JsonProperty("UsId")
	public int getUsId() {
		return UsId;
	}
	@JsonProperty("UsFechaReg")
	public Date getUsFechaReg() {
		return UsFechaReg;
	}
	@JsonProperty("TaCoId")
	public int getTaCoId() {
		return TaCoId;
	}
	@JsonProperty("BuId")
	public int getBuId() {
		return BuId;
	}
	@JsonProperty("BuPlaca")
	public String getBuPlaca() {
		return BuPlaca;
	}
	
	
}
