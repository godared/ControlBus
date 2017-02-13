package com.godared.controlbus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.godared.controlbus.RestException;
import com.godared.controlbus.bean.PuntoControlDetalle;

import com.godared.controlbus.service.IRutaService;


@RestController
@RequestMapping("/rest")
public class PuntoControlDetalleRestController {
	@Autowired
	IRutaService rutaService;
	
	@RequestMapping(value="/puntocontroldetalle/{puCoDeId}", method=RequestMethod.GET)
	public PuntoControlDetalle Get(@PathVariable("puCoDeId") int puCoDeId) {
		PuntoControlDetalle puntoControlDetalle=rutaService.findOnePuntoControlDetalleId(puCoDeId);
		if(puntoControlDetalle==null)
		{
			throw new RestException(1,"PuntoControlDetalle no enccontrado"," PuntoControlDetalle con id:"+ puCoDeId + " No encontrado en el sistema");
		}
		return puntoControlDetalle;
	}
	@RequestMapping(value="/puntocontroldetalle/new", method=RequestMethod.GET)
	public PuntoControlDetalle NewPuntoControlDetalle(){
		return new PuntoControlDetalle();
	}
}
