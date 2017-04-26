package com.godared.controlbus.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.godared.controlbus.bean.Bus;
import com.godared.controlbus.bean.Usp_S_BuGetAllBusesByEmSuEm;
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
	public List<Usp_S_BuGetAllBusesByEmSuEm> GetAllBusesByEmSuEm(int emId, int suEmId){
		return this.busDao.GetAllBusesByEmSuEm(emId, suEmId);
	}
	public List<Bus> GetAllBusActivo(int emId){
		List<Bus> resultBus = new ArrayList<Bus>();
		Bus busBean=null;//new Bus();
		List<Usp_S_BuGetAllBusesByEmSuEm> _usp_S_BuGetAllBusesByEmSuEm=new ArrayList<Usp_S_BuGetAllBusesByEmSuEm>();
		_usp_S_BuGetAllBusesByEmSuEm=this.busDao.GetAllBusesByEmSuEm(emId, 0);//this.GetAllBusesByEmSuEm(emId,0);
		busBean=(Bus)this.busDao.findOne(1);
		 for (Usp_S_BuGetAllBusesByEmSuEm bus: _usp_S_BuGetAllBusesByEmSuEm) {
		        if (bus.getBuActivo()==true) {
		        	busBean=new Bus();
		        	busBean.setBuId(bus.getBuId());		        	
		        	resultBus.add(busBean);
		        }
		    }
		 return resultBus;
	}
	public List<Bus>SortearAleatorio(int emId){
		List<Bus> busActivos = new ArrayList<Bus>();
		busActivos=this.GetAllBusActivo(emId);
		Collections.shuffle(busActivos);
		return busActivos;
		
		
	}
}
