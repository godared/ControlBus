package com.godared.controlbus.dao;

import java.util.Date;
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
	public List<AlertaIncidencia> Usp_S_AlInGetAllAlertaIncidenciaByEmTaCo(int emId,int taCoId){
		 StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_S_AlInGetAllAlertaIncidenciaByEmTaCo");
	 	    storedProcedure.setParameter("emId",emId);
	 	   storedProcedure.setParameter("taCoId",taCoId);
	 	    return storedProcedure.getResultList();
	 }
	public List<AlertaIncidencia> Usp_S_AlInGetAllAlertaIncidenciaByEmFecha(int emId,Date fecha){
		 StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_S_AlInGetAllAlertaIncidenciaByEmFecha");
	 	    storedProcedure.setParameter("emId",emId);
	 	   storedProcedure.setParameter("fecha",fecha);
	 	    return storedProcedure.getResultList();
	 }
	 
	    
}
