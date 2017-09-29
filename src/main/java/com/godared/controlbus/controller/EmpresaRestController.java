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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.godared.controlbus.RestException;
import com.godared.controlbus.bean.Empresa;
import com.godared.controlbus.service.IEmpresaService;

@RestController
@RequestMapping("/rest")
public class EmpresaRestController {
	@Autowired
	IEmpresaService empresaService;
	@RequestMapping(value = "/empresa", method=RequestMethod.GET)	
	public List<Empresa> List() {
		return empresaService.findAll();
	}
	@RequestMapping(value="/empresa/{id}", method=RequestMethod.GET)
	public Empresa Get(@PathVariable("id") int emId) {
		Empresa empresa=empresaService.findOne(emId);
		if(empresa==null)
		{
			throw new RestException(1,"Empresa no enccontrado","empresa con id:"+ emId + " No encontrado en el sistema");
		}
		return empresa;
	}
	@RequestMapping(value="/empresa/new", method=RequestMethod.GET)
	public Empresa NewEmpresa(){
		return new Empresa();
	}
	@RequestMapping(value = "/empresa/save", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Empresa> save(@Valid @RequestBody Empresa empresa) {
		empresaService.Save(empresa);
		return new ResponseEntity<Empresa>(empresa, HttpStatus.OK);
	}
	
	@RequestMapping(value="/empresa/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
		empresaService.Delete(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
}
