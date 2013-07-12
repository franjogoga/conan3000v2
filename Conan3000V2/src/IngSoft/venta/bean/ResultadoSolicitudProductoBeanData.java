package IngSoft.venta.bean;

import java.io.Serializable;

public class ResultadoSolicitudProductoBeanData implements Serializable {
	
	private String estado;
	private Integer cantidad;
	private String idSolicitudProducto;
		
	public String getIdSolicitudProducto() {
		return idSolicitudProducto;
	}
	public void setIdSolicitudProducto(String idSolicitudProducto) {
		this.idSolicitudProducto = idSolicitudProducto;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
}
