package com.godared.controlbus.dao;

import java.util.List;

import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import com.godared.controlbus.bean.Georeferencia;
import com.godared.controlbus.bean.RegistroDiario;

@Repository
public class GeoreferenciaDaoImp extends AbstractJpaDAO<Georeferencia> implements IGeoreferenciaDao {
	 public GeoreferenciaDaoImp() {
	        super();
	        setClazz(Georeferencia.class);
	    }
	 @SuppressWarnings("unchecked")
	 public List<Georeferencia> GetAllGeoreferenciaByTaCo(int taCoId){
		 StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_S_GeGetAllGeoreferenciaByTaCo");
	 	    storedProcedure.setParameter("taCoId",taCoId);
	 	    return storedProcedure.getResultList();
	 }
	 public void Usp_D_GeEliminaByTaCo(int taCoId){
		 StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_D_GeEliminaByTaCo");
	 	    storedProcedure.setParameter("taCoId",taCoId);
	 	    storedProcedure.execute();
	 }
	 
}
