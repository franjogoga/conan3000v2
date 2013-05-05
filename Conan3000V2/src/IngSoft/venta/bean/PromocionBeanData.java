package IngSoft.venta.bean;

import java.util.Date;

public class PromocionBeanData {

	private int codigo;
	private String nombre;
	private Date fechainicio;
	private Date fechafin;
	private String descripcion;
	private String estado;
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setIdPromocion(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Date getFechainicio() {
		return fechainicio;
	}
	
	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}
	
	public Date getFechafin() {
		return fechafin;
	}
	
	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
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
