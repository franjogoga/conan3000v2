
package IngSoft.venta.bean;

import java.io.Serializable;
import java.util.Date;


public class OrdenPagoBeanData implements Serializable {
	
	private String idProducto;
	private Double monto;
	private Date fechaEmision;
	private Date fechaVencimiento;
	private String descripcion;
	private String estadoOtroIngreso;
	private String idSocio;
	private String socio;
	private String idConcepto;
	private String idOtroIngreso;
	private String idIngreso;
	private Date fechaPago;
	
	private String idActividad;
	private String idFamiliar;
	private String idReservaBungalow;
	private String idReservaCancha;
	private String idServAdicional;
	private Date fecha;
	private String idEventoSocio;
	private String idEventoCorp;
	private String idBungalow;
	private String idSorteo;
	private String idEventoSede;
	private String idInvitado;
	private String idMembresiaAnt;
	private String idMembresiaNue;
	private String idSuspensionFalta;
	private String idSolicitudProducto;
	private String idSolicitudServicio;
	private Integer cuota;
	private String descripcionCuota;
	private String periodo;
	private Integer aplicar;
	
	
	
	
	public Integer getAplicar() {
		return aplicar;
	}
	public void setAplicar(Integer aplicar) {
		this.aplicar = aplicar;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public String getDescripcionCuota() {
		return descripcionCuota;
	}
	public void setDescripcionCuota(String descripcionCuota) {
		this.descripcionCuota = descripcionCuota;
	}
	public Integer getCuota() {
		return cuota;
	}
	public void setCuota(Integer cuota) {
		this.cuota = cuota;
	}
	public String getIdIngreso() {
		return idIngreso;
	}
	public void setIdIngreso(String idIngreso) {
		this.idIngreso = idIngreso;
	}
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	public String getIdOtroIngreso() {
		return idOtroIngreso;
	}
	public void setIdOtroIngreso(String idOtroIngreso) {
		this.idOtroIngreso = idOtroIngreso;
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
	public String getIdActividad() {
		return idActividad;
	}
	public void setIdActividad(String idActividad) {
		this.idActividad = idActividad;
	}
	public String getIdFamiliar() {
		return idFamiliar;
	}
	public void setIdFamiliar(String idFamiliar) {
		this.idFamiliar = idFamiliar;
	}
	public String getIdReservaBungalow() {
		return idReservaBungalow;
	}
	public void setIdReservaBungalow(String idReservaBungalow) {
		this.idReservaBungalow = idReservaBungalow;
	}
	public String getIdReservaCancha() {
		return idReservaCancha;
	}
	public void setIdReservaCancha(String idReservaCancha) {
		this.idReservaCancha = idReservaCancha;
	}
	public String getIdServAdicional() {
		return idServAdicional;
	}
	public void setIdServAdicional(String idServAdicional) {
		this.idServAdicional = idServAdicional;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getIdEventoSocio() {
		return idEventoSocio;
	}
	public void setIdEventoSocio(String idEventoSocio) {
		this.idEventoSocio = idEventoSocio;
	}
	public String getIdEventoCorp() {
		return idEventoCorp;
	}
	public void setIdEventoCorp(String idEventoCorp) {
		this.idEventoCorp = idEventoCorp;
	}
	public String getIdBungalow() {
		return idBungalow;
	}
	public void setIdBungalow(String idBungalow) {
		this.idBungalow = idBungalow;
	}
	public String getIdSorteo() {
		return idSorteo;
	}
	public void setIdSorteo(String idSorteo) {
		this.idSorteo = idSorteo;
	}
	public String getIdEventoSede() {
		return idEventoSede;
	}
	public void setIdEventoSede(String idEventoSede) {
		this.idEventoSede = idEventoSede;
	}
	public String getIdInvitado() {
		return idInvitado;
	}
	public void setIdInvitado(String idInvitado) {
		this.idInvitado = idInvitado;
	}
	public String getIdMembresiaAnt() {
		return idMembresiaAnt;
	}
	public void setIdMembresiaAnt(String idMembresiaAnt) {
		this.idMembresiaAnt = idMembresiaAnt;
	}
	public String getIdMembresiaNue() {
		return idMembresiaNue;
	}
	public void setIdMembresiaNue(String idMembresiaNue) {
		this.idMembresiaNue = idMembresiaNue;
	}
	public String getIdSuspensionFalta() {
		return idSuspensionFalta;
	}
	public void setIdSuspensionFalta(String idSuspensionFalta) {
		this.idSuspensionFalta = idSuspensionFalta;
	}
	public String getIdSolicitudProducto() {
		return idSolicitudProducto;
	}
	public void setIdSolicitudProducto(String idSolicitudProducto) {
		this.idSolicitudProducto = idSolicitudProducto;
	}
	public String getIdSolicitudServicio() {
		return idSolicitudServicio;
	}
	public void setIdSolicitudServicio(String idSolicitudServicio) {
		this.idSolicitudServicio = idSolicitudServicio;
	}
	
	
	
	
	
}