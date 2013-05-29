package IngSoft.servicio.bean;

import java.io.Serializable;

public class ReservaBungalowMiniBeanData implements Serializable{
	private String codigoBungalow;
	private String nombreBungalow;
	private String codigoSocio;
	private java.sql.Date fecha;
	
	public String getCodigoBungalow() {
		return codigoBungalow;
	}
	public void setCodigoBungalow(String codigoBungalow) {
		this.codigoBungalow = codigoBungalow;
	}
	public String getNombreBungalow() {
		return nombreBungalow;
	}
	public void setNombreBungalow(String nombreBungalow) {
		this.nombreBungalow = nombreBungalow;
	}
	public String getCodigoSocio() {
		return codigoSocio;
	}
	public void setCodigoSocio(String codigoSocio) {
		this.codigoSocio = codigoSocio;
	}
	public java.sql.Date getFecha() {
		return fecha;
	}
	public void setFecha(java.sql.Date fecha) {
		this.fecha = fecha;
	}
	
	
	
}
