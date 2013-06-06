package IngSoft.administracion.bean;

import java.io.Serializable;
import java.sql.Date;

public class CriterioEmpleadoBeanData implements Serializable{
	private String nombre; 
	private String apaterno;
	private String puesto;
	private String estado;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApaterno() {
		return apaterno;
	}
	public void setApaterno(String apaterno) {
		this.apaterno = apaterno;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	



}
