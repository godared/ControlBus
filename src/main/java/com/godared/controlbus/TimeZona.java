package com.godared.controlbus;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/*
 *Esta clase hace la coversion de zona horario de acuerdo a lo que esta configurado
 *el servidor de OPENSHIFT, segun lo que pude averifuar esta configurado con una 
 *zona horario de EE.UU/Virgina(no puede configurarlo en el server xq hay que pagar como cuenta premium).
 *La cosa es que el EE.UU/Virgina existen dos zonas horarioa la de verano y la de invierno y en vera suma 2 hora y la de invierno 1 o algo asi
*por ejemplo cuando se hace la conversion, resultaria aumentado mas la hora segun la fecha horaria:
*la proyecciones horarias lo saque de aqui:http://www.hora.es/cambiohorario/dst.do?tz=America/New_York
*/

public  class TimeZona {
	private Date InicioTemporada;
	private Date FinTemporada;
	private int Valor;
	private Date Fechaorigen;
	
	public TimeZona(){
		
	}
	public TimeZona(Date inicioTemporada,Date finTemporada,int valor){
			this.setInicioTemporada(inicioTemporada);
			this.setFinTemporada(finTemporada);
			this.setValor(valor);
	}
	public Date CalcularTimeZone(Date fechaorigen, boolean getMostrar ){
		String zona;
		if (getMostrar)
			zona="America/Montevideo";
		else
			zona="America/Lima";
		Date fechaConvertida=null;
		//HAcemos la COnversion y adicion segun zona horaria
		TimeZone timeZone2 = TimeZone.getTimeZone(zona); //-3GMT		
		String dateFormat = "MMMM dd,yyyy G"; //MMMM dd,yyyy G
     	String timeFormat = "yyyy-MM-dd kk:mm:ss";
		DateFormat dateFormat2 = new SimpleDateFormat(timeFormat);
		Calendar cal = Calendar.getInstance(timeZone2);
		
		//verificamos si es nulo se asignamos una fecha por defecto
		String fechaTimestamp="1970-01-01 00:00:00";
		if(fechaorigen==null){
			try{
			dateFormat2.setTimeZone(cal.getTimeZone());	
			fechaorigen=dateFormat2.parse(fechaTimestamp);
			}
			catch (ParseException e) {
	            e.printStackTrace();
	        }
		}
		////////////////////////
		cal.setTime(fechaorigen);
		 
		dateFormat2.setTimeZone(cal.getTimeZone());
		String currentTime = dateFormat2.format(cal.getTime());
		Date dateZona=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
		 try {
		 dateZona=sdf.parse(currentTime);
		 }catch (ParseException e) {
            e.printStackTrace();
        }
		///Ahora agregamos 0 o 2 dependiend del la zona
		 List<TimeZona> timeZonas=null;
		 timeZonas=LlenarTimeZone();
		 fechaConvertida=dateZona;
		 int c=1,c2=0, ano=0,ano2=0;
		 for(TimeZona timeZona:timeZonas){
			 //Este codigo es para lo especial del server openshift
			 //cuando es el feha inicio(solo un dia) del segundo periodo del año solamente resta en 1 
			 if (c==1){
				cal.setTime(timeZona.getInicioTemporada());
			 	ano=cal.get(Calendar.YEAR);
			 }
			 cal.setTime(timeZona.getInicioTemporada());
			 ano2=cal.get(Calendar.YEAR);
			 c2=c2+1;
			 if(ano!=ano2){
				 cal.setTime(timeZona.getInicioTemporada());
				 ano=cal.get(Calendar.YEAR);
				 c2=1;
			 }
			//fin de ese caso especial	 
			 if(dateZona.getTime()>=timeZona.getInicioTemporada().getTime() & dateZona.getTime()<=timeZona.getFinTemporada().getTime())
			 {
				 cal.setTime(dateZona);
				 if (c2==2 & dateZona.getDate()==timeZona.getInicioTemporada().getDate())
					 cal.add(Calendar.HOUR_OF_DAY, -1);				 					 
				 else					 
					 cal.add(Calendar.HOUR_OF_DAY, -timeZona.getValor());
				 
				fechaConvertida=cal.getTime();
			 }
			 
			 c=c+1;
			 
		 }		 
		
		return fechaConvertida;
	}
	public List<TimeZona> LlenarTimeZone(){
				
		List<TimeZona> timeZones=new ArrayList();		
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
		//String _fechaInicio="2014-03-10 00:00:00";
		//String _fechaFin="2014-11-04 23:59:59";
		try {
            //Date _fechaInicioDate = formatter.parse(_fechaInicio);
            //Date _fechaFinDate = formatter.parse(_fechaInicio);
			///Agregamos los cambios zonas horaria de EEUU/virgina esto lo saque http://www.cuandopasa.com/index.php?v=m11000000n167d&p=2 
            timeZones.add(new TimeZona(formatter.parse("2014-03-10 00:00:00"),formatter.parse("2014-11-01 23:59:59"),0));
            timeZones.add(new TimeZona(formatter.parse("2014-11-02 00:00:00"),formatter.parse("2015-03-08 23:59:59"),2));
            ///
            timeZones.add(new TimeZona(formatter.parse("2015-03-09 00:00:00"),formatter.parse("2015-10-31 23:59:59"),0));
            timeZones.add(new TimeZona(formatter.parse("2015-11-01 00:00:00"),formatter.parse("2016-03-13 23:59:59"),2));
            ///
            timeZones.add(new TimeZona(formatter.parse("2016-03-14 00:00:00"),formatter.parse("2016-11-05 23:59:59"),0));
            timeZones.add(new TimeZona(formatter.parse("2016-11-06 00:00:00"),formatter.parse("2017-03-12 23:59:59"),2));
            ///
            timeZones.add(new TimeZona(formatter.parse("2017-03-13 00:00:00"),formatter.parse("2017-11-04 23:59:59"),0));
            timeZones.add(new TimeZona(formatter.parse("2017-11-05 00:00:00"),formatter.parse("2018-03-11 23:59:59"),2));
            ///
            timeZones.add(new TimeZona(formatter.parse("2018-03-12 00:00:00"),formatter.parse("2018-11-03 23:59:59"),0));
            timeZones.add(new TimeZona(formatter.parse("2018-11-04 00:00:00"),formatter.parse("2019-03-10 23:59:59"),2));
            ///
            timeZones.add(new TimeZona(formatter.parse("2019-03-11 00:00:00"),formatter.parse("2019-11-02 23:59:59"),0));
            timeZones.add(new TimeZona(formatter.parse("2019-11-03 00:00:00"),formatter.parse("2020-03-08 23:59:59"),2));
            ///
            timeZones.add(new TimeZona(formatter.parse("2020-03-09 00:00:00"),formatter.parse("2020-10-31 23:59:59"),0));
            timeZones.add(new TimeZona(formatter.parse("2020-11-01 00:00:00"),formatter.parse("2021-03-14 23:59:59"),2));
            ///
            timeZones.add(new TimeZona(formatter.parse("2021-03-15 00:00:00"),formatter.parse("2021-10-06 23:59:59"),0));
            timeZones.add(new TimeZona(formatter.parse("2021-11-07 00:00:00"),formatter.parse("2022-03-13 23:59:59"),2));
            ///
            timeZones.add(new TimeZona(formatter.parse("2022-03-14 00:00:00"),formatter.parse("2022-11-05 23:59:59"),0));
            timeZones.add(new TimeZona(formatter.parse("2022-11-06 00:00:00"),formatter.parse("2023-03-12 23:59:59"),2));
            ///
            timeZones.add(new TimeZona(formatter.parse("2023-03-13 00:00:00"),formatter.parse("2023-11-04 23:59:59"),0));
            timeZones.add(new TimeZona(formatter.parse("2023-11-05 00:00:00"),formatter.parse("2024-03-10 23:59:59"),0));
            ///
            timeZones.add(new TimeZona(formatter.parse("2024-03-11 00:00:00"),formatter.parse("2024-11-02 23:59:59"),0));
            timeZones.add(new TimeZona(formatter.parse("2024-11-03 00:00:00"),formatter.parse("2025-03-10 23:59:59"),0));
                      
            
		 } catch (ParseException e) {
	            e.printStackTrace();
	     }
		return timeZones;
	}
	public Date getInicioTemporada() {
		return InicioTemporada;
	}
	public void setInicioTemporada(Date inicioTemporada) {
		this.InicioTemporada = inicioTemporada;
	}
	public Date getFinTemporada() {
		return FinTemporada;
	}
	public void setFinTemporada(Date finTemporada) {
		this.FinTemporada = finTemporada;
	}
	public int getValor() {
		return Valor;
	}
	public void setValor(int valor) {
		Valor = valor;
	}
	
	

}
