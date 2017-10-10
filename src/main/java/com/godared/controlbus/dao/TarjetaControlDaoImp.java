package com.godared.controlbus.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import com.godared.controlbus.bean.TarjetaControl;
import com.godared.controlbus.bean.Usp_S_RuGetAllRutaByEm;
import com.godared.controlbus.bean.Usp_S_TaCoGetAllTarjetaControlByEmPuCo;
@Repository
public class TarjetaControlDaoImp extends AbstractJpaDAO<TarjetaControl> implements ITarjetaControlDao {
	 public TarjetaControlDaoImp() {
	        super();

	        setClazz(TarjetaControl.class);
	    }
	 @SuppressWarnings("unchecked")
	 public List<Usp_S_TaCoGetAllTarjetaControlByEmPuCo> GetAllTarjetaControlByEmPuCo(int emId,int puCoId){
		 StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_S_TaCoGetAllTarjetaControlByEmPuCo");
	 	   storedProcedure.setParameter("emId",emId);
	 	   storedProcedure.setParameter("puCoId",puCoId);
	 	   return storedProcedure.getResultList();
	 }
	 @SuppressWarnings("unchecked")
	 public List<TarjetaControl> Usp_S_TaCoGetAllTarjetaControlByBuIdFecha(int buId,Date taCoFecha){
		 StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_S_TaCoGetAllTarjetaControlByBuIdFecha");
	 	   storedProcedure.setParameter("buId",buId);
	 	   storedProcedure.setParameter("taCoFecha",taCoFecha);
	 	   return storedProcedure.getResultList();
	 }
}