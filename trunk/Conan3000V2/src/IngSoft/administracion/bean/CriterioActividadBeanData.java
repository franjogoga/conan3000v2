package IngSoft.administracion.bean;

import java.io.Serializable;
import java.sql.Date;

public class CriterioActividadBeanData implements Serializable{
	private String nombre; 
	private String tipoactividad;
	private String estado;
	private int vacantes;
	private int inscritos;
	
	
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
	public int getVacantes() {
		return vacantes;
	}
	public void setVacantes(int vacantes) {
		this.vacantes = vacantes;
	}
	public int getInscritos() {
		return inscritos;
	}
	public void setInscritos(int inscritos) {
		this.inscritos = inscritos;
	}
	
	

	



}
