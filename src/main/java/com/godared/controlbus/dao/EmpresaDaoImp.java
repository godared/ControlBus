package com.godared.controlbus.dao;

import org.springframework.stereotype.Repository;

import com.godared.controlbus.bean.Empresa;

@Repository
public class EmpresaDaoImp extends AbstractJpaDAO<Empresa> implements IEmpresaDao {
	public EmpresaDaoImp() {
        super();
        setClazz(Empresa.class);
    }
}
