package com.godared.controlbus.dao;

import java.util.List;

import com.godared.controlbus.bean.ProgramacionBase;
import com.godared.controlbus.bean.Usp_S_PrBaGetAllProgramacionBaseByEm;

public interface IProgramacionBaseDao {
	ProgramacionBase findOne(int id);
    List<ProgramacionBase> findAll();
    void create(ProgramacionBase entity);
    ProgramacionBase createReturn(ProgramacionBase entity);
    ProgramacionBase update(ProgramacionBase entity);
    void delete(ProgramacionBase entity);
    void deleteById(int entityId);
    List<Usp_S_PrBaGetAllProgramacionBaseByEm> GetAllProgramacionBaseByEm(int emId,int anio);

}
