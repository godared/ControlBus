package com.godared.controlbus.dao;

import java.util.List;

import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import com.godared.controlbus.bean.BusPersona;
import com.godared.controlbus.bean.Usp_S_PeGetAllPersonaByEmSuEm;
@Repository
public class BusPersonaDaoImp extends AbstractJpaDAO<BusPersona> implements IBusPersonaDao {
	public BusPersonaDaoImp() {
        super();
        setClazz(BusPersona.class);
    }
	public void deleteByBu(int buId){
		StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_D_EmPeEliminaByBu");
 	    storedProcedure.setParameter("buId",buId);
 	    storedProcedure.execute();
	}
	public List<Usp_S_PeGetAllPersonaByEmSuEm> getAllPersonaByEmBu (int emId, int buId){
		StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_S_PeGetAllPersonaByEmBu");
 	    storedProcedure.setParameter("emId",emId);
 	   storedProcedure.setParameter("buId",buId);
 	   return storedProcedure.getResultList();
	}

}
