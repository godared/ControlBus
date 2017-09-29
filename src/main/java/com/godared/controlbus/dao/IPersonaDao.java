package com.godared.controlbus.dao;

import java.util.List;

import com.godared.controlbus.bean.Bus;
import com.godared.controlbus.bean.Persona;
import com.godared.controlbus.bean.Usp_S_BuGetAllBusesByEmSuEm;

public interface IPersonaDao {
	Persona findOne(int id);
    List<Persona> findAll();
    void create(Persona entity);
    Persona update(Persona entity);
    void delete(Persona entity);
    void deleteById(int entityId);
    //List<Usp_S_PeGetAllPersonalByEmSuEm> GetAllPersonalByEmSuEm(int emId,int suEmId);
}
