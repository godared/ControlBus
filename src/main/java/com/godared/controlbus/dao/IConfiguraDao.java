package com.godared.controlbus.dao;

import java.util.List;

import com.godared.controlbus.bean.Configura;


public interface IConfiguraDao {
	Configura findOne(int id);
    List<Configura> findAll();
    List<Configura> GetAllConfiguraByEmPeriodo(int emId,int coPeriodo);
    void create(Configura entity);
    Configura update(Configura entity);
    void delete(Configura entity);
    void deleteById(int entityId);

}
