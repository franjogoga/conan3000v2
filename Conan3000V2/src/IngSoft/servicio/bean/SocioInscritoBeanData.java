package IngSoft.servicio.bean;

import java.io.Serializable;
import java.util.Date;

public class SocioInscritoBeanData implements Serializable{
	private String idSocio;
	private String idSorteo;
	private Date fecha;
	
	public String getIdSocio() {
		return idSocio;
	}
	public void setIdSocio(String idSocio) {
		this.idSocio = idSocio;
	}
	public String getIdSorteo() {
		return idSorteo;
	}
	public void setIdSorteo(String idSorteo) {
		this.idSorteo = idSorteo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
