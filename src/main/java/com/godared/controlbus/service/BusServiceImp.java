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
import com.godared.controlbus.bean.BusPersona;
import com.godared.controlbus.bean.Telefono;
import com.godared.controlbus.bean.Usp_S_BuGetAllBusesByEmSuEm;
import com.godared.controlbus.bean.Usp_S_PeGetAllPersonaByEmSuEm;
import com.godared.controlbus.bean.Usp_S_TeGetAllTelefonoByBuImei;
import com.godared.controlbus.dao.IBusDao;
import com.godared.controlbus.dao.IBusPersonaDao;
import com.godared.controlbus.dao.ITelefonoDao;

@Service
@Transactional
public class BusServiceImp implements IBusService{
	private IBusDao busDao;
	private IBusPersonaDao busPersonaDao;
	private ITelefonoDao telefonoDao;
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
//	injeccion de dependencias
	public void setBusDao(IBusDao busDao) {
		 this.busDao = busDao;		 
	}
	public void setBusPersonaDao(IBusPersonaDao busPersonaDao) {
		 this.busPersonaDao = busPersonaDao;		 
	}
	public void setTelefonoDao(ITelefonoDao telefonoDao) {
		 this.telefonoDao = telefonoDao;		 
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
	
	//BusEmpresa	
	public BusPersona findOneBusPersona(int buPeId){
		return this.busPersonaDao.findOne(buPeId);
	}
	public List<Usp_S_PeGetAllPersonaByEmSuEm> getAllPersonaByEmBu(int emId, int buId){
		return this.busPersonaDao.getAllPersonaByEmBu(emId, buId);
	}
	public void DeleteBusPersona(int buPeId){
		this.busPersonaDao.deleteById(buPeId);
	}
	public void DeleteBusPersonaByBu(int buId){
		this.busPersonaDao.deleteByBu(buId);
	}
	public void Save(BusPersona busPersona){
		if (busPersona.getBuPeId()>0)
		{
			this.busPersonaDao.update(busPersona);
		}
		else
		{			
			busPersona.setUsFechaReg(new Date());
			this.busPersonaDao.create(busPersona);
		}
	}
	//Telefono
	public Telefono findOneTelefono(int teId){
		return telefonoDao.findOne(teId);
	}
	public List<Usp_S_TeGetAllTelefonoByBuImei> getAllTelefonoByBuImei(int buId, String teImei){
		return telefonoDao.GetAllTelefonoByBuImei(buId, teImei);
	}
	public void DeleteTelefono(int teId){
		this.telefonoDao.deleteById(teId);
	}
	//void DeleteBusPersonaByBu(int buId);
	public void Save(Telefono telefono){
		if (telefono.getTeId()>0)
		{
			this.telefonoDao.update(telefono);
		}
		else
		{			
			telefono.setUsFechaReg(new Date());
			this.telefonoDao.create(telefono);
		}
	}
}
