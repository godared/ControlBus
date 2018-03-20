package com.godared.controlbus.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import com.godared.controlbus.bean.Georeferencia;
import com.godared.controlbus.bean.RegistroDiario;
import com.godared.controlbus.bean.Usp_S_GeGetAllUbicacionActualByEmTiempo;

@Repository
public class GeoreferenciaDaoImp extends AbstractJpaDAO<Georeferencia> implements IGeoreferenciaDao {
	 public GeoreferenciaDaoImp() {
	        super();
	        setClazz(Georeferencia.class);
	    }
	 @SuppressWarnings("unchecked")
	 public List<Georeferencia> GetAllGeoreferenciaByTaCo(int taCoId){
		 StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_S_GeGetAllGeoreferenciaByTaCo");
	 	    storedProcedure.setParameter("taCoId",taCoId);
	 	    return storedProcedure.getResultList();
	 }
	 public void Usp_D_GeEliminaByTaCo(int taCoId){
		 StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_D_GeEliminaByTaCo");
	 	    storedProcedure.setParameter("taCoId",taCoId);
	 	    storedProcedure.execute();
	 }
	 @SuppressWarnings("unchecked")
	public List<Usp_S_GeGetAllUbicacionActualByEmTiempo> GeGetAllUbicacionActualByEmTiempo(int emId,int periodo,Date tiempo){
		 StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_S_GeGetAllUbicacionActualByEmTiempo");
	 	    storedProcedure.setParameter("emId",emId);
	 	    storedProcedure.setParameter("periodo",periodo);
	 	    storedProcedure.setParameter("tiempo",tiempo);
	 	   return storedProcedure.getResultList();
	 }
	 @SuppressWarnings("unchecked")
	public List<Usp_S_GeGetAllUbicacionActualByEmTiempo> GeGetAllRecorridoVueltaByEmBuReDi(int emId,int periodo,int buId, int reDiDeId){
		 StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_S_GeGetAllRecorridoVueltaByEmBuReDi");
	 	    storedProcedure.setParameter("emId",emId);
	 	    storedProcedure.setParameter("periodo",periodo);
	 	    storedProcedure.setParameter("buId",buId);
	 	    storedProcedure.setParameter("reDiDeId",reDiDeId);
	 	    return storedProcedure.getResultList();
	 }
	 
}
