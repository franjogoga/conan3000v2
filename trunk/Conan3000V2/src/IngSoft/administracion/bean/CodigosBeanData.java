package IngSoft.administracion.bean;

import java.io.Serializable;

public class CodigosBeanData implements Serializable{
	private String codigoPerfil;
	private String codigoCaso;
	private String codigoAccion;
	public String getCodigoPerfil() {
		return codigoPerfil;
	}
	public void setCodigoPerfil(String codigoPerfil) {
		this.codigoPerfil = codigoPerfil;
	}
	public String getCodigoCaso() {
		return codigoCaso;
	}
	public void setCodigoCaso(String codigoCaso) {
		this.codigoCaso = codigoCaso;
	}
	public String getCodigoAccion() {
		return codigoAccion;
	}
	public void setCodigoAccion(String codigoAccion) {
		this.codigoAccion = codigoAccion;
	}	
}
