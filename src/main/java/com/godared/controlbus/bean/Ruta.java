package com.godared.controlbus.bean;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
public class Ruta  implements Serializable  {
	@Id 
	@GeneratedValue
	private int RuId;	
	private	int EmId;
	private String RuDescripcion;
	private Date RuFechaCreacion;
	private String RuRegMunicipal;
	private float RuKilometro;
	private Boolean RuActivo=true;
	private int UsId;
	private Date UsFechaReg;//acepta timestamp
	
	@JsonProperty("RuId")
	public int getRuId() {
		return RuId;
	}
	public void setRuId(int ruId) {
		RuId = ruId;
	}
	@JsonProperty("EmId")
	public int getEmId() {
		return EmId;
	}
	public void setEmId(int emId) {
		EmId = emId;
	}
	@JsonProperty("RuDescripcion")
	public String getRuDescripcion() {
		return RuDescripcion;
	}
	public void setRuDescripcion(String ruDescripcion) {
		RuDescripcion = ruDescripcion;
	}
	@JsonProperty("RuFechaCreacion")
	public Date getRuFechaCreacion() {
		return RuFechaCreacion;
	}
	public void setRuFechaCreacion(Date ruFechaCreacion) {
		RuFechaCreacion = ruFechaCreacion;
	}
	@JsonProperty("RuRegMunicipal")
	public String getRuRegMunicipal() {
		return RuRegMunicipal;
	}
	public void setRuRegMunicipal(String ruRegMunicipal) {
		RuRegMunicipal = ruRegMunicipal;
	}
	@JsonProperty("RuKilometro")
	public float getRuKilometro() {
		return RuKilometro;
	}
	public void setRuKilometro(float ruKilometro) {
		RuKilometro = ruKilometro;
	}
	@JsonProperty("RuActivo")
	public Boolean getRuActivo() {
		return RuActivo;
	}
	public void setRuActivo(Boolean ruActivo) {
		RuActivo = ruActivo;
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
}
