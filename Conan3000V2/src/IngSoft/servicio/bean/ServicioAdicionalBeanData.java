package IngSoft.servicio.bean;

import java.io.Serializable;

public class ServicioAdicionalBeanData implements Serializable{
	private String codigo;
	private String nombre;
	private String tipo;
	private double monto;
	private String descripcion;
	private String estado;
	private String registrado;
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
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
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
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
	public String getRegistrado() {
		return registrado;
	}
	public void setRegistrado(String registrado) {
		this.registrado = registrado;
	}
	
	
}
