package com.godared.controlbus.controller;

import java.util.List;

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
import com.godared.controlbus.bean.ProgramacionDetalle;
import com.godared.controlbus.bean.PuntoControlDetalle;
import com.godared.controlbus.service.IProgramacionService;

@RestController
@RequestMapping("/rest")
public class ProgramacionDetalleRestController {
	@Autowired
	IProgramacionService programacionService;

	@RequestMapping(value="/programaciondetalle/{prDeId}", method=RequestMethod.GET)
	public ProgramacionDetalle Get(@PathVariable("prDeId") int prDeId) {
		ProgramacionDetalle programacionDetalle=programacionService.findOneProgramacionDetalleId(prDeId);
		if(programacionDetalle==null)
		{
			throw new RestException(1,"programaciondetalle no enccontrado"," programaciondetalle con id:"+ prDeId + " No encontrado en el sistema");
		}
		return programacionDetalle;
	}
	@RequestMapping(value="/programaciondetalle/prid/{prId}", method=RequestMethod.GET)
	public List<ProgramacionDetalle> getAllProgramacionDetalleByPr(@PathVariable("prId") int prId) {
		List<ProgramacionDetalle> programacionDetalle=programacionService.getAllProgramacionDetalleByPr(prId);
		if(programacionDetalle==null)
		{
			throw new RestException(1,"ProgramacionDetalle no enccontrado"," ProgramacionDetalle con prid:"+ prId + " No encontrado en el sistema");
		}
		return programacionDetalle;
	}
	@RequestMapping(value="/programaciondetalle/new", method=RequestMethod.GET)
	public ProgramacionDetalle NewProgramacionDetalle(){
		return new ProgramacionDetalle();
	}
	@RequestMapping(value = "/programaciondetalle/save", method=RequestMethod.POST,produces = "application/json",consumes="application/json")
	//@Consumes({ MediaType.APPLICATION_JSON })
    //@Produces({ MediaType.APPLICATION_JSON })
	@ResponseBody
	public ResponseEntity<Boolean> save(@RequestBody List<ProgramacionDetalle> programacionDetalle) {		
		programacionService.CreateProgramacionDetalle(programacionDetalle);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
}
