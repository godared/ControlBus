package com.godared.controlbus.bean;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
public class RutaDetalle  implements Serializable  {
	@Id 
	@GeneratedValue	
	private int RuId;
	private String RuDeDescripcion;
	private float RuDeLatitud;
	private float RuDeLongitud;
	private int UsId;
	private Date UsFechaReg;
	
	@JsonProperty("RuId")
	public int getRuId() {
		return RuId;
	}
	public void setRuId(int ruId) {
		RuId = ruId;
	}
	@JsonProperty("RuDeDescripcion")
	public String getRuDeDescripcion() {
		return RuDeDescripcion;
	}
	public void setRuDeDescripcion(String ruDeDescripcion) {
		RuDeDescripcion = ruDeDescripcion;
	}
	@JsonProperty("RuDeLatitud")
	public float getRuDeLatitud() {
		return RuDeLatitud;
	}
	public void setRuDeLatitud(float ruDeLatitud) {
		RuDeLatitud = ruDeLatitud;
	}
	@JsonProperty("RuDeLongitud")
	public float getRuDeLongitud() {
		return RuDeLongitud;
	}
	public void setRuDeLongitud(float ruDeLongitud) {
		RuDeLongitud = ruDeLongitud;
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
