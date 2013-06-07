package IngSoft.venta.bean;

import java.io.Serializable;
import java.util.Date;


public class MembresiaBeanData implements Serializable {
	
	private String idMembresia;
	private String codigo;
	private String socio;
	private String codigoSocio;
	private Date fechaInicio;
	private String descripcion;
	private Date fechaFin;
	private Double costo;
	private String periodo;
	private String estado;
	
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getIdMembresia() {
		return idMembresia;
	}
	
	public void setIdMembresia(String idMembresia) {
		this.idMembresia=idMembresia;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo=codigo;
	}
	
	public String getCodigoSocio() {
		return codigoSocio;
	}
	
	public void setCodigoSocio(String codigoSocio) {
		this.codigoSocio=codigoSocio;
	}
	
	public String getSocio() {
		return socio;
	}
	
	public void setSocio(String socio) {
		this.socio=socio;
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
	
	public Double getCosto() {
		return costo;
	}
	
	public void setCosto(Double costo) {
		this.costo = costo;
	}
	
	public String getPeriodo() {
		return periodo;
	}
	
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}	
}