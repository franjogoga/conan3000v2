package IngSoft.venta.bean;

import java.io.Serializable;
import java.util.Date;


public class PagoBeanData implements Serializable {
	

	
	private String idIngreso;
	private Date fechaPago;
	private String solicitudCambio;
	private String motivo;
	private String respuesta;
	private String estadoSolicitudCambio;
	private String estado;
	private String estadoCuota;
	private Double montoTotal;
	private String idCuota;
	private String idProducto;
	private Double monto;
	private Date fechaEmision;
	private Date fechaVencimiento;
	private String descripcion;
	private String estadoOtroIngreso;
	private String idSocio;
	private String socio;
	private String idConcepto;
	private Integer cantidad;
	private Integer numCuota;
	
	
	
	
	
	public Integer getNumCuota() {
		return numCuota;
	}

	public void setNumCuota(Integer numCuota) {
		this.numCuota = numCuota;
	}

	public String getEstadoCuota() {
		return estadoCuota;
	}

	public void setEstadoCuota(String estadoCuota) {
		this.estadoCuota = estadoCuota;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getIdCuota() {
		return idCuota;
	}

	public void setIdCuota(String idCuota) {
		this.idCuota = idCuota;
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


	
	
	
	public String getIdConcepto() {
		return idConcepto;
	}

	public void setIdConcepto(String idConcepto) {
		this.idConcepto = idConcepto;
	}

	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstadoOtroIngreso() {
		return estadoOtroIngreso;
	}

	public void setEstadoOtroIngreso(String estadoOtroIngreso) {
		this.estadoOtroIngreso = estadoOtroIngreso;
	}

	public void setMontoTotal(Double montoTotal) {
		this.montoTotal = montoTotal;
	}

	public String getIdIngreso() {
		return idIngreso;
	}
	
	public void setIdIngreso(String idIngreso) {
		this.idIngreso=idIngreso;
	}
	
	public Date getFechaPago() {
		return fechaPago;
	}
	
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	
	public String getSolicitudCambio() {
		return solicitudCambio;
	}
	
	public void setSolicitudCambio(String solicitudCambio) {
		this.solicitudCambio = solicitudCambio;
	}
	
	
	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	
	
	public String getEstadoSolicitudCambio() {
		return estadoSolicitudCambio;
	}
	
	public void setEstadoSolicitudCambio(String estadoSolicitudCambio) {
		this.estadoSolicitudCambio = estadoSolicitudCambio;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Double getMontoTotal() {
		return montoTotal;
	}
	
	public void setMontoTotal(String montoTotal) {
		this.estado = montoTotal;
	}
	
	
}
