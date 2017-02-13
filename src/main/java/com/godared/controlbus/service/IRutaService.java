package com.godared.controlbus.service;

import java.util.List;

import com.godared.controlbus.bean.PuntoControl;
import com.godared.controlbus.bean.PuntoControlDetalle;
import com.godared.controlbus.bean.Ruta;
import com.godared.controlbus.bean.RutaDetalle;
import com.godared.controlbus.bean.Usp_S_PuCoGetAllPuntoControlByEmRu;
import com.godared.controlbus.bean.Usp_S_RuGetAllRutaByEm;

public interface IRutaService {
	 
	 List<Ruta> findAll();
	 Ruta findOne(int ruId);
	 void Delete(int ruId);
	 void Save(Ruta ruta,List<RutaDetalle> rutaDetalle);
	 List<Usp_S_RuGetAllRutaByEm> GetAllRutaByEm(int emId);
	 //Ruta Detalle
	 RutaDetalle findOneRutaDetalleId(int ruId);
	 RutaDetalle findOneRutaDetalleByruId(int ruId);
	 void CreateRutaDetalle(RutaDetalle rutaDetalle);
	 void UpdateRutaDetalle(int ruId,RutaDetalle rutaDetalle);
	 void DeleteRutaDetalle(int ruId);
	 //PuntoControl
	 List<PuntoControl> findAllPuntoControl();
	 PuntoControl findOnePuntoControl(int puCoId);
	 void DeletePuntoControl(int puCoId);
	 void Save(PuntoControl puntoControl,List<PuntoControlDetalle> puntoControlDetalle);
	 List<Usp_S_PuCoGetAllPuntoControlByEmRu> GetAllPuntoControlByEmRu(int emId,int ruId);
	//PuntaContro Detalle
	 PuntoControlDetalle findOnePuntoControlDetalleId(int puCoDeId);
	 PuntoControlDetalle findOnePuntoControlDetalleBypuCoId(int puCoId);
	 void CreatePuntoControlDetalle(PuntoControlDetalle puntoControlDetalle);
	 void UpdatePuntoControlDetalle(int puCoId,PuntoControlDetalle puntoControlDetalle);
	 void DeletePuntoControlDetalle(int puCoDeId);
	 void DeletePuntoControlDetalleByPuCoId(int puCoId);
 
}
