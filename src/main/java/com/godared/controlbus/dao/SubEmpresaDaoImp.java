package com.godared.controlbus.dao;

import java.util.List;

import javax.persistence.StoredProcedureQuery;

import com.godared.controlbus.bean.SubEmpresa;

public class SubEmpresaDaoImp extends AbstractJpaDAO<SubEmpresa> implements ISubEmpresaDao {
	public SubEmpresaDaoImp() {
        super();
        setClazz(SubEmpresa.class);
    }
	public void deleteByEm(int emId){
		StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_D_SuEmEliminaByEm");
 	    storedProcedure.setParameter("emId",emId);
 	    storedProcedure.execute();
	}
    public List<SubEmpresa> getAllSuEmpresaByEm(int emId){
    	StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_S_SuEmGetAllSubEmpresaByEm");
 	    storedProcedure.setParameter("emId",emId);
 	   return storedProcedure.getResultList();
    }
}
