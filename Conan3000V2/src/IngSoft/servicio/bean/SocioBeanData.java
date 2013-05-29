package IngSoft.servicio.bean;

import java.io.Serializable;

public class SocioBeanData implements Serializable{
	private String idSocio;
	private String nombres;
	private String apePaterno;
	private String apeMaterno;
	private long telefonoCelular;
	private long telefonoFijo;
	
	
	
	
	public long getTelefonoCelular() {
		return telefonoCelular;
	}
	public void setTelefonoCelular(long telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}
	public long getTelefonoFijo() {
		return telefonoFijo;
	}
	public void setTelefonoFijo(long telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}
	public String getIdSocio() {
		return idSocio;
	}
	public void setIdSocio(String idSocio) {
		this.idSocio = idSocio;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApePaterno() {
		return apePaterno;
	}
	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}
	public String getApeMaterno() {
		return apeMaterno;
	}
	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}
}
