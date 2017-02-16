package com.godared.controlbus.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public void RegistrarProgramacionBase(int emId,int prId, Boolean aleatorio,
			List<ProgramacionDetalle> ... programacionDetalles ){		
		IBusService _busService=new BusServiceImp();
		List<Bus> _busAleatorio = new ArrayList<Bus>();
		IProgramacionService _programacionService=new ProgramacionServiceImp();
		Programacion _programacion;
		ProgramacionDetalle _programacionDetalle=new ProgramacionDetalle();
		List<ProgramacionDetalle> _programacionDetalles=new ArrayList<ProgramacionDetalle>();
		int c=1;
		//Obteniendo los datos de la programación
		_programacion=_programacionService.findOne(prId);
		long _nroDias=_programacion.getPrFechaInicio().getTime()-_programacion.getPrFechaFin().getTime();
			
		
		if (aleatorio==true){
			_busAleatorio=_busService.SortearAleatorio(emId);
			for(Bus _bus:_busAleatorio){
				_programacionDetalle.setPrId(prId);
				_programacionDetalle.setBuId(_bus.getBuId());
				_programacionDetalle.setUsFechaReg(_programacion.getPrFechaInicio());
				_programacionDetalle.setPrDeBase(true);
				_programacionDetalle.setPrDeOrden(c);
				_programacionDetalle.setUsId(1);
				_programacionDetalle.setUsFechaReg(new Date());
				
				_programacionDetalles.add(_programacionDetalle);
				c=c+1;
			}
			for (ProgramacionDetalle programaDet:_programacionDetalles)
			_programacionService.CreateProgramacionDetalle(programaDet);
			this.GenerarProgramacionMensual(emId,prId,_programacionDetalles,_nroDias);
			
		}else{
			
			if (!programacionDetalles[0].isEmpty()){
				for (ProgramacionDetalle programaDet:programacionDetalles[0])
					_programacionService.CreateProgramacionDetalle(programaDet);
				this.GenerarProgramacionMensual(emId,prId,programacionDetalles[0],_nroDias);
			}
			
			
		}
		
		
		
	}
	public void GenerarProgramacionMensual(int emId,int prId, 
			List<ProgramacionDetalle> programacionDetalles,long nroDias){
		
		int c= 2;
		List<ProgramacionDetalle> _programacionDetalles=new ArrayList<ProgramacionDetalle>();
		List<ProgramacionDetalle> _programacionDetalles2=new ArrayList<ProgramacionDetalle>();
		//_programacionDetalles=programacionDetalles;
		_programacionDetalles2=programacionDetalles;
		
		for(int i=2; i<=nroDias;i++){
			if ( i % 2==0){
				Collections.sort(programacionDetalles, new Comparator<ProgramacionDetalle>() {
		               
	                public int compare(ProgramacionDetalle lhs, ProgramacionDetalle rhs) {
	                    // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
	                    return lhs.getPrDeOrden() > rhs.getPrDeOrden() ? -1 : (lhs.getPrDeOrden() < rhs.getPrDeOrden() ) ? 1 : 0;
	                }
	            });
				
				for(ProgramacionDetalle pr:programacionDetalles){		
					//Agregar a la base de datos
						 
				}
				//
			}else
			{
				c=1;
				int c2=3;
				int c1=1;
				for(ProgramacionDetalle pr:_programacionDetalles2){	
					if(c%2==0){
						//Ingresa
						pr.setPrDeOrden(c1);
						_programacionDetalles.add(pr);
						if (c==2)
							c1=c1+1;
						else
							c1=c1+2;
					}else{
						//ingresa
						pr.setPrDeOrden(c2);
						_programacionDetalles.add(pr);
						c2=c2+2;
					}						
					//
					c=c+1;					
				}				
				_programacionDetalles2=programacionDetalles;
			}
			
		}	
	}
	
	
	//Programacion Detalle
	public ProgramacionDetalle findOneProgramacionDetalleId(int prDeId){
		return this.programacionDetalleDao.findOne(prDeId);	
	}
	public ProgramacionDetalle findOneProgramacionDetalleByprId(int prId){
		 return this.programacionDetalleDao.findOne(prId);	
	}
	public void CreateProgramacionDetalle(ProgramacionDetalle programacionDetalle){
		this.programacionDetalleDao.create(programacionDetalle);
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

}
