package com.godared.controlbus.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.godared.controlbus.RestException;
import com.godared.controlbus.bean.Usp_S_UsGetAllUsuarioByEm;
import com.godared.controlbus.bean.Usuario;
import com.godared.controlbus.service.IPersonaService;

@RestController
@RequestMapping("/rest")
public class UsuarioRestController {
	@Autowired
	IPersonaService personaService;
	@RequestMapping(value="/usuario/{id}", method=RequestMethod.GET)
	public Usuario Get(@PathVariable("id") int usId) {
		Usuario usuario=personaService.findOneUsuario(usId);
		if(usuario==null)
		{
			throw new RestException(1,"Usuario no enccontrado","Usuario con id:"+ usId + " No encontrado en el sistema");
		}
		return usuario;
	}
	@RequestMapping(value="/usuario/new", method=RequestMethod.GET)
	public Usuario NewUsuario(){
		return new Usuario();
	}
	@RequestMapping(value = "/usuario/save", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Usuario> save(@Valid @RequestBody Usuario usuario) {
		personaService.SaveUsuario(usuario);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@RequestMapping(value="/usuario/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
		personaService.Delete(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
	@RequestMapping(value = "/usuario/getallusuariobyem",params = {"emId"}, method=RequestMethod.GET)
	public List<Usp_S_UsGetAllUsuarioByEm> GetAllUsuarioByEm(@RequestParam("emId") int emId) {
		return personaService.GetAllUsuarioByEm(emId,"","");
	}
	@RequestMapping(value = "/usuario/authenticate", method=RequestMethod.POST)
	@ResponseBody
	public List<Usp_S_UsGetAllUsuarioByEm> authenticate(@Valid @RequestBody Usuario usuario) {
		return personaService.GetAllUsuarioByEm(0,usuario.getUsUserName(),usuario.getUsPassword());
	}
}
