package com.godared.controlbus.bean;

import java.io.Serializable;

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
	@NamedStoredProcedureQuery(name = "Usp_S_UsGetAllUsuarioByEm", 
	procedureName = "Usp_S_UsGetAllUsuarioByEm",
	resultClasses = Usp_S_UsGetAllUsuarioByEm.class , 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "emId"),
		@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class,name = "usUserName"),
		@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class,name = "usPassword")
	})
})
public class Usp_S_UsGetAllUsuarioByEm  implements Serializable {
	@Id
	@GeneratedValue
	private int UsId;
	private String PeNombres; 
	private String PeApellidos; 
	private String UsUserName;
	private int EmId;
	private Boolean UsActivo;
	
	@JsonProperty("UsId")
	public int getUsId() {
		return UsId;
	}
	@JsonProperty("PeNombres")
	public String getPeNombres() {
		return PeNombres;
	}
	@JsonProperty("PeApellidos")
	public String getPeApellidos() {
		return PeApellidos;
	}
	@JsonProperty("UsUserName")
	public String getUsUserName() {
		return UsUserName;
	}
	@JsonProperty("EmId")
	public int getEmId() {
		return EmId;
	}
	@JsonProperty("UsActivo")
	public Boolean getUsActivo() {
		return UsActivo;
	}
	

}
