package com.godared.controlbus.service;

import java.util.List;

import com.godared.controlbus.bean.Bus;
import com.godared.controlbus.bean.Usp_S_BuGetAllBusesByEmSuEm;

public interface IBusService {
	List<Bus> findAll();
	 Bus findOne(int buId);
	 void Delete(int buId);
	 void Save(Bus bus);
	 List<Usp_S_BuGetAllBusesByEmSuEm> GetAllBusesByEmSuEm(int emId, int suEmId);
	 List<Bus>GetAllBusActivo(int emId);
}
