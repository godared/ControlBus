package com.godared.controlbus.dao;

import java.util.List;

import com.godared.controlbus.bean.RutaDetalle;

public interface IRutaDetalleDao {
	RutaDetalle findOne(int id);
    List<RutaDetalle> findAll();
    void create(RutaDetalle entity);
    RutaDetalle update(RutaDetalle entity);
    void delete(RutaDetalle entity);
    void deleteById(int entityId);

}
