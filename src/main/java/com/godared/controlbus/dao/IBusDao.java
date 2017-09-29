package com.godared.controlbus.dao;

import java.util.List;

import com.godared.controlbus.bean.Bus;
import com.godared.controlbus.bean.Usp_S_BuGetAllBusesByEmSuEm;

public interface IBusDao {
	Bus findOne(int id);
    List<Bus> findAll();
    void create(Bus entity);
    Bus update(Bus entity);
    void delete(Bus entity);
    void deleteById(int entityId);
    List<Usp_S_BuGetAllBusesByEmSuEm> GetAllBusesByEmSuEm(int emId,int suEmId);
}
