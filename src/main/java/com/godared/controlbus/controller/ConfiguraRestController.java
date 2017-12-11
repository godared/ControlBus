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
import com.godared.controlbus.bean.Configura;
import com.godared.controlbus.service.IEmpresaService;

@RestController
@RequestMapping("/rest")
public class ConfiguraRestController {
	@Autowired
	IEmpresaService empresaService;

	@RequestMapping(value="/configura/{id}", method=RequestMethod.GET)
	public Configura Get(@PathVariable("id") int geId) {
		Configura configura=empresaService.findOneConfigura(geId);
		if(configura==null)
		{
			throw new RestException(1,"Configura no enccontrado","configura con id:"+ geId + " No encontrado en el sistema");
		}
		return configura;
	}
	@RequestMapping(value = "/configura/getallconfigurabyemperiodo",params = {"emId","coPeriodo"}, method=RequestMethod.GET)
	public List<Configura> GetAllConfiguraByEmPeriodo(@RequestParam("emId") int emId,@RequestParam("coPeriodo") int coPeriodo){
		return this.empresaService.GetAllConfiguraByEmPeriodo(emId, coPeriodo);
	}
	@RequestMapping(value="/configura/new", method=RequestMethod.GET)
	public Configura NewConfigura(){
		return new Configura();
	}
	@RequestMapping(value = "/configura/save", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Configura> save(@Valid @RequestBody Configura configura) {
		empresaService.SaveConfigura(configura);
		return new ResponseEntity<Configura>(configura, HttpStatus.OK);
	}
	
	@RequestMapping(value="/configura/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
		empresaService.DeleteConfigura(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
}
