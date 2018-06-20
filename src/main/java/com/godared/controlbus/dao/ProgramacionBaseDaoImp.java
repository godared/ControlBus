package com.godared.controlbus.dao;

import java.util.List;

import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import com.godared.controlbus.bean.ProgramacionBase;
import com.godared.controlbus.bean.Telefono;
import com.godared.controlbus.bean.Usp_S_PrBaGetAllProgramacionBaseByEm;
import com.godared.controlbus.bean.Usp_S_TeGetAllTelefonoByBuImei;

@Repository
public class ProgramacionBaseDaoImp  extends AbstractJpaDAO<ProgramacionBase> implements IProgramacionBaseDao {
	 public ProgramacionBaseDaoImp() {
	        super();
	        setClazz(ProgramacionBase.class);
	    }
	public List<Usp_S_PrBaGetAllProgramacionBaseByEm> GetAllProgramacionBaseByEm(int emId,int anio){
		 StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_S_PrBaGetAllProgramacionBaseByEm");
		 storedProcedure.setParameter("emId",emId);
	 	  storedProcedure.setParameter("anio",anio);
	 	    return storedProcedure.getResultList();
	 }
}
