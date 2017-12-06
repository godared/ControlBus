package com.godared.controlbus.dao;

import java.util.List;

import com.godared.controlbus.bean.Georeferencia;

public interface IGeoreferenciaDao {
	Georeferencia findOne(int id);
    List<Georeferencia> findAll();
    List<Georeferencia> GetAllGeoreferenciaByTaCo(int TaCoId);    
    void create(Georeferencia entity);
    Georeferencia createReturn(Georeferencia entity);
    Georeferencia update(Georeferencia entity);
    void delete(Georeferencia entity);
    void deleteById(int entityId);
}
