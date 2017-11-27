package com.godared.controlbus.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "Usp_S_GetAllRegistroVueltasDiariasByEmPrFe", 
	procedureName = "Usp_S_GetAllRegistroVueltasDiariasByEmPrFe",
	resultClasses = Usp_S_GetAllRegistroVueltasDiariasByEmPrFe.class , 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "emId"),
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "prId"),
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class,name = "fechaDiario")
	})
})
public class Usp_S_GetAllRegistroVueltasDiariasByEmPrFe implements Serializable {
	@Id
	private int PrDeId;
	private int BuId;
	private int PrDeOrden;
	private String BuPlaca;
	private int ReDiId;
	private int ReDiDeId;
	private int ReDiDeNroVuelta;
	private int ReReId;
	private Date ReReTiempo;
	private int TaCoId;
	private Date TaCoHoraSalida;
	private Date HoraLlegada;
	private Date PuCoTiempoBus;
	
	@JsonProperty("PrDeId")
	public int getPrDeId() {
		return PrDeId;
	}
	@JsonProperty("BuId")
	public int getBuId() {
		return BuId;
	}
	@JsonProperty("PrDeOrden")
	public int getPrDeOrden() {
		return PrDeOrden;
	}
	@JsonProperty("BuPlaca")
	public String getBuPlaca() {
		return BuPlaca;
	}
	@JsonProperty("ReDiId")
	public int getReDiId() {
		return ReDiId;
	}
	@JsonProperty("ReDiDeId")
	public int getReDiDeId() {
		return ReDiDeId;
	}
	@JsonProperty("ReDiDeNroVuelta")
	public int getReDiDeNroVuelta() {
		return ReDiDeNroVuelta;
	}
	@JsonProperty("ReReId")
	public int getReReId() {
		return ReReId;
	}
	@JsonProperty("ReReTiempo")
	public Date getReReTiempo() {
		return ReReTiempo;
	}
	@JsonProperty("TaCoId")
	public int getTaCoId() {
		return TaCoId;
	}
	@JsonProperty("TaCoHoraSalida")
	public Date getTaCoHoraSalida() {
		return TaCoHoraSalida;
	}
	@JsonProperty("HoraLlegada")
	public Date getHoraLlegada() {
		return HoraLlegada;
	}
	@JsonProperty("PuCoTiempoBus")
	public Date getPuCoTiempoBus() {
		return PuCoTiempoBus;
	}
	
	
}
