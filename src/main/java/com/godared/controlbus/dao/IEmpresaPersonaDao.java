package com.godared.controlbus.dao;

import java.util.List;

import com.godared.controlbus.bean.EmpresaPersona;
import com.godared.controlbus.bean.Usp_S_PeGetAllPersonaByEmSuEm;

public interface IEmpresaPersonaDao {
	EmpresaPersona findOne(int id);
    List<EmpresaPersona> findAll();
    void create(EmpresaPersona entity);
    EmpresaPersona update(EmpresaPersona entity);
    void delete(EmpresaPersona entity);
    void deleteById(int entityId);
    ///
    void deleteBySuEm(int suEmId);
    List<Usp_S_PeGetAllPersonaByEmSuEm> getAllPersonaByEmSuEm(int emId, int suEmId);
}
