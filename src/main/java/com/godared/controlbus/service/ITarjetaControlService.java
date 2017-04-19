package com.godared.controlbus.service;

import java.util.List;

import com.godared.controlbus.bean.TarjetaControl;
import com.godared.controlbus.bean.TarjetaControlDetalle;
import com.godared.controlbus.bean.Usp_S_RuGetAllRutaByEm;
import com.godared.controlbus.bean.Usp_S_TaCoGetAllTarjetaControlByEmPuCo;

public interface ITarjetaControlService {
	 List<TarjetaControl> findAll();
	 TarjetaControl findOne(int taCoId);
	 void Delete(int taCoId);
	 void Save(TarjetaControl tarjetaControl);
	 void Save(TarjetaControl tarjetaControl,List<TarjetaControlDetalle> tarjetaControlDetalle);
	 List<Usp_S_TaCoGetAllTarjetaControlByEmPuCo> GetAllTarjetaControlByEmPuCo(int emId,int puCoId);
	//TarjetaControl Detalle
	 TarjetaControlDetalle findOneTarjetaControlDetalleId(int taCoDeId);
	 TarjetaControlDetalle findOneTarjetaControlDetalleBytaCoId(int taCoId);
	 void CreateTarjetaControlDetalle(TarjetaControlDetalle tarjetaControlDetalle);
	 void CreateTarjetaControlDetalle(List<TarjetaControlDetalle> tarjetaControlDetalle);
	 void UpdateTarjetaControlDetalle(int taCoId,TarjetaControlDetalle tarjetaControlDetalle);
	 void DeleteTarjetaControlDetalle(int taCoDeId);
	 void DeleteTarjetaControlDetalleBytaCoId(int taCoId);
}
