package IngSoft.servicio.bean;

import java.util.Vector;

public class ReservaBugalowBeanData {
	private String codigo;					
	private Vector<ReservaDiaBeanData> reservas;
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
