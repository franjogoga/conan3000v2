package IngSoft.servicio.bean;

import java.io.Serializable;
import java.sql.Date;

public class ResultadoEventoBeanData implements Serializable{
	private String codigo;
	private String nombre; 
	private String tipo;
	private Date limInicio;
	private Date limFin;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
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
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
}
