package com.godared.controlbus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.godared.controlbus.RestException;
import com.godared.controlbus.bean.PuntoControlDetalle;
import com.godared.controlbus.bean.RutaDetalle;
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
	@RequestMapping(value="/puntocontroldetalle/pucoid/{puCoId}", method=RequestMethod.GET)
	public List<PuntoControlDetalle> getAllPuntoControlDetalleByPuCo(@PathVariable("puCoId") int puCoId) {
		List<PuntoControlDetalle> puntoControlDetalle=rutaService.getAllPuntoControlDetalleByPuCo(puCoId);
		if(puntoControlDetalle==null)
		{
			throw new RestException(1,"PuntoControlDetalle no enccontrado"," PuntoControlDetalle con id:"+ puCoId + " No encontrado en el sistema");
		}
		return puntoControlDetalle;
	}
	@RequestMapping(value="/puntocontroldetalle/new", method=RequestMethod.GET)
	public PuntoControlDetalle NewPuntoControlDetalle(){
		return new PuntoControlDetalle();
	}
	@RequestMapping(value = "/puntocontroldetalle/save", method=RequestMethod.POST,produces = "application/json",consumes="application/json")
	//@Consumes({ MediaType.APPLICATION_JSON })
    //@Produces({ MediaType.APPLICATION_JSON })
	@ResponseBody
	public ResponseEntity<Boolean> save(@RequestBody List<PuntoControlDetalle> puntoControlDetalle) {		
		rutaService.CreatePuntoControlDetalle(puntoControlDetalle);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
	
	@RequestMapping(value="/puntocontroldetalle/delete/pucoid/{pucoId}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> Delete(@PathVariable("pucoId") int puCoId) {
		rutaService.DeletePuntoControlDetalleByPuCoId(puCoId);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
}
