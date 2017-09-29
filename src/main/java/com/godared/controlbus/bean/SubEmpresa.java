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
	@NamedStoredProcedureQuery(name = "Usp_D_SuEmEliminaByEm", 
	procedureName = "Usp_D_SuEmEliminaByEm",	
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "emId")
	}),
	@NamedStoredProcedureQuery(name = "Usp_S_SuEmGetAllSubEmpresaByEm", 
	procedureName = "Usp_S_SuEmGetAllSubEmpresaByEm",
	resultClasses = SubEmpresa.class , 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "emId")
	})
})
public class SubEmpresa implements Serializable {
	@Id 
	@GeneratedValue
	private int SuEmId;
	private int EmId;
	private String SuEmRuc;
	private String SuEmDireccion;
	private String SuEmUbigeo;
	private String SuEmTelefono;
	private String SuEmEmail; 
	private Date SuEmTiempoVuelta; 
	private Boolean SuEmActivo; 
	private int UsId; 
	private Date UsFechaReg;
	private String SuEmRSocial;
	
	@JsonProperty("SuEmId")
	public int getSuEmId() {
		return SuEmId;
	}
	public void setSuEmId(int suEmId) {
		SuEmId = suEmId;
	}
	@JsonProperty("EmId")
	public int getEmId() {
		return EmId;
	}
	public void setEmId(int emId) {
		EmId = emId;
	}
	@JsonProperty("SuEmRuc")
	public String getSuEmRuc() {
		return SuEmRuc;
	}
	public void setSuEmRuc(String suEmRuc) {
		SuEmRuc = suEmRuc;
	}
	@JsonProperty("SuEmDireccion")
	public String getSuEmDireccion() {
		return SuEmDireccion;
	}
	public void setSuEmDireccion(String suEmDireccion) {
		SuEmDireccion = suEmDireccion;
	}
	@JsonProperty("SuEmUbigeo")
	public String getSuEmUbigeo() {
		return SuEmUbigeo;
	}
	public void setSuEmUbigeo(String suEmUbigeo) {
		SuEmUbigeo = suEmUbigeo;
	}
	@JsonProperty("SuEmTelefono")
	public String getSuEmTelefono() {
		return SuEmTelefono;
	}
	public void setSuEmTelefono(String suEmTelefono) {
		SuEmTelefono = suEmTelefono;
	}
	@JsonProperty("SuEmEmail")
	public String getSuEmEmail() {
		return SuEmEmail;
	}
	public void setSuEmEmail(String suEmEmail) {
		SuEmEmail = suEmEmail;
	}
	@JsonProperty("SuEmTiempoVuelta")
	public Date getSuEmTiempoVuelta() {
		return SuEmTiempoVuelta;
	}
	public void setSuEmTiempoVuelta(Date suEmTiempoVuelta) {
		SuEmTiempoVuelta = suEmTiempoVuelta;
	}
	@JsonProperty("SuEmActivo")
	public Boolean getSuEmActivo() {
		return SuEmActivo;
	}
	public void setSuEmActivo(Boolean suEmActivo) {
		SuEmActivo = suEmActivo;
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
	@JsonProperty("SuEmRSocial")
	public String getSuEmRSocial() {
		return SuEmRSocial;
	}
	public void setSuEmRSocial(String suEmRSocial) {
		SuEmRSocial = suEmRSocial;
	}
	


}
