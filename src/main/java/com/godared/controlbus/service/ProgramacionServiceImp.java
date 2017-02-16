package com.godared.controlbus.service;

import java.util.ArrayList;
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
	public void RegistrarProgramacionBase(int emId, Boolean aleatorio){
		IBusService busService=new BusServiceImp();
		List<Bus> busAleatorio = new ArrayList<Bus>();
		if (aleatorio==true){
			busAleatorio=busService.SortearAleatorio(emId);
			for(Bus bus:busAleatorio){
				
			}
			
		}else{
			
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
