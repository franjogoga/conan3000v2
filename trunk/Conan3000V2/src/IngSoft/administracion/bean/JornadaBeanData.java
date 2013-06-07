package IngSoft.administracion.bean;

import java.io.Serializable;
import java.util.Date;

public class JornadaBeanData implements Serializable {
	private String idJornada;
	private String idEmpleado;
	private String horaInicio;
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}
	private String horaFin;
	private Date fecha;
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
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

}
