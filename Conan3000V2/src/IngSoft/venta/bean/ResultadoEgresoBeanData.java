package IngSoft.venta.bean;

import java.sql.Date;

public class ResultadoEgresoBeanData {
	private String idEgreso;
	private String descripcion;
	private String idConcepto;
	private Double montoTotal;
	private Integer cantidad;
	private Date fechaPago;
	private String estado;
	private String idSocio;
	private String socio;
	
	
	public String getIdEgreso() {
		return idEgreso;
	}
	public void setIdEgreso(String idEgreso) {
		this.idEgreso = idEgreso;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getIdConcepto() {
		return idConcepto;
	}
	public void setIdConcepto(String idConcepto) {
		this.idConcepto = idConcepto;
	}
	public Double getMontoTotal() {
		return montoTotal;
	}
	public void setMontoTotal(Double montoTotal) {
		this.montoTotal = montoTotal;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getIdSocio() {
		return idSocio;
	}
	public void setIdSocio(String idSocio) {
		this.idSocio = idSocio;
	}
	public String getSocio() {
		return socio;
	}
	public void setSocio(String socio) {
		this.socio = socio;
	}
	
	
	

}
