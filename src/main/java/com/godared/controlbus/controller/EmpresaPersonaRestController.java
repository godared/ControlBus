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
import com.godared.controlbus.bean.EmpresaPersona;
import com.godared.controlbus.bean.Persona;
import com.godared.controlbus.bean.Usp_S_PeGetAllPersonaByEmSuEm;
import com.godared.controlbus.service.IEmpresaService;

@RestController
@RequestMapping("/rest")
public class EmpresaPersonaRestController {
	@Autowired
	IEmpresaService empresaService;
	@RequestMapping(value="/empresapersona/{id}", method=RequestMethod.GET)
	public EmpresaPersona Get(@PathVariable("id") int emPeId) {
		EmpresaPersona empresaPersona=empresaService.findOneEmpresaPersona(emPeId);
		if(empresaPersona==null)
		{
			throw new RestException(1,"EmpresaPersona no enccontrado","EmpresaPersona con id:"+ emPeId + " No encontrado en el sistema");
		}
		return empresaPersona;
	}
	//http://localhost:8080/ControlBus/rest/empresapersona/getallppersonabyemsuem?emId=1&suEmId=1
	@RequestMapping(value = "/empresapersona/getallpersonabyemsuem",params = {"emId","suEmId"}, method=RequestMethod.GET)
	public List<Usp_S_PeGetAllPersonaByEmSuEm> getAllPersonaByEmSuEm(@RequestParam("emId") int emId,@RequestParam("suEmId") int suEmId) {
		return empresaService.getAllPersonaByEmSuEm(emId,suEmId);
	}
	@RequestMapping(value="/empresapersona/new", method=RequestMethod.GET)
	public EmpresaPersona NewEmpresaPersona(){
		return new EmpresaPersona();
	}
	
	@RequestMapping(value = "/empresapersona/save", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<EmpresaPersona> save(@Valid @RequestBody EmpresaPersona empresaPersona) {
		empresaService.Save(empresaPersona);
		return new ResponseEntity<EmpresaPersona>(empresaPersona, HttpStatus.OK);
	}
	
	@RequestMapping(value="/empresapersona/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
		empresaService.DeleteEmpresaPersona(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
	@RequestMapping(value="/empresapersona/suemid/{suEmId}", method=RequestMethod.DELETE)	
	public ResponseEntity<Boolean> Delete(@PathVariable("suEmId")int suEmId){
		empresaService.DeleteEmpresaPersonaBySuEm(suEmId);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
}
