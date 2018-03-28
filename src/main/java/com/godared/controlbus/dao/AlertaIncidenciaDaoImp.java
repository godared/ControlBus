package com.godared.controlbus.dao;

import java.util.List;

import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import com.godared.controlbus.bean.AlertaIncidencia;


@Repository
public class AlertaIncidenciaDaoImp  extends AbstractJpaDAO<AlertaIncidencia> implements IAlertaIncidenciaDao {
	 public AlertaIncidenciaDaoImp() {
	        super();
	        setClazz(AlertaIncidencia.class);
	    }
	/* public List<Usp_S_TeGetAllTelefonoByBuImei> GetAllTelefonoByBuImei(int buId,String teImei){
		 StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_S_TeGetAllTelefonoByBuImei");
	 	    storedProcedure.setParameter("buId",buId);
	 	   storedProcedure.setParameter("teImei",teImei);
	 	    return storedProcedure.getResultList();
	 }*/
}
