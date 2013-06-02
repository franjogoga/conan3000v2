package IngSoft.venta.bean;

import java.io.Serializable;

public class CriterioProductoBeanData implements Serializable{
	
	private String idProdProveedor;
	private String nombre;
	public String getIdProdProveedor() {
		return idProdProveedor;
	}
	public void setIdProdProveedor(String idProdProveedor) {
		this.idProdProveedor = idProdProveedor;
	}
	private String proveedor;
	private String estado;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

}
