package com.godared.controlbus.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.godared.controlbus.bean.Ruta;
import com.godared.controlbus.bean.RutaDetalle;
import com.godared.controlbus.dao.IRutaDao;
import com.godared.controlbus.dao.IRutaDetalleDao;


@Service
@Transactional
public class RutaServiceImp implements IRutaService {
	
	private IRutaDao rutaDao;
	private IRutaDetalleDao rutaDetalleDao;
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
	public void setRutaDao(IRutaDao rutaDao) {
		 this.rutaDao = rutaDao;
		 
		 }
	public void setRutaDetalleDao(IRutaDetalleDao rutaDetalleDao) {
		 this.rutaDetalleDao = rutaDetalleDao;
		 
		 }
	
	
	public void Delete(int id){
		try{
		 this.rutaDao.deleteById(id);
		 this.DeleteRutaDetalle(id);
		}
		catch(Exception ex ){
			
		}
	 }
	public List<Ruta> findAll() {
		// TODO Auto-generated method stub
		return rutaDao.findAll();
	}

	public Ruta findOne(int id) {
		// TODO Auto-generated method stub
		return rutaDao.findOne(id);
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
		catch(Exception e){
		    transaction.rollback();
		       throw new RuntimeException(e);
		}
		finally{
			entityManager.close();
		}
	}
	
	 //Ruta Detalle
	public RutaDetalle findOneRutaDetalleId(int ruId){
		return rutaDetalleDao.findOne(ruId);//aqui hay que hacer un procedure
	 }
	public RutaDetalle findOneRutaDetalleByruId(int ruId){
		return rutaDetalleDao.findOne(ruId);//aqui hay que hacer un procedure
	 }
	public void CreateRutaDetalle(RutaDetalle rutaDetalle){
		 this.rutaDetalleDao.create(rutaDetalle);
	 }
	public void UpdateRutaDetalle(int ruId,RutaDetalle rutaDetalle){
		RutaDetalle _rutaDetalle=new RutaDetalle();
		_rutaDetalle=findOneRutaDetalleId(ruId);
		_rutaDetalle.setRuDeDescripcion(rutaDetalle.getRuDeDescripcion());
		_rutaDetalle.setRuDeLatitud(rutaDetalle.getRuDeLatitud());
		_rutaDetalle.setRuDeLongitud(rutaDetalle.getRuDeLongitud());
		_rutaDetalle.setUsFechaReg(rutaDetalle.getUsFechaReg());
		this.rutaDetalleDao.update(_rutaDetalle);	
	 }
	 public void DeleteRutaDetalle(int ruId){
		 this.rutaDetalleDao.deleteById(ruId);
	 }
}
