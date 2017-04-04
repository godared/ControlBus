package com.godared.controlbus.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import com.fasterxml.jackson.annotation.JsonProperty;

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
	})
})
public class ProgramacionDetalle implements Serializable {
	@Id 
	private int PrId;
	private int BuId;
	private Date PrDeFecha;
	private Boolean PrDeBase;
	private int PrDeOrden;
	private int UsId;
	private Date UsFechaReg;
	
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
		return PrDeFecha;
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
		return UsFechaReg;
	}
	public void setUsFechaReg(Date usFechaReg) {
		UsFechaReg = usFechaReg;
	}	
	

}
