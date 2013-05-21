package IngSoft.servicio.bean;

import java.sql.Date;
import java.util.Vector;

public class ReservaDiaBeanData {
	private Date Fecha;
	private Vector<String> horas;
	public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	public Vector<String> getHoras() {
		return horas;
	}
	public void setHoras(Vector<String> horas) {
		this.horas = horas;
	}
	
	

}
