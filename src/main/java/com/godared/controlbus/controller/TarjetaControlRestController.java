package com.godared.controlbus.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
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
import com.godared.controlbus.bean.Configura;
import com.godared.controlbus.bean.RegistroDiario;
import com.godared.controlbus.bean.TarjetaControl;
import com.godared.controlbus.bean.Usp_S_GetAllRegistroVueltasDiariasByEmPrFe;
import com.godared.controlbus.bean.Usp_S_PrGetAllProgramacionByEm;
import com.godared.controlbus.bean.Usp_S_TaCoGetAllTarjetaControlByBuIdFecha;
import com.godared.controlbus.bean.Usp_S_TaCoGetAllTarjetaControlByEmPuCo;
import com.godared.controlbus.service.IEmpresaService;
import com.godared.controlbus.service.IProgramacionService;
import com.godared.controlbus.service.IRegistroDiarioService;
import com.godared.controlbus.service.ITarjetaControlService;
import com.godared.controlbus.service.TarjetaControlServiceImp;
@RestController
@RequestMapping("/rest")
public class TarjetaControlRestController {
	@Autowired
	ITarjetaControlService tarjetaControlService;
	@Autowired
	IEmpresaService empresaService;
	@Autowired
	IRegistroDiarioService registroDiarioService;
	@Autowired
	IProgramacionService programacionService;
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
	@RequestMapping(value = "/tarjetacontrol/savemovil", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Integer> saveMovil(@RequestBody TarjetaControl tarjetaControl){
		//tarjetaControlService.Save(tarjetaControl);
		int codEnvio=0;
		if(tarjetaControl.getTaCoId()>0)
			codEnvio= tarjetaControlService.UpdateTarjetaControlOfMovil(tarjetaControl.getTaCoId(),tarjetaControl);
		return new ResponseEntity<Integer>(codEnvio, HttpStatus.OK);
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
	@RequestMapping(value = "/tarjetacontrol/getalltarjetacontrolbybuidfecha",params = {"emId","buId","taCoFecha"}, method=RequestMethod.GET)
	public List<Usp_S_TaCoGetAllTarjetaControlByBuIdFecha> Usp_S_TaCoGetAllTarjetaControlByBuIdFecha(@RequestParam("emId") int emId,@RequestParam("buId") int buId,@RequestParam("taCoFecha") String taCoFecha) throws ParseException{
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date date=formatter.parse(taCoFecha);
		return tarjetaControlService.Usp_S_TaCoGetAllTarjetaControlByBuIdFecha(emId,buId,date);
	}
	@RequestMapping(value = "/tarjetacontrol/getalltarjetacontrolbyemredide",params = {"emId","reDiDe"}, method=RequestMethod.GET)
	public List<Usp_S_TaCoGetAllTarjetaControlByBuIdFecha> GetAllTarjetaControlByEmReDiDe(@RequestParam("emId") int buId,@RequestParam("reDiDe") int reDiDe) throws ParseException{
		
		return tarjetaControlService.GetAllTarjetaControlByEmReDiDe(buId,reDiDe);
	}
	/*Este procedimiento genera para las consultas de vueltas considerando dos
	 * aspectos con solamente una programacion(caso ruta 13) y programaciones separadas por subempresa(ruta11)
	 * al final genera las vueltas de acuerdo a la programacion de la fecha actual*/
	@RequestMapping(value = "/tarjetacontrol/getallregistrovueltasdiariasbyemprfe",params = {"emId","prId","fechaDiario"}, method=RequestMethod.GET)
	public List<Usp_S_GetAllRegistroVueltasDiariasByEmPrFe> GetAllRegistroVueltasDiariasByEmPrFe(int emId,int prId,Date fechaDiario){
		// el porque lo hago aqui y no en service es que cuando hago la peticion del dao GetAllRegistroVueltasDiariasByEmPrFe
		// para el tipo _configura.getCoSiId()==2 no se que hace se sobreescribe y sobrepone la lista de vuelta(esto debido a que se realiza la llamada por subempresa
		//y puede ser de dos a mas y unir las listas).
		Configura _configura =new Configura();
		Calendar c = Calendar.getInstance();
		c.setTime(fechaDiario);
		int year = c.get(Calendar.YEAR);
		
		List<Usp_S_GetAllRegistroVueltasDiariasByEmPrFe> _getAllRegistroVueltasDiariasByEmPrFe= new ArrayList<Usp_S_GetAllRegistroVueltasDiariasByEmPrFe>();
		
		_configura=this.empresaService.GetAllConfiguraByEmPeriodo(emId,year).get(0);
		List<Usp_S_GetAllRegistroVueltasDiariasByEmPrFe> _usp_S_GetAllRegistroVueltasDiariasByEmPrFe=new ArrayList<Usp_S_GetAllRegistroVueltasDiariasByEmPrFe> () ;
		if (_configura.getCoSiId()==1) //Si el 1 entonce no considera dos programaciones 
			_usp_S_GetAllRegistroVueltasDiariasByEmPrFe=tarjetaControlService.GetAllRegistroVueltasDiariasByEmPrFe(emId,prId,fechaDiario);
			
		else if(_configura.getCoSiId()==2) { // si es 2 entonces tiene la cantidad de programaciones por subempresas y el orden en registrodiario para concatenar y generar el registro de vueltas
			//Buscamos el orden de las subempresas
			List<RegistroDiario> _registroDiarios=null;
			_registroDiarios=registroDiarioService.GetAllRegistroDiarioByEm(emId);
			//este codigo filtra y el resultado lo devuelve en _registroDiarios
			Iterator<RegistroDiario> it = _registroDiarios.iterator();
			while (it.hasNext()) {
				RegistroDiario current = it.next();
			    if (current.getReDiFeha().compareTo(fechaDiario)!=0) {
			        it.remove();
			    }
			}
			//Obtenemos el orden de las subempresas
			String _ordenSubEmpresas=_registroDiarios.get(0).getReDiOrdenSubEmpresa();
			String[] _subEmpresas = _ordenSubEmpresas.split(",");
			int c1=0;
			while(c1<_subEmpresas.length){
				//Obtenemos y filtramos la programacion por SubEmpresa
				List<Usp_S_PrGetAllProgramacionByEm> _programaciones=null;			
				_programaciones=programacionService.GetAllProgramacionByEm(emId,year);
				//este codigo filtra y el resultado lo devuelve en _programaciones
				Iterator<Usp_S_PrGetAllProgramacionByEm> it2 = _programaciones.iterator();
				while (it2.hasNext()) {
					Usp_S_PrGetAllProgramacionByEm current = it2.next();
				    if (current.getSuEmId()!=Integer.parseInt(_subEmpresas[c1])) {
				        it2.remove();
				    }
				}
				//Ahora si agregamos de acuerdo al orden especificado de las subempresas

				_getAllRegistroVueltasDiariasByEmPrFe.removeAll(_getAllRegistroVueltasDiariasByEmPrFe);							
				_getAllRegistroVueltasDiariasByEmPrFe=tarjetaControlService.GetAllRegistroVueltasDiariasByEmPrFe(emId,_programaciones.get(0).getPrId(),fechaDiario);
				
				_usp_S_GetAllRegistroVueltasDiariasByEmPrFe.addAll(_getAllRegistroVueltasDiariasByEmPrFe);
				c1=c1+1;
			}
			//Ahora si modificamos e correlativo del id
			List<Usp_S_GetAllRegistroVueltasDiariasByEmPrFe> _usp_S_GetAllRegistroVueltasDiariasByEmPrFe2= new ArrayList<Usp_S_GetAllRegistroVueltasDiariasByEmPrFe>();
			//_usp_S_GetAllRegistroVueltasDiariasByEmPrFe2.addAll(_usp_S_GetAllRegistroVueltasDiariasByEmPrFe2);
			int nroVueltas=_registroDiarios.get(0).getReDiTotalVuelta();
			int count=1;
			int vuelta=0;
			int subEmpresa=0;
			int c5=1;
			int valorOrden=0;
			for(Usp_S_GetAllRegistroVueltasDiariasByEmPrFe usp_S_GetAllRegistroVueltasDiariasByEmPrFe: _usp_S_GetAllRegistroVueltasDiariasByEmPrFe){
				Usp_S_GetAllRegistroVueltasDiariasByEmPrFe usp_S_GetAllRegistroVueltasDiariasByEmPrFe2=new Usp_S_GetAllRegistroVueltasDiariasByEmPrFe();
				usp_S_GetAllRegistroVueltasDiariasByEmPrFe2=org.apache.commons.lang3.SerializationUtils.clone(usp_S_GetAllRegistroVueltasDiariasByEmPrFe);
				usp_S_GetAllRegistroVueltasDiariasByEmPrFe2.setId(count);
				
				if (count==1){
					vuelta=usp_S_GetAllRegistroVueltasDiariasByEmPrFe.getReDiDeNroVuelta();
					subEmpresa=usp_S_GetAllRegistroVueltasDiariasByEmPrFe.getSuEmId();
					valorOrden=0;
				}
				if(subEmpresa!= usp_S_GetAllRegistroVueltasDiariasByEmPrFe.getSuEmId()){
					valorOrden=valorOrden+c5-1;
					subEmpresa=usp_S_GetAllRegistroVueltasDiariasByEmPrFe.getSuEmId();
				}
				if( vuelta!=usp_S_GetAllRegistroVueltasDiariasByEmPrFe.getReDiDeNroVuelta()){
					c5=valorOrden+1;
					vuelta=usp_S_GetAllRegistroVueltasDiariasByEmPrFe.getReDiDeNroVuelta();
					}
				usp_S_GetAllRegistroVueltasDiariasByEmPrFe2.setPrDeOrden(c5);
				c5=c5+1;
				
				_usp_S_GetAllRegistroVueltasDiariasByEmPrFe2.add(usp_S_GetAllRegistroVueltasDiariasByEmPrFe2);
				count=count+1;
			}
			_usp_S_GetAllRegistroVueltasDiariasByEmPrFe=_usp_S_GetAllRegistroVueltasDiariasByEmPrFe2;
		}
		else
			return null;
		
		
		return _usp_S_GetAllRegistroVueltasDiariasByEmPrFe;
		
		//return tarjetaControlService.GetAllRegistroVueltasDiariasByEmPrFe(emId,prId,fechaDiario);
	}
	@RequestMapping(value = "/tarjetacontrol/asignartarjeta", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Boolean> AsignarTarjetaControl(@RequestBody TarjetaControl tarjetaControl){
		this.tarjetaControlService.AsignarTarjetaControl(tarjetaControl,false);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
	@RequestMapping(value = "/tarjetacontrol/asignartarjetamultiple/{reten1}/{reten2}", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Boolean> AsignarTarjetaControlMultiple(@RequestBody  TarjetaControl tarjetaControl, @PathVariable("reten1")Date reten1,@PathVariable("reten2") Date reten2){
		this.tarjetaControlService.AsignarTarjetaMultiple(tarjetaControl,reten1,reten2,true);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
	@RequestMapping(value = "/tarjetacontrol/terminarvuelta/{id}", method=RequestMethod.POST)	
	public ResponseEntity<Boolean> TerminarVuelta(@PathVariable("id") int reDiDeId){
		this.tarjetaControlService.TerminarVuelta(reDiDeId);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}
}
