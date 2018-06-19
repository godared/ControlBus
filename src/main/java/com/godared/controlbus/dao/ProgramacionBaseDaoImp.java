package com.godared.controlbus.dao;

import java.util.List;

import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import com.godared.controlbus.bean.ProgramacionBase;
import com.godared.controlbus.bean.Telefono;
import com.godared.controlbus.bean.Usp_S_TeGetAllTelefonoByBuImei;

@Repository
public class ProgramacionBaseDaoImp  extends AbstractJpaDAO<ProgramacionBase> implements IProgramacionBaseDao {
	 public ProgramacionBaseDaoImp() {
	        super();
	        setClazz(ProgramacionBase.class);
	    }
	/* public List<Usp_S_PrBaProgramacionBaseByEm> GetAllProgramacionBaseByEm(int buId,String teImei){
		 StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_S_PrBaProgramacionBaseByEm");
	 	    storedProcedure.setParameter("buId",buId);
	 	   storedProcedure.setParameter("teImei",teImei);
	 	    return storedProcedure.getResultList();
	 }*/
}
