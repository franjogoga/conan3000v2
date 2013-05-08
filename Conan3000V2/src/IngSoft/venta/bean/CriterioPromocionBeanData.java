package IngSoft.venta.bean;

import java.util.Date;

public class CriterioPromocionBeanData {
	
	private String codigo;
	private String nombre;
	private Date limInicio;
	private Date limFin;
	private String estado;
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setIdPromocion(String codigo) {
		this.codigo = codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}		
}
