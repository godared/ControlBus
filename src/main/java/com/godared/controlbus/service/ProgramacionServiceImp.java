package com.godared.controlbus.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.apache.commons.lang3.SerializationUtils;

import com.godared.controlbus.bean.Bus;
import com.godared.controlbus.bean.Programacion;
import com.godared.controlbus.bean.ProgramacionDetalle;
import com.godared.controlbus.bean.Usp_S_PrGetAllProgramacionByEm;
import com.godared.controlbus.dao.IProgramacionDao;
import com.godared.controlbus.dao.IProgramacionDetalleDao;

@Service
@Transactional
public class ProgramacionServiceImp implements IProgramacionService {
	private IProgramacionDao programacionDao;
	private IProgramacionDetalleDao programacionDetalleDao;
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	@Autowired
	IBusService busService;
//	injeccion de dependencias
	public void setProgramacionDao(IProgramacionDao programacionDao) {
		 this.programacionDao = programacionDao;		 
	}
	public void setProgramacionDetalleDao(IProgramacionDetalleDao programacionDetalleDao) {
		 this.programacionDetalleDao = programacionDetalleDao;		 
	}
	
	public List<Programacion> findAll() {
		// TODO Auto-generated method stub
		return this.programacionDao.findAll();
	}

	public Programacion findOne(int id) {
		// TODO Auto-generated method stub
		return this.programacionDao.findOne(id);
	}
	public void CreateProgramacion(Programacion programacion){
		this.programacionDao.create(programacion);
	}
	public Programacion createReturn(Programacion programacion){
		return this.programacionDao.createReturn(programacion);
	}
	public Programacion Save(Programacion programacion){
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		Programacion _programacion=null;
		try {		
			transaction.begin();
			if (programacion.getPrId()>0)
			{
				programacion.setUsFechaReg(new Date());
				_programacion=(Programacion)this.programacionDao.update(programacion);
			}else
			{
				_programacion=(Programacion)this.programacionDao.createReturn(programacion);
			}
			transaction.commit();
		}catch(Exception ex){
		    transaction.rollback();
		       throw new RuntimeException(ex);
		}
		finally{
			entityManager.close();
		}
		return _programacion;
	}
	public void Save(Programacion programacion,List<ProgramacionDetalle> programacionDetalle) {
		// TODO Auto-generated method stub
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {		
			transaction.begin();
			if (programacion.getPrId()>0)
			{
				programacion.setUsFechaReg(new Date());
				this.programacionDao.update(programacion);
				//REgistramos el detalle
				for(ProgramacionDetalle programacionDet : programacionDetalle) {
					programacionDet.setPrId(programacion.getPrId());
					this.programacionDetalleDao.update(programacionDet);//System.out.println(rutaDet);
		        }
				
			}
			else
			{
				this.programacionDao.create(programacion);
				//REgistramos el detalle
				for(ProgramacionDetalle programacionDet : programacionDetalle) {
					programacionDet.setPrId(programacion.getPrId());
					this.CreateProgramacionDetalle(programacionDet);//System.out.println(rutaDet);
		        }			
			}
			transaction.commit();
		}
		catch(Exception ex){
		    transaction.rollback();
		       throw new RuntimeException(ex);
		}
		finally{
			entityManager.close();
		}
	}
	public void Delete(int id){
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try{
			transaction.begin();
			this.DeleteProgramacionDetalleByPrId(id);
			this.programacionDao.deleteById(id);
			transaction.commit();
		}
		catch(Exception ex ){
			transaction.rollback();
		       throw new RuntimeException(ex);
		}
		finally{
			entityManager.close();
		}
	 }
	public List<Usp_S_PrGetAllProgramacionByEm> GetAllProgramacionByEm(int emId, int anio){
		return programacionDao.GetAllProgramacionByEm(emId,anio);
	}
	//Registrar el la programacion Base 
	public void RegistrarProgramacionBase(List<ProgramacionDetalle>  programacionDetalles,
			int emId,int prId, Boolean aleatorio ) {		
		//BusServiceImp _busService=new BusServiceImp();
		List<Bus> _busAleatorio = new ArrayList<Bus>();		
		Programacion _programacion=null;		
		List<ProgramacionDetalle> _programacionDetalles=new ArrayList<ProgramacionDetalle>();
		List<ProgramacionDetalle> _programacionDetallesBD=new ArrayList<ProgramacionDetalle>();
		List<ProgramacionDetalle> _programacionDetallesBD2=new ArrayList<ProgramacionDetalle>();
		int c=1;
		//Obteniendo los datos de la programaci�n
		_programacion=(Programacion)this.programacionDao.findOne(prId);//_programacionService.findOne(prId);
		
		//String day = new SimpleDateFormat("dd").format(new Date(_programacion.getPrFechaInicio()));
		long timestamp = _programacion.getPrFechaInicio().getTime();
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(timestamp);
		long DiasIncio=cal.get(Calendar.DAY_OF_YEAR);
		long timestamp2 = _programacion.getPrFechaFin().getTime();
		Calendar cal2 = Calendar.getInstance();
		cal2.setTimeInMillis(timestamp2);
		long DiasFin=cal2.get(Calendar.DAY_OF_YEAR);
		String _diasIncluidos=_programacion.getPrDiasIncluidos();
		//*OBTENIENDO LOS DIAS REALES DE LA PROGRAMACION
				
		//long _nroDias=DiasFin-DiasIncio+1;
		//Vamos a quitar el aleatorio porque esto lo esta haciendo en el frontend
	/*	if (aleatorio==true){
			_busAleatorio=busService.SortearAleatorio(emId);
			for(Bus _bus:_busAleatorio){
				ProgramacionDetalle obj=new ProgramacionDetalle();
				obj.setPrId(prId);
				obj.setBuId(_bus.getBuId());
				obj.setUsFechaReg(_programacion.getPrFechaInicio());
				obj.setPrDeBase(true);
				obj.setPrDeOrden(c);
				obj.setUsId(1);
				obj.setUsFechaReg(new Date());
				
				_programacionDetalles.add(obj);
				c=c+1;
			}
			for (ProgramacionDetalle programacionDet:_programacionDetalles){
				ProgramacionDetalle obj=new ProgramacionDetalle();
				obj=org.apache.commons.lang3.SerializationUtils.clone(programacionDet);
				obj.setPrDeBase(true);
				obj.setPrDeFecha(_programacion.getPrFechaInicio());	
				//this.programacionDetalleDao.create(programaDet);
				_programacionDetallesBD.add(obj);}
				_programacionDetallesBD2=this.GenerarProgramacionMensual(emId,prId,_programacionDetalles,_programacion.getPrFechaFin(),_programacion.getPrFechaInicio(),_programacionDetallesBD,_diasIncluidos);
			
		}else{	*/		
			if (!programacionDetalles.isEmpty()){
				for (ProgramacionDetalle programacionDet:programacionDetalles){
					ProgramacionDetalle obj=new ProgramacionDetalle();
					obj=org.apache.commons.lang3.SerializationUtils.clone(programacionDet);
					obj.setPrDeBase(true);
					obj.setPrDeFecha(_programacion.getPrFechaInicio());					
					_programacionDetallesBD.add(obj);
					}					
					//_programacionService.CreateProgramacionDetalle(programaDet);
				_programacionDetallesBD2=this.GenerarProgramacionMensual(emId,prId,programacionDetalles,_programacion.getPrFechaFin(),_programacion.getPrFechaInicio(),_programacionDetallesBD,_diasIncluidos);
			}		
			
		//}
		//Guardando en la Base de Datos
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {		
			transaction.begin();
			for(ProgramacionDetalle programacionDet : _programacionDetallesBD2) {
				//programacionDet.setPrId(programacion.getPrId());
				//this.CreateProgramacionDetalle(programacionDet);//System.out.println(rutaDet);
				ProgramacionDetalle obj=new ProgramacionDetalle();				
				obj=org.apache.commons.lang3.SerializationUtils.clone(programacionDet);
				this.programacionDetalleDao.create(obj);
	        }	
			transaction.commit();
		}
		catch(Exception ex ){
			transaction.rollback();
		       throw new RuntimeException(ex);
		}
		finally{
			entityManager.close();
		}	
	}
	public List<ProgramacionDetalle> GenerarProgramacionMensual(int emId,int prId, 
			List<ProgramacionDetalle> programacionDetalles, Date fechaFin, Date fechaInicio,
			List<ProgramacionDetalle>programacionDetallesBD, String diasIncluidos){		
		int c= 2;
		List<ProgramacionDetalle> _programacionDetalles=new ArrayList<ProgramacionDetalle>(programacionDetalles);
		List<ProgramacionDetalle> _programacionDetalles2=new ArrayList<ProgramacionDetalle>(programacionDetalles);
		List<ProgramacionDetalle> _programacionDetalles1=new ArrayList<ProgramacionDetalle>(programacionDetalles);
		List<ProgramacionDetalle> _programacionDetallesBD=new ArrayList<ProgramacionDetalle>(programacionDetallesBD);
		
		//long timestamp =fechaInicio.getTime();
		Calendar cal = Calendar.getInstance();
		Calendar calInicio = Calendar.getInstance();
		Calendar calFin = Calendar.getInstance();
		Date _fechaInicio=fechaInicio;
		//cal.setTime(_fechaInicio);
		//cal.add(Calendar.DAY_OF_MONTH, 1);
		//_fechaInicio=cal.getTime();
		//long DiasIncio=cal.get(Calendar.DAY_OF_YEAR);
		//Este procedimiento es para separar lo enviado en DIasIncluir en un Array
		//y despues hacemos que el 1 empiece en domingo
		String[] dias_semana = diasIncluidos.split(",");		
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
	  	int nroDias=1;
	  	calInicio.setTime(fechaInicio);
	  	calFin.setTime(fechaFin);
	  	//cal2.get(Calendar.DAY_OF_YEAR)
	  	while(calInicio.getTime().before(calFin.getTime()) ||  calInicio.getTime().equals(calFin.getTime())){ //!calInicio.getTime().equals(calFin.getTime())
	  		int dayOfWeek = calInicio.get(Calendar.DAY_OF_WEEK);
	  		if (dias_semana3[dayOfWeek-1].equals(true)){
	  			nroDias=nroDias+1;
	  		}
	  		calInicio.add(Calendar.DAY_OF_MONTH, 1);
	  	}
		for(int i=2; i<=nroDias-1;i++){
			cal.setTime(_fechaInicio);
			cal.add(Calendar.DAY_OF_MONTH, 1);
			//Obtenemos el dia de la semana
			int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
			//verificamos que no sea false el dia, si es asi avanza un dia 
			while(dias_semana3[dayOfWeek-1].equals(false))//dias_semana3[dayOfWeek-1]!="1"
		  	{
		  		cal.add(Calendar.DAY_OF_MONTH, 1);
		  		if(dayOfWeek==7) 
		  			dayOfWeek=1;
		  		else
		  			dayOfWeek=dayOfWeek+1;
		  		//System.out.println(cal.getTime());
		  	}
			////
			_fechaInicio=cal.getTime();
			if ( i % 2==0){
				//si la clumna  dia es par tonces invertimos de la columna inpar anterior 
				c=1;
				Collections.sort(_programacionDetalles1, new Comparator<ProgramacionDetalle>() {		               
	                public int compare(ProgramacionDetalle lhs, ProgramacionDetalle rhs) {
	                    // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
	                    return lhs.getPrDeOrden() > rhs.getPrDeOrden() ? -1 : (lhs.getPrDeOrden() < rhs.getPrDeOrden() ) ? 1 : 0;
	                }
	            });				
				for(ProgramacionDetalle pr:_programacionDetalles1){		
					//Agregar a la base de datos					
					ProgramacionDetalle obj=new ProgramacionDetalle();
					obj=org.apache.commons.lang3.SerializationUtils.clone(pr);
					obj.setPrDeBase(false);
					obj.setPrDeFecha(_fechaInicio);	
					obj.setPrDeOrden(c);
					_programacionDetallesBD.add(obj);
					//this.programacionDetalleDao.create(pr);
					c=c+1;	 
				}
				//
			}else
			{//si es impar tonces hacemos la logica de orden para ordenarlo mas adelante
				c=1;
				int c2=2;
				int c1=1;
				int total=0;
				total=(int)_programacionDetalles2.size();
				_programacionDetalles.clear();				
				for(ProgramacionDetalle pr:_programacionDetalles2){	
					ProgramacionDetalle obj=new ProgramacionDetalle();
					obj=org.apache.commons.lang3.SerializationUtils.clone(pr);
					obj.setPrDeBase(false);
					obj.setPrDeFecha(_fechaInicio);	
					if(c%2==0){
						//EN caso el total sea par
						//if(total%2==0){
						if(c==total-1)
							//if(c==total-1)
								//pr.setPrDeOrden(c1+3);
							obj.setPrDeOrden(c1+1);
						else
							//pr.setPrDeOrden(c1);
							obj.setPrDeOrden(c1);
						//_programacionDetalles.add(pr);
						_programacionDetalles.add(obj);
						
						if (c==2)
							c1=c1+0;
						else
							if(c==4)
								c1=c1+1;
							else
								c1=c1+2;
					}else{
						//en caso el total sea inpar					
						if(c==total)
							//pr.setPrDeOrden(c2-3);
							obj.setPrDeOrden(c2-3);
						else
							//pr.setPrDeOrden(c2);
							obj.setPrDeOrden(c2);
						
						_programacionDetalles.add(obj);
						c2=c2+2;
					}						
					//
					c=c+1;					
				}	
				// ordenamos en forma ascendente de acuerdo a lo anterior hecho en else
				Collections.sort(_programacionDetalles, new Comparator<ProgramacionDetalle>() {		               
	                public int compare(ProgramacionDetalle lhs, ProgramacionDetalle rhs) {
	                    // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
	                    return lhs.getPrDeOrden() < rhs.getPrDeOrden() ? -1 : (lhs.getPrDeOrden() > rhs.getPrDeOrden() ) ? 1 : 0;
	                }
	            });
				_programacionDetalles1=new ArrayList<ProgramacionDetalle>(_programacionDetalles);//_programacionDetalles;
				_programacionDetalles2=new ArrayList<ProgramacionDetalle>(_programacionDetalles);//_programacionDetalles;
				//Agregamos  para el sigueiente dia base detalle Programacion
				for(ProgramacionDetalle pr:_programacionDetalles){	
					//pr.setPrDeFecha(_fechaInicio);
					//pr.setPrDeBase(false);
					//_programacionDetallesBD.add(pr);					
					ProgramacionDetalle obj=new ProgramacionDetalle();
					obj=org.apache.commons.lang3.SerializationUtils.clone(pr);	
					_programacionDetallesBD.add(obj);
					//this.programacionDetalleDao.create(pr);
				}
			}
			
		}
		return _programacionDetallesBD;
	}	
	
	//Programacion Detalle
	public ProgramacionDetalle findOneProgramacionDetalleId(int prDeId){
		return this.programacionDetalleDao.findOne(prDeId);	
	}
	public List<ProgramacionDetalle> getAllProgramacionDetalleByPr(int prId){
		 return this.programacionDetalleDao.getAllProgramacionDetalleByPr(prId);	
	}
	public List<ProgramacionDetalle> getAllProgramacionDetalleByPrFecha(int prId,Date prDeFecha){
		return this.programacionDetalleDao.getAllProgramacionDetalleByPrFecha(prId,prDeFecha);
	}
	public void CreateProgramacionDetalle(ProgramacionDetalle programacionDetalle){
		if (programacionDetalle.getPrDeId()>0)
		{
		this.programacionDetalleDao.update(programacionDetalle);
		}
		else
			this.programacionDetalleDao.create(programacionDetalle);
	}
	 public void CreateProgramacionDetalle(List<ProgramacionDetalle> programacionDetalle){
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction transaction=entityManager.getTransaction();
			try {
				transaction.begin();
				for(ProgramacionDetalle _programacionDetalle : programacionDetalle) {
					//_puntoControlDetalle.setRuId(_puntoControlDetalle.getRuId());
					 this.programacionDetalleDao.create(_programacionDetalle);
		        }
				transaction.commit();
			}catch(Exception ex ){
				transaction.rollback();
			       throw new RuntimeException(ex);
			}
			finally{
				entityManager.close();
			}
			
		 }
	 public void RegistrarHoraBase(List<ProgramacionDetalle> programacionDetalle){
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction transaction=entityManager.getTransaction();
			ProgramacionDetalle _programacionDetalle2;
			try {
				transaction.begin();
				for(ProgramacionDetalle _programacionDetalle : programacionDetalle) {
					//_puntoControlDetalle.setRuId(_puntoControlDetalle.getRuId());
					_programacionDetalle2=new ProgramacionDetalle();
					_programacionDetalle2=this.findOneProgramacionDetalleId(_programacionDetalle.getPrDeId());
					_programacionDetalle2.setPrDeHoraBase(_programacionDetalle.getPrDeHoraBase());
					 this.programacionDetalleDao.update(_programacionDetalle2);
		        }
				transaction.commit();
			}catch(Exception ex ){
				transaction.rollback();
			       throw new RuntimeException(ex);
			}
			finally{
				entityManager.close();
			}
			
		 }
	public void UpdateProgramacionDetalle(int prDeId,ProgramacionDetalle programacionDetalle){
		 ProgramacionDetalle _programacionDetalle=new ProgramacionDetalle();
			_programacionDetalle=findOneProgramacionDetalleId(prDeId);
			_programacionDetalle.setPrDeFecha(programacionDetalle.getPrDeFecha());
			_programacionDetalle.setPrDeBase(programacionDetalle.getPrDeBase());
			_programacionDetalle.setPrDeOrden(programacionDetalle.getPrDeOrden());
			_programacionDetalle.setUsFechaReg(programacionDetalle.getUsFechaReg());
			this.programacionDetalleDao.update(_programacionDetalle);	
	}
	public void DeleteProgramacionDetalle(int prDeId){
		this.programacionDetalleDao.deleteById(prDeId);
	}
	public void DeleteProgramacionDetalleByPrId(int prId){
		this.programacionDetalleDao.deleteByPrId(prId);
	}
	public ProgramacionDetalle UpdateFieldProgramacionDetalle(ProgramacionDetalle programacionDetalle){
		ProgramacionDetalle _programacionDetalle=this.programacionDetalleDao.findOne(programacionDetalle.getPrDeId());
		_programacionDetalle.setPrDeAsignadoTarjeta(programacionDetalle.getPrDeAsignadoTarjeta());
		_programacionDetalle.setPrDeCountVuelta(programacionDetalle.getPrDeCountVuelta());
		return this.programacionDetalleDao.update(_programacionDetalle);
	}
	

}
