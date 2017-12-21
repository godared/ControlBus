package com.godared.controlbus.controller;

import java.util.List;

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
import com.godared.controlbus.bean.TarjetaControlDetalle;
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
	@RequestMapping(value="/tarjetacontroldetalle/tacoid/{taCoId}", method=RequestMethod.GET)
	public List<TarjetaControlDetalle> getAllTarjetaControlDetalleByTaCo(@PathVariable("taCoId") int taCoId) {
		List<TarjetaControlDetalle> tarjetaControlDetalle=tarjetaControlService.getAllTarjetaControlDetalleByTaCo(taCoId);
		if(tarjetaControlDetalle==null)
		{
			throw new RestException(1,"Tarjeta Control no enccontrado"," TarjetaControl con id:"+ taCoId + " No encontrado en el sistema");
		}
		return tarjetaControlDetalle;
	}
	@RequestMapping(value="/tarjetacontroldetalle/new", method=RequestMethod.GET)
	public TarjetaControlDetalle NewTarjetaControlDetalle(){
		return new TarjetaControlDetalle();
	}
	@RequestMapping(value = "/tarjetacontroldetalle/save", method=RequestMethod.POST,produces = "application/json",consumes="application/json")
	@ResponseBody
	public ResponseEntity<Boolean> save(@RequestBody List<TarjetaControlDetalle> tarjetaControlDetalle) {		
		tarjetaControlService.CreateTarjetaControlDetalle(tarjetaControlDetalle);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
	//para guardar desde el movil
	@RequestMapping(value = "/tarjetacontroldetalle/saveone", method=RequestMethod.POST,produces = "application/json",consumes="application/json")
	@ResponseBody
	public ResponseEntity<Integer> saveOne(@RequestBody TarjetaControlDetalle tarjetaControlDetalle) {
		int codEnvio=0;
		if(tarjetaControlDetalle.getTaCoDeId()>0){
			codEnvio=tarjetaControlService.UpdateTarjetaControlDetalleOfMovil(tarjetaControlDetalle.getTaCoDeId(), tarjetaControlDetalle);
		}
		
		return new ResponseEntity<Integer>(codEnvio, HttpStatus.OK);
	}
	
	@RequestMapping(value="/tarjetacontroldetalle/delete/tacoid/{taCoDeId}", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Boolean> Delete(@PathVariable("taCoId")int taCoId){
		tarjetaControlService.DeleteTarjetaControlDetalleBytaCoId(taCoId);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
}
