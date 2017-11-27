package com.godared.controlbus.dao;

import java.util.Date;
import java.util.List;

import com.godared.controlbus.bean.TarjetaControl;
import com.godared.controlbus.bean.Usp_S_GetAllRegistroVueltasDiariasByEmPrFe;
import com.godared.controlbus.bean.Usp_S_RuGetAllRutaByEm;
import com.godared.controlbus.bean.Usp_S_TaCoGetAllTarjetaControlByEmPuCo;

public interface ITarjetaControlDao {
	TarjetaControl findOne(int id);
    List<TarjetaControl> findAll();
    void create(TarjetaControl entity);
    TarjetaControl createReturn(TarjetaControl entity); 
    TarjetaControl update(TarjetaControl entity);
    void delete(TarjetaControl entity);
    void deleteById(int entityId);
    List<Usp_S_TaCoGetAllTarjetaControlByEmPuCo> GetAllTarjetaControlByEmPuCo(int emId,int puCoId);
    List<TarjetaControl> Usp_S_TaCoGetAllTarjetaControlByBuIdFecha(int buId,Date taCoFecha);
    List<Usp_S_GetAllRegistroVueltasDiariasByEmPrFe> GetAllRegistroVueltasDiariasByEmPrFe(int emId,int prId,Date fechaDiario);
}
