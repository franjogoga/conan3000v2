package IngSoft.venta.bean;

import java.io.Serializable;

public class CriterioVentaBeanData implements Serializable{
	


	private String idVenta;
	private String estado;


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
