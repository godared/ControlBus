package com.godared.controlbus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	@RequestMapping(value="/programaciondetalle/new", method=RequestMethod.GET)
	public PuntoControlDetalle NewProgramacionDetalle(){
		return new PuntoControlDetalle();
	}
}
