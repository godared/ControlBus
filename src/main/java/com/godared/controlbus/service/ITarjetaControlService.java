package com.godared.controlbus.service;

import java.util.Date;
import java.util.List;

import com.godared.controlbus.bean.TarjetaControl;
import com.godared.controlbus.bean.TarjetaControlDetalle;
import com.godared.controlbus.bean.Usp_S_TaCoGetAllTarjetaControlByEmPuCo;

public interface ITarjetaControlService {
	 List<TarjetaControl> findAll();
	 TarjetaControl findOne(int taCoId);
	 List<TarjetaControl> Usp_S_TaCoGetAllTarjetaControlByBuIdFecha(int buId,Date taCoFecha);
	 void Delete(int taCoId);
	 TarjetaControl Save(TarjetaControl tarjetaControl);
	 void Save(TarjetaControl tarjetaControl,List<TarjetaControlDetalle> tarjetaControlDetalle);
	 List<Usp_S_TaCoGetAllTarjetaControlByEmPuCo> GetAllTarjetaControlByEmPuCo(int emId,int puCoId);
	//TarjetaControl Detalle
	 TarjetaControlDetalle findOneTarjetaControlDetalleId(int taCoDeId);
	 TarjetaControlDetalle findOneTarjetaControlDetalleBytaCoId(int taCoId);
	 List<TarjetaControlDetalle> getAllTarjetaControlDetalleByTaCo(int taCoId);
	 void CreateTarjetaControlDetalle(TarjetaControlDetalle tarjetaControlDetalle);
	 void CreateTarjetaControlDetalle(List<TarjetaControlDetalle> tarjetaControlDetalle);
	 void UpdateTarjetaControlDetalleOfMovil(int taCoId,TarjetaControlDetalle tarjetaControlDetalle);
	 void DeleteTarjetaControlDetalle(int taCoDeId);
	 void DeleteTarjetaControlDetalleBytaCoId(int taCoId);
	 void AsignarTarjetaControl(TarjetaControl tarjetaControl);
}
