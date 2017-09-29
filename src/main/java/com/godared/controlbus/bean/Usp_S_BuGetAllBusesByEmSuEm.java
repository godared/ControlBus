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
import com.godared.controlbus.TimeZona;

@Entity
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "Usp_S_BuGetAllBusesByEmSuEm", 
	procedureName = "Usp_S_BuGetAllBusesByEmSuEm",
	resultClasses = Usp_S_BuGetAllBusesByEmSuEm.class , 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "emId"),
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "suEmId")
	})
})
public class Usp_S_BuGetAllBusesByEmSuEm  implements Serializable {
	@Id
	@GeneratedValue
	private int BuId;
	private int SuEmId;
	private String BuDescripcion;
	private String BuPlaca;
	private int BuCapacidad;
	private String BuMarca;
	private Date BuFechaIngreso;
	private String SuEmRSocial;
	private Boolean BuActivo;
	
	@JsonProperty("BuId")
	public int getBuId() {
		return BuId;
	}
	@JsonProperty("SuEmId")
	public int getSuEmId() {
		return SuEmId;
	}
	@JsonProperty("BuDescripcion")
	public String getBuDescripcion() {
		return BuDescripcion;
	}
	@JsonProperty("BuPlaca")
	public String getBuPlaca() {
		return BuPlaca;
	}
	@JsonProperty("BuCapacidad")
	public int getBuCapacidad() {
		return BuCapacidad;
	}
	@JsonProperty("BuMarca")
	public String getBuMarca() {
		return BuMarca;
	}
	@JsonProperty("BuFechaIngreso")
	public Date getBuFechaIngreso() {
		TimeZona timeZona=new TimeZona();
		Date dateCovertida=null;
		dateCovertida=timeZona.CalcularTimeZone(BuFechaIngreso,true);
		return dateCovertida ;
	}
	@JsonProperty("SuEmRSocial")
	public String getSuEmRSocial() {
		return SuEmRSocial;
	}
	@JsonProperty("BuActivo")
	public Boolean getBuActivo() {
		return BuActivo;
	}
	
	
	
	

}
