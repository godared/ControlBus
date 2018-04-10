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
import com.godared.controlbus.bean.Empresa;
import com.godared.controlbus.bean.TarjetaControlDetalle;
import com.godared.controlbus.bean.Usp_S_AlInGetAllAlertaIncidenciaByEmFecha;
import com.godared.controlbus.bean.AlertaIncidencia;
import com.godared.controlbus.bean.Usp_S_TeGetAllTelefonoByBuImei;
import com.godared.controlbus.service.IBusService;
import com.godared.controlbus.service.ITarjetaControlService;

@RestController
@RequestMapping("/rest")
public class AlertaIncidenciaRestController {
	@Autowired
	ITarjetaControlService tarjetaControlService;
	@RequestMapping(value="/alertaincidencia/{id}", method=RequestMethod.GET)
	public AlertaIncidencia Get(@PathVariable("id") int alInId) {
		AlertaIncidencia alertaIncidencia=tarjetaControlService.findOneAlertaIncidencia(alInId);
		if(alertaIncidencia==null)
		{
			throw new RestException(1,"alertaIncidencia no enccontrado","alertaIncidencia con id:"+ alInId + " No encontrado en el sistema");
		}
		return alertaIncidencia;
	}
	@RequestMapping(value = "/alertaincidencia/getallalertaincidenciabyemtaco",params = {"emId","taCoId"}, method=RequestMethod.GET)
	public List<AlertaIncidencia> GetAllAlertaIncidenciaByEmTaCo(@RequestParam("emId") int emId,@RequestParam("taCoId") int taCoId) {
		return tarjetaControlService.GetAllAlertaIncidenciaByEmTaCo(emId,taCoId);
	}
	@RequestMapping(value = "/alertaincidencia/getallalertaincidenciabyemfecha",params = {"emId","fecha"}, method=RequestMethod.GET)
	public List<Usp_S_AlInGetAllAlertaIncidenciaByEmFecha> GetAllAlertaIncidenciaByEmFecha(@RequestParam("emId") int emId,@RequestParam("fecha") Date fecha) {
		return tarjetaControlService.GetAllAlertaIncidenciaByEmFecha(emId,fecha);
	}
	@RequestMapping(value="/alertaincidencia/new", method=RequestMethod.GET)
	public AlertaIncidencia NewAlertaIncidencia(){
		return new AlertaIncidencia();
	}
	@RequestMapping(value = "/alertaincidencia/save", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Integer> save(@Valid @RequestBody AlertaIncidencia alertaIncidencia) {
		AlertaIncidencia _alertaIncidencia;
		_alertaIncidencia=tarjetaControlService.CreateAlertaIncidencia(alertaIncidencia);
		return new ResponseEntity<Integer>(_alertaIncidencia.getAlInId(), HttpStatus.OK);
	}
	@RequestMapping(value = "/alertaincidencia/saves", method=RequestMethod.POST,produces = "application/json",consumes="application/json")
	@ResponseBody
	public ResponseEntity<Boolean> save(@RequestBody List<AlertaIncidencia> alertaIncidencia) {		
		tarjetaControlService.CreateAlertaIncidencias(alertaIncidencia);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
	@RequestMapping(value="/alertaincidencia/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
		tarjetaControlService.DeleteAlertaIncidencia(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
}
