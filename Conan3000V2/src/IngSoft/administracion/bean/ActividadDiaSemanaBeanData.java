package IngSoft.administracion.bean;

import java.io.Serializable;

public class ActividadDiaSemanaBeanData implements Serializable{
	
	private String codigoDia;
	private String codigoActividad;
	private String horaInicio;
	private String horaFin;
	private Double duracion;
	private String estado;
	
	
	public String getCodigoDia() {
		return codigoDia;
	}
	public void setCodigoDia(String codigoDia) {
		this.codigoDia = codigoDia;
	}
	public String getCodigoActividad() {
		return codigoActividad;
	}
	public void setCodigoActividad(String codigoActividad) {
		this.codigoActividad = codigoActividad;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}
	public Double getDuracion() {
		return duracion;
	}
	public void setDuracion(Double duracion) {
		this.duracion = duracion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	

	
	
}
