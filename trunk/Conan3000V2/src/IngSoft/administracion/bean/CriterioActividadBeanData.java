package IngSoft.administracion.bean;

import java.io.Serializable;
import java.sql.Date;

public class CriterioActividadBeanData implements Serializable{
	private String nombre; 
	private String tipoactividad;
	private String estado;
	
	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipoactividad() {
		return tipoactividad;
	}
	public void setTipoactividad(String tipoactividad) {
		this.tipoactividad = tipoactividad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	

	



}
