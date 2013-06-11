package IngSoft.administracion.bean;

import java.io.Serializable;
import java.sql.Date;

public class CriterioHorariodeactividadBeanData implements Serializable{
	private String nombre; 
	

	
	private String codDiasemana;
	private String horaInicio;
	private String horaFin;
	
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

	
	
	

	


	


}
