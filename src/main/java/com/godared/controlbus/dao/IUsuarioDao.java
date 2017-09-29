package com.godared.controlbus.dao;

import java.util.List;

import com.godared.controlbus.bean.Usp_S_UsGetAllUsuarioByEm;
import com.godared.controlbus.bean.Usuario;

public interface IUsuarioDao {
	Usuario findOne(int id);
    List<Usuario> findAll();
    void create(Usuario entity);
    Usuario update(Usuario entity);
    void delete(Usuario entity);
    void deleteById(int entityId);
    List<Usp_S_UsGetAllUsuarioByEm> GetAllUsuarioByEm(int emId,String usUserName,String usPassword);
}
