package com.godared.controlbus.dao;

import java.util.List;

import javax.persistence.StoredProcedureQuery;

import com.godared.controlbus.bean.RegistroReten;

public class RegistroRetenDaoImp extends AbstractJpaDAO<RegistroReten> implements IRegistroRetenDao {
	 public RegistroRetenDaoImp() {
	        super();
	        setClazz(RegistroReten.class);
	    }
	 /* @SuppressWarnings("unchecked")
	 public List<RegistroReten> GetAllRegistroRetenByReDiDe(int reDiDeId){
		 StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_S_ReReGetAllRegistroRetenByReDiDe");
	 	    storedProcedure.setParameter("reDiDeId",reDiDeId);
	 	    return storedProcedure.getResultList();
	 }*/
	 
}
