package com.godared.controlbus.dao;

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
}
