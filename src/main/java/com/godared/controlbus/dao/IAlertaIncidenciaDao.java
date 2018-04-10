package com.godared.controlbus.dao;

import java.util.Date;
import java.util.List;

import com.godared.controlbus.bean.AlertaIncidencia;
import com.godared.controlbus.bean.Georeferencia;
import com.godared.controlbus.bean.Usp_S_AlInGetAllAlertaIncidenciaByEmFecha;


public interface IAlertaIncidenciaDao {
	AlertaIncidencia findOne(int id);
    List<AlertaIncidencia> findAll();
    void create(AlertaIncidencia entity);
    AlertaIncidencia createReturn(AlertaIncidencia entity);
    AlertaIncidencia update(AlertaIncidencia entity);
    void delete(AlertaIncidencia entity);
    void deleteById(int entityId);
    List<AlertaIncidencia> Usp_S_AlInGetAllAlertaIncidenciaByEmTaCo(int emId,int taCoId);
    List<Usp_S_AlInGetAllAlertaIncidenciaByEmFecha> Usp_S_AlInGetAllAlertaIncidenciaByEmFecha(int emId,Date fecha);

}
