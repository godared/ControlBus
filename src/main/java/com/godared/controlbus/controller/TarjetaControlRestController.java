package com.godared.controlbus.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.godared.controlbus.bean.TarjetaControl;
import com.godared.controlbus.bean.Usp_S_GetAllRegistroVueltasDiariasByEmPrFe;
import com.godared.controlbus.bean.Usp_S_TaCoGetAllTarjetaControlByEmPuCo;
import com.godared.controlbus.service.ITarjetaControlService;
@RestController
@RequestMapping("/rest")
public class TarjetaControlRestController {
	@Autowired
	ITarjetaControlService tarjetaControlService;
	
	@RequestMapping(value = "/tarjetacontrol", method=RequestMethod.GET)	
	public List<TarjetaControl> List() {
		return tarjetaControlService.findAll();
	}
	@RequestMapping(value="/tarjetacontrol/{id}", method=RequestMethod.GET)
	public TarjetaControl Get(@PathVariable("id") int taCoId) {
		TarjetaControl tarjetaControl=tarjetaControlService.findOne(taCoId);
		if(tarjetaControl==null)
		{
			throw new RestException(1,"TarjetaControl no enccontrado","TarjetaControl con id:"+ taCoId + " No encontrado en el sistema");
		}
		return tarjetaControlService.findOne(taCoId);
	}
	@RequestMapping(value="/tarjetacontrol/new", method=RequestMethod.GET)
	public TarjetaControl NewPuntoControl(){
		return new TarjetaControl();
	}
	@RequestMapping(value = "/tarjetacontrol/save", method=RequestMethod.POST)
	@ResponseBody
	public TarjetaControl save(@RequestBody TarjetaControl tarjetaControl){
		//tarjetaControlService.Save(tarjetaControl);
		return tarjetaControlService.Save(tarjetaControl);
	}
	@RequestMapping(value = "/tarjetacontrol/saveTaDe", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Boolean> save(@RequestBody RequestWrapper requestWrapper) {
		
		tarjetaControlService.Save(requestWrapper.getTarjetaControl(), requestWrapper.getTarjetaControlDetalle());;
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
	
	@RequestMapping(value="/tarjetacontrol/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> Delete(@PathVariable("id") int id) {
		tarjetaControlService.Delete(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
	//http://localhost:8080/ControlBus/rest/ruta/getallrutabyem?emId=1
	@RequestMapping(value = "/tarjetacontrol/getalltarjetacontrolbyempuco",params = {"emId","puCoId"}, method=RequestMethod.GET)
	public List<Usp_S_TaCoGetAllTarjetaControlByEmPuCo> GetAllTarjetaControlByEmPuCo(@RequestParam("emId") int emId,@RequestParam("puCoId") int puCoId) {
		return tarjetaControlService.GetAllTarjetaControlByEmPuCo(emId,puCoId);
	}
	@RequestMapping(value = "/tarjetacontrol/getalltarjetacontrolbybuidfecha",params = {"buId","taCoFecha"}, method=RequestMethod.GET)
	public List<TarjetaControl> Usp_S_TaCoGetAllTarjetaControlByBuIdFecha(@RequestParam("buId") int buId,@RequestParam("taCoFecha") String taCoFecha) throws ParseException{
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date date=formatter.parse(taCoFecha);
		return tarjetaControlService.Usp_S_TaCoGetAllTarjetaControlByBuIdFecha(buId,date);
	}
	@RequestMapping(value = "/tarjetacontrol/getallregistrovueltasdiariasbyemprfe",params = {"emId","prId","fechaDiario"}, method=RequestMethod.GET)
	public List<Usp_S_GetAllRegistroVueltasDiariasByEmPrFe> GetAllRegistroVueltasDiariasByEmPrFe(int emId,int prId,Date fechaDiario){
		return tarjetaControlService.GetAllRegistroVueltasDiariasByEmPrFe(emId,prId,fechaDiario);
	}
	@RequestMapping(value = "/tarjetacontrol/asignartarjeta", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Boolean> AsignarTarjetaControl(@RequestBody TarjetaControl tarjetaControl){
		this.tarjetaControlService.AsignarTarjetaControl(tarjetaControl,false);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
	@RequestMapping(value = "/tarjetacontrol/asignartarjetamultiple/{tarjetaControl}/{reten1}/{reten2}", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Boolean> AsignarTarjetaControlMultiple(@RequestParam("tarjetaControl")  TarjetaControl tarjetaControl, @RequestParam("reten1")Date reten1,@RequestParam("reten2") Date reten2){
		this.tarjetaControlService.AsignarTarjetaMultiple(tarjetaControl,reten1,reten2,true);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
	@RequestMapping(value = "/tarjetacontrol/terminarvuelta/{id}", method=RequestMethod.POST)	
	public ResponseEntity<Boolean> TerminarVuelta(@PathVariable("id") int reDiDeId){
		this.tarjetaControlService.TerminarVuelta(reDiDeId);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
}
