package com.godared.controlbus.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.persistence.Convert;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.godared.controlbus.bean.ProgramacionDetalle;
import com.godared.controlbus.bean.PuntoControlDetalle;
import com.godared.controlbus.bean.TarjetaControl;
import com.godared.controlbus.bean.TarjetaControlDetalle;
import com.godared.controlbus.bean.TiempoProgramado;
import com.godared.controlbus.bean.TiempoSalida;
import com.godared.controlbus.bean.Usp_S_RuGetAllRutaByEm;
import com.godared.controlbus.bean.Usp_S_TaCoGetAllTarjetaControlByEmPuCo;
import com.godared.controlbus.bean.Usp_S_TiPrGetAllTiempoProgramadoByTiSa;
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
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	@Autowired
	IRutaService rutaService;
	@Autowired
	IProgramacionService programacionService;
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
	
	public List<TarjetaControl> findAll() {
		// TODO Auto-generated method stub
		return tarjetaControlDao.findAll();
	}

	public TarjetaControl findOne(int id) {
		// TODO Auto-generated method stub
		return tarjetaControlDao.findOne(id);
	}
	public List<TarjetaControl> Usp_S_TaCoGetAllTarjetaControlByBuIdFecha(int buId,Date taCoFecha){
		return tarjetaControlDao.Usp_S_TaCoGetAllTarjetaControlByBuIdFecha(buId,taCoFecha);
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
	public void Delete(int id){
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try{
			transaction.begin();
			TarjetaControl tarjetaControl;
			tarjetaControl=this.findOne(id);
			this.DeleteTarjetaControlDetalleBytaCoId(id);
			this.tarjetaControlDao.deleteById(id);
			
			this.ActualizarEstadoTarjetaProgramacionDetalle(tarjetaControl, false);
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
	public List<Usp_S_TaCoGetAllTarjetaControlByEmPuCo> GetAllTarjetaControlByEmPuCo(int emId,int puCoId){
		return tarjetaControlDao.GetAllTarjetaControlByEmPuCo(emId,puCoId);
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
	public void UpdateTarjetaControlDetalleOfMovil(int taCoDeId,TarjetaControlDetalle tarjetaControlDetalle){
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
			this.tarjetaControlDetalleDao.update(_tarjetaControlDetalle);	
	}
	public void DeleteTarjetaControlDetalle(int taCoDeId){
		this.tarjetaControlDetalleDao.deleteById(taCoDeId);
	}
	public void DeleteTarjetaControlDetalleBytaCoId(int taCoId){
		 this.tarjetaControlDetalleDao.deleteByTaCoId(taCoId);
	}
	//Asigna la tarjeta de control a un bus

	public void AsignarTarjetaControl(TarjetaControl tarjetaControl){
		//Primero guardamos la tarjeta de controlCabecera
		TarjetaControl _tarjetaControl=null;
		TarjetaControlDetalle _tarjetaControlDetalle=null;
		
		List<PuntoControlDetalle> _puntoControlDetalle=null; 
		_tarjetaControl=this.tarjetaControlDao.createReturn(tarjetaControl);	
		int puCoId=_tarjetaControl.getPuCoId();
		
		//Buscamos los puntos de control detalle para obtener todo el detalle
		_puntoControlDetalle=rutaService.getAllPuntoControlDetalleByPuCo(puCoId);
		/*insertamos en la tabla tarjetacontroldetalle*/
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
		cal.add(Calendar.HOUR, 1);		
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
			this.ActualizarEstadoTarjetaProgramacionDetalle(_tarjetaControl, true);
					
		}
		
	}
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
	
}
