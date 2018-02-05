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
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "Usp_S_CoGetAllConfiguraByEmPeriodo", 
	procedureName = "Usp_S_CoGetAllConfiguraByEmPeriodo",
	resultClasses = Configura.class , 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "emId"),
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "coPeriodo")
	})
})
public class Configura implements Serializable {
	@Id 
	@GeneratedValue
	private int CoId;
	private int EmId;
	private int CoPeriodo; 
	private int CoNroMaxVueltas;
	private String CoLogo;
	private int CoCountMovilTaCo; 
	private int CoCountMovilTaCoDe;
	private String CoMembreReporte;
	private int UsId; 
	private Date UsFechaReg;
	private int CoSiId;
	@JsonProperty("CoId")
	public int getCoId() {
		return CoId;
	}
	public void setCoId(int coId) {
		CoId = coId;
	}
	@JsonProperty("EmId")
	public int getEmId() {
		return EmId;
	}
	public void setEmId(int emId) {
		EmId = emId;
	}
	@JsonProperty("CoPeriodo")
	public int getCoPeriodo() {
		return CoPeriodo;
	}
	public void setCoPeriodo(int coPeriodo) {
		CoPeriodo = coPeriodo;
	}
	@JsonProperty("CoNroMaxVueltas")
	public int getCoNroMaxVueltas() {
		return CoNroMaxVueltas;
	}
	public void setCoNroMaxVueltas(int coNroMaxVueltas) {
		CoNroMaxVueltas = coNroMaxVueltas;
	}
	@JsonProperty("CoLogo")
	public String getCoLogo() {
		return CoLogo;
	}
	public void setCoLogo(String coLogo) {
		CoLogo = coLogo;
	}
	@JsonProperty("CoCountMovilTaCo")
	public int getCoCountMovilTaCo() {
		return CoCountMovilTaCo;
	}
	public void setCoCountMovilTaCo(int coCountMovilTaCo) {
		CoCountMovilTaCo = coCountMovilTaCo;
	}
	@JsonProperty("CoCountMovilTaCoDe")
	public int getCoCountMovilTaCoDe() {
		return CoCountMovilTaCoDe;
	}
	public void setCoCountMovilTaCoDe(int coCountMovilTaCoDe) {
		CoCountMovilTaCoDe = coCountMovilTaCoDe;
	}
	@JsonProperty("CoMembreReporte")
	public String getCoMembreReporte() {
		return CoMembreReporte;
	}
	public void setCoMembreReporte(String coMembreReporte) {
		CoMembreReporte = coMembreReporte;
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
		return UsFechaReg;
	}
	public void setUsFechaReg(Date usFechaReg) {
		UsFechaReg = usFechaReg;
	}
	@JsonProperty("CoSiId")
	public int getCoSiId() {
		return CoSiId;
	}
	public void setCoSiId(int coSiId) {
		CoSiId = coSiId;
	}
	

	
}
