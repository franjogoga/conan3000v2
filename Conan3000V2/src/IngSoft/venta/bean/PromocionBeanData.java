package IngSoft.venta.bean;

import java.util.Date;

public class PromocionBeanData {

	private int idPromocion;
	private String nombre;
	private Date fechainicio;
	private Date fechafin;
	private String descripcion;
	private String estado;
	
	public int getIdPromocion() {
		return idPromocion;
	}
	
	public void setIdPromocion(int idPromocion) {
		this.idPromocion = idPromocion;
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
