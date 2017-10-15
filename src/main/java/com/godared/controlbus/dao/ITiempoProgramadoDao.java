package com.godared.controlbus.dao;

import java.util.List;

import com.godared.controlbus.bean.TiempoProgramado;
import com.godared.controlbus.bean.TiempoSalida;
import com.godared.controlbus.bean.Usp_S_TiPrGetAllTiempoProgramadoByTiSa;

public interface ITiempoProgramadoDao {
	TiempoProgramado findOne(int id);
    List<TiempoProgramado> findAll();
    void create(TiempoProgramado entity);
    TiempoProgramado update(TiempoProgramado entity);
    void delete(TiempoProgramado entity);
    void deleteById(int entityId);
    List<Usp_S_TiPrGetAllTiempoProgramadoByTiSa> GetAllTiempoProgramadoByTiSa(int tiSaId);
}
