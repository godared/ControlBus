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
	@NamedStoredProcedureQuery(name = "Usp_D_RuDeEliminaByRu", 
	procedureName = "Usp_D_RuDeEliminaByRu",
	//resultClasses = Usp_S_RuGetAllRutaByEm.class , 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "ruId")
	}),
	@NamedStoredProcedureQuery(name = "Usp_S_RuDeGetAllRutaDetalleByRu", 
	procedureName = "Usp_S_RuDeGetAllRutaDetalleByRu",
	resultClasses = RutaDetalle.class , 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "ruId")
	})
})
public class RutaDetalle  implements Serializable  {
	@Id	
	@GeneratedValue
	private int RuDeId;
	private int RuId;
	private int RuDeOrden;
	private double RuDeLatitud;
	private double RuDeLongitud;
	private int UsId;
	private Date UsFechaReg;
	

	@JsonProperty("RuDeId")
	public int getRuDeId() {
		return RuDeId;
	}
	public void setRuDeId(int ruDeId) {
		RuDeId = ruDeId;
	}
	@JsonProperty("RuId")
	public int getRuId() {
		return RuId;
	}
	public void setRuId(int ruId) {
		RuId = ruId;
	}
	@JsonProperty("RuDeOrden")
	public int getRuDeOrden() {
		return RuDeOrden;
	}
	public void setRuDeOrden(int ruDeOrden) {
		RuDeOrden = ruDeOrden;
	}
	@JsonProperty("RuDeLatitud")
	public double getRuDeLatitud() {
		return RuDeLatitud;
	}
	public void setRuDeLatitud(double ruDeLatitud) {
		RuDeLatitud = ruDeLatitud;
	}
	@JsonProperty("RuDeLongitud")
	public double getRuDeLongitud() {
		return RuDeLongitud;
	}
	public void setRuDeLongitud(double ruDeLongitud) {
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
		TimeZona timeZona=new TimeZona();
		Date dateCovertida=null;
		dateCovertida=timeZona.CalcularTimeZone(UsFechaReg,true);
		return dateCovertida;
		
	}
	public void setUsFechaReg(Date usFechaReg) {
		UsFechaReg = usFechaReg;
	}

	
	
}
