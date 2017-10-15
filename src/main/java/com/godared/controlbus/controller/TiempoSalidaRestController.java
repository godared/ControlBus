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
import com.godared.controlbus.bean.TiempoSalida;
import com.godared.controlbus.bean.Usp_S_TiPrGetAllTiempoProgramadoByTiSa;
import com.godared.controlbus.service.ITarjetaControlService;

@RestController
@RequestMapping("/rest")
public class TiempoSalidaRestController {
	@Autowired
	ITarjetaControlService tarjetaControlService;
	@RequestMapping(value="/tiemposalida/{id}", method=RequestMethod.GET)
	public TiempoSalida Get(@PathVariable("id") int tiSaId) {
		TiempoSalida tiempoSalida=tarjetaControlService.findOneTiempoSalida(tiSaId);
		if(tiempoSalida==null)
		{
			throw new RestException(1,"tiempoSalida no enccontrado","tiempoSalida con id:"+ tiSaId + " No encontrado en el sistema");
		}
		return tiempoSalida;
	}
	@RequestMapping(value = "/tiemposalida/getalltiemposalidabyem",params = {"emId"}, method=RequestMethod.GET)
	public List<TiempoSalida> GetAllTiempoSalidaByEm(@RequestParam("tiSaId") int emId) {
		return tarjetaControlService.GetAllTiempoSalidaByEm(emId);
	}
	
	@RequestMapping(value="/tiemposalida/new", method=RequestMethod.GET)
	public TiempoSalida NewTiempoSalida(){
		return new TiempoSalida();
	}
	@RequestMapping(value = "/tiemposalida/save", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<TiempoSalida> save(@Valid @RequestBody TiempoSalida tiempoSalida) {
		tarjetaControlService.SaveTiempoSalida(tiempoSalida);
		return new ResponseEntity<TiempoSalida>(tiempoSalida, HttpStatus.OK);
	}
	@RequestMapping(value="/tiemposalida/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
		tarjetaControlService.DeleteTiempoSalida(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}

}
