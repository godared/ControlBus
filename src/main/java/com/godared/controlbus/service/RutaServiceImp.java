package com.godared.controlbus.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.godared.controlbus.bean.Ruta;
import com.godared.controlbus.dao.IRutaDao;

@Service
@Transactional
public class RutaServiceImp implements IRutaService {
	
	private IRutaDao rutaDao;
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
	public void setRutaDao(IRutaDao rutaDao) {
		 this.rutaDao = rutaDao;
		 
		 }
	public void Save(Ruta ruta) {
		// TODO Auto-generated method stub
		if (ruta.getRuId()>0)
		{
			ruta.setUsFechaReg(new Date() );
			this.rutaDao.update(ruta);
		}
		else
		{
			
			ruta.setUsFechaReg(new Date() );
			this.rutaDao.create(ruta);
		}
		
	}
	public void Delete(int id){
		 this.rutaDao.deleteById(id);
	 }
	public List<Ruta> findAll() {
		// TODO Auto-generated method stub
		return rutaDao.findAll();
	}

	public Ruta findOne(int id) {
		// TODO Auto-generated method stub
		return rutaDao.findOne(id);
	}
}
