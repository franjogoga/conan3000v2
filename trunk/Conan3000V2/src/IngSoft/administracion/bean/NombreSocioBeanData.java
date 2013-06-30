package IngSoft.administracion.bean;

import java.io.Serializable;

public class NombreSocioBeanData implements Serializable{
	private String nombres;
	private String apepaterno;
	private String apematerno;
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApepaterno() {
		return apepaterno;
	}
	public void setApepaterno(String apepaterno) {
		this.apepaterno = apepaterno;
	}
	public String getApematerno() {
		return apematerno;
	}
	public void setApematerno(String apematerno) {
		this.apematerno = apematerno;
	}			
}
