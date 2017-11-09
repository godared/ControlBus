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
import com.godared.controlbus.bean.RegistroDiarioDetalle;
import com.godared.controlbus.service.IRegistroDiarioService;

@RestController
@RequestMapping("/rest")
public class RegistroDiarioDetalleRestController {
	@Autowired
	IRegistroDiarioService registroDiarioService;
		
	@RequestMapping(value="/registrodiariodetalle/{id}", method=RequestMethod.GET)
	public RegistroDiarioDetalle Get(@PathVariable("id") int reDiDeId) {
		RegistroDiarioDetalle registroDiarioDetalle=registroDiarioService.findOneRegistroDiarioDetalle(reDiDeId);
		if(registroDiarioDetalle==null)
		{
			throw new RestException(1,"registrodiariodetalle no enccontrado","registrodiariodetalle con id:"+ reDiDeId + " No encontrado en el sistema");
		}
		return registroDiarioDetalle;
	}
	@RequestMapping(value = "/registrodiariodetalle/getallregistrodiariodetallebyredi",params = {"reDiId"}, method=RequestMethod.GET)
	public List<RegistroDiarioDetalle> GetAllRegistroDiarioDetalleByReDi(@RequestParam("reDiId") int reDiId) {
		return registroDiarioService.GetAllRegistroDiarioDetalleByReDi(reDiId);
	}
	@RequestMapping(value="/registrodiariodetalle/new", method=RequestMethod.GET)
	public RegistroDiarioDetalle New(){
		return new RegistroDiarioDetalle();
	}
	@RequestMapping(value = "/registrodiariodetalle/save", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<RegistroDiarioDetalle> save(@Valid @RequestBody RegistroDiarioDetalle registroDiarioDetalle) {
		registroDiarioService.SaveRegistroDiarioDetalle(registroDiarioDetalle);
		return new ResponseEntity<RegistroDiarioDetalle>(registroDiarioDetalle, HttpStatus.OK);
	}
	@RequestMapping(value="/registrodiariodetalle/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
		registroDiarioService.DeleteRegistroDiarioDetalle(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
}
