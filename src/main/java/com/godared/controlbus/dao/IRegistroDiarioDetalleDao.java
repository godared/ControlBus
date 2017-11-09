package com.godared.controlbus.dao;

import java.util.List;

import com.godared.controlbus.bean.RegistroDiarioDetalle;

public interface IRegistroDiarioDetalleDao {
	RegistroDiarioDetalle findOne(int id);
    List<RegistroDiarioDetalle> findAll();
    void create(RegistroDiarioDetalle entity);
    RegistroDiarioDetalle update(RegistroDiarioDetalle entity);
    void delete(RegistroDiarioDetalle entity);
    void deleteById(int entityId);
    List<RegistroDiarioDetalle> GetAllRegistroDiarioDetalleByReDi(int reDiId);
}
