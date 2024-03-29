package IngSoft.venta.bean;

import java.io.Serializable;
import java.util.Date;


public class CriterioOrdenPagoBeanData implements Serializable {
	
	private String idIngreso;
	private String idSocio;
	private String socio;
	private String idConcepto;
	private String concepto;
	private Date fechaVencimientoIni;
	private Date fechaVencimientoFin;
	
	private Date fechaPagoIni;
	private Date fechaPagoFin;
	private String estado;
	
	private Date fechaEmisionIni;
	private Date fechaEmisionFin;

	
	
	

	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
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
	public Date getFechaVencimientoIni() {
		return fechaVencimientoIni;
	}
	public void setFechaVencimientoIni(Date fechaVencimientoIni) {
		this.fechaVencimientoIni = fechaVencimientoIni;
	}
	public Date getFechaVencimientoFin() {
		return fechaVencimientoFin;
	}
	public void setFechaVencimientoFin(Date fechaVencimientoFin) {
		this.fechaVencimientoFin = fechaVencimientoFin;
	}
	public Date getFechaEmisionIni() {
		return fechaEmisionIni;
	}
	public void setFechaEmisionIni(Date fechaEmisionIni) {
		this.fechaEmisionIni = fechaEmisionIni;
	}
	public Date getFechaEmisionFin() {
		return fechaEmisionFin;
	}
	public void setFechaEmisionFin(Date fechaEmisionFin) {
		this.fechaEmisionFin = fechaEmisionFin;
	}
	
	public String getIdIngreso() {
		return idIngreso;
	}
	public void setIdIngreso(String idIngreso) {
		this.idIngreso = idIngreso;
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
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
