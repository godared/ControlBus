package com.godared.controlbus.controller;

import java.util.List;

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
import com.godared.controlbus.bean.Programacion;
import com.godared.controlbus.bean.ProgramacionDetalle;
import com.godared.controlbus.bean.PuntoControl;
import com.godared.controlbus.bean.Usp_S_PrGetAllProgramacionByEm;
import com.godared.controlbus.service.IBusService;
import com.godared.controlbus.service.IProgramacionService;


@RestController
@RequestMapping("/rest")
public class ProgramacionRestController {
	@Autowired
	IProgramacionService programacionService;
	
	@RequestMapping(value = "/programacion", method=RequestMethod.GET)	
	public List<Programacion> List() {
		return programacionService.findAll();
	}
	@RequestMapping(value="/programacion/{id}", method=RequestMethod.GET)
	public Programacion Get(@PathVariable("id") int prId) {
		Programacion programacion=programacionService.findOne(prId);
		if(programacion==null)
		{
			throw new RestException(1,"Programacion no enccontrado","Programacion con id:"+ prId + " No encontrado en el sistema");
		}
		return programacion;
	}
	@RequestMapping(value="/programacion/new", method=RequestMethod.GET)
	public Programacion NewProgramacion(){
		return new Programacion();
	}
	@RequestMapping(value = "/programacion/save", method=RequestMethod.POST)
	@ResponseBody
	public Programacion save(@RequestBody Programacion programacion) {
			//programacionService.Save(programacion);
		return programacionService.Save(programacion);// new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
	@RequestMapping(value = "/programacion/savePrDe", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Boolean> save(@RequestBody RequestWrapper requestWrapper) {
		programacionService.Save(requestWrapper.getProgramacion(), requestWrapper.getProgramacionDetalle());;
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
	
	@RequestMapping(value="/programacion/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> Delete(@PathVariable("id") int id) {
		programacionService.Delete(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
	//http://localhost:8080/ControlBus/rest/ruta/getallrutabyem?emId=1
	@RequestMapping(value = "/programacion/getallprogramacionbyem",params = {"emId","anio"}, method=RequestMethod.GET)
	public List<Usp_S_PrGetAllProgramacionByEm> GetAllProgramacionByEm(@RequestParam("emId") int emId,@RequestParam("anio") int anio) {
		return programacionService.GetAllProgramacionByEm(emId,anio);
	}
	@RequestMapping(value = "/programacion/programacionbase/{emId}/{prId}/{aleatorio}/", method=RequestMethod.POST) //params = {"emId","prId","aleatorio"},
	@ResponseBody
	public ResponseEntity<Boolean> RegistrarProgramacionBase(@RequestBody List<ProgramacionDetalle>  programacionDetalles ,
			@PathVariable("emId")int emId,@PathVariable("prId")int prId, @PathVariable("aleatorio")Boolean aleatorio) {
		programacionService.RegistrarProgramacionBase(programacionDetalles,emId,prId,aleatorio);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
		
	}
	
}
