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
import com.godared.controlbus.bean.TiempoProgramado;
import com.godared.controlbus.bean.TiempoSalida;
import com.godared.controlbus.bean.Usp_S_TeGetAllTelefonoByBuImei;
import com.godared.controlbus.bean.Usp_S_TiPrGetAllTiempoProgramadoByTiSa;
import com.godared.controlbus.service.ITarjetaControlService;

@RestController
@RequestMapping("/rest")
public class TiempoProgramadoRestController {
	@Autowired
	ITarjetaControlService tarjetaControlService;
	@RequestMapping(value="/tiempoprogramado/{id}", method=RequestMethod.GET)
	public TiempoProgramado Get(@PathVariable("id") int tiPrId) {
		TiempoProgramado tiempoProgramado=tarjetaControlService.findOneTiempoProgramado(tiPrId);
		if(tiempoProgramado==null)
		{
			throw new RestException(1,"tiempoSalida no enccontrado","tiempoSalida con id:"+ tiPrId + " No encontrado en el sistema");
		}
		return tiempoProgramado;
	}
	@RequestMapping(value = "/tiempoprogramado/getalltiempoprogramadobytisa",params = {"tiSaId"}, method=RequestMethod.GET)
	public List<Usp_S_TiPrGetAllTiempoProgramadoByTiSa> GetAllTiempoProgramadoByTiSa(@RequestParam("tiSaId") int tiSaId) {
		return tarjetaControlService.GetAllTiempoProgramadoByTiSa(tiSaId);
	}
	@RequestMapping(value="/tiempoprogramado/new", method=RequestMethod.GET)
	public TiempoProgramado NewTiempoSalida(){
		return new TiempoProgramado();
	}
	@RequestMapping(value = "/tiempoprogramado/save", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<TiempoProgramado> save(@Valid @RequestBody TiempoProgramado tiempoProgramado) {
		tarjetaControlService.SaveTiempoProgramado(tiempoProgramado);
		return new ResponseEntity<TiempoProgramado>(tiempoProgramado, HttpStatus.OK);
	}
	@RequestMapping(value="/tiempoprogramado/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
		tarjetaControlService.DeleteTiempoProgramado(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
}
