package com.godared.controlbus.service;

import java.util.List;

import com.godared.controlbus.bean.Ruta;

public interface IRutaService {
	 void Save(Ruta ruta);
	 List<Ruta> findAll();
	 Ruta findOne(int id);
	 void Delete(int id);
}
