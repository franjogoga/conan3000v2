package IngSoft.servicio.bean;

import java.io.Serializable;
import java.util.Date;

public class EventoBeanData implements Serializable{
	
	private String codigo;
	private String nombre;
	private int entradasTotal;
	private int limiteEntradas;
	private double precioEntrada;
	private String idSede;
	private String idConcesionario;
	private Date fecha;
	private double monto;
	private String estado;
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
	public int getEntradasTotal() {
		return entradasTotal;
	}
	public void setEntradasTotal(int entradasTotal) {
		this.entradasTotal = entradasTotal;
	}
	public int getLimiteEntradas() {
		return limiteEntradas;
	}
	public void setLimiteEntradas(int limiteEntradas) {
		this.limiteEntradas = limiteEntradas;
	}
	public double getPrecioEntrada() {
		return precioEntrada;
	}
	public void setPrecioEntrada(double precioEntrada) {
		this.precioEntrada = precioEntrada;
	}
	public String getIdSede() {
		return idSede;
	}
	public void setIdSede(String idSede) {
		this.idSede = idSede;
	}
	public String getIdConcesionario() {
		return idConcesionario;
	}
	public void setIdConcesionario(String idConcesionario) {
		this.idConcesionario = idConcesionario;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
