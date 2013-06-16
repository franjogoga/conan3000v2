package IngSoft.administracion.bean;

import java.io.Serializable;
import java.util.Date;

public class HorariodetrabajoBeanData implements Serializable{


	private String codigo;	
	private String nombre;
	
	
	private String codDiasemana;// Un string con todos los codigos separados por comas
	private String diaSemana;// Un string con todos los dias separados por comas	
	
	private String horaInicio;
	private String horaFin;
	
	private String estadosDias;
	
	
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

	public String getCodDiasemana() {
		return codDiasemana;
	}
	public void setCodDiasemana(String codDiasemana) {
		this.codDiasemana = codDiasemana;
	}
	public String getDiaSemana() {
		return diaSemana;
	}
	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
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
	public String getEstadosDias() {
		return estadosDias;
	}
	public void setEstadosDias(String estadosDias) {
		this.estadosDias = estadosDias;
	}
	

	


	

	
	
	
	
}
