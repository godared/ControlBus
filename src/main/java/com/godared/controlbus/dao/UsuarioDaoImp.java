package com.godared.controlbus.dao;

import java.util.List;

import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import com.godared.controlbus.bean.Usp_S_UsGetAllUsuarioByEm;
import com.godared.controlbus.bean.Usuario;
@Repository
public class UsuarioDaoImp extends AbstractJpaDAO<Usuario> implements IUsuarioDao {
	 public UsuarioDaoImp() {
	        super();
	        setClazz(Usuario.class);
	    }
	 public List<Usp_S_UsGetAllUsuarioByEm> GetAllUsuarioByEm(int emId,String usUserName,String usPassword){
		 StoredProcedureQuery storedProcedure  = entityManager.createNamedStoredProcedureQuery("Usp_S_UsGetAllUsuarioByEm");
	 	    storedProcedure.setParameter("emId",emId);	 
	 	   storedProcedure.setParameter("usUserName",usUserName);	 
	 	  storedProcedure.setParameter("usPassword",usPassword);	 
	 	    return storedProcedure.getResultList();
	 }

}
