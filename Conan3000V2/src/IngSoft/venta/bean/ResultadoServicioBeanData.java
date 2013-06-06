package IngSoft.venta.bean;

import java.io.Serializable;

public class ResultadoServicioBeanData implements Serializable{
	
	private String codServicio;
	private String codProveedor;
	private String nombreServicio;
	private String nombreProveedor;
	private double precio;
	private String estado;
	
	
	

	public String getCodServicio() {
		return codServicio;
	}

	public void setCodServicio(String codServicio) {
		this.codServicio = codServicio;
	}

	public String getCodProveedor() {
		return codProveedor;
	}

	public void setCodProveedor(String codProveedor) {
		this.codProveedor = codProveedor;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}
	
	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}
	
	public String getNombreProveedor() {
		return nombreProveedor;
	}
	
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	

}
