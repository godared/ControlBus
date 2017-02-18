package com.godared.controlbus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.godared.controlbus.RestException;
import com.godared.controlbus.bean.PuntoControlDetalle;
import com.godared.controlbus.bean.TarjetaControlDetalle;
import com.godared.controlbus.service.IRutaService;
import com.godared.controlbus.service.ITarjetaControlService;

@RestController
@RequestMapping("/rest")
public class TarjetaControlDetalleRestController {
	@Autowired
	ITarjetaControlService tarjetaControlService;
	
	@RequestMapping(value="/tarjetacontroldetalle/{taCoDeId}", method=RequestMethod.GET)
	public TarjetaControlDetalle Get(@PathVariable("taCoDeId") int taCoDeId) {
		TarjetaControlDetalle tarjetaControlDetalle=tarjetaControlService.findOneTarjetaControlDetalleId(taCoDeId);
		if(tarjetaControlDetalle==null)
		{
			throw new RestException(1,"TarjetaControlDetalle no enccontrado"," TarjetaControlDetalle con id:"+ taCoDeId + " No encontrado en el sistema");
		}
		return tarjetaControlDetalle;
	}
	@RequestMapping(value="/tarjetacontroldetalle/new", method=RequestMethod.GET)
	public TarjetaControlDetalle NewTarjetaControlDetalle(){
		return new TarjetaControlDetalle();
	}
}
