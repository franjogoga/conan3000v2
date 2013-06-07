
package IngSoft.venta.bean;

import java.io.Serializable;
import java.util.Date;


public class OrdenBeanPago implements Serializable {
	
	private String idProducto;
	private Double monto;
	private Date fechaEmision;
	private Date fechaVencimiento;
	private String descripcion;
	private String estadoOtroIngreso;
	private String idSocio;
	private String socio;
	private String idConcepto;
	
	
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
	
	
}