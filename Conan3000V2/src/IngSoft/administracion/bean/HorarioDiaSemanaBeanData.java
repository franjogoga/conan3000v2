package IngSoft.administracion.bean;

import java.io.Serializable;

public class HorarioDiaSemanaBeanData implements Serializable{
	
	private String codigoDia;
	private String codigoHorario;
	private String horaInicio;
	private String horaFin;
	private String estado;
	
	public String getCodigoDia() {
		return codigoDia;
	}
	public void setCodigoDia(String codigoDia) {
		this.codigoDia = codigoDia;
	}
	public String getCodigoHorario() {
		return codigoHorario;
	}
	public void setCodigoHorario(String codigoHorario) {
		this.codigoHorario = codigoHorario;
	}
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
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	

	
}
