package com.godared.controlbus.bean;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
/*@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "Usp_S_GetAllRegistroVueltasDiariasByEmPrFe", 
	procedureName = "Usp_S_GetAllRegistroVueltasDiariasByEmPrFe",
	resultClasses = Usp_S_GetAllRegistroVueltasDiariasByEmPrFe.class , 
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "emId"),
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class,name = "prId"),
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Date.class,name = "fechaDiario")
	})
})*/
public class Usp_S_GetAllRegistroVueltasDiariasByEmPrFe implements Serializable {
	//aqui hay algo muy importante para el @id tiene que ser la columna que se quiere se muestre pe. 365 y 365 son los unicos 
	// valores pero estos a su vez tienen un conjuntos de registros es como un detalle.
	@Id
	
	//@GeneratedValue
	private int Id;	
	private int PrDeId;
	private int BuId;
	private int PrDeOrden;
	private String BuPlaca;
	private int ReDiId;
	private int ReDiDeId;	
	private int ReDiDeNroVuelta;
	private int ReReId;
	private Date ReReTiempo;
	private int TaCoId;
	private Date TaCoHoraSalida;
	private Date HoraLlegada;
	private Date PuCoTiempoBus;
	private String TaCoAsignado;
	private Boolean TaCoMultiple;
	private int SuEmId;
	
	@JsonProperty("Id")
	public int getId() {
		return Id;
	}
	@JsonProperty("PrDeId")
	public int getPrDeId() {
		return PrDeId;
	}
	@JsonProperty("BuId")
	public int getBuId() {
		return BuId;
	}
	@JsonProperty("PrDeOrden")
	public int getPrDeOrden() {
		return PrDeOrden;
	}
	@JsonProperty("BuPlaca")
	public String getBuPlaca() {
		return BuPlaca;
	}
	@JsonProperty("ReDiId")
	public int getReDiId() {
		return ReDiId;
	}
	@JsonProperty("ReDiDeId")
	public int getReDiDeId() {
		return ReDiDeId;
	}
	@JsonProperty("ReDiDeNroVuelta")
	public int getReDiDeNroVuelta() {
		return ReDiDeNroVuelta;
	}
	@JsonProperty("ReReId")
	public int getReReId() {
		return ReReId;
	}
	@JsonProperty("ReReTiempo")
	public Date getReReTiempo() {
		return ReReTiempo;
	}
	@JsonProperty("TaCoId")
	public int getTaCoId() {
		return TaCoId;
	}
	@JsonProperty("TaCoHoraSalida")
	public Date getTaCoHoraSalida() {
		return TaCoHoraSalida;
	}
	@JsonProperty("HoraLlegada")
	public Date getHoraLlegada() {
		Calendar cal = Calendar.getInstance();
		String fechaTimestamp="00:00:00";
		String timeFormat = "kk:mm:ss"; //"yyyy-MM-dd kk:mm:ss";
		DateFormat dateFormat2 = new SimpleDateFormat(timeFormat);
		
		Date _tiempoSalida=this.TaCoHoraSalida;
		Date _tiempoTiempoVuelta=this.PuCoTiempoBus;
		//Date _tiempoReten=this.ReReTiempo;
		Date _tiempoLlegada=null;
		int _minuto=0,_segundo=0,_hora=0;
		int _minutoVuelta=0,_segundoVuelta=0,_horaVuelta=0;
		//Si en caso en tiempoSalida es null
		if(_tiempoSalida==null){
			//dateFormat2.setTimeZone(cal.getTimeZone());	
			try{
				_tiempoSalida=dateFormat2.parse(fechaTimestamp);
			}
			catch (ParseException e) {
	            e.printStackTrace();
	        }
		}
		/*
		//Agregamos el tiempo de Reten
		if(_tiempoReten==null){
			//dateFormat2.setTimeZone(cal.getTimeZone());	
			try{
				_tiempoReten=dateFormat2.parse(fechaTimestamp);
			}
			catch (ParseException e) {
	            e.printStackTrace();
	        }
		}
		cal.setTime(_tiempoReten);
		_minuto=cal.get(Calendar.MINUTE);			
		_segundo=cal.get(Calendar.SECOND);
		_hora=cal.get(Calendar.HOUR);
		cal.setTime(_tiempoSalida);
		cal.add(Calendar.MINUTE, _minuto); // agrega 20 minutos
		cal.add(Calendar.SECOND, _segundo);
		cal.add(Calendar.HOUR, _hora);
		_tiempoSalida=cal.getTime();*/
		//Agregamos el reten de Vuelta
		if(_tiempoTiempoVuelta==null){
			//dateFormat2.setTimeZone(cal.getTimeZone());	
			try{
				_tiempoTiempoVuelta=dateFormat2.parse(fechaTimestamp);
			}
			catch (ParseException e) {
	            e.printStackTrace();
	        }
		}
		cal.setTime(_tiempoTiempoVuelta);
		_minuto=cal.get(Calendar.MINUTE);			
		_segundo=cal.get(Calendar.SECOND);
		_hora=cal.get(Calendar.HOUR);
		cal.setTime(_tiempoSalida);
		cal.add(Calendar.MINUTE, _minuto); // agrega 20 minutos
		cal.add(Calendar.SECOND, _segundo);
		cal.add(Calendar.HOUR, _hora);
		_tiempoSalida=cal.getTime();
		_tiempoLlegada=_tiempoSalida;
		if(_tiempoLlegada==null){
			//dateFormat2.setTimeZone(cal.getTimeZone());	
			try{
			_tiempoLlegada=dateFormat2.parse(fechaTimestamp);
			}
			catch (ParseException e) {
	            e.printStackTrace();
	        }
		}	
		return _tiempoLlegada; //HoraLlegada;		
	}
	@JsonProperty("PuCoTiempoBus")
	public Date getPuCoTiempoBus() {
		return PuCoTiempoBus;
	}
	@JsonProperty("TaCoAsignado")
	public String getTaCoAsignado() {
		return TaCoAsignado;
	}
	@JsonProperty("TaCoMultiple")
	public Boolean getTaCoMultiple() {
		return TaCoMultiple;
	}
	//TODOS LOS SETTTER-- jejeje
	public void setId(int id) {
		Id = id;
	}
	public void setPrDeId(int prDeId) {
		PrDeId = prDeId;
	}
	public void setBuId(int buId) {
		BuId = buId;
	}
	public void setPrDeOrden(int prDeOrden) {
		PrDeOrden = prDeOrden;
	}
	public void setBuPlaca(String buPlaca) {
		BuPlaca = buPlaca;
	}
	public void setReDiId(int reDiId) {
		ReDiId = reDiId;
	}
	public void setReDiDeId(int reDiDeId) {
		ReDiDeId = reDiDeId;
	}
	public void setReDiDeNroVuelta(int reDiDeNroVuelta) {
		ReDiDeNroVuelta = reDiDeNroVuelta;
	}
	public void setReReId(int reReId) {
		ReReId = reReId;
	}
	public void setReReTiempo(Date reReTiempo) {
		ReReTiempo = reReTiempo;
	}
	public void setTaCoId(int taCoId) {
		TaCoId = taCoId;
	}
	public void setTaCoHoraSalida(Date taCoHoraSalida) {
		TaCoHoraSalida = taCoHoraSalida;
	}
	public void setHoraLlegada(Date horaLlegada) {
		HoraLlegada = horaLlegada;
	}
	public void setPuCoTiempoBus(Date puCoTiempoBus) {
		PuCoTiempoBus = puCoTiempoBus;
	}
	public void setTaCoAsignado(String taCoAsignado) {
		TaCoAsignado = taCoAsignado;
	}
	public void setTaCoMultiple(Boolean taCoMultiple) {
		TaCoMultiple = taCoMultiple;
	}
	@JsonProperty("SuEmId")
	public int getSuEmId() {
		return SuEmId;
	}
	public void setSuEmId(int suEmId) {
		SuEmId = suEmId;
	}
	
	
}
