package com.godared.controlbus.dao;

import java.util.List;

import com.godared.controlbus.bean.Empresa;

public interface IEmpresaDao {
	Empresa findOne(int id);
    List<Empresa> findAll();
    void create(Empresa entity);
    Empresa update(Empresa entity);
    void delete(Empresa entity);
    void deleteById(int entityId);

}
