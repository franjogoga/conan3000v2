package IngSoft.administracion.bean;

import java.io.Serializable;

public class CasosBeanData implements Serializable{
	private String codigoCaso;
	private String nombreCaso;
	private String codigoAccion;
	private String nombreAccion;
	public String getCodigoCaso() {
		return codigoCaso;
	}
	public void setCodigoCaso(String codigoCaso) {
		this.codigoCaso = codigoCaso;
	}
	public String getNombreCaso() {
		return nombreCaso;
	}
	public void setNombreCaso(String nombreCaso) {
		this.nombreCaso = nombreCaso;
	}
	public String getCodigoAccion() {
		return codigoAccion;
	}
	public void setCodigoAccion(String codigoAccion) {
		this.codigoAccion = codigoAccion;
	}
	public String getNombreAccion() {
		return nombreAccion;
	}
	public void setNombreAccion(String nombreAccion) {
		this.nombreAccion = nombreAccion;
	}	
}
