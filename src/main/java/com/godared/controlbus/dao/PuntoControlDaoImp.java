package com.godared.controlbus.dao;

import java.util.List;

import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import com.godared.controlbus.bean.PuntoControl;
import com.godared.controlbus.bean.Usp_S_PuCoGetAllPuntoControlByEmRu;

@Repository
public class PuntoControlDaoImp extends AbstractJpaDAO<PuntoControl> implements IPuntoControlDao {
	 public PuntoControlDaoImp() {
	        super();

	        setClazz(PuntoControl.class);
	    }
	 public List<Usp_S_PuCoGetAllPuntoControlByEmRu> GetAllPuntoControlByEmRu(int emId,int ruId){
		 StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_S_PuCoGetAllPuntoControlByEmRu");
	 	    storedProcedure.setParameter("emId",emId);
	 	   storedProcedure.setParameter("ruId",ruId);
	 	    return storedProcedure.getResultList();
	 }
}
