package com.godared.controlbus.dao;

import java.util.List;

import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import com.godared.controlbus.bean.Ruta;
import com.godared.controlbus.bean.Usp_S_RuGetAllRutaByEm;

@Repository
public class RutaDaoImp extends AbstractJpaDAO<Ruta> implements IRutaDao {
	 public RutaDaoImp() {
	        super();

	        setClazz(Ruta.class);
	    }
	 @SuppressWarnings("unchecked")
	 public List<Usp_S_RuGetAllRutaByEm> GetAllRutaByEm(int emId){
		 StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_S_RuGetAllRutaByEm");
	 	    storedProcedure.setParameter("emId",emId);
	 	    return storedProcedure.getResultList();
	 }
}
