package com.godared.controlbus.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.godared.controlbus.TimeZona;
@Entity
public class Bus implements Serializable{
	@Id 
	@GeneratedValue
	private int BuId;
	private int SuEmId;
	private String BuPlaca;
	private int BuAnio;
	private String BuMotor;
	private String BuDescripcion;
	private String BuTipoCombustible;
	private String BuColor;
	private int BuCapacidad;
	private String BuMarca;
	private String BuTipo;
	private String BuSOAT;
	private String BuModelo;
	private Boolean BuOperatividad;
	private Boolean BuActivo;	
	private Date BuFechaIngreso;
	private Date BuFechaSalida;
	private int UsId;
	private Date UsFechaReg;
	
	@JsonProperty("BuId")
	public int getBuId() {
		return BuId;
	}
	public void setBuId(int buId) {
		BuId = buId;
	}
	@JsonProperty("SuEmId")
	public int getSuEmId() {
		return SuEmId;
	}
	public void setSuEmId(int suEmId) {
		SuEmId = suEmId;
	}
	@JsonProperty("BuPlaca")
	public String getBuPlaca() {
		return BuPlaca;
	}
	public void setBuPlaca(String buPlaca) {
		BuPlaca = buPlaca;
	}
	@JsonProperty("BuAnio")
	public int getBuAnio() {
		return BuAnio;
	}
	public void setBuAnio(int buAnio) {
		BuAnio = buAnio;
	}
	@JsonProperty("BuMotor")
	public String getBuMotor() {
		return BuMotor;
	}
	public void setBuMotor(String buMotor) {
		BuMotor = buMotor;
	}
	@JsonProperty("BuDescripcion")
	public String getBuDescripcion() {
		return BuDescripcion;
	}
	public void setBuDescripcion(String buDescripcion) {
		BuDescripcion = buDescripcion;
	}
	@JsonProperty("BuTipoCombustible")
	public String getBuTipoCombustible() {
		return BuTipoCombustible;
	}
	public void setBuTipoCombustible(String buTipoCombustible) {
		BuTipoCombustible = buTipoCombustible;
	}
	@JsonProperty("BuColor")
	public String getBuColor() {
		return BuColor;
	}
	public void setBuColor(String buColor) {
		BuColor = buColor;
	}
	@JsonProperty("BuCapacidad")
	public int getBuCapacidad() {
		return BuCapacidad;
	}
	public void setBuCapacidad(int buCapacidad) {
		BuCapacidad = buCapacidad;
	}
	@JsonProperty("BuMarca")
	public String getBuMarca() {
		return BuMarca;
	}
	public void setBuMarca(String buMarca) {
		BuMarca = buMarca;
	}
	@JsonProperty("BuTipo")
	public String getBuTipo() {
		return BuTipo;
	}
	public void setBuTipo(String buTipo) {
		BuTipo = buTipo;
	}
	@JsonProperty("BuSOAT")
	public String getBuSOAT() {
		return BuSOAT;
	}
	public void setBuSOAT(String buSOAT) {
		BuSOAT = buSOAT;
	}
	@JsonProperty("BuModelo")
	public String getBuModelo() {
		return BuModelo;
	}
	public void setBuModelo(String buModelo) {
		BuModelo = buModelo;
	}
	@JsonProperty("BuOperatividad")
	public Boolean getBuOperatividad() {
		return BuOperatividad;
	}
	public void setBuOperatividad(Boolean buOperatividad) {
		BuOperatividad = buOperatividad;
	}
	@JsonProperty("BuActivo")
	public Boolean getBuActivo() {
		return BuActivo;
	}
	public void setBuActivo(Boolean buActivo) {
		BuActivo = buActivo;
	}
	@JsonProperty("BuFechaIngreso")
	public Date getBuFechaIngreso() {
		return BuFechaIngreso;
	}
	public void setBuFechaIngreso(Date buFechaIngreso) {
		BuFechaIngreso = buFechaIngreso;
	}
	@JsonProperty("BuFechaSalida")
	public Date getBuFechaSalida() {
		TimeZona timeZona=new TimeZona();
		Date dateCovertida=null;
		dateCovertida=timeZona.CalcularTimeZone(BuFechaSalida,true);
		return dateCovertida;
		
	}
	public void setBuFechaSalida(Date buFechaSalida) {
		BuFechaSalida = buFechaSalida;
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
	
	
}
