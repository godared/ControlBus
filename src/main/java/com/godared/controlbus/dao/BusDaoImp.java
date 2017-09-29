package com.godared.controlbus.dao;

import java.util.List;

import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import com.godared.controlbus.bean.Bus;
import com.godared.controlbus.bean.Usp_S_BuGetAllBusesByEmSuEm;
@Repository
public class BusDaoImp extends AbstractJpaDAO<Bus> implements IBusDao {
	 public BusDaoImp() {
	        super();

	        setClazz(Bus.class);
	    }
	 public List<Usp_S_BuGetAllBusesByEmSuEm> GetAllBusesByEmSuEm(int emId,int suEmId){
		 StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_S_BuGetAllBusesByEmSuEm");
	 	    storedProcedure.setParameter("emId",emId);
	 	   storedProcedure.setParameter("suEmId",suEmId);
	 	    return storedProcedure.getResultList();
	 }
}
