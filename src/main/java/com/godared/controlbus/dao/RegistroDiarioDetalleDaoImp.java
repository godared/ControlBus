package com.godared.controlbus.dao;

import java.util.List;

import javax.persistence.StoredProcedureQuery;

import com.godared.controlbus.bean.RegistroDiarioDetalle;

public class RegistroDiarioDetalleDaoImp extends AbstractJpaDAO<RegistroDiarioDetalle> implements IRegistroDiarioDetalleDao{
	 public RegistroDiarioDetalleDaoImp() {
	        super();
	        setClazz(RegistroDiarioDetalle.class);
	    }
	 @SuppressWarnings("unchecked")
	 public List<RegistroDiarioDetalle> GetAllRegistroDiarioDetalleByReDi(int reDiId){
		 StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_S_ReDiDeGetAllRegistroDiarioDetalleByReDi");
	 	    storedProcedure.setParameter("reDiId",reDiId);
	 	    return storedProcedure.getResultList();
	 }
	 
}
