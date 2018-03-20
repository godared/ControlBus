package com.godared.controlbus.dao;

import java.util.Date;
import java.util.List;

import com.godared.controlbus.bean.Georeferencia;
import com.godared.controlbus.bean.Usp_S_GeGetAllUbicacionActualByEmTiempo;

public interface IGeoreferenciaDao {
	Georeferencia findOne(int id);
    List<Georeferencia> findAll();
    List<Georeferencia> GetAllGeoreferenciaByTaCo(int TaCoId);    
    void create(Georeferencia entity);
    Georeferencia createReturn(Georeferencia entity);
    Georeferencia update(Georeferencia entity);
    void delete(Georeferencia entity);
    void deleteById(int entityId);
    void Usp_D_GeEliminaByTaCo(int taCoId);
    List<Usp_S_GeGetAllUbicacionActualByEmTiempo> GeGetAllUbicacionActualByEmTiempo(int emId,int periodo,Date tiempo);
    List<Usp_S_GeGetAllUbicacionActualByEmTiempo> GeGetAllRecorridoVueltaByEmBuReDi(int emId,int periodo,int buId, int reDiDeId);
}
