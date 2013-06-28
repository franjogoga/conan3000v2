package IngSoft.administracion.bean;

import java.io.Serializable;
import java.sql.Date;

public class ResultadoHorariodeactividadBeanData implements Serializable{
	private String horario;
	private String codigo; 
	private String nombre;
	private String codDiasemana;
	private String diaSemana;
	private String horaInicio;
	private String horaFin;	
	private String estado;
	
	private String monto;
	
	
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
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
	public String getMonto() {
		return monto;
	}
	public void setMonto(String monto) {
		this.monto = monto;
	}

	
	
}
