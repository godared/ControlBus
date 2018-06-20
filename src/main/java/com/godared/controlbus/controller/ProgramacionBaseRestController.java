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
import com.godared.controlbus.bean.ProgramacionBase;
import com.godared.controlbus.bean.ProgramacionDetalle;
import com.godared.controlbus.bean.PuntoControl;
import com.godared.controlbus.bean.Usp_S_PrBaGetAllProgramacionBaseByEm;
import com.godared.controlbus.bean.Usp_S_PrGetAllProgramacionByEm;
import com.godared.controlbus.service.IBusService;
import com.godared.controlbus.service.IProgramacionService;


@RestController
@RequestMapping("/rest")
public class ProgramacionBaseRestController {
	@Autowired
	IProgramacionService programacionService;
	
	@RequestMapping(value = "/programacionbase", method=RequestMethod.GET)	
	public List<ProgramacionBase> List() {
		return programacionService.findAllProgramacionBase();
	}
	@RequestMapping(value="/programacionbase/{id}", method=RequestMethod.GET)
	public ProgramacionBase Get(@PathVariable("id") int prBaId) {
		ProgramacionBase programacion=programacionService.findOneProgramacionBase(prBaId);
		if(programacion==null)
		{
			throw new RestException(1,"Programacion no enccontrado","ProgramacionBase con id:"+ prBaId + " No encontrado en el sistema");
		}
		return programacion;
	}
	@RequestMapping(value="/programacionbase/new", method=RequestMethod.GET)
	public ProgramacionBase NewProgramacionBase(){
		return new ProgramacionBase();
	}
	@RequestMapping(value = "/programacionbase/save", method=RequestMethod.POST)
	@ResponseBody
	public ProgramacionBase save(@RequestBody ProgramacionBase programacionBase) {
			//programacionService.Save(programacion);
		return programacionService.SaveProgramacionBase(programacionBase);// new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}	
	
	@RequestMapping(value="/programacionbase/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> Delete(@PathVariable("id") int id) {
		programacionService.DeleteProgramacionBase(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
	//http://localhost:8080/ControlBus/rest/ruta/getallrutabyem?emId=1
	@RequestMapping(value = "/programacionbase/getallprogramacionbasebyem",params = {"emId","anio"}, method=RequestMethod.GET)
	public List<Usp_S_PrBaGetAllProgramacionBaseByEm> GetAllProgramacionBaseByEm(@RequestParam("emId") int emId,@RequestParam("anio") int anio) {
		return programacionService.GetAllProgramacionBaseByEm(emId,anio);
	}
	
}
