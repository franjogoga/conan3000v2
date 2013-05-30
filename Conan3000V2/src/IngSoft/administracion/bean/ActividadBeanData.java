package IngSoft.administracion.bean;

import java.io.Serializable;
import java.util.Date;

public class ActividadBeanData implements Serializable{


	private String codigo;	
	
	private String nombreSede;
	private String nombre;
	
	
	private String nombreTipoactividad;
	
	private String nombreEncargado;
	private String puesto;
	
	private String nombreAmbientes;
	
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
	public String getNombreSede() {
		return nombreSede;
	}
	public void setNombreSede(String nombreSede) {
		this.nombreSede = nombreSede;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombreTipoactividad() {
		return nombreTipoactividad;
	}
	public void setNombreTipoactividad(String nombreTipoactividad) {
		this.nombreTipoactividad = nombreTipoactividad;
	}
	public String getNombreEncargado() {
		return nombreEncargado;
	}
	public void setNombreEncargado(String nombreEncargado) {
		this.nombreEncargado = nombreEncargado;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public String getNombreAmbientes() {
		return nombreAmbientes;
	}
	public void setNombreAmbientes(String nombreAmbientes) {
		this.nombreAmbientes = nombreAmbientes;
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
