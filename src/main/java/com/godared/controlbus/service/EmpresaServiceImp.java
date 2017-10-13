package com.godared.controlbus.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.godared.controlbus.bean.Empresa;
import com.godared.controlbus.bean.EmpresaPersona;
import com.godared.controlbus.bean.SubEmpresa;
import com.godared.controlbus.bean.Usp_S_PeGetAllPersonaByEmSuEm;
import com.godared.controlbus.dao.IEmpresaDao;
import com.godared.controlbus.dao.IEmpresaPersonaDao;
import com.godared.controlbus.dao.ISubEmpresaDao;

@Service
@Transactional
public class EmpresaServiceImp implements IEmpresaService  {
	@Autowired
	private IEmpresaDao empresaDao;	
	@Autowired
	private ISubEmpresaDao subEmpresaDao;
	@Autowired
	private IEmpresaPersonaDao empresaPersonaDao;
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	//injeccion de dependencias
	public void setEmpresaDao(IEmpresaDao empresaDao) {
		 this.empresaDao = empresaDao;		 
	}
	public void setSubEmpresaDao(ISubEmpresaDao subEmpresaDao) {
		 this.subEmpresaDao = subEmpresaDao;		 
	}
	public void setEmpresaPersonaDao(IEmpresaPersonaDao empresaPersonaDao) {
		 this.empresaPersonaDao = empresaPersonaDao;		 
	}
	
	public List<Empresa> findAll(){
		return this.empresaDao.findAll();
	}
	public Empresa findOne(int emId){
		return this.empresaDao.findOne(emId);
	}
	public void Delete(int emId){
		this.empresaDao.deleteById(emId);
	}
	public void Save(Empresa empresa){
		if (empresa.getEmId()>0)
		{
			this.empresaDao.update(empresa);
		}
		else
		{			
			empresa.setUsFechaReg(new Date() );
			this.empresaDao.create(empresa);
		}
	}
	//SubEmpresa
	public SubEmpresa findOneSubEmpresa(int suEmId){
		return this.subEmpresaDao.findOne(suEmId);
	}
	public List<SubEmpresa> getAllSubEmpresaByEm(int emId){
		return this.subEmpresaDao.getAllSuEmpresaByEm(emId);
	}
	public void DeleteSubEmpresa(int suEmId){
		this.subEmpresaDao.deleteById(suEmId);
	}
	public void DeleteSubEmpresaByEm(int emId){
		this.subEmpresaDao.deleteByEm(emId);
	}
	public void Save(SubEmpresa subEmpresa){
		if (subEmpresa.getSuEmId()>0)
		{
			this.subEmpresaDao.update(subEmpresa);
		}
		else
		{			
			subEmpresa.setUsFechaReg(new Date());
			this.subEmpresaDao.create(subEmpresa);
		}
	}
	//EmpresaPersona	
	public EmpresaPersona findOneEmpresaPersona(int emPeId){
		return this.empresaPersonaDao.findOne(emPeId);
	}
	public List<Usp_S_PeGetAllPersonaByEmSuEm> getAllPersonaByEmSuEm(int emId, int suEmId){
		return this.empresaPersonaDao.getAllPersonaByEmSuEm(emId, suEmId);
	}
	public void DeleteEmpresaPersona(int emPeId){
		this.empresaPersonaDao.deleteById(emPeId);
	}
	public void DeleteEmpresaPersonaBySuEm(int suEmId){
		this.empresaPersonaDao.deleteBySuEm(suEmId);
	}
	public void Save(EmpresaPersona empresaPersona){
		if (empresaPersona.getEmPeId()>0)
		{
			this.empresaPersonaDao.update(empresaPersona);
		}
		else
		{			
			empresaPersona.setUsFechaReg(new Date());
			this.empresaPersonaDao.create(empresaPersona);
		}
	}
	
}
