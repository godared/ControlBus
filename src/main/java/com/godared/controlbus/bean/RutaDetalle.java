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
	private int RuId;
	private int RuDeOrden;
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
	@JsonProperty("RuDeOrden")
	public int getRuDeOrden() {
		return RuDeOrden;
	}
	public void setRuDeOrden(int ruDeOrden) {
		RuDeOrden = ruDeOrden;
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
