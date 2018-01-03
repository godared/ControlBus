package com.godared.controlbus.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import com.godared.controlbus.bean.TarjetaControl;
import com.godared.controlbus.bean.Usp_S_GetAllRegistroVueltasDiariasByEmPrFe;
import com.godared.controlbus.bean.Usp_S_RuGetAllRutaByEm;
import com.godared.controlbus.bean.Usp_S_TaCoGetAllTarjetaControlByBuIdFecha;
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
	 public List<Usp_S_TaCoGetAllTarjetaControlByBuIdFecha> Usp_S_TaCoGetAllTarjetaControlByBuIdFecha(int buId,Date taCoFecha){
		 StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_S_TaCoGetAllTarjetaControlByBuIdFecha");
	 	   storedProcedure.setParameter("buId",buId);
	 	   storedProcedure.setParameter("taCoFecha",taCoFecha);
	 	   return storedProcedure.getResultList();
	 }
	 @SuppressWarnings("unchecked")
	 public List<Usp_S_GetAllRegistroVueltasDiariasByEmPrFe> GetAllRegistroVueltasDiariasByEmPrFe(int emId,int prId,Date fechaDiario){
		 StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_S_GetAllRegistroVueltasDiariasByEmPrFe");
	 	   storedProcedure.setParameter("emId",emId);
	 	  storedProcedure.setParameter("prId",prId);
	 	  storedProcedure.setParameter("fechaDiario",fechaDiario);
	 	  List<Usp_S_GetAllRegistroVueltasDiariasByEmPrFe> usp_S_GetAllRegistroVueltasDiariasByEmPrFe=storedProcedure.getResultList();
	 	  //ArrayList valor=storedProcedure.getResultList();
	 	   return usp_S_GetAllRegistroVueltasDiariasByEmPrFe;//storedProcedure.getResultList();
	 }
	 @SuppressWarnings("unchecked")
	 public List<Usp_S_TaCoGetAllTarjetaControlByBuIdFecha> GetAllTarjetaControlByEmReDiDe(int emId,int reDiDe){
		 StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_S_TaCoGetAllTarjetaControlByEmReDiDe");
	 	   storedProcedure.setParameter("emId",emId);
	 	   storedProcedure.setParameter("reDiDe",reDiDe);
	 	   return storedProcedure.getResultList();
	 }
}
