package com.godared.controlbus.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Convert;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.godared.controlbus.bean.Bus;
import com.godared.controlbus.bean.Configura;
import com.godared.controlbus.bean.Georeferencia;
import com.godared.controlbus.bean.ProgramacionDetalle;
import com.godared.controlbus.bean.PuntoControl;
import com.godared.controlbus.bean.PuntoControlDetalle;
import com.godared.controlbus.bean.RegistroDiario;
import com.godared.controlbus.bean.RegistroDiarioDetalle;
import com.godared.controlbus.bean.RegistroReten;
import com.godared.controlbus.bean.Ruta;
import com.godared.controlbus.bean.TarjetaControl;
import com.godared.controlbus.bean.TarjetaControlDetalle;
import com.godared.controlbus.bean.TiempoProgramado;
import com.godared.controlbus.bean.TiempoSalida;
import com.godared.controlbus.bean.Usp_S_GetAllRegistroVueltasDiariasByEmPrFe;
import com.godared.controlbus.bean.Usp_S_RuGetAllRutaByEm;
import com.godared.controlbus.bean.Usp_S_TaCoGetAllTarjetaControlByBuIdFecha;
import com.godared.controlbus.bean.Usp_S_TaCoGetAllTarjetaControlByEmPuCo;
import com.godared.controlbus.bean.Usp_S_TiPrGetAllTiempoProgramadoByTiSa;
import com.godared.controlbus.dao.IGeoreferenciaDao;
import com.godared.controlbus.dao.ITarjetaControlDao;
import com.godared.controlbus.dao.ITarjetaControlDetalleDao;
import com.godared.controlbus.dao.ITiempoProgramadoDao;
import com.godared.controlbus.dao.ITiempoSalidaDao;

@Service
@Transactional
public class TarjetaControlServiceImp implements ITarjetaControlService{
	
	private ITarjetaControlDao tarjetaControlDao;
	
	private ITarjetaControlDetalleDao tarjetaControlDetalleDao;
	
	private ITiempoSalidaDao tiempoSalidaDao;
	
	private ITiempoProgramadoDao tiempoProgramadoDao;
	
	private IGeoreferenciaDao georeferenciaDao;
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	@Autowired
	IRutaService rutaService;
	@Autowired
	IProgramacionService programacionService;
	@Autowired
	IRegistroDiarioService registroDiarioService;
	@Autowired
	IEmpresaService empresaService;
	@Autowired
	IBusService busService;
	//	injeccion de dependencias
	public void setTarjetaControlDao(ITarjetaControlDao tarjetaControlDao) {
		 this.tarjetaControlDao = tarjetaControlDao;
		 
	}
	public void setTarjetaControlDetalleDao(ITarjetaControlDetalleDao tarjetaControlDetalleDao) {
		 this.tarjetaControlDetalleDao = tarjetaControlDetalleDao;
		 
	}
	public void setTiempoSalidaDao(ITiempoSalidaDao tiempoSalidaDao) {
		 this.tiempoSalidaDao = tiempoSalidaDao;
		 
	}
	public void setTiempoProgramadoDao(ITiempoProgramadoDao tiempoProgramadoDao) {
		 this.tiempoProgramadoDao = tiempoProgramadoDao;
		 
	}
	public void setGeoreferenciaDao(IGeoreferenciaDao georeferenciaDao) {
		 this.georeferenciaDao = georeferenciaDao;
		 
	}
	
	public List<TarjetaControl> findAll() {
		// TODO Auto-generated method stub
		return tarjetaControlDao.findAll();
	}

	public TarjetaControl findOne(int id) {
		// TODO Auto-generated method stub
		return tarjetaControlDao.findOne(id);
	}
	public List<Usp_S_TaCoGetAllTarjetaControlByBuIdFecha> Usp_S_TaCoGetAllTarjetaControlByBuIdFecha(int emId,int buId,Date taCoFecha){
		return tarjetaControlDao.Usp_S_TaCoGetAllTarjetaControlByBuIdFecha(emId,buId,taCoFecha);
	}
	public List<Usp_S_TaCoGetAllTarjetaControlByBuIdFecha> GetAllTarjetaControlByEmReDiDe(int emId,int reDiDe){
		return tarjetaControlDao.GetAllTarjetaControlByEmReDiDe(emId,reDiDe);
	}
	public TarjetaControl Save(TarjetaControl tarjetaControl){
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		TarjetaControl _tarjetaControl=null;
		try {		
			transaction.begin();
			if (tarjetaControl.getTaCoId()>0)
			{
				tarjetaControl.setUsFechaReg(new Date() );
				_tarjetaControl=this.tarjetaControlDao.update(tarjetaControl);
			}
			else{
				_tarjetaControl=this.tarjetaControlDao.createReturn(tarjetaControl);
			}
		}
		catch(Exception ex){
		    transaction.rollback();
		       throw new RuntimeException(ex);
		}
		finally{
			entityManager.close();
		}
		return _tarjetaControl;
	}
	public void Save(TarjetaControl tarjetaControl,List<TarjetaControlDetalle> tarjetaControlDetalle) {
		// TODO Auto-generated method stub
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {		
			transaction.begin();
			if (tarjetaControl.getRuId()>0)
			{
				tarjetaControl.setUsFechaReg(new Date() );
				this.tarjetaControlDao.update(tarjetaControl);
				//REgistramos el detalle
				for(TarjetaControlDetalle tarjetaControlDet : tarjetaControlDetalle) {
					tarjetaControlDet.setTaCoId(tarjetaControl.getTaCoId());
					this.tarjetaControlDetalleDao.update(tarjetaControlDet);//System.out.println(rutaDet);
		        }
				
			}
			else
			{
				this.tarjetaControlDao.create(tarjetaControl);
				//REgistramos el detalle
				for(TarjetaControlDetalle tarjetaControlDet : tarjetaControlDetalle) {
					tarjetaControlDet.setTaCoId(tarjetaControl.getTaCoId());
					this.tarjetaControlDetalleDao.create(tarjetaControlDet);//System.out.println(rutaDet);
		        }			
			}
			transaction.commit();
		}
		catch(Exception ex){
		    transaction.rollback();
		       throw new RuntimeException(ex);
		}
		finally{
			entityManager.close();
		}
	}
	public int UpdateTarjetaControlOfMovil(int taCoId,TarjetaControl tarjetaControl){
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		int codEnvio;
		try {
			transaction.begin();
			TarjetaControl _tarjetaControl;
			_tarjetaControl=this.findOne(taCoId);
			_tarjetaControl.setTaCoFinish(true);
			
			//Buscamos el codigo de actualizacion y lo actualizamos
			Configura _configura =new Configura();
			_configura=this.empresaService.findOneConfigura(_tarjetaControl.getCoId());
			codEnvio=_configura.getCoCountMovilTaCo();
			codEnvio=codEnvio+1;
			_configura.setCoCountMovilTaCo(codEnvio);
			this.empresaService.SaveConfigura(_configura);
			_tarjetaControl.setTaCoCodEnvioMovil(codEnvio);
			this.tarjetaControlDao.update(_tarjetaControl);
			transaction.commit();
		}		
		catch(Exception ex ){
			transaction.rollback();
			throw new RuntimeException(ex);
		}
		finally{
			entityManager.close();
		}	
		return codEnvio;
		
	}
	public void Delete(int id){
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try{
			transaction.begin();
			TarjetaControl tarjetaControl;
			tarjetaControl=this.findOne(id);
			//obtenemos el ID PrDeId
			/*int _prDeId=this.GetPrDeIdReten(tarjetaControl);
			List<RegistroReten> _registroRetenes=null;
			_registroRetenes=registroDiarioService.GetAllRegistroRetenByReDiDe(tarjetaControl.getReDiDeId());
			int _reReId=0;
			for(RegistroReten registroReten: _registroRetenes){
				if(registroReten.getPrDeId()==_prDeId){
					_reReId=registroReten.getReReId();
					break;
				}
			}*/
			//solamente eliminamos detalle cuando es 1=asignado
			if (tarjetaControl.getTaCoAsignado().compareTo("1")==0){
				this.DeleteTarjetaControlDetalleBytaCoId(id);
				//if (_reReId>0)
					//registroDiarioService.DeleteRegistroReten(_reReId);
				this.Usp_D_GeEliminaByTaCo(tarjetaControl.getTaCoId());
			}
			this.tarjetaControlDao.deleteById(id);
			
			//this.ActualizarEstadoTarjetaProgramacionDetalle(tarjetaControl, false);
			transaction.commit();
		}
		catch(Exception ex ){
			transaction.rollback();
		       throw new RuntimeException(ex);
		}
		finally{
			entityManager.close();
		}
	 }
	private int GetPrDeIdReten(TarjetaControl tarjetaControl){
		RegistroDiarioDetalle _registroDiarioDetalle=null;	
		RegistroDiario _registroDiario=null;
		//Calendar cal = Calendar.getInstance();
		_registroDiarioDetalle=registroDiarioService.findOneRegistroDiarioDetalle(tarjetaControl.getReDiDeId());
		//Verificamos que sea la la vuelta actual
		//if (_registroDiarioDetalle.getReDiDeEstado().compareTo("02")==1) //osea no es igual
		//	throw new ArithmeticException("La vuelta debe ser la de estado actual");		
		_registroDiario=registroDiarioService.findOne(_registroDiarioDetalle.getReDiId());
		//Obtenemos el tiempo de la vuelta
		Date timeVuelta=null;		
		//Obteneniendo el IDProgramacionDetalle paraguardarlo en reten
		int _prDeId=0;
		List<ProgramacionDetalle> _programacionDetalles=null;
		_programacionDetalles= this.programacionService.getAllProgramacionDetalleByPrFecha(tarjetaControl.getPrId(),_registroDiario.getReDiFeha());
		for(ProgramacionDetalle programacionDetalle: _programacionDetalles){
			if (programacionDetalle.getBuId()==tarjetaControl.getBuId()){
				_prDeId=programacionDetalle.getPrDeId();
				break;
			}
		}
		return _prDeId;
	}
	
	public List<Usp_S_TaCoGetAllTarjetaControlByEmPuCo> GetAllTarjetaControlByEmPuCo(int emId,int puCoId){
		return tarjetaControlDao.GetAllTarjetaControlByEmPuCo(emId,puCoId);
	}
	public List<Usp_S_GetAllRegistroVueltasDiariasByEmPrFe> GetAllRegistroVueltasDiariasByEmPrFe(int emId,int prId,Date fechaDiario){
		return tarjetaControlDao.GetAllRegistroVueltasDiariasByEmPrFe(emId,prId,fechaDiario);
	}
	//Tarjeta de Control Detalle
	public TarjetaControlDetalle findOneTarjetaControlDetalleId(int taCoDeId){
		 return this.tarjetaControlDetalleDao.findOne(taCoDeId);
	 }
	public TarjetaControlDetalle findOneTarjetaControlDetalleBytaCoId(int taCoId){
		return this.tarjetaControlDetalleDao.findOne(taCoId);	//aqui hay que hacer un procedure pa get by puCoId
	}
	public List<TarjetaControlDetalle> getAllTarjetaControlDetalleByTaCo(int taCoId){
		return this.tarjetaControlDetalleDao.getAllTarjetaControlDetalleByTaCo(taCoId);
	}
	public void CreateTarjetaControlDetalle(TarjetaControlDetalle puntoControlDetalle){
		 this.tarjetaControlDetalleDao.create(puntoControlDetalle);
	}
	public void CreateTarjetaControlDetalle(List<TarjetaControlDetalle> tarjetaControlDetalle){
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
			transaction.begin();
			for(TarjetaControlDetalle _puntoControlDetalle:tarjetaControlDetalle){
				this.tarjetaControlDetalleDao.create(_puntoControlDetalle);
			}
			transaction.commit();
		}		
		catch(Exception ex ){
			transaction.rollback();
			throw new RuntimeException(ex);
		}
		finally{
			entityManager.close();
		}
	}
	public int UpdateTarjetaControlDetalleOfMovil(int taCoDeId,TarjetaControlDetalle tarjetaControlDetalle){
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		int codEnvio;
		try {
			transaction.begin();
			TarjetaControlDetalle _tarjetaControlDetalle=new TarjetaControlDetalle();
			_tarjetaControlDetalle=findOneTarjetaControlDetalleId(taCoDeId);
			//_tarjetaControlDetalle.setPuCoDeId(tarjetaControlDetalle.getPuCoDeId());
			_tarjetaControlDetalle.setTaCoDeFecha(tarjetaControlDetalle.getTaCoDeFecha());
			//_tarjetaControlDetalle.setTaCoDeHora(tarjetaControlDetalle.getTaCoDeHora());
			_tarjetaControlDetalle.setTaCoDeLatitud(tarjetaControlDetalle.getTaCoDeLatitud());
			_tarjetaControlDetalle.setTaCoDeLongitud(tarjetaControlDetalle.getTaCoDeLongitud());
			_tarjetaControlDetalle.setTaCoDeTiempo(tarjetaControlDetalle.getTaCoDeTiempo());
			//_tarjetaControlDetalle.setTaCoDeDescripcion(tarjetaControlDetalle.getTaCoDeDescripcion());
			//_tarjetaControlDetalle.setUsId(tarjetaControlDetalle.getUsId());
			//_tarjetaControlDetalle.setUsFechaReg(tarjetaControlDetalle.getUsFechaReg());
			
			//Buscamos el codigo de actualizacion y lo actualizamos
			TarjetaControl _tarjetaControl=new TarjetaControl();
			_tarjetaControl=this.findOne(_tarjetaControlDetalle.getTaCoId());
			Configura _configura =new Configura();
			_configura=this.empresaService.findOneConfigura(_tarjetaControl.getCoId());
			codEnvio=_configura.getCoCountMovilTaCoDe();
			codEnvio=codEnvio+1;
			_configura.setCoCountMovilTaCoDe(codEnvio);
			this.empresaService.SaveConfigura(_configura);
			
			_tarjetaControlDetalle.setTaCoDeCodEnvioMovil(codEnvio);
			this.tarjetaControlDetalleDao.update(_tarjetaControlDetalle);
			transaction.commit();
		}		
		catch(Exception ex ){
			transaction.rollback();
			throw new RuntimeException(ex);
		}
		finally{
			entityManager.close();
		}	
		return codEnvio;
	}
	public List<TarjetaControlDetalle> UpdateTarjetaControlDetalleOfMovil(List<TarjetaControlDetalle> tarjetaControlDetalles){
		List<TarjetaControlDetalle> _tarjetaControlDetalles=new ArrayList<TarjetaControlDetalle>();
		int codEnvio;
		for(TarjetaControlDetalle tarjetaControlDetalle:tarjetaControlDetalles){
			if(tarjetaControlDetalle.getTaCoDeCodEnvioMovil()<=0){
				codEnvio=this.UpdateTarjetaControlDetalleOfMovil(tarjetaControlDetalle.getTaCoDeId(), tarjetaControlDetalle);
				tarjetaControlDetalle.setTaCoDeCodEnvioMovil(codEnvio);
				_tarjetaControlDetalles.add(tarjetaControlDetalle);
			}
		}
		return _tarjetaControlDetalles;
	}
	public void DeleteTarjetaControlDetalle(int taCoDeId){
		this.tarjetaControlDetalleDao.deleteById(taCoDeId);
	}
	public void DeleteTarjetaControlDetalleBytaCoId(int taCoId){
		 this.tarjetaControlDetalleDao.deleteByTaCoId(taCoId);
	}

	//Asigna la tarjeta de control a un bus
	public void AsignarTarjetaControl(TarjetaControl tarjetaControl, boolean tarjetaMulti){
		//Primero guardamos la tarjeta de controlCabecera
		TarjetaControl _tarjetaControl=null;
		TarjetaControlDetalle _tarjetaControlDetalle=null;
		
		List<PuntoControlDetalle> _puntoControlDetalle=null; 
		
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
			transaction.begin();
				
			_tarjetaControl=this.tarjetaControlDao.createReturn(tarjetaControl);	
			int puCoId=_tarjetaControl.getPuCoId();
			
			//Buscamos los puntos de control detalle para obtener todo el detalle
			_puntoControlDetalle=rutaService.getAllPuntoControlDetalleByPuCo(puCoId);
			/*insertamos en la tabla tarjetacontroldetalle*/
			//solamente guardamos si asignado=1, mas no si es 2 y 3 que son ausente y sancionado
			if (_tarjetaControl.getTaCoAsignado().compareTo("1")==0){
				Calendar cal = Calendar.getInstance();
				int _minuto=0,_segundo=0,_hora=0;
				//int _sumaMinutos=0;
				Date _puCoHora=null;
				Date _horaInicio=_tarjetaControl.getTaCoHoraSalida();
				Date _horaInicio2;
				// ordenamos en forma ascendente de acuerdo al campo orden
				Collections.sort(_puntoControlDetalle, new Comparator<PuntoControlDetalle>() {		               
		            public int compare(PuntoControlDetalle lhs, PuntoControlDetalle rhs) {
		                // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
		                return lhs.getPuCoDeOrden() < rhs.getPuCoDeOrden() ? -1 : (lhs.getPuCoDeOrden() > rhs.getPuCoDeOrden() ) ? 1 : 0;
		            }
		        });
				
				//Sumanos una hora creo q es un problema del java no se pero le voy a sumar
				cal.setTime(_horaInicio);
				//cal.add(Calendar.HOUR, 1);		
				_horaInicio2=cal.getTime();
				
				for(int i=0;i<_puntoControlDetalle.size();i++ ){
							
					//volvemos a asignar hora de inicio
					_horaInicio=_horaInicio2;
					
					//agregamos los valore sdel punto de control
					_puCoHora=_puntoControlDetalle.get(i).getPuCoDeHora();
							
					cal.setTime(_puCoHora);
					_minuto=cal.get(Calendar.MINUTE);			
					_segundo=cal.get(Calendar.SECOND);
					_hora=cal.get(Calendar.HOUR);
					
					cal.setTime(_horaInicio);
					cal.add(Calendar.MINUTE, _minuto); // agrega 20 minutos
					cal.add(Calendar.SECOND, _segundo);
					cal.add(Calendar.HOUR, _hora);
					
					_horaInicio=cal.getTime();
					//_sumaMinutos=_sumaMinutos+_minuto;
					_tarjetaControlDetalle=new TarjetaControlDetalle();
					_tarjetaControlDetalle.setTaCoId(_tarjetaControl.getTaCoId());
					_tarjetaControlDetalle.setPuCoDeId(_puntoControlDetalle.get(i).getPuCoDeId());
					_tarjetaControlDetalle.setTaCoDeFecha(null);
					_tarjetaControlDetalle.setTaCoDeHora(_horaInicio);
					_tarjetaControlDetalle.setTaCoDeLatitud(0);
					_tarjetaControlDetalle.setTaCoDeLongitud(0);
					_tarjetaControlDetalle.setTaCoDeTiempo(null);
					_tarjetaControlDetalle.setTaCoDeDescripcion(_puntoControlDetalle.get(i).getPuCoDeDescripcion());
					_tarjetaControlDetalle.setUsId(_puntoControlDetalle.get(i).getUsId());
					_tarjetaControlDetalle.setUsFechaReg(new Date());
					this.tarjetaControlDetalleDao.create(_tarjetaControlDetalle);	
				
				}		
				//this.ActualizarEstadoTarjetaProgramacionDetalle(_tarjetaControl, true); esto ya se quito el asignado se maneja en la tarjeta
				//Esto verifica y termina una vuelta
			}
			//solo termina vuelta si no es tarjeta multiple
			//if(!tarjetaMulti)
				this.TerminarVuelta(_tarjetaControl.getReDiDeId());	
			transaction.commit();
		}		
		catch(Exception ex ){
			transaction.rollback();
			throw new RuntimeException(ex);
		}
		finally{
			entityManager.close();
		}	
		
	}
	public void AsignarTarjetaMultiple(TarjetaControl tarjetaControl, Date reten1,Date reten2,boolean tarjetaMulti ){
		TarjetaControl _tarjetaControl=null;
		_tarjetaControl=tarjetaControl;
		//primero obteniendo la vuelta actual
		RegistroDiarioDetalle _registroDiarioDetalle=null;	
		RegistroDiario _registroDiario=null;
		//Calendar cal = Calendar.getInstance();
		_registroDiarioDetalle=registroDiarioService.findOneRegistroDiarioDetalle(_tarjetaControl.getReDiDeId());
		//Verificamos que sea la la vuelta actual
		if (_registroDiarioDetalle.getReDiDeEstado().compareTo("02")==1) //osea no es igual
			throw new ArithmeticException("La vuelta debe ser la de estado actual");		
		_registroDiario=registroDiarioService.findOne(_registroDiarioDetalle.getReDiId());
		//Obtenemos el tiempo de la vuelta
		Date timeVuelta=null;
		PuntoControl _puntoControl=null;
		_puntoControl=rutaService.findOnePuntoControl(_tarjetaControl.getPuCoId());
		timeVuelta=_puntoControl.getPuCoTiempoBus();
		//Obteneniendo el IDProgramacionDetalle paraguardarlo en reten
		int _prDeId=0;
		List<ProgramacionDetalle> _programacionDetalles=null;
		_programacionDetalles= this.programacionService.getAllProgramacionDetalleByPrFecha(_tarjetaControl.getPrId(),_registroDiario.getReDiFeha());
		for(ProgramacionDetalle programacionDetalle: _programacionDetalles){
			if (programacionDetalle.getBuId()==_tarjetaControl.getBuId()){
				_prDeId=programacionDetalle.getPrDeId();
				break;
			}
		}
		Calendar cal = Calendar.getInstance();
		Date _tiempoSalida=null; //this.TaCoHoraSalida;
		Date _tiempoTiempoVuelta=_puntoControl.getPuCoTiempoBus();
		Date _tiempoReten=null;
		Date _tiempoLlegada=null;
		int _minuto=0,_segundo=0,_hora=0;
		int _minutoVuelta=0,_segundoVuelta=0,_horaVuelta=0;
		int _nroVuelta=_registroDiarioDetalle.getReDiDeNroVuelta();
		int _reDiDeId=_registroDiarioDetalle.getReDiDeId();
		
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
			transaction.begin();
		
			for(int i=1;i<=tarjetaControl.getTaCoCountMultiple();i++){
				//si es el prime se agrega la tarjeta como lo envia 
				if (i<=1){
					 _tiempoSalida=_tarjetaControl.getTaCoHoraSalida();
					_tiempoReten=reten2;//segunindican sies la primera tarjeta el reten es diferente	
					//_tarjetaControl.setTaCoTiempoReten(_tiempoReten);
				}
				else
				{	//pero si es mas de 1 tonces se incrementa en la tarjeta la hora de reten
					//mas el nro de vualta y 
					_tiempoSalida= _tiempoLlegada;
					_tiempoReten=reten2;//de la segunda a mas vuelta el reten es otro
					_tarjetaControl=new TarjetaControl();
					_tarjetaControl.setTaCoId(0);
					_tarjetaControl.setPuCoId(tarjetaControl.getPuCoId());
					_tarjetaControl.setRuId(tarjetaControl.getRuId());
					_tarjetaControl.setBuId(tarjetaControl.getBuId());
					_tarjetaControl.setTaCoFecha(tarjetaControl.getTaCoFecha());
					_tarjetaControl.setTaCoHoraSalida(_tiempoSalida);
					_tarjetaControl.setUsId(tarjetaControl.getUsId());
					_tarjetaControl.setUsFechaReg(tarjetaControl.getUsFechaReg());
					_tarjetaControl.setTaCoNroVuelta(_nroVuelta);
					_tarjetaControl.setPrId(tarjetaControl.getPrId());
					_tarjetaControl.setTiSaId(tarjetaControl.getTiSaId());
					_tarjetaControl.setTaCoAsignado(tarjetaControl.getTaCoAsignado());
					_tarjetaControl.setTaCoTipoHoraSalida(tarjetaControl.getTaCoTipoHoraSalida());
					_tarjetaControl.setReDiDeId(_reDiDeId);
					_tarjetaControl.setTaCoFinish(tarjetaControl.getTaCoFinish());
					_tarjetaControl.setTaCoMultiple(tarjetaControl.getTaCoMultiple());
					_tarjetaControl.setTaCoCodEnvioMovil(tarjetaControl.getTaCoCodEnvioMovil());				
					_tarjetaControl.setTaCoTiempoReten(_tiempoReten);
				}
				
				//Agregamos el tiempo reten a tiemposalida
				cal.setTime(_tiempoReten);
				_minuto=cal.get(Calendar.MINUTE);			
				_segundo=cal.get(Calendar.SECOND);
				_hora=cal.get(Calendar.HOUR);
				cal.setTime(_tiempoSalida);
				cal.add(Calendar.MINUTE, _minuto); // agrega 20 minutos
				cal.add(Calendar.SECOND, _segundo);
				cal.add(Calendar.HOUR, _hora);
				_tiempoSalida=cal.getTime();
				//agregamos el tiempo de la vuelta
				cal.setTime(_tiempoTiempoVuelta);
				_minuto=cal.get(Calendar.MINUTE);			
				_segundo=cal.get(Calendar.SECOND);
				_hora=cal.get(Calendar.HOUR);
				cal.setTime(_tiempoSalida);
				cal.add(Calendar.MINUTE, _minuto); // agrega 20 minutos
				cal.add(Calendar.SECOND, _segundo);
				cal.add(Calendar.HOUR, _hora);
				_tiempoSalida=cal.getTime();
				_tiempoLlegada=_tiempoSalida;
				
				this.AsignarTarjetaControl(_tarjetaControl, tarjetaMulti);
				//Registramos el reten
				/*RegistroReten _registroReten=new RegistroReten();
				_registroReten.setReReId(0);
				_registroReten.setPrDeId(_prDeId);
				_registroReten.setReDiDeId(_reDiDeId);
				_registroReten.setReReTiempo(_tiempoReten);
				_registroReten.setUsId(tarjetaControl.getUsId());
				_registroReten.setUsFechaReg(new Date());
				registroDiarioService.SaveRegistroReten(_registroReten);*/
				
				_nroVuelta=_nroVuelta+1;
				_reDiDeId=_reDiDeId+1;		
				
			}
			transaction.commit();
		}
		catch(Exception ex ){
			transaction.rollback();
			throw new RuntimeException(ex);
		}
		finally{
			entityManager.close();
		}	
	}
	public void TerminarVuelta(int reDiDeId){
		//primero obteniendo la vuelta actual
		RegistroDiarioDetalle _registroDiarioDetalle=null;	
		RegistroDiario _registroDiario=null;
		Calendar cal = Calendar.getInstance();
		_registroDiarioDetalle=registroDiarioService.findOneRegistroDiarioDetalle(reDiDeId);
		//Verificamos que sea la la vuelta actual
		if (_registroDiarioDetalle.getReDiDeEstado().compareTo("02")==1) //osea no es igual
			throw new ArithmeticException("La vuelta debe ser la de estado actual");
		
		_registroDiario=registroDiarioService.findOne(_registroDiarioDetalle.getReDiId());
		
		//obteniendo las tarejtas para una fecha especificada
		List<Usp_S_TaCoGetAllTarjetaControlByBuIdFecha> _tarjetaControls=null;
		_tarjetaControls=this.Usp_S_TaCoGetAllTarjetaControlByBuIdFecha(_registroDiario.getEmId(),0, _registroDiario.getReDiFeha());
		//filtramos eliminando a los que son diferentes a tarjetaControl.getReDiDeId()
		//este codigo filtra y el resultado lo devuelve en _tarjetaControls
		Iterator<Usp_S_TaCoGetAllTarjetaControlByBuIdFecha> it = _tarjetaControls.iterator();
		while (it.hasNext()) {
			Usp_S_TaCoGetAllTarjetaControlByBuIdFecha current = it.next();
		    if (current.getReDiDeId()!=reDiDeId) {
		        it.remove();
		    }
		}
		/*for (Iterator<TarjetaControl> it=tarjetaControls.iterator(); it.hasNext();) {
		    if (!it.next()..contains("How"))
		        it.remove(); // NOTE: Iterator's remove method, not ArrayList's, is used.
		}*/
		 
		//Obteneniendo la programacion detalle para una fecha especifica
		List<ProgramacionDetalle> _programacionDetalles=null;
		_programacionDetalles= this.programacionService.getAllProgramacionDetalleByPrFecha(_tarjetaControls.get(0).getPrId(),_registroDiario.getReDiFeha());
		int count=_tarjetaControls.size();
		int c=1,sw=0;
		if (_programacionDetalles.size()>0){ //sii es que no tinene programacion entonces es registro sin programacion
			
			//verificamos que de acuerdo a los buses de la programacion se hayan creado tarjetas
			for(ProgramacionDetalle programacionDetalle: _programacionDetalles){	
				c=0;
				for(Usp_S_TaCoGetAllTarjetaControlByBuIdFecha tarejetaControl: _tarjetaControls){
					if(programacionDetalle.getBuId()==tarejetaControl.getBuId())
						break;
					else
						c=c+1;
				}
				if (c==count){
					//no esta completo la tarteta tons se activa sw=1			
					sw=1;
					break;
				}
				
			}
		}else
		{
			//buscamos los buses activos
			List<Bus> _busActivos=this.busService.GetAllBusActivo(_registroDiario.getEmId());
			for(Bus bus:_busActivos){
				c=0;
				for(Usp_S_TaCoGetAllTarjetaControlByBuIdFecha tarejetaControl: _tarjetaControls){
					if(bus.getBuId()==tarejetaControl.getBuId())
						break;
					else
						c=c+1;
				}
				if (c==count){
					//no esta completo la tarteta tons se activa sw=1			
					sw=1;
					break;
				}
			}
			
		}
		if (sw==0 & _registroDiario.getReDiTotalVuelta()!=_registroDiarioDetalle.getReDiDeNroVuelta())  {
			//si es 0 entonces guardamos
			this.TerminarVueltaBD(_registroDiarioDetalle,_programacionDetalles);
		}
	}
	private void TerminarVueltaBD(RegistroDiarioDetalle _registroDiarioDetalle,List<ProgramacionDetalle> _programacionDetalles){
		//Actualizamos a la siguiente vuelta
		_registroDiarioDetalle.setReDiDeEstado("03");
		registroDiarioService.SaveRegistroDiarioDetalle(_registroDiarioDetalle);
		int idregistro=_registroDiarioDetalle.getReDiDeId();
		//avanzamos a la sgte vuelta
		idregistro=idregistro+1;
		_registroDiarioDetalle=null;
		_registroDiarioDetalle=registroDiarioService.findOneRegistroDiarioDetalle(idregistro);
		_registroDiarioDetalle.setReDiDeEstado("02");
		registroDiarioService.SaveRegistroDiarioDetalle(_registroDiarioDetalle);
		//Reseteamos programacion detalle a 0			
		for(ProgramacionDetalle programacionDetalle: _programacionDetalles){
			//programacionDetalle= new ProgramacionDetalle();
			//programacionDetalle.setPrId(tarjetaControl.getPrId());
			programacionDetalle.setPrDeCountVuelta((short)0);
			programacionDetalle.setPrDeAsignadoTarjeta((short)0);
			//programacionDetalle.setPrDeId(_prDeId);
			
			this.programacionService.UpdateFieldProgramacionDetalle(programacionDetalle);
		}
	}
	
	//Esto ya se usa xq ya se maneja en la tarejeta
	private void ActualizarEstadoTarjetaProgramacionDetalle(TarjetaControl tarjetaControl,Boolean asignado){
		//actualizamos la tabla programacionDetalle asignar tarta y contador de vueltas
		ProgramacionDetalle _programacionDetalle=null;
		Calendar cal = Calendar.getInstance();
			int _prDeAsignadoTarjeta=0;
			int _prDeCountVuelta=0;
			int _prDeId=0;
			List<ProgramacionDetalle> _programacionDetalles=new ArrayList<ProgramacionDetalle>();
			cal.setTime(tarjetaControl.getTaCoFecha());
			cal.add(Calendar.DAY_OF_MONTH, 1);
				
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String fecha2=formatter.format(cal.getTime());

			_programacionDetalles=this.programacionService.getAllProgramacionDetalleByPrFecha(tarjetaControl.getPrId(),cal.getTime());
			for(ProgramacionDetalle programacionDetalle: _programacionDetalles){
				if(programacionDetalle.getBuId()==tarjetaControl.getBuId()){
					//_prDeAsignadoTarjeta=programacionDetalle.getPrDeAsignadoTarjeta();
					_prDeCountVuelta=programacionDetalle.getPrDeCountVuelta();
					_prDeId=programacionDetalle.getPrDeId();
				}
			}
			if (asignado){
			_prDeCountVuelta=_prDeCountVuelta+1;
			_prDeAsignadoTarjeta=1;
			}
			else{
				_prDeCountVuelta=_prDeCountVuelta-1;
				_prDeAsignadoTarjeta=0;	
			}
			
			_programacionDetalle= new ProgramacionDetalle();
			_programacionDetalle.setPrId(tarjetaControl.getPrId());
			_programacionDetalle.setPrDeCountVuelta((short)_prDeCountVuelta);
			_programacionDetalle.setPrDeAsignadoTarjeta((short)_prDeAsignadoTarjeta);
			_programacionDetalle.setPrDeId(_prDeId);
			
			this.programacionService.UpdateFieldProgramacionDetalle(_programacionDetalle);
	}
	
	
	//TiempoSalida
	public List<TiempoSalida> findAllTiempoSalida(){
		return tiempoSalidaDao.findAll();
	}
	public TiempoSalida findOneTiempoSalida(int tiSaId){
		return tiempoSalidaDao.findOne(tiSaId);
	}
	public List<TiempoSalida> GetAllTiempoSalidaByEm(int emId){
		return tiempoSalidaDao.GetAllTiempoSalidaByEm(emId);
	}
	public List<TiempoSalida> GetValorSalidaByEmBu(int emId,int buId){
		return tiempoSalidaDao.GetValorSalidaByEmBu(emId,buId);
	}
	public void DeleteTiempoSalida(int tiSaId){
		this.tiempoSalidaDao.deleteById(tiSaId);
	}
	//void DeleteBusPersonaByBu(int buId);
	public void SaveTiempoSalida(TiempoSalida tiempoSalida){
		if (tiempoSalida.getTiSaId()>0)
		{
			this.tiempoSalidaDao.update(tiempoSalida);
		}
		else
		{			
			tiempoSalida.setUsFechaReg(new Date());
			this.tiempoSalidaDao.create(tiempoSalida);
		}
	}
	//TiempoProgramado	
	public List<TiempoProgramado> findAllTiempoProgramado(){
		return tiempoProgramadoDao.findAll();
	}
	
	public List<Usp_S_TiPrGetAllTiempoProgramadoByTiSa> GetAllTiempoProgramadoByTiSa(int tiSaId){
		return tiempoProgramadoDao.GetAllTiempoProgramadoByTiSa(tiSaId);
	}
	public TiempoProgramado findOneTiempoProgramado(int tiPrId){
		return tiempoProgramadoDao.findOne(tiPrId);
	}	
	public void DeleteTiempoProgramado(int tiPrId){
		this.tiempoProgramadoDao.deleteById(tiPrId);
	}	
	//void DeleteBusPersonaByBu(int buId);
	public void SaveTiempoProgramado(TiempoProgramado tiempoProgramado){
		if (tiempoProgramado.getTiSaId()>0)
		{
			this.tiempoProgramadoDao.update(tiempoProgramado);
		}
		else
		{			
			tiempoProgramado.setUsFechaReg(new Date());
			this.tiempoProgramadoDao.create(tiempoProgramado);
		}
	}
	//Georeferencia
	public Georeferencia findOneGeoreferencia(int id){		
		return georeferenciaDao.findOne(id);
	}
    public List<Georeferencia> GetAllGeoreferenciaByTaCo(int taCoId){
    	return georeferenciaDao.GetAllGeoreferenciaByTaCo(taCoId);
    }
    /*Este procedimiento permite guardar desde el movil, al finalizar la vuelta, 
     * si ya existe es orque lo guardo en linea  si no lo guarda */
    public void SaveGeoreferenciaOfMovil(List<Georeferencia> georeferencias){
    	//primero buscamos si existe
    	Georeferencia _georeferencia=null;
    	for(Georeferencia georeferencia: georeferencias){
    		_georeferencia=null;
    		_georeferencia=georeferenciaDao.findOne(georeferencia.getGeId());
    		if(_georeferencia.getGeId()>0){
    			//this.georeferenciaDao.update(georeferencia);
    		}
    		else
    		{
    			georeferencia.setUsFechaReg(new Date());
    			this.georeferenciaDao.create(georeferencia);
    		}
    	}
    	
    }
  /*  public int CreateGeoreferenciaOneOfMovil(Georeferencia georeferencia){
    	Georeferencia _georeferencia=null;
    	_georeferencia=this.georeferenciaDao.createReturn(georeferencia);
    	return _georeferencia.getGeId();
    }*/
    public void SaveGeoreferencia(Georeferencia georeferencia){
    	if (georeferencia.getGeId()>0)
		{
			this.georeferenciaDao.update(georeferencia);
		}
		else
		{			
			georeferencia.setUsFechaReg(new Date());
			this.georeferenciaDao.create(georeferencia);
		}
    }
    public Georeferencia createReturnGeoreferencia(Georeferencia georeferencia){
    	georeferencia.setUsFechaReg(new Date());
    	return georeferenciaDao.createReturn(georeferencia);
    }
    public void deleteGeoreferenciaById(int geId){
    	this.georeferenciaDao.deleteById(geId);
    }
    public void Usp_D_GeEliminaByTaCo(int taCoId){
    	this.georeferenciaDao.Usp_D_GeEliminaByTaCo(taCoId);
    }
	
}
