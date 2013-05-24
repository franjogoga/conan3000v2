package IngSoft.servicio.bean;

import java.io.Serializable;

public class BungalowxSorteData implements Serializable{
	private String IdBungalow;
	private String IdSorteo;
	private String IdSocio;
	private double Monto;
	
	public String getIdBungalow() {
		return IdBungalow;
	}
	public void setIdBungalow(String idBungalow) {
		IdBungalow = idBungalow;
	}
	public String getIdSorteo() {
		return IdSorteo;
	}
	public void setIdSorteo(String idSorteo) {
		IdSorteo = idSorteo;
	}
	public String getIdSocio() {
		return IdSocio;
	}
	public void setIdSocio(String idSocio) {
		IdSocio = idSocio;
	}
	public double getMonto() {
		return Monto;
	}
	public void setMonto(double monto) {
		Monto = monto;
	}

	
	
}
