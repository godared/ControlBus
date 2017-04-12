package com.godared.controlbus.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.godared.controlbus.bean.PuntoControl;
import com.godared.controlbus.bean.PuntoControlDetalle;
import com.godared.controlbus.bean.Ruta;
import com.godared.controlbus.bean.RutaDetalle;
import com.godared.controlbus.bean.Usp_S_PuCoGetAllPuntoControlByEmRu;
import com.godared.controlbus.bean.Usp_S_RuGetAllRutaByEm;
import com.godared.controlbus.dao.IPuntoControlDao;
import com.godared.controlbus.dao.IPuntoControlDetalleDao;
import com.godared.controlbus.dao.IRutaDao;
import com.godared.controlbus.dao.IRutaDetalleDao;


@Service
@Transactional
public class RutaServiceImp implements IRutaService {
	
	private IRutaDao rutaDao;
	private IRutaDetalleDao rutaDetalleDao;
	private IPuntoControlDao puntoControlDao;
	private IPuntoControlDetalleDao puntoControlDetalleDao;
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
	
	//	injeccion de dependencias
	public void setRutaDao(IRutaDao rutaDao) {
		 this.rutaDao = rutaDao;
		 
	}
	public void setRutaDetalleDao(IRutaDetalleDao rutaDetalleDao) {
		 this.rutaDetalleDao = rutaDetalleDao;
		 
	}
	public void setPuntoControlDao(IPuntoControlDao puntoControlDao) {
		 this.puntoControlDao = puntoControlDao;
		 
	}
	public void setPuntoControlDetalleDao(IPuntoControlDetalleDao puntoControlDetalleDao) {
		 this.puntoControlDetalleDao = puntoControlDetalleDao;
		 
	}
	
	
	public List<Ruta> findAll() {
		// TODO Auto-generated method stub
		return rutaDao.findAll();
	}

	public Ruta findOne(int id) {
		// TODO Auto-generated method stub
		return rutaDao.findOne(id);
	}
	public void Create(Ruta ruta) {
		 rutaDao.create(ruta);
	}
	public void Save(Ruta ruta,List<RutaDetalle> rutaDetalle) {
		// TODO Auto-generated method stub
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {		
			transaction.begin();
			if (ruta.getRuId()>0)
			{
				ruta.setUsFechaReg(new Date() );
				this.rutaDao.update(ruta);
				//REgistramos el detalle
				for(RutaDetalle rutaDet : rutaDetalle) {
					rutaDet.setRuId(ruta.getRuId());
					this.rutaDetalleDao.update(rutaDet);//System.out.println(rutaDet);
		        }
				
			}
			else
			{
				this.rutaDao.create(ruta);
				//REgistramos el detalle
				for(RutaDetalle rutaDet : rutaDetalle) {
					rutaDet.setRuId(ruta.getRuId());
					this.rutaDetalleDao.create(rutaDet);//System.out.println(rutaDet);
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
			this.DeleteRutaDetalleByRuId(id);
			this.rutaDao.deleteById(id);
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
	public List<Usp_S_RuGetAllRutaByEm> GetAllRutaByEm(int emId){
		return rutaDao.GetAllRutaByEm(emId);
	}
	 //Ruta Detalle
	public RutaDetalle findOneRutaDetalleId(int ruId){
		return rutaDetalleDao.findOne(ruId);//aqui hay que hacer un procedure
	 }
	public List<RutaDetalle> getAllRutaDetalleByRu(int ruId){
		return rutaDetalleDao.getAllRutaDetalleByRu(ruId);
	 }
	public void CreateRutaDetalle(RutaDetalle rutaDetalle){
		 this.rutaDetalleDao.create(rutaDetalle);
	 }
	public void CreateRutaDetalle(List<RutaDetalle> rutaDetalle){
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
			transaction.begin();
			for(RutaDetalle _rutaDetalle : rutaDetalle) {
				_rutaDetalle.setRuId(_rutaDetalle.getRuId());
				 this.rutaDetalleDao.create(_rutaDetalle);
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
	public void UpdateRutaDetalle(int ruId,RutaDetalle rutaDetalle){
		RutaDetalle _rutaDetalle=new RutaDetalle();
		_rutaDetalle=findOneRutaDetalleId(ruId);
		_rutaDetalle.setRuDeOrden(rutaDetalle.getRuDeOrden());
		_rutaDetalle.setRuDeLatitud(rutaDetalle.getRuDeLatitud());
		_rutaDetalle.setRuDeLongitud(rutaDetalle.getRuDeLongitud());
		_rutaDetalle.setUsFechaReg(rutaDetalle.getUsFechaReg());
		this.rutaDetalleDao.update(_rutaDetalle);	
	 }
	 public void DeleteRutaDetalle(int ruId){
		 this.rutaDetalleDao.deleteById(ruId);// para eliminar un registro del detalle, la tabla tiene que tener un Primary Key
	 }
	 public void DeleteRutaDetalleByRuId(int ruId){
		 this.rutaDetalleDao.deleteByRuId(ruId);
	 }
	 //PuntoControl
	 public List<PuntoControl> findAllPuntoControl(){
		 return puntoControlDao.findAll(); 
	 }
	 public PuntoControl findOnePuntoControl(int puCoId){
		 return puntoControlDao.findOne(puCoId);
	 }
	 public void CreatePuntoControl(PuntoControl puntoControl) {
		 puntoControlDao.create(puntoControl);
	}
	 public void DeletePuntoControl(int puCoId){
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try{
			transaction.begin();
			this.DeletePuntoControlDetalleByPuCoId(puCoId);
			this.puntoControlDao.deleteById(puCoId);
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
	 public void Save(PuntoControl puntoControl,List<PuntoControlDetalle> puntoControlDetalle){
		// TODO Auto-generated method stub
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction transaction=entityManager.getTransaction();
			try {		
				transaction.begin();
				if (puntoControl.getPuCoId()>0)
				{
					puntoControl.setUsFechaReg(new Date() );
					this.puntoControlDao.update(puntoControl);
					//REgistramos el detalle
					for(PuntoControlDetalle puntoControlDet : puntoControlDetalle) {
						puntoControlDet.setPuCoId(puntoControl.getPuCoId());
						this.UpdatePuntoControlDetalle(puntoControlDet.getPuCoDeId(),puntoControlDet);//System.out.println(rutaDet);
			        }
					
				}
				else
				{
					this.puntoControlDao.create(puntoControl);
					//REgistramos el detalle
					for(PuntoControlDetalle puntoControlDet : puntoControlDetalle) {
						puntoControlDet.setPuCoId(puntoControl.getPuCoId());
						this.CreatePuntoControlDetalle(puntoControlDet);//System.out.println(rutaDet);
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
	 public List<Usp_S_PuCoGetAllPuntoControlByEmRu> GetAllPuntoControlByEmRu(int emId,int ruId){
		 return this.puntoControlDao.GetAllPuntoControlByEmRu(emId, ruId);
	 }
	//Punta Control Detalle
	 public PuntoControlDetalle findOnePuntoControlDetalleId(int puCoDeId){
		 return this.puntoControlDetalleDao.findOne(puCoDeId);	 
	 }
	 public List<PuntoControlDetalle> getAllPuntoControlDetalleByPuCo(int puCoId){
		 return this.puntoControlDetalleDao.getAllPuntoControlDetalleByPuCo(puCoId);	//aqui hay que hacer un procedure pa get by puCoId
	 }
	
	 public void CreatePuntoControlDetalle(PuntoControlDetalle puntoControlDetalle){
		 this.puntoControlDetalleDao.create(puntoControlDetalle);
	 }
	 public void CreatePuntoControlDetalle(List<PuntoControlDetalle> puntoControlDetalle){
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction transaction=entityManager.getTransaction();
			try {
				transaction.begin();
				for(PuntoControlDetalle _puntoControlDetalle : puntoControlDetalle) {
					//_puntoControlDetalle.setRuId(_puntoControlDetalle.getRuId());
					 this.puntoControlDetalleDao.create(_puntoControlDetalle);
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
	 public void UpdatePuntoControlDetalle(int puCoDetId,PuntoControlDetalle puntoControlDetalle){
		 	 
		 PuntoControlDetalle _puntoControlDetalle=new PuntoControlDetalle();
			_puntoControlDetalle=findOnePuntoControlDetalleId(puCoDetId);
			_puntoControlDetalle.setPuCoDeDescripcion(puntoControlDetalle.getPuCoDeDescripcion());
			_puntoControlDetalle.setPuCoDeLatitud(puntoControlDetalle.getPuCoDeLatitud());
			_puntoControlDetalle.setPuCoDeLongitud(puntoControlDetalle.getPuCoDeLongitud());
			_puntoControlDetalle.setUsFechaReg(puntoControlDetalle.getUsFechaReg());
			this.puntoControlDetalleDao.update(_puntoControlDetalle);	
	 }
	 public void DeletePuntoControlDetalle(int puCoDeId){
		 this.puntoControlDetalleDao.deleteById(puCoDeId);
		 
	 }
	 public void DeletePuntoControlDetalleByPuCoId(int puCoId){
		 this.puntoControlDetalleDao.deleteByPuCoId(puCoId);
	 }
}