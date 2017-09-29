package com.godared.controlbus.dao;

import java.util.List;

import com.godared.controlbus.bean.PuntoControl;
import com.godared.controlbus.bean.Usp_S_PuCoGetAllPuntoControlByEmRu;

public interface IPuntoControlDao {
	PuntoControl findOne(int id);
    List<PuntoControl> findAll();
    void create(PuntoControl entity);
    PuntoControl update(PuntoControl entity);
    void delete(PuntoControl entity);
    void deleteById(int entityId);
    List<Usp_S_PuCoGetAllPuntoControlByEmRu> GetAllPuntoControlByEmRu(int emId,int ruId);
}
