package com.godared.controlbus.dao;

import java.util.List;

import com.godared.controlbus.bean.SubEmpresa;
import com.godared.controlbus.bean.TarjetaControlDetalle;

public interface ISubEmpresaDao {
	SubEmpresa findOne(int id);
    List<SubEmpresa> findAll();
    void create(SubEmpresa entity);
    SubEmpresa update(SubEmpresa entity);
    void delete(SubEmpresa entity);
    void deleteById(int entityId);
    ///
    void deleteByEm(int emId);
    List<SubEmpresa> getAllSuEmpresaByEm(int emId);
}
