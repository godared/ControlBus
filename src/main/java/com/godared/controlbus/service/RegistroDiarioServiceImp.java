package com.godared.controlbus.service;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.godared.controlbus.bean.RegistroDiario;
import com.godared.controlbus.bean.RegistroDiarioDetalle;
import com.godared.controlbus.bean.RegistroReten;
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
		registroDiarioDao.create(registroDiario);
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
		registroDiarioDetalleDao.create(registroDiarioDetalle);
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
		registroRetenDao.create(registroReten);
	}
}
