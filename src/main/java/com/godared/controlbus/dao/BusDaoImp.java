package com.godared.controlbus.dao;

import org.springframework.stereotype.Repository;

import com.godared.controlbus.bean.Bus;
@Repository
public class BusDaoImp extends AbstractJpaDAO<Bus> implements IBusDao {
	 public BusDaoImp() {
	        super();

	        setClazz(Bus.class);
	    }
}
