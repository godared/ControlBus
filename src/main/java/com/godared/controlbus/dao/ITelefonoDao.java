package com.godared.controlbus.dao;

import java.util.List;

import com.godared.controlbus.bean.Telefono;
import com.godared.controlbus.bean.Usp_S_TeGetAllTelefonoByBuImei;

public interface ITelefonoDao {
	Telefono findOne(int id);
    List<Telefono> findAll();
    void create(Telefono entity);
    Telefono update(Telefono entity);
    void delete(Telefono entity);
    void deleteById(int entityId);
    List<Usp_S_TeGetAllTelefonoByBuImei> GetAllTelefonoByBuImei(int buId,String teImei);

}
