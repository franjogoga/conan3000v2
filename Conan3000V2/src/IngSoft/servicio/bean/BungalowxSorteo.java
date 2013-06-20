package IngSoft.servicio.bean;

import java.io.Serializable;
import java.util.Date;

public class BungalowxSorteo implements Serializable {
	private String idBungalow;
	private double areaBungalow;
	public double getAreaBungalow() {
		return areaBungalow;
	}
	public void setAreaBungalow(double areaBungalow) {
		this.areaBungalow = areaBungalow;
	}
	private String idSorteo;
	private String idSocio;
	public String getIdBungalow() {
		return idBungalow;
	}
	public void setIdBungalow(String idBungalow) {
		this.idBungalow = idBungalow;
	}
	public String getIdSorteo() {
		return idSorteo;
	}
	public void setIdSorteo(String idSorteo) {
		this.idSorteo = idSorteo;
	}
	public String getIdSocio() {
		return idSocio;
	}
	public void setIdSocio(String idSocio) {
		this.idSocio = idSocio;
	}
	public double getMontoBungalow() {
		return montoBungalow;
	}
	public void setMontoBungalow(double montoBungalow) {
		this.montoBungalow = montoBungalow;
	}
	private double montoBungalow;
	
	
}
