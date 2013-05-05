package IngSoft.servicio.bean;

import java.io.Serializable;
import java.util.Date;

public class SorteoBeanData implements Serializable {
	private int codigo;
	private Date fechaInicio;
	private Date fechaFin;
	private Date fechaSorteo;
	private String desc;
	private String estado;
	private int[] bungalows;
	private int[] socios;
	private int[] ganadores;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	
}
