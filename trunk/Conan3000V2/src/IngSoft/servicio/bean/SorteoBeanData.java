package IngSoft.servicio.bean;

import java.io.Serializable;
import java.util.Date;

public class SorteoBeanData implements Serializable {
	private String idSorteo;
	private String idSede;
	private String nombre;
	private Date fechaInicio;
	private Date fechaFin;
	private Date fechaSorteo;
	private String descripcion;
	private String estado;
	private int[] bungalows;
	private int[] socios;
	private int[] ganadores;
	
	public String getCodigo() {
		return idSorteo;
	}
	public void setCodigo(String codigo) {
		this.idSorteo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdSorteo() {
		return idSorteo;
	}
	public void setIdSorteo(String idSorteo) {
		this.idSorteo = idSorteo;
	}
	public String getIdSede() {
		return idSede;
	}
	public void setIdSede(String idSede) {
		this.idSede = idSede;
	}
	public int[] getBungalows() {
		return bungalows;
	}
	public void setBungalows(int[] bungalows) {
		this.bungalows = bungalows;
	}
	public int[] getSocios() {
		return socios;
	}
	public void setSocios(int[] socios) {
		this.socios = socios;
	}
	public int[] getGanadores() {
		return ganadores;
	}
	public void setGanadores(int[] ganadores) {
		this.ganadores = ganadores;
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
	public Date getFechaSorteo() {
		return fechaSorteo;
	}
	public void setFechaSorteo(Date fechaSorteo) {
		this.fechaSorteo = fechaSorteo;
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
