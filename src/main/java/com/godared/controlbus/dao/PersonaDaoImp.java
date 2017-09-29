package com.godared.controlbus.dao;


import org.springframework.stereotype.Repository;

import com.godared.controlbus.bean.Persona;
@Repository
public class PersonaDaoImp extends AbstractJpaDAO<Persona> implements IPersonaDao {
	public PersonaDaoImp() {
        super();
        setClazz(Persona.class);
    }
}
