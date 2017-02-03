package com.godared.controlbus.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.godared.controlbus.bean.RutaDetalle;

@Repository
public class RutaDetalleDaoImp extends AbstractJpaDAO<RutaDetalle> implements IRutaDetalleDao {
	 public RutaDetalleDaoImp() {
	        super();

	        setClazz(RutaDetalle.class);
	    }
}