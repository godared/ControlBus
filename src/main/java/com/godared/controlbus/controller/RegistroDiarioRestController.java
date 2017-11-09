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
import com.godared.controlbus.bean.RegistroDiario;
import com.godared.controlbus.service.IRegistroDiarioService;

@RestController
@RequestMapping("/rest")
public class RegistroDiarioRestController {
	@Autowired
	IRegistroDiarioService registroDiarioService;
	
	@RequestMapping(value="/registrodiario/{id}", method=RequestMethod.GET)
	public RegistroDiario Get(@PathVariable("id") int reDiId) {
		RegistroDiario registroDiario=registroDiarioService.findOne(reDiId);
		if(registroDiario==null)
		{
			throw new RestException(1,"registroDiario no enccontrado","registroDiario con id:"+ reDiId + " No encontrado en el sistema");
		}
		return registroDiario;
	}
	@RequestMapping(value = "/registrodiario/getallregistrodiariobyem",params = {"emId"}, method=RequestMethod.GET)
	public List<RegistroDiario> GetAllRegistroDiarioByEm(@RequestParam("emId") int emId) {
		return registroDiarioService.GetAllRegistroDiarioByEm(emId);
	}
	@RequestMapping(value="/registrodiario/new", method=RequestMethod.GET)
	public RegistroDiario New(){
		return new RegistroDiario();
	}
	@RequestMapping(value = "/registrodiario/save", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<RegistroDiario> save(@Valid @RequestBody RegistroDiario registroDiario) {
		registroDiarioService.Save(registroDiario);
		return new ResponseEntity<RegistroDiario>(registroDiario, HttpStatus.OK);
	}
	@RequestMapping(value="/registrodiario/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
		registroDiarioService.Delete(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
}
