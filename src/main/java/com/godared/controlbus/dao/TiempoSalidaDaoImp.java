package com.godared.controlbus.dao;

import java.util.List;

import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import com.godared.controlbus.bean.TiempoSalida;

@Repository
public class TiempoSalidaDaoImp extends AbstractJpaDAO<TiempoSalida> implements ITiempoSalidaDao  {
	 public TiempoSalidaDaoImp() {
	        super();
	        setClazz(TiempoSalida.class);
	    }
	 @SuppressWarnings("unchecked")
	 public List<TiempoSalida> GetAllTiempoSalidaByEm(int emId){
		 StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_S_TiSaGetAllTiempoSalidaByEm");
	 	    storedProcedure.setParameter("emId",emId);
	 	    return storedProcedure.getResultList();
	 }
	 @SuppressWarnings("unchecked")
	 public List<TiempoSalida> GetValorSalidaByEmBu(int emId,int buId){
		 StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_S_TiSaGetValorSalidaByEmBu");
	 	    storedProcedure.setParameter("emId",emId);
	 	   storedProcedure.setParameter("buId",buId);
	 	    return storedProcedure.getResultList();
	 }
}
