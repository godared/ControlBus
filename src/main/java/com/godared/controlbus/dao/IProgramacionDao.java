package com.godared.controlbus.dao;

import java.util.List;

import com.godared.controlbus.bean.Programacion;
import com.godared.controlbus.bean.Usp_S_PrGetAllProgramacionByEm;

public interface IProgramacionDao {
	Programacion findOne(int id);
    List<Programacion> findAll();
    void create(Programacion entity);
    Programacion createReturn(Programacion entity);
    Programacion update(Programacion entity);
    void delete(Programacion entity);
    void deleteById(int entityId);
    List<Usp_S_PrGetAllProgramacionByEm> GetAllProgramacionByEm(int emId,int anio);

}
