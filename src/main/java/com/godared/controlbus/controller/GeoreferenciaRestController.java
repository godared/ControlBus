package com.godared.controlbus.controller;

import java.util.Date;
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
import com.godared.controlbus.bean.Usp_S_GeGetAllUbicacionActualByEmTiempo;
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
	@RequestMapping(value = "/georeferencia/getallubicacionactualbyemtiempo",params = {"emId","periodo","tiempo"}, method=RequestMethod.GET)
	public List<Usp_S_GeGetAllUbicacionActualByEmTiempo> GetAllUbicacionActualByEmTiempo(@RequestParam("emId") int emId,@RequestParam("periodo") int periodo,@RequestParam("tiempo") Date tiempo) {
		return tarjetaControlService.GetAllUbicacionActualByEmTiempo(emId, periodo, tiempo);
	}
	@RequestMapping(value = "/georeferencia/getallrecorridovueltabyemburedi",params = {"emId","periodo","buId","reDiDeId"}, method=RequestMethod.GET)
	public List<Usp_S_GeGetAllUbicacionActualByEmTiempo> GetAllRecorridoVueltaByEmBuReDi(@RequestParam("emId") int emId,@RequestParam("periodo") int periodo,@RequestParam("buId") int buId,@RequestParam("reDiDeId") int reDiDeId) {
		return tarjetaControlService.GetAllRecorridoVueltaByEmBuReDi(emId, periodo, buId, reDiDeId);
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
	//esto lo guarda del movil, y obtiene el su id para poder controlar el envio
	@RequestMapping(value = "/georeferencia/saveone", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Boolean> saveOne(@Valid @RequestBody Georeferencia georeferencia) {
		Georeferencia _georeferencia=null;
		_georeferencia =tarjetaControlService.createReturnGeoreferencia(georeferencia);
		return new ResponseEntity<Boolean>(_georeferencia.getGeEnviadoMovil(), HttpStatus.OK);
	}
	@RequestMapping(value="/georeferencia/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
		tarjetaControlService.deleteGeoreferenciaById(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
}
