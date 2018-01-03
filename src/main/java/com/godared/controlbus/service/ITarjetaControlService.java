package com.godared.controlbus.service;

import java.util.Date;
import java.util.List;

import com.godared.controlbus.bean.Georeferencia;
import com.godared.controlbus.bean.TarjetaControl;
import com.godared.controlbus.bean.TarjetaControlDetalle;
import com.godared.controlbus.bean.Telefono;
import com.godared.controlbus.bean.TiempoProgramado;
import com.godared.controlbus.bean.TiempoSalida;
import com.godared.controlbus.bean.Usp_S_GetAllRegistroVueltasDiariasByEmPrFe;
import com.godared.controlbus.bean.Usp_S_TaCoGetAllTarjetaControlByBuIdFecha;
import com.godared.controlbus.bean.Usp_S_TaCoGetAllTarjetaControlByEmPuCo;
import com.godared.controlbus.bean.Usp_S_TeGetAllTelefonoByBuImei;
import com.godared.controlbus.bean.Usp_S_TiPrGetAllTiempoProgramadoByTiSa;

public interface ITarjetaControlService {
	 List<TarjetaControl> findAll();
	 TarjetaControl findOne(int taCoId);
	 List<Usp_S_TaCoGetAllTarjetaControlByBuIdFecha> Usp_S_TaCoGetAllTarjetaControlByBuIdFecha(int buId,Date taCoFecha);
	 List<Usp_S_TaCoGetAllTarjetaControlByBuIdFecha> GetAllTarjetaControlByEmReDiDe(int emId,int reDiDe);
	 void Delete(int taCoId);
	 TarjetaControl Save(TarjetaControl tarjetaControl);
	 void Save(TarjetaControl tarjetaControl,List<TarjetaControlDetalle> tarjetaControlDetalle);
	 int UpdateTarjetaControlOfMovil(int taCoId,TarjetaControl tarjetaControl);
	 List<Usp_S_TaCoGetAllTarjetaControlByEmPuCo> GetAllTarjetaControlByEmPuCo(int emId,int puCoId);
	 List<Usp_S_GetAllRegistroVueltasDiariasByEmPrFe> GetAllRegistroVueltasDiariasByEmPrFe(int emId,int prId,Date fechaDiario);
	 void AsignarTarjetaControl(TarjetaControl tarjetaControl, boolean tarjetaMulti);
	 void AsignarTarjetaMultiple(TarjetaControl tarjetaControl, Date reten1,Date reten2,boolean tarjetaMulti);
	 void TerminarVuelta(int reDiDeId);
	//TarjetaControl Detalle
	 TarjetaControlDetalle findOneTarjetaControlDetalleId(int taCoDeId);
	 TarjetaControlDetalle findOneTarjetaControlDetalleBytaCoId(int taCoId);
	 List<TarjetaControlDetalle> getAllTarjetaControlDetalleByTaCo(int taCoId);
	 void CreateTarjetaControlDetalle(TarjetaControlDetalle tarjetaControlDetalle);
	 void CreateTarjetaControlDetalle(List<TarjetaControlDetalle> tarjetaControlDetalle);
	 int UpdateTarjetaControlDetalleOfMovil(int taCoId,TarjetaControlDetalle tarjetaControlDetalle);
	 void DeleteTarjetaControlDetalle(int taCoDeId);
	 void DeleteTarjetaControlDetalleBytaCoId(int taCoId);
	 
	 
	//TiempoSalida
	List<TiempoSalida> findAllTiempoSalida();
	TiempoSalida findOneTiempoSalida(int tiSaId);	
	List<TiempoSalida> GetAllTiempoSalidaByEm(int emId);
	List<TiempoSalida> GetValorSalidaByEmBu(int emId,int buId);
	void DeleteTiempoSalida(int tiSaId);
	void SaveTiempoSalida(TiempoSalida tiempoSalida);
	//TiempoProgramado	
	List<TiempoProgramado> findAllTiempoProgramado();	
	TiempoProgramado findOneTiempoProgramado(int tiPrId);
	List<Usp_S_TiPrGetAllTiempoProgramadoByTiSa> GetAllTiempoProgramadoByTiSa(int tiSaId);
	void DeleteTiempoProgramado(int tiPrId);
	//void DeleteBusPersonaByBu(int buId);
	void SaveTiempoProgramado(TiempoProgramado tiempoProgramado);
	//Georeferencia
	Georeferencia findOneGeoreferencia(int geid);    
    List<Georeferencia> GetAllGeoreferenciaByTaCo(int taCoId); 
    void SaveGeoreferenciaOfMovil(List<Georeferencia> georeferencias);
    void SaveGeoreferencia(Georeferencia georeferencia);
    Georeferencia createReturnGeoreferencia(Georeferencia georeferencia);
    void deleteGeoreferenciaById(int geId);
    void Usp_D_GeEliminaByTaCo(int taCoId);
	
}
