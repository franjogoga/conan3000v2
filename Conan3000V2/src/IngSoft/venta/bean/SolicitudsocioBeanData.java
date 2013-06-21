package IngSoft.venta.bean;

import java.io.Serializable;
import java.util.Date;

public class SolicitudsocioBeanData implements Serializable{
	
	private String codSolicitudIngreso;
	private Date fechaRegistro;
	private String observaciones;
	private String nombres;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private Date fechaNacimiento;
	private String direccion;
	private String codDistrito;
	private String estado;
	
	
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCodSolicitudIngreso() {
		return codSolicitudIngreso;
	}
	
	public void setCodSolicitudIngreso(String codSolicitudIngreso) {
		this.codSolicitudIngreso = codSolicitudIngreso;
	}
	
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	public String getObservaciones() {
		return observaciones;
	}
	
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
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
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getCodDistrito() {
		return codDistrito;
	}
	
	public void setCodDistrito(String codDistrito) {
		this.codDistrito = codDistrito;
	}

}
