package IngSoft.servicio.bean;

import java.sql.Date;

public class CriterioEventoBeanData {
	private String nombre;
	private int tipo;
	private Date limInicio;
	private Date limFin;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public Date getLimInicio() {
		return limInicio;
	}
	public void setLimInicio(Date limInicio) {
		this.limInicio = limInicio;
	}
	public Date getLimFin() {
		return limFin;
	}
	public void setLimFin(Date limFin) {
		this.limFin = limFin;
	}

}
