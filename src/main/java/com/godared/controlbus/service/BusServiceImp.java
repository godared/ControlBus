package com.godared.controlbus.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.godared.controlbus.bean.Bus;
import com.godared.controlbus.dao.IBusDao;

@Service
@Transactional
public class BusServiceImp implements IBusService{
	private IBusDao busDao;
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
//	injeccion de dependencias
	public void setBusDao(IBusDao busDao) {
		 this.busDao = busDao;		 
	}
	
	public List<Bus> findAll() {
		// TODO Auto-generated method stub
		return this.busDao.findAll();
	}

	public Bus findOne(int id) {
		// TODO Auto-generated method stub
		return this.busDao.findOne(id);
	}
	public void Save(Bus bus){
		if (bus.getBuId()>0)
		{
			this.busDao.update(bus);
		}
		else
		{
			
			bus.setUsFechaReg(new Date() );
			this.busDao.create(bus);
		}
	}
	public void Delete(int id){
		 this.busDao.deleteById(id);
	 }
}
