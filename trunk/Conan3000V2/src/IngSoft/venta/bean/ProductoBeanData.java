package IngSoft.venta.bean;
import java.io.Serializable;
import java.util.Date;

public class ProductoBeanData implements Serializable{
	
	
	
	private String idProdProveedor;
	private String idProveedor;
	//private String proveedor;
	
	private String nombre;
	private String presentacion;
	private String descripcion;
	private Double precioU;
	private String estado;
	
	//public String getProveedor() {
	//	return proveedor;
	//}
	//public void setProveedor(String proveedor) {
	//	this.proveedor = proveedor;
	//}
	
	public String getIdProdProveedor() {
		return idProdProveedor;
	}
	public void setIdProdProveedor(String idProdProveedor) {
		this.idProdProveedor = idProdProveedor;
	}
	public String getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(String idProveedor) {
		this.idProveedor = idProveedor;
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
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	

}
