package IngSoft.venta.bean;

import java.io.Serializable;
import java.util.Date;

public class ResultadoVentaBeanData implements Serializable{
	
	private String idVenta;
	private String idSocio; 
	private String idEmpleado;
	private Date fechaVenta;
	private String estado;
	
	private String idProducto;
	private String producto;
	private String idLineaVenta;
	private String sede;
	private Integer cantidad;
	private Double subtotal;
	private Double precioU;
	
	
	
	
	public Double getPrecioU() {
		return precioU;
	}
	public void setPrecioU(Double precioU) {
		this.precioU = precioU;
	}
	public String getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public String getIdLineaVenta() {
		return idLineaVenta;
	}
	public void setIdLineaVenta(String idLineaVenta) {
		this.idLineaVenta = idLineaVenta;
	}
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	

	
	
	
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
		this.idSocio = idSocio;
	}
	public String getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public Date getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}


}