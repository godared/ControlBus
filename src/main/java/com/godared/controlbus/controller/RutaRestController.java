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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.godared.controlbus.RestException;
import com.godared.controlbus.bean.Ruta;
import com.godared.controlbus.service.IRutaService;



@RestController
@RequestMapping("/rest")
public class RutaRestController {
	@Autowired
	IRutaService rutaService;
	
	@RequestMapping(value = "/ruta", method=RequestMethod.GET)
	public List<Ruta> List() {
		return rutaService.findAll();
	}
	@RequestMapping(value="/ruta/{id}", method=RequestMethod.GET)
	public Ruta Get(@PathVariable("id") int ruId) {
		Ruta ruta=rutaService.findOne(ruId);
		if(ruta==null)
		{
			throw new RestException(1,"Ruta no enccontrado"," Tramite con id:"+ ruId + " No encontrado en el sistema");
		}
		return rutaService.findOne(ruId);
	}
	@RequestMapping(value="/ruta/new", method=RequestMethod.GET)
	public Ruta NewRuta(){
		return new Ruta();
	}
	
	@RequestMapping(value = "/ruta/save", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Boolean> save(@RequestBody RequestWrapper requestWrapper) {
		
		rutaService.Save(requestWrapper.getRuta(), requestWrapper.getRutaDetalle());;
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
	
	@RequestMapping(value="/ruta/delete/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> Delete(@PathVariable("id") int id) {
		rutaService.Delete(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
	
}
