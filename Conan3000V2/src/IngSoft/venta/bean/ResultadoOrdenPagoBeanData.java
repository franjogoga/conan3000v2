package IngSoft.venta.bean;

import java.io.Serializable;
import java.util.Date;

public class ResultadoOrdenPagoBeanData implements Serializable {
	
	private String idPago;
	private String idSocio;
	private String idCuota;
	private String socio;
	private Date fechaEmision;
	private Date fechaVencimiento;
	private Date fechaPago;
	private String concepto;
	private String estado;
	private Double monto;
	
	private Integer numCuota;
	private Integer cantidad;
	private String estadoCuota;
	
	
	
	
	public String getIdCuota() {
		return idCuota;
	}
	public void setIdCuota(String idCuota) {
		this.idCuota = idCuota;
	}
	public Integer getNumCuota() {
		return numCuota;
	}
	public void setNumCuota(Integer numCuota) {
		this.numCuota = numCuota;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public String getEstadoCuota() {
		return estadoCuota;
	}
	public void setEstadoCuota(String estadoCuota) {
		this.estadoCuota = estadoCuota;
	}
	public String getIdSocio() {
		return idSocio;
	}
	public void setIdSocio(String idSocio) {
		this.idSocio = idSocio;
	}
	
	public String getIdPago() {
		return idPago;
	}
	public void setIdPago(String idPago) {
		this.idPago = idPago;
	}
	public String getSocio() {
		return socio;
	}
	public void setSocio(String socio) {
		this.socio = socio;
	}
	public Date getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	
		
}
