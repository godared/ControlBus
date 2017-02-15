package com.godared.controlbus.service;

import java.util.List;

import com.godared.controlbus.bean.Bus;

public interface IBusService {
	List<Bus> findAll();
	 Bus findOne(int buId);
	 void Delete(int buId);
	 void Save(Bus bus);
	 //List<Usp_S_PrGetAllProgramacionByEm> GetAllProgramacionByEm(int emId, int anio);
}
