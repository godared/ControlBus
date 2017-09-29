package com.godared.controlbus.dao;

import java.util.List;

import com.godared.controlbus.bean.PuntoControlDetalle;

public interface IPuntoControlDetalleDao {
	PuntoControlDetalle findOne(int id);
    List<PuntoControlDetalle> findAll();
    void create(PuntoControlDetalle entity);
    PuntoControlDetalle update(PuntoControlDetalle entity);
    void delete(PuntoControlDetalle entity);
    void deleteById(int entityId);
    void deleteByPuCoId(int entityPuCoId);
    List<PuntoControlDetalle> getAllPuntoControlDetalleByPuCo(int puCoId);
}
