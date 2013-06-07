package IngSoft.administracion.bean;

import java.sql.Date;

public class CriterioJornadaBeanData {
	private String idJornada;
	private String idEmpleado;
	private String horaInicio;
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	private Date horaFin;
	public String getIdJornada() {
		return idJornada;
	}
	public void setIdJornada(String idJornada) {
		this.idJornada = idJornada;
	}
	public String getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	
	public Date getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(Date horaFin) {
		this.horaFin = horaFin;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	private Date fecha;
	

}
