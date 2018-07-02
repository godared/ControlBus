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
	@NamedStoredProcedureQuery(name = "Usp_D_PrDeEliminaByPr", 
	procedureName = "Usp_D_PrDeEliminaByPr",
	//resultClasses = Usp_S_RuGetAllRutaByEm.class , 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "prId")
	}),	
	@NamedStoredProcedureQuery(name = "Usp_S_PrDeGetAllProgramacionDetalleByPr", 
	procedureName = "Usp_S_PrDeGetAllProgramacionDetalleByPr",
	resultClasses = ProgramacionDetalle.class , 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "prId")
	}),
	@NamedStoredProcedureQuery(name = "Usp_S_PrDeGetAllProgramacionDetalleByPrFecha", 
	procedureName = "Usp_S_PrDeGetAllProgramacionDetalleByPrFecha",
	resultClasses = ProgramacionDetalle.class , 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "prId"),
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class,name = "prDeFecha")
	})
	,
	@NamedStoredProcedureQuery(name = "Usp_S_PrDeGetAllProgramacionDetalleByPrBaFecha", 
	procedureName = "Usp_S_PrDeGetAllProgramacionDetalleByPrBaFecha",
	resultClasses = ProgramacionDetalle.class , 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "prBaId"),
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class,name = "prDeFecha")
	})
})
public class ProgramacionDetalle implements Serializable {
	@Id
	@GeneratedValue
	private int PrDeId;
	private int PrId;
	private int BuId;
	private Date PrDeFecha;
	private Boolean PrDeBase;
	private int PrDeOrden;
	private int UsId;
	private Date UsFechaReg;
	private short PrDeAsignadoTarjeta;
	private short PrDeCountVuelta;
	private Date PrDeHoraBase;
	
	@JsonProperty("PrDeId")
	public int getPrDeId() {
		return PrDeId;
	}
	public void setPrDeId(int prDeId) {
		PrDeId = prDeId;
	}
	@JsonProperty("PrId")
	public int getPrId() {
		return PrId;
	}
	public void setPrId(int prId) {
		PrId = prId;
	}
	@JsonProperty("BuId")
	public int getBuId() {
		return BuId;
	}
	public void setBuId(int buId) {
		BuId = buId;
	}
	@JsonProperty("PrDeFecha")
	public Date getPrDeFecha() {
		TimeZona timeZona=new TimeZona();
		Date dateCovertida=null;
		dateCovertida=timeZona.CalcularTimeZone(PrDeFecha,true);
		return dateCovertida;
		
	}
	public void setPrDeFecha(Date prDeFecha) {
		PrDeFecha = prDeFecha;
	}
	@JsonProperty("PrDeBase")
	public Boolean getPrDeBase() {
		return PrDeBase;
	}
	public void setPrDeBase(Boolean prDeBase) {
		PrDeBase = prDeBase;
	}
	@JsonProperty("PrDeOrden")
	public int getPrDeOrden() {
		return PrDeOrden;
	}
	public void setPrDeOrden(int prDeOrden) {
		PrDeOrden = prDeOrden;
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
	@JsonProperty("PrDeAsignadoTarjeta")
	public short getPrDeAsignadoTarjeta() {
		return PrDeAsignadoTarjeta;
	}
	public void setPrDeAsignadoTarjeta(short prDeAsignadoTarjeta) {
		this.PrDeAsignadoTarjeta = prDeAsignadoTarjeta;
	}
	@JsonProperty("PrDeCountVuelta")
	public short getPrDeCountVuelta() {
		return PrDeCountVuelta;
	}
	public void setPrDeCountVuelta(short prDeCountVuelta) {
		PrDeCountVuelta = prDeCountVuelta;
	}
	@JsonProperty("PrDeHoraBase")
	public Date getPrDeHoraBase() {
		return PrDeHoraBase;
	}
	public void setPrDeHoraBase(Date prDeHoraBase) {
		PrDeHoraBase = prDeHoraBase;
	}	
	


}
