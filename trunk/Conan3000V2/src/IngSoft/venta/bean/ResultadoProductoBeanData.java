package IngSoft.venta.bean;

import java.io.Serializable;

public class ResultadoProductoBeanData implements Serializable {
	
	private String idProdProveedor;
	private String nombre;
	private String presentacion;
	private String descripcion;
	private String precioU;
	
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
	public String getPrecioU() {
		return precioU;
	}
	public void setPrecioU(String precioU) {
		this.precioU = precioU;
	}


}
