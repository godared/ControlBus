package com.godared.controlbus.service;

import java.util.List;

import com.godared.controlbus.bean.Programacion;
import com.godared.controlbus.bean.ProgramacionDetalle;
import com.godared.controlbus.bean.Usp_S_PrGetAllProgramacionByEm;

public interface IProgramacionService {
	 List<Programacion> findAll();
	 Programacion findOne(int prId);
	 void Delete(int prId);
	 void Save(Programacion programacion,List<ProgramacionDetalle> programacionDetalle);
	 List<Usp_S_PrGetAllProgramacionByEm> GetAllProgramacionByEm(int emId, int anio);
	//Programacion Detalle
	 ProgramacionDetalle findOneProgramacionDetalleId(int prDeId);
	 ProgramacionDetalle findOneProgramacionDetalleByprId(int prId);
	 void CreateProgramacionDetalle(ProgramacionDetalle programacionDetalle);
	 void UpdateProgramacionDetalle(int prDeId,ProgramacionDetalle programacionDetalle);
	 void DeleteProgramacionDetalle(int prDeId);
	 void DeleteProgramacionDetalleByPrId(int prId);

}
