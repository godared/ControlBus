package com.godared.controlbus.dao;

import java.util.List;

import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import com.godared.controlbus.bean.Configura;

@Repository
public class ConfiguraDaoImp extends AbstractJpaDAO<Configura> implements IConfiguraDao {
	public ConfiguraDaoImp() {
        super();
        setClazz(Configura.class);
    }
	 @SuppressWarnings("unchecked")
	 public List<Configura> GetAllConfiguraByEmPeriodo(int emId,int coPeriodo){
		 StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_S_CoGetAllConfiguraByEmPeriodo");
	 	    storedProcedure.setParameter("emId",emId);
	 	   storedProcedure.setParameter("coPeriodo",coPeriodo);
	 	    return storedProcedure.getResultList();
	 }
}
