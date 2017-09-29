package com.godared.controlbus.bean;

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
	@NamedStoredProcedureQuery(name = "Usp_S_TeGetAllTelefonoByBuImei", 
	procedureName = "Usp_S_TeGetAllTelefonoByBuImei",
	resultClasses = Usp_S_TeGetAllTelefonoByBuImei.class , 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "buId"),
		@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class,name = "teImei")
	})
})
public class Usp_S_TeGetAllTelefonoByBuImei {
	@Id
	@GeneratedValue
	private int TeId;
	private String TeMarca;
	private String TeImei;
	private int BuId;
	private String BuPlaca;
	private int EmId;
	private String SuEmRSocial;
	private String EmConsorcio;
	
	@JsonProperty("TeId")
	public int getTeId() {
		return TeId;
	}
	@JsonProperty("TeMarca")
	public String getTeMarca() {
		return TeMarca;
	}
	@JsonProperty("TeImei")
	public String getTeImei() {
		return TeImei;
	}
	@JsonProperty("BuId")
	public int getBuId() {
		return BuId;
	}
	@JsonProperty("BuPlaca")
	public String getBuPlaca() {
		return BuPlaca;
	}
	@JsonProperty("EmId")
	public int getEmId() {
		return EmId;
	}
	@JsonProperty("SuEmRSocial")
	public String getSuEmRSocial() {
		return SuEmRSocial;
	}
	@JsonProperty("EmConsorcio")
	public String getEmConsorcio() {
		return EmConsorcio;
	}
	
	

}
