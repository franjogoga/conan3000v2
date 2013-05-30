package IngSoft.administracion.bean;

import java.io.Serializable;
import java.util.Date;

public class ActividadBeanData implements Serializable{


	private String codigo;	
	private String nombre;
	
	private String idSede;
	private String idTipoactividad;
	private String idEncargado;
	private String idAmbientes;
	
	private Date fechaInicio;
	private Date fechaFin;
	
	
	private String dia;
	private String descripcion;
	private String estado;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getIdSede() {
		return idSede;
	}
	public void setIdSede(String idSede) {
		this.idSede = idSede;
	}
	public String getIdTipoactividad() {
		return idTipoactividad;
	}
	public void setIdTipoactividad(String idTipoactividad) {
		this.idTipoactividad = idTipoactividad;
	}
	public String getIdEncargado() {
		return idEncargado;
	}
	public void setIdEncargado(String idEncargado) {
		this.idEncargado = idEncargado;
	}
	public String getIdAmbientes() {
		return idAmbientes;
	}
	public void setIdAmbientes(String idAmbientes) {
		this.idAmbientes = idAmbientes;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	
		
	
	
}
