package com.godared.controlbus.controller;

import java.util.List;

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
import com.godared.controlbus.bean.PuntoControl;
import com.godared.controlbus.bean.Ruta;
import com.godared.controlbus.bean.Usp_S_PuCoGetAllPuntoControlByEmRu;
import com.godared.controlbus.service.IRutaService;

@RestController
@RequestMapping("/rest")
public class PuntoControlRestController {
	@Autowired
	IRutaService rutaService;
	@RequestMapping(value = "/puntocontrol", method=RequestMethod.GET)
	
	public List<PuntoControl> List() {
		return rutaService.findAllPuntoControl();
	}
	@RequestMapping(value="/puntocontrol/{id}", method=RequestMethod.GET)
	public PuntoControl Get(@PathVariable("id") int puCoId) {
		PuntoControl puntoControl=rutaService.findOnePuntoControl(puCoId);
		if(puntoControl==null)
		{
			throw new RestException(1,"PuntoControl no enccontrado","PuntoControl con id:"+ puCoId + " No encontrado en el sistema");
		}
		return rutaService.findOnePuntoControl(puCoId);
	}
	@RequestMapping(value="/puntocontrol/new", method=RequestMethod.GET)
	public PuntoControl NewPuntoControl(){
		return new PuntoControl();
	}
	@RequestMapping(value = "/puntocontrol/save", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Boolean> save(@RequestBody PuntoControl puntoControl) {
		
		rutaService.CreatePuntoControl(puntoControl);;
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
	@RequestMapping(value = "/puntocontrol/savePuCoDe", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Boolean> save(@RequestBody RequestWrapper requestWrapper) {
		
		rutaService.Save(requestWrapper.getPuntoControl(), requestWrapper.getPuntoControlDetalle());;
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
	
	@RequestMapping(value="/puntocontrol/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> Delete(@PathVariable("id") int id) {
		rutaService.Delete(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
	//http://localhost:8080/ControlBus/rest/puntocontrol/getallpuntocontrolbyemru?emId=1&ruId=1
	@RequestMapping(value = "/puntocontrol/getallpuntocontrolbyemru",params = {"emId","ruId"}, method=RequestMethod.GET)
	public List<Usp_S_PuCoGetAllPuntoControlByEmRu> GetAllPuntoControlByEmRu(@RequestParam("emId") int emId,@RequestParam("ruId") int ruId) {
		return rutaService.GetAllPuntoControlByEmRu(emId,ruId);
	}
}
