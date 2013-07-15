package IngSoft.venta.bean;

import java.io.Serializable;
import java.util.Date;

public class CriterioVentaBeanData implements Serializable{
	


	private String idVenta;
	private String estado;
	private String sede;
	private Date FechaIni;
	private Date FechaFin;
	private String idSede;

	
	

	public String getIdSede() {
		return idSede;
	}

	public void setIdSede(String idSede) {
		this.idSede = idSede;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public Date getFechaIni() {
		return FechaIni;
	}

	public void setFechaIni(Date fechaIni) {
		FechaIni = fechaIni;
	}

	public Date getFechaFin() {
		return FechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		FechaFin = fechaFin;
	}

	public void setIdVenta(String idVenta) {
		this.idVenta = idVenta;
	}

	public String getIdVenta() {
		return idVenta;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	

}
