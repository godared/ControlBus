package com.godared.controlbus.dao;

import java.util.List;

import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import com.godared.controlbus.bean.Programacion;
import com.godared.controlbus.bean.Usp_S_PrGetAllProgramacionByEm;

@Repository
public class ProgramacionDaoImp extends AbstractJpaDAO<Programacion> implements IProgramacionDao {
	 public ProgramacionDaoImp() {
	        super();

	        setClazz(Programacion.class);
	    }
	
	 public List<Usp_S_PrGetAllProgramacionByEm> GetAllProgramacionByEm(int emId,int anio){
		 StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_S_PrGetAllProgramacionByEm");
	 	    storedProcedure.setParameter("emId",emId);
	 	   storedProcedure.setParameter("anio",anio);
	 	    return storedProcedure.getResultList();
	 }
}
