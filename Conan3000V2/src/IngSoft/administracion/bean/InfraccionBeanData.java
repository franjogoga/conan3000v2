package IngSoft.administracion.bean;

import java.io.Serializable;
import java.util.Date;

public class InfraccionBeanData implements Serializable {
	String codigo;
	String codigofamiliar;
	String codigosocio;
	String montomulta;
	String descripcion;
	Date fechainicio;
	Date fechafin;
	String estado;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getCodigofamiliar() {
		return codigofamiliar;
	}
	public void setCodigofamiliar(String codigofamiliar) {
		this.codigofamiliar = codigofamiliar;
	}
	public String getCodigosocio() {
		return codigosocio;
	}
	public void setCodigosocio(String codigosocio) {
		this.codigosocio = codigosocio;
	}
	public String getMontomulta() {
		return montomulta;
	}
	public void setMontomulta(String montomulta) {
		this.montomulta = montomulta;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFechainicio() {
		return fechainicio;
	}
	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}
	public Date getFechafin() {
		return fechafin;
	}
	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	}



	
	
	
	
	
	
	

	

