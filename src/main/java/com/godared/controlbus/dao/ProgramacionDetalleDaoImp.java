package com.godared.controlbus.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.StoredProcedureQuery;

import com.godared.controlbus.bean.ProgramacionDetalle;

public class ProgramacionDetalleDaoImp extends AbstractJpaDAO<ProgramacionDetalle> implements IProgramacionDetalleDao   {
	 public ProgramacionDetalleDaoImp() {
	        super();
	        setClazz(ProgramacionDetalle.class);
	    }
	 public void deleteByPrId(int prId){
		 StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_D_PrDeEliminaByPr");
	 	    storedProcedure.setParameter("prId",prId);
	 	    storedProcedure.execute();
	 }
	 public List<ProgramacionDetalle> getAllProgramacionDetalleByPr(int prId){
		 StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_S_PrDeGetAllProgramacionDetalleByPr");
	 	    storedProcedure.setParameter("prId",prId);
	 	   return storedProcedure.getResultList();
	 }
	 public List<ProgramacionDetalle> getAllProgramacionDetalleByPrFecha(int prId,Date prDeFecha){
		 StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_S_PrDeGetAllProgramacionDetalleByPrFecha");
	 	    storedProcedure.setParameter("prId",prId);
	 	   storedProcedure.setParameter("prDeFecha",prDeFecha);
	 	   return storedProcedure.getResultList();
	 }
	 public List<ProgramacionDetalle> getAllProgramacionDetalleByPrBaFecha(int prBaId,Date prDeFecha){
		 StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_S_PrDeGetAllProgramacionDetalleByPrBaFecha");
	 	    storedProcedure.setParameter("prBaId",prBaId);
	 	   storedProcedure.setParameter("prDeFecha",prDeFecha);
	 	   return storedProcedure.getResultList();
	 }
}
