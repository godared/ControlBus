package com.godared.controlbus.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.godared.controlbus.bean.RegistroDiario;
import com.godared.controlbus.bean.RegistroDiarioDetalle;
import com.godared.controlbus.bean.RegistroReten;
import com.godared.controlbus.bean.TarjetaControl;
import com.godared.controlbus.dao.IRegistroDiarioDao;
import com.godared.controlbus.dao.IRegistroDiarioDetalleDao;
import com.godared.controlbus.dao.IRegistroRetenDao;
import com.godared.controlbus.dao.ITarjetaControlDao;

@Service
@Transactional
public class RegistroDiarioServiceImp implements IRegistroDiarioService{
	private IRegistroDiarioDao registroDiarioDao;
	private IRegistroDiarioDetalleDao registroDiarioDetalleDao;
	private IRegistroRetenDao registroRetenDao;
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
//	injeccion de dependencias
	public void setRegistroDiarioDao(IRegistroDiarioDao registroDiarioDao) {
		 this.registroDiarioDao = registroDiarioDao;		 
	}
	public void setRegistroDiarioDetalleDao(IRegistroDiarioDetalleDao registroDiarioDetalleDao) {
		 this.registroDiarioDetalleDao = registroDiarioDetalleDao;		 
	}
	public void setRegistroRetenDao(IRegistroRetenDao registroRetenDao) {
		 this.registroRetenDao = registroRetenDao;		 
	}
	
	public List<RegistroDiario> findAll(){
		return registroDiarioDao.findAll();
	}
	
	public RegistroDiario findOne(int reDiId){
		return registroDiarioDao.findOne(reDiId);
	}
	public List<RegistroDiario> GetAllRegistroDiarioByEm(int emId){
		return registroDiarioDao.GetAllRegistroDiarioByEm(emId);
	}
	public void Delete(int reDiId){
		registroDiarioDao.deleteById(reDiId);
	}
	public void Save(RegistroDiario registroDiario){
		
		if (registroDiario.getReDiId()>0)
		{
			this.registroDiarioDao.update(registroDiario);			
			
		}
		else
		{			
			registroDiario.setUsFechaReg(new Date());
			RegistroDiario _registroDiario=null;
			_registroDiario=this.registroDiarioDao.createReturn(registroDiario);
			//generando el detalle
			int c=1;
			RegistroDiarioDetalle registroDiarioDetalle;
			for(Integer i=1; i<=registroDiario.getReDiTotalVuelta();i++){
				registroDiarioDetalle=new RegistroDiarioDetalle();
				registroDiarioDetalle.setReDiDeNroVuelta(i);
				registroDiarioDetalle.setReDiDeNombreVuelta("VUELTA"+i.toString());
				registroDiarioDetalle.setReDiId(_registroDiario.getReDiId());
				registroDiarioDetalle.setUsFechaReg(new Date());
				registroDiarioDetalle.setUsId(1);
				if(i==1)
					registroDiarioDetalle.setReDiDeEstado("02"); //ACTIVO
				else
					registroDiarioDetalle.setReDiDeEstado("01");//NO REALIZADO
				this.registroDiarioDetalleDao.create(registroDiarioDetalle);
				
			}
		}
	}
	
	//RegistroDiarioDetalle
	public List<RegistroDiarioDetalle> findAllRegistroDiarioDetalle(){
		return registroDiarioDetalleDao.findAll();
	}
	public RegistroDiarioDetalle findOneRegistroDiarioDetalle(int reDiDeId){
		return registroDiarioDetalleDao.findOne(reDiDeId);
	}
	public List<RegistroDiarioDetalle> GetAllRegistroDiarioDetalleByReDi(int reDiId){
		return registroDiarioDetalleDao.GetAllRegistroDiarioDetalleByReDi(reDiId);
	}
	public void DeleteRegistroDiarioDetalle(int reDiDeId){
		registroDiarioDetalleDao.deleteById(reDiDeId);
	}
	public void SaveRegistroDiarioDetalle(RegistroDiarioDetalle registroDiarioDetalle){
		
		if (registroDiarioDetalle.getReDiDeId()>0)
		{
			this.registroDiarioDetalleDao.update(registroDiarioDetalle);
		}
		else
		{			
			registroDiarioDetalle.setUsFechaReg(new Date());
			this.registroDiarioDetalleDao.create(registroDiarioDetalle);
		}
	}
	
	//RegistroReten
	public List<RegistroReten> findAllRegistroReten(){
		return registroRetenDao.findAll();
	}
	public RegistroReten findOneRegistroReten(int reReId){
		return registroRetenDao.findOne(reReId);
	}
	public List<RegistroReten> GetAllRegistroRetenByReDiDe(int reDiDeId){
		return registroRetenDao.GetAllRegistroRetenByReDiDe(reDiDeId);
	}
	public void DeleteRegistroReten(int reReId){
		registroRetenDao.deleteById(reReId);
	}
	public void SaveRegistroReten(RegistroReten registroReten){
		if (registroReten.getReReId()>0)
		{
			this.registroRetenDao.update(registroReten);
		}
		else
		{			
			registroReten.setUsFechaReg(new Date());
			this.registroRetenDao.create(registroReten);
		}		
	}
}
