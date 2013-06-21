package IngSoft.venta.bean;

import java.io.Serializable;
import java.sql.Date;

public class CriterioSolicitudSocioBeanData implements Serializable{
	
	private String codSolicitudSocio;
	private String nombres;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private Date fechaRegistro;
	private String estado;
	
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getCodSolicitudSocio() {
		return codSolicitudSocio;
	}
	
	public void setCodSolicitudSocio(String codSolicitudSocio) {
		this.codSolicitudSocio = codSolicitudSocio;
	}
	
	public String getNombres() {
		return nombres;
	}
	
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	
	
}
