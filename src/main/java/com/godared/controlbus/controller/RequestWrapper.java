package com.godared.controlbus.controller;

import java.util.List;

import com.godared.controlbus.bean.Programacion;
import com.godared.controlbus.bean.ProgramacionDetalle;
import com.godared.controlbus.bean.PuntoControl;
import com.godared.controlbus.bean.PuntoControlDetalle;
import com.godared.controlbus.bean.Ruta;
import com.godared.controlbus.bean.RutaDetalle;
import com.godared.controlbus.bean.TarjetaControl;
import com.godared.controlbus.bean.TarjetaControlDetalle;

public class RequestWrapper {
	Ruta ruta;
	List<RutaDetalle> rutaDetalle;
	PuntoControl puntoControl;
	List<PuntoControlDetalle> puntoControlDetalle;
	Programacion programacion;
	List<ProgramacionDetalle> programacionDetalle;
	TarjetaControl tarjetaControl;
	List<TarjetaControlDetalle> tarjetaControlDetalle;
	
	public Ruta getRuta() {
		return ruta;
	}
	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}
	public List<RutaDetalle> getRutaDetalle() {
		return rutaDetalle;
	}
	public void setRutaDetalle(List<RutaDetalle> rutaDetalle) {
		this.rutaDetalle = rutaDetalle;
	}
	public PuntoControl getPuntoControl() {
		return puntoControl;
	}
	public void setPuntoControl(PuntoControl puntoControl) {
		this.puntoControl = puntoControl;
	}
	public List<PuntoControlDetalle> getPuntoControlDetalle() {
		return puntoControlDetalle;
	}
	public void setPuntoControlDetalle(List<PuntoControlDetalle> puntoControlDetalle) {
		this.puntoControlDetalle = puntoControlDetalle;
	}
	public Programacion getProgramacion() {
		return programacion;
	}
	public void setProgramacion(Programacion programacion) {
		this.programacion = programacion;
	}
	public List<ProgramacionDetalle> getProgramacionDetalle() {
		return programacionDetalle;
	}
	public void setProgramacionDetalle(List<ProgramacionDetalle> programacionDetalle) {
		this.programacionDetalle = programacionDetalle;
	}
	public TarjetaControl getTarjetaControl() {
		return tarjetaControl;
	}
	public void setTarjetaControl(TarjetaControl tarjetaControl) {
		this.tarjetaControl = tarjetaControl;
	}
	public List<TarjetaControlDetalle> getTarjetaControlDetalle() {
		return tarjetaControlDetalle;
	}
	public void setTarjetaControlDetalle(List<TarjetaControlDetalle> tarjetaControlDetalle) {
		this.tarjetaControlDetalle = tarjetaControlDetalle;
	}
	

}
