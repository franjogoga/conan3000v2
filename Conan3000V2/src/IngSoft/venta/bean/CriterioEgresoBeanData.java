package IngSoft.venta.bean;

import java.io.Serializable;
import java.util.Date;

public class CriterioEgresoBeanData implements Serializable{
	
	private String codigo;
	private String codigoSocio;
	private String nombre;
	private Date fechaPagoIni;
	private Date fechaPagoFin;
	private String estado;
	private String descripcion;
	private Double montoTotal;
	
	
	
	public Double getMontoTotal() {
		return montoTotal;
	}
	public void setMontoTotal(Double montoTotal) {
		this.montoTotal = montoTotal;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getCodigoSocio() {
		return codigoSocio;
	}
	public void setCodigoSocio(String codigoSocio) {
		this.codigoSocio = codigoSocio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaPagoIni() {
		return fechaPagoIni;
	}
	public void setFechaPagoIni(Date fechaPagoIni) {
		this.fechaPagoIni = fechaPagoIni;
	}
	public Date getFechaPagoFin() {
		return fechaPagoFin;
	}
	public void setFechaPagoFin(Date fechaPagoFin) {
		this.fechaPagoFin = fechaPagoFin;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
		
	
}