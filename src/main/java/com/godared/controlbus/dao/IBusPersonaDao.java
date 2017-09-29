package com.godared.controlbus.dao;

import java.util.List;

import com.godared.controlbus.bean.BusPersona;
import com.godared.controlbus.bean.Usp_S_PeGetAllPersonaByEmSuEm;


public interface IBusPersonaDao {
	BusPersona findOne(int id);
    List<BusPersona> findAll();
    void create(BusPersona entity);
    BusPersona update(BusPersona entity);
    void delete(BusPersona entity);
    void deleteById(int entityId);
    ///
    void deleteByBu(int buId);
    List<Usp_S_PeGetAllPersonaByEmSuEm> getAllPersonaByEmBu (int emId, int buId);
}
