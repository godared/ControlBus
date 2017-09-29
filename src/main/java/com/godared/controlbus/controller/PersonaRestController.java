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
import com.godared.controlbus.bean.Persona;
import com.godared.controlbus.service.IPersonaService;

@RestController
@RequestMapping("/rest")
public class PersonaRestController {
	@Autowired
	IPersonaService personaService;
	@RequestMapping(value = "/persona", method=RequestMethod.GET)	
	public List<Persona> List() {
		return personaService.findAll();
	}
	@RequestMapping(value="/persona/{id}", method=RequestMethod.GET)
	public Persona Get(@PathVariable("id") int peId) {
		Persona persona=personaService.findOne(peId);
		if(persona==null)
		{
			throw new RestException(1,"Persona no enccontrado","Persona con id:"+ peId + " No encontrado en el sistema");
		}
		return persona;
	}
	@RequestMapping(value="/persona/new", method=RequestMethod.GET)
	public Persona NewPersona(){
		return new Persona();
	}
	@RequestMapping(value = "/persona/save", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Persona> save(@Valid @RequestBody Persona persona) {
		personaService.Save(persona);
		return new ResponseEntity<Persona>(persona, HttpStatus.OK);
	}
	
	@RequestMapping(value="/persona/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
		personaService.Delete(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
}
