package com.godared.controlbus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.godared.controlbus.RestException;
import com.godared.controlbus.bean.Ruta;
import com.godared.controlbus.service.IRutaService;

@RestController
@RequestMapping("/rest")
public class RutaDetalleRestController {
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
}
