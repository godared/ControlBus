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
import com.godared.controlbus.bean.SubEmpresa;
import com.godared.controlbus.service.IEmpresaService;

@RestController
@RequestMapping("/rest")
public class SubEmpresaRestController {
	@Autowired
	IEmpresaService empresaService;

	@RequestMapping(value="/subempresa/{id}", method=RequestMethod.GET)
	public SubEmpresa Get(@PathVariable("id") int suEmId) {
		SubEmpresa subEmpresa=empresaService.findOneSubEmpresa(suEmId);
		if(subEmpresa==null)
		{
			throw new RestException(1,"SubEmpresa no enccontrado","SubEmpresa con id:"+ suEmId + " No encontrado en el sistema");
		}
		return subEmpresa;
	}
	@RequestMapping(value="/subempresa/emid/{emId}", method=RequestMethod.GET)
	public List<SubEmpresa> getAllSubEmpresaByEm(@PathVariable("emId") int emId) {
		List<SubEmpresa> subEmpresas=empresaService.getAllSubEmpresaByEm(emId);	
		return subEmpresas;
	}
	@RequestMapping(value="/subempresa/new", method=RequestMethod.GET)
	public SubEmpresa NewSubEmpresa(){
		return new SubEmpresa();
	}
	@RequestMapping(value = "/subempresa/save", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<SubEmpresa> save(@Valid @RequestBody SubEmpresa subEmpresa) {
		empresaService.Save(subEmpresa);
		return new ResponseEntity<SubEmpresa>(subEmpresa, HttpStatus.OK);
	}
	
	@RequestMapping(value="/subempresa/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
		empresaService.DeleteSubEmpresa(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
	@RequestMapping(value="/subempresa/emid/{emId}", method=RequestMethod.DELETE)	
	public ResponseEntity<Boolean> Delete(@PathVariable("emId")int emId){
		empresaService.DeleteSubEmpresaByEm(emId);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
}
