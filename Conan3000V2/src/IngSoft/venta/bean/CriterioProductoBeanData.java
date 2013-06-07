package IngSoft.venta.bean;

import java.io.Serializable;

public class CriterioProductoBeanData implements Serializable{
	
	private String idProdProveedor;
	private String nombre;
	private Double precioU;
	private String estado;
	private String presentacion;
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


	private String descripcion;
	
	
	public String getIdProdProveedor() {
		return idProdProveedor;
	}
	
	public void setIdProdProveedor(String idProdProveedor) {
		this.idProdProveedor = idProdProveedor;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecioU() {
		return precioU;
	}
	public void setPrecioU(Double precioU) {
		this.precioU = precioU;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	

}
