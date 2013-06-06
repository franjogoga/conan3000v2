package IngSoft.servicio.bean;

import java.io.Serializable;

public class ReservaCanchaMiniBeanData implements Serializable{
	private String codigoCancha;
	private String descCancha;
	private String codigoSocio;
	private java.sql.Date fecha;
	private String horaIni;
	private String horaFin;
	public String getCodigoCancha() {
		return codigoCancha;
	}
	public void setCodigoCancha(String codigoCancha) {
		this.codigoCancha = codigoCancha;
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
	public String getDescCancha() {
		return descCancha;
	}
	public void setDescCancha(String descCancha) {
		this.descCancha = descCancha;
	}
	public String getHoraIni() {
		return horaIni;
	}
	public void setHoraIni(String horaIni) {
		this.horaIni = horaIni;
	}
	public String getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}
	
	
}
