package IngSoft.servicio.bean;

import java.util.Vector;

public class ReservaBugalowBeanData {
	private String codigo;
	private String nombre;
	private Vector<ReservaDiaBeanData> reservas;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Vector<ReservaDiaBeanData> getReservas() {
		return reservas;
	}
	public void setReservas(Vector<ReservaDiaBeanData> reservas) {
		this.reservas = reservas;
	}
	
	
}
