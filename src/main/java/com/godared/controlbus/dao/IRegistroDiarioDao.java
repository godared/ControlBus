package com.godared.controlbus.dao;

import java.util.List;

import com.godared.controlbus.bean.RegistroDiario;

public interface IRegistroDiarioDao {
	RegistroDiario findOne(int id);
    List<RegistroDiario> findAll();
    List<RegistroDiario> GetAllRegistroDiarioByEm(int emId);    
    void create(RegistroDiario entity);
    RegistroDiario update(RegistroDiario entity);
    void delete(RegistroDiario entity);
    void deleteById(int entityId);
}
