package com.godared.controlbus.dao;

import java.util.List;

import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import com.godared.controlbus.bean.Telefono;
import com.godared.controlbus.bean.Usp_S_TeGetAllTelefonoByBuImei;

@Repository
public class TelefonoDaoImp  extends AbstractJpaDAO<Telefono> implements ITelefonoDao {
	 public TelefonoDaoImp() {
	        super();
	        setClazz(Telefono.class);
	    }
	 public List<Usp_S_TeGetAllTelefonoByBuImei> GetAllTelefonoByBuImei(int buId,String teImei){
		 StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_S_TeGetAllTelefonoByBuImei");
	 	    storedProcedure.setParameter("buId",buId);
	 	   storedProcedure.setParameter("teImei",teImei);
	 	    return storedProcedure.getResultList();
	 }
}
