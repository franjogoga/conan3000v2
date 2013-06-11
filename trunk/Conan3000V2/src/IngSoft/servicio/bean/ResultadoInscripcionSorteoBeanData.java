package IngSoft.servicio.bean;

import java.io.Serializable;
import java.sql.Date;

public class ResultadoInscripcionSorteoBeanData implements Serializable {
	private String codigo;
	private String nombre;
	private Date fechaIni;
	private Date fechaFin;
	private Date fechaSorteo;
	private String estado;
	private int flag;
	private String nombSede;
	
	public String getNombSede() {
		return nombSede;
	}
	public void setNombSede(String nombSede) {
		this.nombSede = nombSede;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Date getFechaSorteo() {
		return fechaSorteo;
	}
	public void setFechaSorteo(Date fechaSorteo) {
		this.fechaSorteo = fechaSorteo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaIni() {
		return fechaIni;
	}
	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

}
