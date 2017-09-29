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
import com.godared.controlbus.bean.Bus;
import com.godared.controlbus.bean.Usp_S_BuGetAllBusesByEmSuEm;
import com.godared.controlbus.service.IBusService;

@RestController
@RequestMapping("/rest")
public class BusRestController {
	@Autowired
	IBusService busService;
	@RequestMapping(value = "/bus", method=RequestMethod.GET)	
	public List<Bus> List() {
		return busService.findAll();
	}
	@RequestMapping(value="/bus/{id}", method=RequestMethod.GET)
	public Bus Get(@PathVariable("id") int buId) {
		Bus programacion=busService.findOne(buId);
		if(programacion==null)
		{
			throw new RestException(1,"Bus no enccontrado","Bus con id:"+ buId + " No encontrado en el sistema");
		}
		return programacion;
	}
	@RequestMapping(value="/bus/new", method=RequestMethod.GET)
	public Bus NewBus(){
		return new Bus();
	}
	@RequestMapping(value = "/bus/save", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Bus> save(@Valid @RequestBody Bus bus) {
		busService.Save(bus);
		return new ResponseEntity<Bus>(bus, HttpStatus.OK);
	}
	
	@RequestMapping(value="/bus/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
		busService.Delete(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
	//http://localhost:8080/ControlBus/rest/bus/getallrutabyem?emId=1
	@RequestMapping(value = "/bus/getallbusesbyemsuem",params = {"emId","suEmId"}, method=RequestMethod.GET)
	public List<Usp_S_BuGetAllBusesByEmSuEm> GetAllBusesByEmSuEm(@RequestParam("emId") int emId,@RequestParam("suEmId") int suEmId) {
		return busService.GetAllBusesByEmSuEm(emId,suEmId);
	}
	@RequestMapping(value = "/bus/seorteoaleatorio",params = {"emId"}, method=RequestMethod.GET)
	public List<Bus> SortearAleatorio(@RequestParam("emId") int emId) {
		return busService.SortearAleatorio(emId);
	}
	
}
