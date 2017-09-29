package com.godared.controlbus.service;

import java.util.List;

import com.godared.controlbus.bean.Empresa;
import com.godared.controlbus.bean.EmpresaPersona;
import com.godared.controlbus.bean.SubEmpresa;
import com.godared.controlbus.bean.Usp_S_PeGetAllPersonaByEmSuEm;

public interface IEmpresaService {
	List<Empresa> findAll();
	Empresa findOne(int emId);
	void Delete(int emId);
	void Save(Empresa empresa);
	//SubEmpresa	
	SubEmpresa findOneSubEmpresa(int suEmId);
	List<SubEmpresa> getAllSubEmpresaByEm(int emId);	
	void DeleteSubEmpresa(int suEmId);
	void DeleteSubEmpresaByEm(int emId);
	void Save(SubEmpresa subEmpresa);
	//PersonaEmpresa	
	EmpresaPersona findOneEmpresaPersona(int emPeId);
	List<Usp_S_PeGetAllPersonaByEmSuEm> getAllPersonaByEmSuEm(int emId, int suEmId);	
	void DeleteEmpresaPersona(int emPeId);
	void DeleteEmpresaPersonaBySuEm(int suEmId);
	void Save(EmpresaPersona empresaPersona);
}
