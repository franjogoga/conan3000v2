package IngSoft.administracion.bean;

import java.io.Serializable;

public class ResultadoActividadBeanData implements Serializable{
	private String codigo;
	private String nombre; 
	private String tipoactividad;
	private String estado;
	
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
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