package com.godared.controlbus.bean;

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
	@NamedStoredProcedureQuery(name = "Usp_S_PeGetAllPersonaByEmSuEm", 
	procedureName = "Usp_S_PeGetAllPersonaByEmSuEm",
	resultClasses = Usp_S_PeGetAllPersonaByEmSuEm.class , 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "emId"),
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "suEmId")
	}),
	@NamedStoredProcedureQuery(name = "Usp_S_PeGetAllPersonaByEmBu", 
	procedureName = "Usp_S_PeGetAllPersonaByEmBu",
	resultClasses = Usp_S_PeGetAllPersonaByEmSuEm.class , 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "emId"),
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "buId")
	})
})
public class Usp_S_PeGetAllPersonaByEmSuEm {
	@Id
	private String PeNombres;
	private String PeApellidos; 
	private String PeDNI; 	
	private Date PeFecNac;	
	private String PeEmail;
	private Date PeFechaIng; 
	private Boolean PeSexo; 
	private String EmPeTipo;
	private String SuEmRSocial;
	private int Id;//este Id es por que esta clase se usa para dos procedimientos almacenados de la tabla BusPersona y EmpresaPersona(es el Id de ambos)
	private int PeId;
	private int EmId;
	private int SuEmId;
	private int BuId;
	
	@JsonProperty("PeNombres")
	public String getPeNombres() {
		return PeNombres;
	}
	@JsonProperty("PeApellidos")
	public String getPeApellidos() {
		return PeApellidos;
	}
	@JsonProperty("PeDNI")
	public String getPeDNI() {
		return PeDNI;
	}
	@JsonProperty("PeFecNac")
	public Date getPeFecNac() {
		return PeFecNac;
	}	
	@JsonProperty("PeEmail")
	public String getPeEmail() {
		return PeEmail;
	}
	@JsonProperty("PeFechaIng")
	public Date getPeFechaIng() {
		return PeFechaIng;
	}
	@JsonProperty("PeSexo")
	public Boolean getPeSexo() {
		return PeSexo;
	}
	@JsonProperty("EmPeTipo")
	public String getEmPeTipo() {
		return EmPeTipo;
	}
	@JsonProperty("SuEmRSocial")
	public String getSuEmRSocial() {
		return SuEmRSocial;
	}
	@JsonProperty("Id")
	public int getId() {
		return Id;
	}
	@JsonProperty("PeId")
	public int getPeId() {
		return PeId;
	}
	@JsonProperty("EmId")
	public int getEmId() {
		return EmId;
	}
	@JsonProperty("SuEmId")
	public int getSuEmId() {
		return SuEmId;
	}
	@JsonProperty("BuId")
	public int getBuId() {
		return BuId;
	}
	

}
