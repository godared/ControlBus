package com.godared.controlbus.controller;

import java.util.List;

import com.godared.controlbus.bean.Ruta;
import com.godared.controlbus.bean.RutaDetalle;

public class RequestWrapper {
	Ruta ruta;
	List<RutaDetalle> rutaDetalle;
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
	

}
