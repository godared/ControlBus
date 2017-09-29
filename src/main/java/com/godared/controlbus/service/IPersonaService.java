package com.godared.controlbus.service;

import java.util.List;

import com.godared.controlbus.bean.Persona;
import com.godared.controlbus.bean.Usp_S_UsGetAllUsuarioByEm;
import com.godared.controlbus.bean.Usuario;

public interface IPersonaService {
	List<Persona> findAll();
	Persona findOne(int peId);
	void Delete(int peId);
	void Save(Persona persona);
	
	//Usuario
	List<Usuario> findAllUsuario();
	Usuario findOneUsuario(int usId);
	void DeleteUsuario(int usId);
	void SaveUsuario(Usuario usuario);
	List<Usp_S_UsGetAllUsuarioByEm> GetAllUsuarioByEm(int emId,String usUserName,String usPassword);
}
