package com.godared.controlbus.dao;


import java.util.List;

import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import com.godared.controlbus.bean.RutaDetalle;

@Repository
public class RutaDetalleDaoImp extends AbstractJpaDAO<RutaDetalle> implements IRutaDetalleDao {
	 public RutaDetalleDaoImp() {
	        super();

	        setClazz(RutaDetalle.class);
	    }
	 public void deleteByRuId(int ruId){
		 StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_D_RuDeEliminaByRu");
	 	    storedProcedure.setParameter("ruId",ruId);
	 	    storedProcedure.execute();
	 }
	 public List<RutaDetalle> getAllRutaDetalleByRu(int ruId){
		 StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_S_RuDeGetAllRutaDetalleByRu");
	 	    storedProcedure.setParameter("ruId",ruId);
	 	   return storedProcedure.getResultList();
	 }
}
