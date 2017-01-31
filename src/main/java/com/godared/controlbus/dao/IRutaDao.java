package com.godared.controlbus.dao;

import java.util.List;

import com.godared.controlbus.bean.Ruta;

public interface IRutaDao {
	Ruta findOne(int id);
    List<Ruta> findAll();
    void create(Ruta entity);
    Ruta update(Ruta entity);
    void delete(Ruta entity);
    void deleteById(int entityId);

}
