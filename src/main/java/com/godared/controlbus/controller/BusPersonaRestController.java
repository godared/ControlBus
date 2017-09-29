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
import com.godared.controlbus.bean.BusPersona;
import com.godared.controlbus.bean.EmpresaPersona;
import com.godared.controlbus.bean.Usp_S_PeGetAllPersonaByEmSuEm;
import com.godared.controlbus.service.IBusService;

@RestController
@RequestMapping("/rest")
public class BusPersonaRestController {
	@Autowired
	IBusService busService;
	@RequestMapping(value="/buspersona/{id}", method=RequestMethod.GET)
	public BusPersona Get(@PathVariable("id") int buPeId) {
		BusPersona busPersona=busService.findOneBusPersona(buPeId);
		if(busPersona==null)
		{
			throw new RestException(1,"BusPersona no enccontrado","BusPersona con id:"+ buPeId + " No encontrado en el sistema");
		}
		return busPersona;
	}
	@RequestMapping(value = "/buspersona/getallpersonabyembu",params = {"emId","buId"}, method=RequestMethod.GET)
	public List<Usp_S_PeGetAllPersonaByEmSuEm> getAllPersonaByEmBu(@RequestParam("emId") int emId,@RequestParam("buId") int buId) {
		return busService.getAllPersonaByEmBu(emId,buId);
	}
	@RequestMapping(value="/buspersona/new", method=RequestMethod.GET)
	public BusPersona NewbusPersona(){
		return new BusPersona();
	}
	@RequestMapping(value = "/buspersona/save", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<BusPersona> save(@Valid @RequestBody BusPersona busPersona) {
		busService.Save(busPersona);
		return new ResponseEntity<BusPersona>(busPersona, HttpStatus.OK);
	}
	
	@RequestMapping(value="/buspersona/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
		busService.DeleteBusPersona(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
	@RequestMapping(value="/buspersona/buid/{buId}", method=RequestMethod.DELETE)	
	public ResponseEntity<Boolean> Delete(@PathVariable("buId")int buId){
		busService.DeleteBusPersonaByBu(buId);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
}
