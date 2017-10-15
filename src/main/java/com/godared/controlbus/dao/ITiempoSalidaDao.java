package com.godared.controlbus.dao;

import java.util.List;

import com.godared.controlbus.bean.TiempoSalida;

public interface ITiempoSalidaDao {
	TiempoSalida findOne(int id);
    List<TiempoSalida> findAll();
    List<TiempoSalida> GetAllTiempoSalidaByEm(int emId);
    void create(TiempoSalida entity);
    TiempoSalida update(TiempoSalida entity);
    void delete(TiempoSalida entity);
    void deleteById(int entityId);

}
