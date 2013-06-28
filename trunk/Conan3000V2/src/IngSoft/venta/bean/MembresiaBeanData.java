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
	
	private Date fechaCreacion;
	private Date fechaEmision;
	private Date fechaVencimiento;
	private Date fechaActual;
	private String idDetalleCuota;
	private Integer cantCuota;
	private String EstadoDetalle;
	private String idCuota;
	private Integer numCuota;
	private Double monto;
	private Integer cantidad;
	private String EstadoCuota;
	private Integer mesIni;
	
	
	
	
	
	
	
	public Date getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual(Date fechaActual) {
		this.fechaActual = fechaActual;
	}

	public Integer getMesIni() {
		return mesIni;
	}

	public void setMesIni(Integer mesIni) {
		this.mesIni = mesIni;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
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

	public String getIdDetalleCuota() {
		return idDetalleCuota;
	}

	public void setIdDetalleCuota(String idDetalleCuota) {
		this.idDetalleCuota = idDetalleCuota;
	}

	public Integer getCantCuota() {
		return cantCuota;
	}

	public void setCantCuota(Integer cantCuota) {
		this.cantCuota = cantCuota;
	}

	public String getEstadoDetalle() {
		return EstadoDetalle;
	}

	public void setEstadoDetalle(String estadoDetalle) {
		EstadoDetalle = estadoDetalle;
	}

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

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getEstadoCuota() {
		return EstadoCuota;
	}

	public void setEstadoCuota(String estadoCuota) {
		EstadoCuota = estadoCuota;
	}

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
