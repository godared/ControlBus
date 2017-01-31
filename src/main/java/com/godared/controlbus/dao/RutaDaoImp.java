package com.godared.controlbus.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.godared.controlbus.bean.Ruta;

@Repository
public class RutaDaoImp extends AbstractJpaDAO<Ruta> implements IRutaDao {
	 public RutaDaoImp() {
	        super();

	        setClazz(Ruta.class);
	    }
}
