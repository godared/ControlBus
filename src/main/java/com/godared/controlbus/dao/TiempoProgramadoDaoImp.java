package com.godared.controlbus.dao;


import java.util.List;

import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import com.godared.controlbus.bean.TiempoProgramado;

import com.godared.controlbus.bean.Usp_S_TiPrGetAllTiempoProgramadoByTiSa;
@Repository
public class TiempoProgramadoDaoImp extends AbstractJpaDAO<TiempoProgramado> implements ITiempoProgramadoDao {
	 public TiempoProgramadoDaoImp() {
	        super();
	        setClazz(TiempoProgramado.class);
	    }
	 @SuppressWarnings("unchecked")
	 public List<Usp_S_TiPrGetAllTiempoProgramadoByTiSa> GetAllTiempoProgramadoByTiSa(int tiSaId){
		 StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_S_TiPrGetAllTiempoProgramadoByTiSa");
	 	    storedProcedure.setParameter("tiSaId",tiSaId);
	 	    return storedProcedure.getResultList();
	 }
}
