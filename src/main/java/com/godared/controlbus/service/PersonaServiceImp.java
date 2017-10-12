package com.godared.controlbus.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.godared.controlbus.bean.Persona;
import com.godared.controlbus.bean.Usp_S_UsGetAllUsuarioByEm;
import com.godared.controlbus.bean.Usuario;
import com.godared.controlbus.dao.IPersonaDao;
import com.godared.controlbus.dao.IUsuarioDao;

@Service
@Transactional
public class PersonaServiceImp implements IPersonaService {
	@Autowired	
	private IPersonaDao personaDao;
	@Autowired
	private IUsuarioDao usuarioDao;
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	public void setPersonaDao(IPersonaDao personaDao) {
		 this.personaDao = personaDao;		 
	}
	public void setUsuarioDao(IUsuarioDao usuarioDao) {
		 this.usuarioDao = usuarioDao;		 
	}
	
	public List<Persona> findAll(){
		return this.personaDao.findAll();
	}
	public Persona findOne(int peId){
		return this.personaDao.findOne(peId);
	}
	public void Delete(int peId){
		this.personaDao.deleteById(peId);
	}
	public void Save(Persona persona){
		if (persona.getPeId()>0)
		{
			this.personaDao.update(persona);
		}
		else
		{			
			persona.setUsFechaReg(new Date() );
			this.personaDao.create(persona);
		}
	}
	public List<Usuario> findAllUsuario(){
		return this.usuarioDao.findAll();
	}
	public Usuario findOneUsuario(int usId){
		return this.usuarioDao.findOne(usId);
	}
	public void DeleteUsuario(int usId){
		this.usuarioDao.deleteById(usId);
	}
	public void SaveUsuario(Usuario usuario){
		if (usuario.getUsId()>0)
		{
			this.usuarioDao.update(usuario);
		}
		else
		{			
			//usuario.setUsFechaReg(new Date() );
			this.usuarioDao.create(usuario);
		}
	}
	public List<Usp_S_UsGetAllUsuarioByEm> GetAllUsuarioByEm(int emId,String usUserName,String usPassword){
		return this.usuarioDao.GetAllUsuarioByEm(emId,usUserName,usPassword);
	}
}
