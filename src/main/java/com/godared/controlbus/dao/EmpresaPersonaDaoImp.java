package com.godared.controlbus.dao;


import java.util.List;

import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import com.godared.controlbus.bean.EmpresaPersona;
import com.godared.controlbus.bean.Usp_S_PeGetAllPersonaByEmSuEm;
@Repository
public class EmpresaPersonaDaoImp extends AbstractJpaDAO<EmpresaPersona> implements IEmpresaPersonaDao{
	public EmpresaPersonaDaoImp() {
        super();
        setClazz(EmpresaPersona.class);
    }
	public  void deleteBySuEm(int suEmId){
		StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_D_EmPeEliminaBySuEm");
 	    storedProcedure.setParameter("suEmId",suEmId);
 	    storedProcedure.execute();
	}
	public  List<Usp_S_PeGetAllPersonaByEmSuEm> getAllPersonaByEmSuEm(int emId, int suEmId){
		StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_S_PeGetAllPersonaByEmSuEm");
 	    storedProcedure.setParameter("emId",emId);
 	   storedProcedure.setParameter("suEmId",suEmId);
 	   return storedProcedure.getResultList();
	}
}
