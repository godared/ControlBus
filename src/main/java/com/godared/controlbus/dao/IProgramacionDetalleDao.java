package com.godared.controlbus.dao;

import java.util.Date;
import java.util.List;

import com.godared.controlbus.bean.ProgramacionDetalle;

public interface IProgramacionDetalleDao {
	ProgramacionDetalle findOne(int id);
    List<ProgramacionDetalle> findAll();
    void create(ProgramacionDetalle entity);
    ProgramacionDetalle update(ProgramacionDetalle entity);
    void delete(ProgramacionDetalle entity);
    void deleteById(int entityId);
    void deleteByPrId(int prId);
    List<ProgramacionDetalle> getAllProgramacionDetalleByPr(int prId);
    List<ProgramacionDetalle> getAllProgramacionDetalleByPrFecha(int prId,Date prDeFecha);
    List<ProgramacionDetalle> getAllProgramacionDetalleByPrBaFecha(int prBaId,Date prDeFecha);
    
}
