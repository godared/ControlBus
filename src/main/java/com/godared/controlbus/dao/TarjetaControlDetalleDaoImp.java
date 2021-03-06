package com.godared.controlbus.dao;

import java.util.List;

import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import com.godared.controlbus.bean.TarjetaControlDetalle;
@Repository
public class TarjetaControlDetalleDaoImp extends AbstractJpaDAO<TarjetaControlDetalle> implements ITarjetaControlDetalleDao   {
	 public TarjetaControlDetalleDaoImp() {
	        super();
	        setClazz(TarjetaControlDetalle.class);
	    }
	 public void deleteByTaCoId(int taCoId){
		 StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_D_TaCoDeEliminaByTaCo");
	 	    storedProcedure.setParameter("taCoId",taCoId);
	 	    storedProcedure.execute();
	 }
	 public List<TarjetaControlDetalle> getAllTarjetaControlDetalleByTaCo(int taCoId){
		 StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_S_TaCoDeGetAllTarjetaControlDetalleByTaCo");
	 	    storedProcedure.setParameter("taCoId",taCoId);
	 	   return storedProcedure.getResultList();
	 }
}
