package com.godared.controlbus.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
public class Usp_S_GeGetAllUbicacionActualByEmTiempo  implements Serializable{
	@Id	
	private int GeId;
	private int BuId;
	private int TaCoId;
	private double GeLatitud;
	private double GeLongitud;
	private Date GeFechaHora;
	private Date UsFechaReg;
	private int TaCoNroVuelta;
	private String BuPlaca;
	private int EmId;
	private int SuEmId;	
	private int ReDiDeId;
	private int GeOrden;
	
	@JsonProperty("GeId")
	public int getGeId() {
		return GeId;
	}
	@JsonProperty("BuId")
	public int getBuId() {
		return BuId;
	}
	@JsonProperty("TaCoId")
	public int getTaCoId() {
		return TaCoId;
	}
	@JsonProperty("GeLatitud")
	public double getGeLatitud() {
		return GeLatitud;
	}
	@JsonProperty("GeLongitud")
	public double getGeLongitud() {
		return GeLongitud;
	}
	@JsonProperty("GeFechaHora")
	public Date getGeFechaHora() {
		return GeFechaHora;
	}
	@JsonProperty("UsFechaReg")
	public Date getUsFechaReg() {
		return UsFechaReg;
	}
	@JsonProperty("TaCoNroVuelta")
	public int getTaCoNroVuelta() {
		return TaCoNroVuelta;
	}
	@JsonProperty("BuPlaca")
	public String getBuPlaca() {
		return BuPlaca;
	}
	@JsonProperty("EmId")
	public int getEmId() {
		return EmId;
	}
	@JsonProperty("SuEmId")
	public int getSuEmId() {
		return SuEmId;
	}
	@JsonProperty("ReDiDeId")
	public int getReDiDeId() {
		return ReDiDeId;
	}
	@JsonProperty("GeOrden")
	public int getGeOrden() {
		return GeOrden;
	}	
	
}
