package com.godared.controlbus.dao;

import java.util.List;

import com.godared.controlbus.bean.AlertaIncidencia;


public interface IAlertaIncidenciaDao {
	AlertaIncidencia findOne(int id);
    List<AlertaIncidencia> findAll();
    void create(AlertaIncidencia entity);
    AlertaIncidencia update(AlertaIncidencia entity);
    void delete(AlertaIncidencia entity);
    void deleteById(int entityId);
    //List<Usp_S_TeGetAllTelefonoByBuImei> GetAllTelefonoByBuImei(int buId,String teImei);

}
