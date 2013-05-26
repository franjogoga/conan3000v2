
package IngSoft.venta.bean;

import java.io.Serializable;
import java.util.Date;

public class ResultadoMembresiaBeanData implements Serializable {
	
	private String codigo;
	private String nombre;
	private Date limInicio;
	private Date limFin;
	private String estado;
	private Double costo;
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public Double getCosto() {
		return costo;
	}
	
	public void setCosto(Double costo) {
		this.costo = costo;
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
