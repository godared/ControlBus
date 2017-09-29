package com.godared.controlbus.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.godared.controlbus.TimeZona;
@Entity
public class Persona implements Serializable {
	@Id 
	@GeneratedValue
	private int PeId;
	private String PeNombres;
	private String PeApellidos; 
	private String PeDNI; 	
	private Date PeFecNac;  
	private String PeDireccion;	
	private String PeTipoLicencia;
	private String PeCelular; 
	private String PeTelefonoFijo; 
	private String PeEmail;
	private Date PeFechaIng; 
	private Date PeFechaSal;
	private int UsId;
	private Date UsFechaReg; 
	private Boolean PeSexo; 
	private String PeEstadoCivil;
	
	@JsonProperty("PeId")
	public int getPeId() {
		return PeId;
	}
	public void setPeId(int peId) {
		PeId = peId;
	}
	@JsonProperty("PeNombres")
	public String getPeNombres() {
		return PeNombres;
	}
	public void setPeNombres(String peNombres) {
		PeNombres = peNombres;
	}
	@JsonProperty("PeApellidos")
	public String getPeApellidos() {
		return PeApellidos;
	}
	public void setPeApellidos(String peApellidos) {
		PeApellidos = peApellidos;
	}
	@JsonProperty("PeDNI")
	public String getPeDNI() {
		return PeDNI;
	}
	public void setPeDNI(String peDNI) {
		PeDNI = peDNI;
	}
	@JsonProperty("PeFecNac")
	public Date getPeFecNac() {
		TimeZona timeZona=new TimeZona();
		Date dateCovertida=null;
		dateCovertida=timeZona.CalcularTimeZone(PeFecNac,true);
		return dateCovertida;
	}
	public void setPeFecNac(Date peFecNac) {
		PeFecNac = peFecNac;
	}
	@JsonProperty("PeDireccion")
	public String getPeDireccion() {
		return PeDireccion;
	}
	public void setPeDireccion(String peDireccion) {
		PeDireccion = peDireccion;
	}	
	@JsonProperty("PeTipoLicencia")
	public String getPeTipoLicencia() {
		return PeTipoLicencia;
	}
	public void setPeTipoLicencia(String peTipoLicencia) {
		PeTipoLicencia = peTipoLicencia;
	}
	@JsonProperty("PeCelular")
	public String getPeCelular() {
		return PeCelular;
	}
	public void setPeCelular(String peCelular) {
		PeCelular = peCelular;
	}
	@JsonProperty("PeTelefonoFijo")
	public String getPeTelefonoFijo() {
		return PeTelefonoFijo;
	}
	public void setPeTelefonoFijo(String peTelefonoFijo) {
		PeTelefonoFijo = peTelefonoFijo;
	}
	@JsonProperty("PeEmail")
	public String getPeEmail() {
		return PeEmail;
	}
	public void setPeEmail(String peEmail) {
		PeEmail = peEmail;
	}
	@JsonProperty("getPeFechaIng")
	public Date getPeFechaIng() {
		TimeZona timeZona=new TimeZona();
		Date dateCovertida=null;
		dateCovertida=timeZona.CalcularTimeZone(PeFechaIng,true);
		return dateCovertida;
	}
	public void setPeFechaIng(Date peFechaIng) {
		PeFechaIng = peFechaIng;
	}
	@JsonProperty("PeFechaSal")
	public Date getPeFechaSal() {
		TimeZona timeZona=new TimeZona();
		Date dateCovertida=null;
		dateCovertida=timeZona.CalcularTimeZone(PeFechaSal,true);
		return dateCovertida;
	}
	public void setPeFechaSal(Date peFechaSal) {
		PeFechaSal = peFechaSal;
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
	@JsonProperty("PeSexo")
	public Boolean getPeSexo() {
		return PeSexo;
	}
	public void setPeSexo(Boolean peSexo) {
		PeSexo = peSexo;
	}
	@JsonProperty("PeEstadoCivil")
	public String getPeEstadoCivil() {
		return PeEstadoCivil;
	}
	public void setPeEstadoCivil(String peEstadoCivil) {
		PeEstadoCivil = peEstadoCivil;
	}
	

}
