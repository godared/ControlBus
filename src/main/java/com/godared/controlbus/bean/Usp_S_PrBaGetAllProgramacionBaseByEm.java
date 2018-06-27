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
	@NamedStoredProcedureQuery(name = "Usp_S_PrBaGetAllProgramacionBaseByEm", 
	procedureName = "Usp_S_PrBaGetAllProgramacionBaseByEm",
	resultClasses = Usp_S_PrBaGetAllProgramacionBaseByEm.class , 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "emId"),
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "anio")
	})
})
public class Usp_S_PrBaGetAllProgramacionBaseByEm implements Serializable {
	@Id
	private int PrBaId;
	private String PrBaDescripcion;	
	private Date PrBaFecha;
	private Date PrBaFechaInicio;
	private Date PrBaFechaFin;
	private short dias;	
	private String PrBaDiasIncluidos;
	private int EmId;
	private String EmConsorcio;
	
	
	@JsonProperty("PrBaId")
	public int getPrBaId() {
		return PrBaId;
	}


	@JsonProperty("PrBaDescripcion")
	public String getPrBaDescripcion() {
		return PrBaDescripcion;
	}


	@JsonProperty("PrBaFecha")
	public Date getPrBaFecha() {
		return PrBaFecha;
	}


	@JsonProperty("PrBaFechaInicio")
	public Date getPrBaFechaInicio() {
		return PrBaFechaInicio;
	}


	@JsonProperty("PrBaFechaFin")
	public Date getPrBaFechaFin() {
		return PrBaFechaFin;
	}

	@JsonProperty("PrDiasIncluidos")
	public String getPrDiasIncluidos() {
		return PrBaDiasIncluidos;
	}

	@JsonProperty("EmId")
	public int getEmId() {
		return EmId;
	}

	@JsonProperty("EmConsorcio")
	public String getEmConsorcio() {
		return EmConsorcio;
	}
	
	@JsonProperty("dias")
	public short getDias() {
		Calendar calInicio = Calendar.getInstance();
		Calendar calFin = Calendar.getInstance();
		//Este procedimiento es para separar lo enviado en DIasIncluir en un Array
		//y despues hacemos que el 1 empiece en domingo
		int nroDias=0;
		if(!this.PrBaDiasIncluidos.isEmpty()){
			String[] dias_semana = this.PrBaDiasIncluidos.split(",");		
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
		  	
		  	calInicio.setTime(this.PrBaFechaInicio);
		  	calFin.setTime(this.PrBaFechaFin);
		  	//cal2.get(Calendar.DAY_OF_YEAR)
		  	while(calInicio.getTime().before(calFin.getTime()) ||  calInicio.getTime().equals(calFin.getTime()) ){
		  		int dayOfWeek = calInicio.get(Calendar.DAY_OF_WEEK);
		  		if (dias_semana3[dayOfWeek-1].equals(true)){
		  			nroDias=nroDias+1;
		  		}
		  		calInicio.add(Calendar.DAY_OF_MONTH, 1);
		  	} 
		}
		return (short)nroDias;//dias;
	}
		
	
	
}
