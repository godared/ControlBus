package com.godared.controlbus.dao;

import java.util.List;

import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import com.godared.controlbus.bean.RegistroDiario;

@Repository
public class RegistroDiarioDaoImp extends AbstractJpaDAO<RegistroDiario> implements IRegistroDiarioDao {
	 public RegistroDiarioDaoImp() {
	        super();
	        setClazz(RegistroDiario.class);
	    }
	 @SuppressWarnings("unchecked")
	 public List<RegistroDiario> GetAllRegistroDiarioByEm(int emId){
		 StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_S_ReDiGetAllRegistroDiarioByEm");
	 	    storedProcedure.setParameter("emId",emId);
	 	    return storedProcedure.getResultList();
	 }
}
