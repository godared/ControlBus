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
import com.godared.controlbus.bean.Georeferencia;
import com.godared.controlbus.bean.RegistroDiario;
import com.godared.controlbus.bean.TarjetaControlDetalle;
import com.godared.controlbus.service.IRegistroDiarioService;
import com.godared.controlbus.service.ITarjetaControlService;

@RestController
@RequestMapping("/rest")
public class GeoreferenciaRestController {
	@Autowired
	ITarjetaControlService tarjetaControlService;
	
	@RequestMapping(value="/georeferencia/{id}", method=RequestMethod.GET)
	public Georeferencia Get(@PathVariable("id") int geId) {
		Georeferencia georeferencia=tarjetaControlService.findOneGeoreferencia(geId);
		if(georeferencia==null)
		{
			throw new RestException(1,"georeferencia no enccontrado","georeferencia con id:"+ geId + " No encontrado en el sistema");
		}
		return georeferencia;
	}
	@RequestMapping(value = "/georeferencia/getallgeoreferenciabytaco",params = {"taCoId"}, method=RequestMethod.GET)
	public List<Georeferencia> GetAllGeoreferenciaByTaCo(@RequestParam("taCoId") int taCoId) {
		return tarjetaControlService.GetAllGeoreferenciaByTaCo(taCoId);
	}
	@RequestMapping(value="/georeferencia/new", method=RequestMethod.GET)
	public Georeferencia New(){
		return new Georeferencia();
	}
	@RequestMapping(value = "/georeferencia/save", method=RequestMethod.POST,produces = "application/json",consumes="application/json")
	@ResponseBody
	public ResponseEntity<Boolean> save(@RequestBody List<Georeferencia> georeferencia) {		
		tarjetaControlService.SaveGeoreferenciaOfMovil(georeferencia);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
	@RequestMapping(value = "/georeferencia/saveone", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Georeferencia> saveOne(@Valid @RequestBody Georeferencia georeferencia) {
		tarjetaControlService.SaveGeoreferencia(georeferencia);
		return new ResponseEntity<Georeferencia>(georeferencia, HttpStatus.OK);
	}
	@RequestMapping(value="/georeferencia/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
		tarjetaControlService.deleteGeoreferenciaById(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
}
