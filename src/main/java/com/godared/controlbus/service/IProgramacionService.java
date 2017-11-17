package com.godared.controlbus.service;

import java.util.Date;
import java.util.List;

import com.godared.controlbus.bean.Programacion;
import com.godared.controlbus.bean.ProgramacionDetalle;
import com.godared.controlbus.bean.PuntoControl;
import com.godared.controlbus.bean.Usp_S_PrGetAllProgramacionByEm;

public interface IProgramacionService {
	 List<Programacion> findAll();
	 Programacion findOne(int prId);
	 void Delete(int prId);
	 void CreateProgramacion(Programacion programacion);
	 Programacion Save(Programacion programacion);
	 void Save(Programacion programacion,List<ProgramacionDetalle> programacionDetalle);
	 List<Usp_S_PrGetAllProgramacionByEm> GetAllProgramacionByEm(int emId, int anio);
	 void RegistrarProgramacionBase(List<ProgramacionDetalle>  programacionDetalles ,
				int emId,int prId, Boolean aleatorio );
	 List<ProgramacionDetalle> GenerarProgramacionMensual(int emId,int prId, 
				List<ProgramacionDetalle> programacionDetalles,long nroDias, Date fechaInicio,List<ProgramacionDetalle>programacionDetallesBD);
	//Programacion Detalle
	 ProgramacionDetalle findOneProgramacionDetalleId(int prDeId);
	 List<ProgramacionDetalle> getAllProgramacionDetalleByPr(int prId);
	 List<ProgramacionDetalle> getAllProgramacionDetalleByPrFecha(int prId,Date prDeFecha);
	 void CreateProgramacionDetalle(List<ProgramacionDetalle> programacionDetalle);
	 void RegistrarHoraBase(List<ProgramacionDetalle> programacionDetalle);
	 void CreateProgramacionDetalle(ProgramacionDetalle programacionDetalle);
	 void UpdateProgramacionDetalle(int prDeId,ProgramacionDetalle programacionDetalle);
	 void DeleteProgramacionDetalle(int prDeId);
	 void DeleteProgramacionDetalleByPrId(int prId);
	 ProgramacionDetalle UpdateFieldProgramacionDetalle(ProgramacionDetalle programacionDetalle);

}
