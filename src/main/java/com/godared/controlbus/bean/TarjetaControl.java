package com.godared.controlbus.bean;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.godared.controlbus.TimeZona;
@Entity
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "Usp_S_TaCoGetAllTarjetaControlByBuIdFecha", 
	procedureName = "Usp_S_TaCoGetAllTarjetaControlByBuIdFecha",
	resultClasses = TarjetaControl.class , 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "buId"),
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class,name = "taCoFecha")
	})
})
public class TarjetaControl implements Serializable{
	@Id 
	@GeneratedValue
	private int TaCoId;
	private int PuCoId;
	private int RuId;
	private int BuId;
	private Date TaCoFecha;	
	private Date TaCoHoraSalida;
	private float TaCoCuota;
	private int UsId;
	private Date UsFechaReg;
	private int TaCoNroVuelta;
	private int PrId;
	private int TiSaId;
	private String TaCoAsignado;
	private Boolean TaCoTipoHoraSalida;
	private int ReDiDeId;
	
	@JsonProperty("TaCoId")
	public int getTaCoId() {
		return TaCoId;
	}
	public void setTaCoId(int taCoId) {
		TaCoId = taCoId;
	}
	@JsonProperty("PuCoId")
	public int getPuCoId() {
		return PuCoId;
	}
	public void setPuCoId(int puCoId) {
		PuCoId = puCoId;
	}
	@JsonProperty("RuId")
	public int getRuId() {
		return RuId;
	}
	public void setRuId(int ruId) {
		RuId = ruId;
	}
	@JsonProperty("BuId")
	public int getBuId() {
		return BuId;
	}
	public void setBuId(int buId) {
		BuId = buId;
	}
	@JsonProperty("TaCoFecha")
	public Date getTaCoFecha() {
		TimeZona timeZona=new TimeZona();
		Date dateCovertida=null;
		dateCovertida=timeZona.CalcularTimeZone(TaCoFecha,true);		
		return dateCovertida;//dato2;// calendar.getTime();//TaCoFecha;
	}
	public void setTaCoFecha(Date taCoFecha) {
		
		TaCoFecha = taCoFecha;
	}
	@JsonProperty("TaCoHoraSalida")
	public Date getTaCoHoraSalida() {
		TimeZona timeZona=new TimeZona();
		Date dateCovertida=null;
		dateCovertida=timeZona.CalcularTimeZone(TaCoHoraSalida,true);
		return dateCovertida;
	}
	public void setTaCoHoraSalida(Date taCoHoraSalida) {
		TimeZona timeZona=new TimeZona();
		Date dateCovertida=null;
		dateCovertida=timeZona.CalcularTimeZone(taCoHoraSalida,false);
		TaCoHoraSalida = dateCovertida;
	}
	@JsonProperty("TaCoCuota")
	public float getTaCoCuota() {
		return TaCoCuota;
	}
	public void setTaCoCuota(float taCoCuota) {
		TaCoCuota = taCoCuota;
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
		TimeZona timeZona=new TimeZona();
		Date dateCovertida=null;
		dateCovertida=timeZona.CalcularTimeZone(usFechaReg,false);
		UsFechaReg = dateCovertida;
	}
	@JsonProperty("TaCoNroVuelta")
	public int getTaCoNroVuelta() {
		return TaCoNroVuelta;
	}
	public void setTaCoNroVuelta(int taCoNroVuelta) {
		TaCoNroVuelta = taCoNroVuelta;
	}
	@JsonProperty("PrId")
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "PrId")
	public int getPrId() {
		return PrId;
	}
	public void setPrId(int prId) {
		PrId = prId;
	}
	@JsonProperty("TiSaId")
	public int getTiSaId() {
		return TiSaId;
	}
	public void setTiSaId(int tiSaId) {
		TiSaId = tiSaId;
	}
	@JsonProperty("TaCoAsignado")
	public String getTaCoAsignado() {
		return TaCoAsignado;
	}
	public void setTaCoAsignado(String taCoAsignado) {
		TaCoAsignado = taCoAsignado;
	}
	@JsonProperty("TaCoTipoHoraSalida")
	public Boolean getTaCoTipoHoraSalida() {
		return TaCoTipoHoraSalida;
	}
	public void setTaCoTipoHoraSalida(Boolean taCoTipoHoraSalida) {
		TaCoTipoHoraSalida = taCoTipoHoraSalida;
	}
	@JsonProperty("ReDiDeId")
	public int getReDiDeId() {
		return ReDiDeId;
	}
	public void setReDiDeId(int reDiDeId) {
		ReDiDeId = reDiDeId;
	}	
	
}
