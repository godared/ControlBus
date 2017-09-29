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
import com.godared.controlbus.bean.Empresa;
import com.godared.controlbus.bean.Telefono;
import com.godared.controlbus.bean.Usp_S_TeGetAllTelefonoByBuImei;
import com.godared.controlbus.service.IBusService;

@RestController
@RequestMapping("/rest")
public class TelefonoRestController {
	@Autowired
	IBusService busService;
	@RequestMapping(value="/telefono/{id}", method=RequestMethod.GET)
	public Telefono Get(@PathVariable("id") int teId) {
		Telefono telefono=busService.findOneTelefono(teId);
		if(telefono==null)
		{
			throw new RestException(1,"Telefono no enccontrado","Telefono con id:"+ teId + " No encontrado en el sistema");
		}
		return telefono;
	}
	@RequestMapping(value = "/telefono/getalltelefonobybu",params = {"buId"}, method=RequestMethod.GET)
	public List<Usp_S_TeGetAllTelefonoByBuImei> GetAllTelefonoByBuImei(@RequestParam("buId") int buId) {
		return busService.getAllTelefonoByBuImei(buId,"");
	}
	@RequestMapping(value = "/telefono/getalltelefonobyimei",params = {"teImei"}, method=RequestMethod.GET)
	public List<Usp_S_TeGetAllTelefonoByBuImei> GetAllTelefonoByBuImei(@RequestParam("teImei") String teImei) {
		return busService.getAllTelefonoByBuImei(0,teImei);
	}
	@RequestMapping(value="/telefono/new", method=RequestMethod.GET)
	public Telefono NewTelefono(){
		return new Telefono();
	}
	@RequestMapping(value = "/telefono/save", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Telefono> save(@Valid @RequestBody Telefono telefono) {
		busService.Save(telefono);
		return new ResponseEntity<Telefono>(telefono, HttpStatus.OK);
	}
	@RequestMapping(value="/telefono/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
		busService.DeleteTelefono(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
}
