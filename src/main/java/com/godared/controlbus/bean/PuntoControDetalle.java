package com.godared.controlbus.bean;

import java.util.Date;

import javax.persistence.Entity;
@Entity
public class PuntoControDetalle {
	private int PuCoDeId;
	private int PuCoId;
	private double PuCoDeLatitud;
	private double PuCoDeLongitud;
	private String PuCoDeDescripcion;
	private Date PuCoDeHora;
	private int UsId;
	private Date UsFechaReg;
	
}
