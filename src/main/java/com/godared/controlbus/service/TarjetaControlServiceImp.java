package com.godared.controlbus.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.godared.controlbus.bean.TarjetaControl;
import com.godared.controlbus.bean.TarjetaControlDetalle;
import com.godared.controlbus.bean.Usp_S_RuGetAllRutaByEm;
import com.godared.controlbus.bean.Usp_S_TaCoGetAllTarjetaControlByEmPuCo;
import com.godared.controlbus.dao.ITarjetaControlDao;
import com.godared.controlbus.dao.ITarjetaControlDetalleDao;

@Service
@Transactional
public class TarjetaControlServiceImp implements ITarjetaControlService{
	private ITarjetaControlDao tarjetaControlDao;
	private ITarjetaControlDetalleDao tarjetaControlDetalleDao;
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	//	injeccion de dependencias
	public void setTarjetaControlDao(ITarjetaControlDao tarjetaControlDao) {
		 this.tarjetaControlDao = tarjetaControlDao;
		 
	}
	public void setTarjetaControlDetalleDao(ITarjetaControlDetalleDao tarjetaControlDetalleDao) {
		 this.tarjetaControlDetalleDao = tarjetaControlDetalleDao;
		 
	}
	public List<TarjetaControl> findAll() {
		// TODO Auto-generated method stub
		return tarjetaControlDao.findAll();
	}

	public TarjetaControl findOne(int id) {
		// TODO Auto-generated method stub
		return tarjetaControlDao.findOne(id);
	}
	public void Save(TarjetaControl tarjetaControl){
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {		
			transaction.begin();
			if (tarjetaControl.getRuId()>0)
			{
				tarjetaControl.setUsFechaReg(new Date() );
				this.tarjetaControlDao.update(tarjetaControl);
			}
			else{
				this.tarjetaControlDao.create(tarjetaControl);
			}
		}
		catch(Exception ex){
		    transaction.rollback();
		       throw new RuntimeException(ex);
		}
		finally{
			entityManager.close();
		}
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
			this.DeleteTarjetaControlDetalleBytaCoId(id);
			this.tarjetaControlDao.deleteById(id);
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
	public void UpdateTarjetaControlDetalle(int taCoDeId,TarjetaControlDetalle tarjetaControlDetalle){
		 TarjetaControlDetalle _tarjetaControlDetalle=new TarjetaControlDetalle();
			_tarjetaControlDetalle=findOneTarjetaControlDetalleId(taCoDeId);
			_tarjetaControlDetalle.setPuCoDeId(tarjetaControlDetalle.getPuCoDeId());
			_tarjetaControlDetalle.setTaCoDeFecha(tarjetaControlDetalle.getTaCoDeFecha());
			_tarjetaControlDetalle.setTaCoDeHora(tarjetaControlDetalle.getTaCoDeHora());
			_tarjetaControlDetalle.setTaCoDeLatitud(tarjetaControlDetalle.getTaCoDeLatitud());
			_tarjetaControlDetalle.setTaCoDeLongitud(tarjetaControlDetalle.getTaCoDeLongitud());
			_tarjetaControlDetalle.setTaCoDeTiempo(tarjetaControlDetalle.getTaCoDeTiempo());
			_tarjetaControlDetalle.setTaCoDeDescripcion(tarjetaControlDetalle.getTaCoDeDescripcion());
			_tarjetaControlDetalle.setUsId(tarjetaControlDetalle.getUsId());
			_tarjetaControlDetalle.setUsFechaReg(tarjetaControlDetalle.getUsFechaReg());
			this.tarjetaControlDetalleDao.update(_tarjetaControlDetalle);	
	}
	public void DeleteTarjetaControlDetalle(int taCoDeId){
		this.tarjetaControlDetalleDao.deleteById(taCoDeId);
	}
	public void DeleteTarjetaControlDetalleBytaCoId(int taCoId){
		 this.tarjetaControlDetalleDao.deleteByTaCoId(taCoId);
	 }
	
}
