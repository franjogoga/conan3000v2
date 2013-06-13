package IngSoft.venta.bean;

import java.io.Serializable;
import java.util.Date;


public class EgresoBeanData implements Serializable {
	
	private String idEgreso;
	private String descripcion;
	private Double montoTotal;
	private Integer cantidad;
	private Date fechaPago;
	private String Estado;
	private String idConcepto;
	
	
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
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public String getIdConcepto() {
		return idConcepto;
	}
	public void setIdConcepto(String idConcepto) {
		this.idConcepto = idConcepto;
	}
	



}
