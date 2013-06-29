package IngSoft.general.bean;

import java.io.Serializable;

public class PerfilBeanData implements Serializable {

	private String idPerfil;
	private String idAccion;
	private String idCasoUso;
	private String mantenimiento;
	
	public String getMantenimiento() {
		return mantenimiento;
	}
	public void setMantenimiento(String mantenimiento) {
		this.mantenimiento = mantenimiento;
	}
	public String getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(String idPerfil) {
		this.idPerfil = idPerfil;
	}
	public String getIdAccion() {
		return idAccion;
	}
	public void setIdAccion(String idAccion) {
		this.idAccion = idAccion;
	}
	public String getIdCasoUso() {
		return idCasoUso;
	}
	public void setIdCasoUso(String idCasoUso) {
		this.idCasoUso = idCasoUso;
	}
	
	
}
