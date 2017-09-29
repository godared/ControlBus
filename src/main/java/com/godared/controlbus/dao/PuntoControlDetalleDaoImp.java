package com.godared.controlbus.dao;

import java.util.List;

import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import com.godared.controlbus.bean.PuntoControlDetalle;


@Repository
public class PuntoControlDetalleDaoImp extends AbstractJpaDAO<PuntoControlDetalle> implements IPuntoControlDetalleDao  {
	 public PuntoControlDetalleDaoImp() {
	        super();

	        setClazz(PuntoControlDetalle.class);
	    }
	 public void deleteByPuCoId(int puCoId){
		 StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_D_PuCoDeEliminaByPuCo");
	 	    storedProcedure.setParameter("puCoId",puCoId);
	 	    storedProcedure.execute();
	 }
	 public List<PuntoControlDetalle> getAllPuntoControlDetalleByPuCo(int puCoId){
		 StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_S_PuCoDeGetAllPuntoControlDetalleByPuCo");
	 	    storedProcedure.setParameter("puCoId",puCoId);
	 	   return storedProcedure.getResultList();
	 }

}
