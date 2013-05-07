package IngSoft.venta.bean;

import java.util.Date;

public class CriterioPromocionBeanData {
	
	private String codigo;
	private String nombre;
	private Date fechaInicio;
	private Date fechaFin;
	private String estado;
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setIdPromocion(String codigo) {
		this.codigo = codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Date getFechaInicio() {
		return fechaInicio;
	}
	
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public Date getFechaFin() {
		return fechaFin;
	}
	
	public void setFechafin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}		
}
