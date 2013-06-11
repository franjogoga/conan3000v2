package IngSoft.administracion.bean;

import java.io.Serializable;
import java.util.Date;

public class HorariodeactividadBeanData implements Serializable{


	private String codigo;	
	private String nombre;
	
	
	private String codDiasemana;
	private String diaSemana;	
	
	private String horaInicio;
	private String horaFin;
	
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
	

	


	

	
	
	
	
}
