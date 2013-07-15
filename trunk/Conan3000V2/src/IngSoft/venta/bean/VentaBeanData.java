package IngSoft.venta.bean;

import java.io.Serializable;
import java.util.Date;

public class VentaBeanData implements Serializable{
	
	private String idVenta;
	private String idSocio; 
	private String idEmpleado;
	private Date fechaVenta;
	private String estado;
	private Integer cantidad;
	
	private String nombre;
	private String presentacion;
	private String descripcion;
	private Double precioU;
	
	private String idProducto;
	private String producto;
	private Double precioUnitario;
	private Integer cantidadComprada;
	private Integer cantidadVendida;
	private String idSede;
	private Double subTotal;
	private String idLineaVenta;
	
	
	//private float monto;
	//private String observacion 
	
	
	
	
	public Double getSubTotal() {
		return subTotal;
	}
	public String getIdLineaVenta() {
		return idLineaVenta;
	}
	public void setIdLineaVenta(String idLineaVenta) {
		this.idLineaVenta = idLineaVenta;
	}
	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}
	public String getIdVenta() {
		return idVenta;
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
	public Double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public Integer getCantidadComprada() {
		return cantidadComprada;
	}
	public void setCantidadComprada(Integer cantidadComprada) {
		this.cantidadComprada = cantidadComprada;
	}
	public Integer getCantidadVendida() {
		return cantidadVendida;
	}
	public void setCantidadVendida(Integer cantidadVendida) {
		this.cantidadVendida = cantidadVendida;
	}
	public String getIdSede() {
		return idSede;
	}
	public void setIdSede(String idSede) {
		this.idSede = idSede;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPresentacion() {
		return presentacion;
	}
	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getPrecioU() {
		return precioU;
	}
	public void setPrecioU(Double precioU) {
		this.precioU = precioU;
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