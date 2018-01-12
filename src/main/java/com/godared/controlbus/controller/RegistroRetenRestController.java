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
import com.godared.controlbus.bean.RegistroDiarioDetalle;
import com.godared.controlbus.bean.RegistroReten;
import com.godared.controlbus.service.IRegistroDiarioService;

@RestController
@RequestMapping("/rest")
public class RegistroRetenRestController {
	@Autowired
	IRegistroDiarioService registroDiarioService;
	
	/*@RequestMapping(value="/registroreten/{id}", method=RequestMethod.GET)
	public RegistroReten Get(@PathVariable("id") int reReId) {
		RegistroReten registroReten=registroDiarioService.findOneRegistroReten(reReId);
		if(registroReten==null)
		{
			throw new RestException(1,"registroReten no enccontrado","registroReten con id:"+ reReId + " No encontrado en el sistema");
		}
		return registroReten;
	}
	@RequestMapping(value = "/registroreten/getallregistroretenbyredide",params = {"reDiDeId"}, method=RequestMethod.GET)
	public List<RegistroReten> GetAllRegistroRetenByReDiDe(@RequestParam("reDiDeId") int reDiDeId) {
		return registroDiarioService.GetAllRegistroRetenByReDiDe(reDiDeId);
	}
	@RequestMapping(value="/registroreten/new", method=RequestMethod.GET)
	public RegistroReten New(){
		return new RegistroReten();
	}
	@RequestMapping(value = "/registroreten/save", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<RegistroReten> save(@Valid @RequestBody RegistroReten registroReten) {
		registroDiarioService.SaveRegistroReten(registroReten);
		return new ResponseEntity<RegistroReten>(registroReten, HttpStatus.OK);
	}
	@RequestMapping(value="/registroreten/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
		registroDiarioService.DeleteRegistroReten(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}*/
}
