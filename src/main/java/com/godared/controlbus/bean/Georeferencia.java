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
	@NamedStoredProcedureQuery(name = "Usp_S_GeGetAllGeoreferenciaByTaCo", 
	procedureName = "Usp_S_GeGetAllGeoreferenciaByTaCo",
	resultClasses = Georeferencia.class , 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "taCoId")
	}),
	@NamedStoredProcedureQuery(name = "Usp_D_GeEliminaByTaCo", 
	procedureName = "Usp_D_GeEliminaByTaCo",
	//resultClasses = Georeferencia.class , 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "taCoId")
	})
})
public class Georeferencia implements Serializable {
	@Id 
	@GeneratedValue
	private int GeId;
	private int TaCoId;
	private double GeLatitud;
	private double GeLongitud;
	private Date GeFechaHora;
	private int UsId;
	private Date UsFechaReg;
	private int GeOrden;
	private Boolean GeEnviadoMovil;
	
	@JsonProperty("GeId")
	public int getGeId() {
		return GeId;
	}
	public void setGeId(int geId) {
		GeId = geId;
	}
	@JsonProperty("TaCoId")
	public int getTaCoId() {
		return TaCoId;
	}
	public void setTaCoId(int taCoId) {
		TaCoId = taCoId;
	}
	@JsonProperty("GeLatitud")
	public double getGeLatitud() {
		return GeLatitud;
	}
	public void setGeLatitud(double geLatitud) {
		GeLatitud = geLatitud;
	}
	@JsonProperty("GeLongitud")
	public double getGeLongitud() {
		return GeLongitud;
	}
	public void setGeLongitud(double geLongitud) {
		GeLongitud = geLongitud;
	}
	@JsonProperty("GeFechaHora")
	public Date getGeFechaHora() {
		return GeFechaHora;
	}
	public void setGeFechaHora(Date geFechaHora) {
		GeFechaHora = geFechaHora;
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
	@JsonProperty("GeOrden")
	public int getGeOrden() {
		return GeOrden;
	}
	public void setGeOrden(int geOrden) {
		GeOrden = geOrden;
	}
	@JsonProperty("GeEnviadoMovil")
	public Boolean getGeEnviadoMovil() {
		return GeEnviadoMovil;
	}
	public void setGeEnviadoMovil(Boolean geEnviadoMovil) {
		GeEnviadoMovil = geEnviadoMovil;
	}
	
	
	
	
}
