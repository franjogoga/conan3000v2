package IngSoft.venta.bean;

import java.util.Date;

public class SolicitudServicioBeanData {

	private String codigoSolicitud;
	private Date fecha;
	private Double montototal;
	private String estado;
	private Double[] monto;
	
	
	
	public String getCodigoSolicitud() {
		return codigoSolicitud;
	}

	public void setCodigoSolicitud(String codigoSolicitud) {
		this.codigoSolicitud = codigoSolicitud;
	}

	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Double getMontototal() {
		return montototal;
	}
	
	public void setMontototal(Double montototal) {
		this.montototal = montototal;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Double[] getMonto() {
		return monto;
	}
	
	public void setMonto(Double[] monto) {
		this.monto = monto;
	}
	
	
	
	
	
	
	
	
	
}
