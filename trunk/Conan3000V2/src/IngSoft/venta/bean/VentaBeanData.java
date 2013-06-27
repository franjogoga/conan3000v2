package IngSoft.venta.bean;

import java.io.Serializable;

public class VentaBeanData implements Serializable{
	
	private String idVenta;
	private String idSocio; 
	private String idEmpleado;
	private String fechaVenta;
	private String estado;
	
	//private float monto;
	//private String observacion 
	
	public String getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(String idVenta) {
		this.idVenta = idVenta;
	}
	public String getIdSocio() {
		return idSocio;
	}
	public void setIdSocio(String idSocio) {
		idSocio = idSocio;
	}
	public String getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(String idEmpleado) {
		idEmpleado = idEmpleado;
	}
	public String getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(String fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}


}