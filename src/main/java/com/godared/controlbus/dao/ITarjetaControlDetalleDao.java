package com.godared.controlbus.dao;

import java.util.List;

import com.godared.controlbus.bean.TarjetaControlDetalle;

public interface ITarjetaControlDetalleDao {
	TarjetaControlDetalle findOne(int id);
    List<TarjetaControlDetalle> findAll();
    void create(TarjetaControlDetalle entity);
    TarjetaControlDetalle update(TarjetaControlDetalle entity);
    void delete(TarjetaControlDetalle entity);
    void deleteById(int entityId);
    void deleteByTaCoId(int entityTaCoId);
}
