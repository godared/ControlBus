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
	 public List<Georeferencia> GetAllGeoreferenciaByTaCo(int taCo){
		 StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_S_GeGetAllGeoreferenciaByTaCo");
	 	    storedProcedure.setParameter("taCo",taCo);
	 	    return storedProcedure.getResultList();
	 }
}
