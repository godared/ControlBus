package com.godared.controlbus.bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.godared.controlbus.TimeZona;

@Entity
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "Usp_S_PrGetAllProgramacionByEm", 
	procedureName = "Usp_S_PrGetAllProgramacionByEm",
	resultClasses = Usp_S_PrGetAllProgramacionByEm.class , 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "emId"),
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "anio")
	})
})
public class Usp_S_PrGetAllProgramacionByEm implements Serializable {
	@Id
	private int prId;
	private String prDescripcion;
	private int PrCantidadBuses;
	private Date PrFecha;
	private Date PrFechaInicio;
	private Date PrFechaFin;
	private short dias;
	private String PrTipo; 
	private Boolean PrAleatorio;	
	private String EmConsorcio;
	private String PrDiasIncluidos;
	
	@JsonProperty("prId")
	public int getPrId() {
		return prId;
	}
	@JsonProperty("prDescripcion")
	public String getPrDescripcion() {
		return prDescripcion;
	}
	@JsonProperty("PrCantidadBuses")
	public int getPrCantidadBuses() {
		return PrCantidadBuses;
	}
	@JsonProperty("PrFecha")
	public Date getPrFecha() {
		TimeZona timeZona=new TimeZona();
		Date dateCovertida=null;
		dateCovertida=timeZona.CalcularTimeZone(PrFecha,true);
		return dateCovertida;
	}
	@JsonProperty("PrFechaInicio")
	public Date getPrFechaInicio() {
		TimeZona timeZona=new TimeZona();
		Date dateCovertida=null;
		dateCovertida=timeZona.CalcularTimeZone(PrFechaInicio,true);
		return dateCovertida;
	}
	@JsonProperty("PrFechaFin")
	public Date getPrFechaFin() {
		TimeZona timeZona=new TimeZona();
		Date dateCovertida=null;
		dateCovertida=timeZona.CalcularTimeZone(PrFechaFin,true);
		return dateCovertida;
	}
	@JsonProperty("dias")
	public short getDias() {
		Calendar calInicio = Calendar.getInstance();
		Calendar calFin = Calendar.getInstance();
		//Este procedimiento es para separar lo enviado en DIasIncluir en un Array
		//y despues hacemos que el 1 empiece en domingo
		String[] dias_semana = this.PrDiasIncluidos.split(",");		
	  	Boolean[] dias_semana3=new Boolean[7]; 
	  	int count1=1;
	  	for(int i=0;i<dias_semana.length;i++){
	  		System.out.println(dias_semana[i]);
	  		if (i==6)
	  			dias_semana3[0]=(dias_semana[i].equals("1"))?true:false;
	  		else
	  			dias_semana3[count1]=(dias_semana[i].equals("1"))?true:false; 			
	  		count1=count1+1;
	  	}
	  //obtenemos los dias reales descontando los dias no considerados
	  	int nroDias=0;
	  	calInicio.setTime(this.PrFechaInicio);
	  	calFin.setTime(this.PrFechaFin);
	  	//cal2.get(Calendar.DAY_OF_YEAR)
	  	while(calInicio.getTime().before(calFin.getTime()) ||  calInicio.getTime().equals(calFin.getTime()) ){
	  		int dayOfWeek = calInicio.get(Calendar.DAY_OF_WEEK);
	  		if (dias_semana3[dayOfWeek-1].equals(true)){
	  			nroDias=nroDias+1;
	  		}
	  		calInicio.add(Calendar.DAY_OF_MONTH, 1);
	  	} 
		
		return (short)nroDias;//dias;
	}
	@JsonProperty("PrTipo")
	public String getPrTipo() {
		return PrTipo;
	}
	@JsonProperty("PrAleatorio")
	public Boolean getPrAleatorio() {
		return PrAleatorio;
	}
	@JsonProperty("EmConsorcio")
	public String getEmConsorcio() {
		return EmConsorcio;
	}
	@JsonProperty("PrDiasIncluidos")
	public String getPrDiasIncluidos() {
		return PrDiasIncluidos;
	}
	
	
}
