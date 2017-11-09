package com.godared.controlbus.service;

import java.util.List;

import com.godared.controlbus.bean.RegistroDiario;
import com.godared.controlbus.bean.RegistroDiarioDetalle;
import com.godared.controlbus.bean.RegistroReten;


public interface IRegistroDiarioService {
		List<RegistroDiario> findAll();
		RegistroDiario findOne(int reDiId);	
		List<RegistroDiario> GetAllRegistroDiarioByEm(int emId);		
		void Delete(int reDiId);
		void Save(RegistroDiario registroDiario);
		
		//RegistroDiarioDetalle
		List<RegistroDiarioDetalle> findAllRegistroDiarioDetalle();
		RegistroDiarioDetalle findOneRegistroDiarioDetalle(int reDiDeId);	
		List<RegistroDiarioDetalle> GetAllRegistroDiarioDetalleByReDi(int reDiId);		
		void DeleteRegistroDiarioDetalle(int reDiDeId);
		void SaveRegistroDiarioDetalle(RegistroDiarioDetalle registroDiarioDetalle);
		
		//RegistroReten
		List<RegistroReten> findAllRegistroReten();
		RegistroReten findOneRegistroReten(int reReId);	
		List<RegistroReten> GetAllRegistroRetenByReDiDe(int reDiDeId);		
		void DeleteRegistroReten(int reReId);
		void SaveRegistroReten(RegistroReten registroReten);
}
