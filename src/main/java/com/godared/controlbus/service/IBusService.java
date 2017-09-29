package com.godared.controlbus.service;

import java.util.List;

import com.godared.controlbus.bean.Bus;
import com.godared.controlbus.bean.BusPersona;
import com.godared.controlbus.bean.Telefono;
import com.godared.controlbus.bean.Usp_S_BuGetAllBusesByEmSuEm;
import com.godared.controlbus.bean.Usp_S_PeGetAllPersonaByEmSuEm;
import com.godared.controlbus.bean.Usp_S_TeGetAllTelefonoByBuImei;

public interface IBusService {
	List<Bus> findAll();
	 Bus findOne(int buId);
	 void Delete(int buId);
	 void Save(Bus bus);
	 List<Usp_S_BuGetAllBusesByEmSuEm> GetAllBusesByEmSuEm(int emId, int suEmId);
	 List<Bus>GetAllBusActivo(int emId);
	 List<Bus>SortearAleatorio(int emId);
	//BusEmpresa	
	BusPersona findOneBusPersona(int buPeId);
	List<Usp_S_PeGetAllPersonaByEmSuEm> getAllPersonaByEmBu(int emId, int buId);	
	void DeleteBusPersona(int buPeId);
	void DeleteBusPersonaByBu(int buId);
	void Save(BusPersona busPersona);
	//Telefono	
	Telefono findOneTelefono(int teId);
	List<Usp_S_TeGetAllTelefonoByBuImei> getAllTelefonoByBuImei(int buId, String teImei);	
	void DeleteTelefono(int teId);
	//void DeleteBusPersonaByBu(int buId);
	void Save(Telefono telefono);
}
