package com.godared.controlbus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.godared.controlbus.RestException;
import com.godared.controlbus.bean.Ruta;
import com.godared.controlbus.bean.RutaDetalle;
import com.godared.controlbus.service.IRutaService;

@RestController
@RequestMapping("/rest")
public class RutaDetalleRestController {
	@Autowired
	IRutaService rutaService;
	
	@RequestMapping(value="/ruta/{id}", method=RequestMethod.GET)
	public RutaDetalle Get(@PathVariable("id") int ruId) {
		RutaDetalle rutaDetalle=rutaService.findOneRutaDetalleId(ruId);
		if(rutaDetalle==null)
		{
			throw new RestException(1,"Ruta no enccontrado"," Ruta con id:"+ ruId + " No encontrado en el sistema");
		}
		return rutaDetalle;
	}
	@RequestMapping(value="/ruta/new", method=RequestMethod.GET)
	public RutaDetalle NewRutaDetalle(){
		return new RutaDetalle();
	}
}