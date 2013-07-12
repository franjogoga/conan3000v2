package IngSoft.venta.bean;

import java.sql.Date;

public class CriterioSolicitudProductoBeanData {

	private String idSolicitudProducto;
	private Date limInicio;
	private Integer cantidad;
	private String estado;

	
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getLimInicio() {
		return limInicio;
	}
	public void setLimInicio(Date limInicio) {
		this.limInicio = limInicio;
	}

	public String getIdSolicitudProducto() {
		return idSolicitudProducto;
	}
	public void setIdSolicitudProducto(String idSolicitudProducto) {
		this.idSolicitudProducto = idSolicitudProducto;
	}
	
	
}
