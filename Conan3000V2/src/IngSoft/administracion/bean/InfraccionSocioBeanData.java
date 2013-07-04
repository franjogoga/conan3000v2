package IngSoft.administracion.bean;

import java.io.Serializable;

public class InfraccionSocioBeanData implements Serializable {
	String codigo;
	String codigosocio;
	Double montomulta;
	String descripcion;
	String fechainicio;
	String fechafin;
	String estado;
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getCodigosocio() {
		return codigosocio;
	}
	public void setCodigosocio(String codigosocio) {
		this.codigosocio = codigosocio;
	}
	public Double getMontomulta() {
		return montomulta;
	}
	public void setMontomulta(Double montomulta) {
		this.montomulta = montomulta;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFechainicio() {
		return fechainicio;
	}
	public void setFechainicio(String fechainicio) {
		this.fechainicio = fechainicio;
	}
	public String getFechafin() {
		return fechafin;
	}
	public void setFechafin(String fechafin) {
		this.fechafin = fechafin;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}