package com.godared.controlbus.service;

import java.util.List;

import com.godared.controlbus.bean.Ruta;
import com.godared.controlbus.bean.RutaDetalle;

public interface IRutaService {
	 
	 List<Ruta> findAll();
	 Ruta findOne(int ruId);
	 void Delete(int ruId);
	 void Save(Ruta ruta,List<RutaDetalle> rutaDetalle);
	 //Ruta Detalle
	 RutaDetalle findOneRutaDetalleId(int ruId);
	 RutaDetalle findOneRutaDetalleByruId(int ruId);
	 void CreateRutaDetalle(RutaDetalle rutaDetalle);
	 void UpdateRutaDetalle(int ruId,RutaDetalle rutaDetalle);
	 void DeleteRutaDetalle(int ruId);
}
