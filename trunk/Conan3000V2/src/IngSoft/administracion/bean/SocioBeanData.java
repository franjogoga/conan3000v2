package IngSoft.administracion.bean;

import java.io.Serializable;

public class SocioBeanData implements Serializable{
	private String codigo;
	private String membresia;	
	private String fechaInicio;	
	private String estado;
	private String vitalicio;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getMembresia() {
		return membresia;
	}
	public void setMembresia(String membresia) {
		this.membresia = membresia;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getVitalicio() {
		return vitalicio;
	}
	public void setVitalicio(String vitalicio) {
		this.vitalicio = vitalicio;
	}		
}
