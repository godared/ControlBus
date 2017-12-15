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
public class Usp_S_TaCoGetAllTarjetaControlByBuIdFecha implements Serializable{
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
	private int TaCoNroVuelta;
	private int PrId;
	private int TiSaId;
	private String TaCoAsignado;
	private Boolean TaCoTipoHoraSalida;
	private int ReDiDeId;
	private Boolean TaCoFinish;
	private Boolean TaCoMultiple;
	private int TaCoCodEnvioMovil;
	private int TaCoCountMultiple;
	private String BuPlaca;
	private Date PuCoTiempoBus;	
	private String PuCoDescripcion;
	
	@JsonProperty("TaCoId")
	public int getTaCoId() {
		return TaCoId;
	}
	@JsonProperty("PuCoId")
	public int getPuCoId() {
		return PuCoId;
	}
	@JsonProperty("RuId")
	public int getRuId() {
		return RuId;
	}
	@JsonProperty("BuId")
	public int getBuId() {
		return BuId;
	}
	@JsonProperty("TaCoFecha")
	public Date getTaCoFecha() {
		return TaCoFecha;
	}
	@JsonProperty("TaCoHoraSalida")
	public Date getTaCoHoraSalida() {
		return TaCoHoraSalida;
	}
	@JsonProperty("TaCoCuota")
	public float getTaCoCuota() {
		return TaCoCuota;
	}
	@JsonProperty("UsId")
	public int getUsId() {
		return UsId;
	}
	@JsonProperty("UsFechaReg")
	public Date getUsFechaReg() {
		return UsFechaReg;
	}
	@JsonProperty("TaCoNroVuelta")
	public int getTaCoNroVuelta() {
		return TaCoNroVuelta;
	}
	@JsonProperty("PrId")
	public int getPrId() {
		return PrId;
	}
	@JsonProperty("TiSaId")
	public int getTiSaId() {
		return TiSaId;
	}
	@JsonProperty("TaCoAsignado")
	public String getTaCoAsignado() {
		return TaCoAsignado;
	}
	@JsonProperty("TaCoTipoHoraSalida")
	public Boolean getTaCoTipoHoraSalida() {
		return TaCoTipoHoraSalida;
	}
	@JsonProperty("ReDiDeId")
	public int getReDiDeId() {
		return ReDiDeId;
	}
	@JsonProperty("TaCoFinish")
	public Boolean getTaCoFinish() {
		return TaCoFinish;
	}
	@JsonProperty("TaCoMultiple")
	public Boolean getTaCoMultiple() {
		return TaCoMultiple;
	}
	@JsonProperty("TaCoCodEnvioMovil")
	public int getTaCoCodEnvioMovil() {
		return TaCoCodEnvioMovil;
	}
	@JsonProperty("TaCoCountMultiple")
	public int getTaCoCountMultiple() {
		return TaCoCountMultiple;
	}
	@JsonProperty("BuPlaca")
	public String getBuPlaca() {
		return BuPlaca;
	}
	@JsonProperty("PuCoTiempoBus")
	public Date getPuCoTiempoBus() {
		return PuCoTiempoBus;
	}
	@JsonProperty("PuCoDescripcion")
	public String getPuCoDescripcion() {
		return PuCoDescripcion;
	}	
	
}
