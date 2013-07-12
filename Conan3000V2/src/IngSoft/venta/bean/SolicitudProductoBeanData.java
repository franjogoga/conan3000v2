package IngSoft.venta.bean;

import java.io.Serializable;
import java.sql.Date;

public class SolicitudProductoBeanData implements Serializable {
		

private String idSolicitudProducto;
private Integer cantidad;

private String idSede;
private String estado;
public String getIdSede() {
	return idSede;
}
public void setIdSede(String idSede) {
	this.idSede = idSede;
}
private double precio;
private Date fecha;
private String idProductoProv;

public String getIdSolicitudProducto() {
	return idSolicitudProducto;
}
public void setIdSolicitudProducto(String idSolicitudProducto) {
	this.idSolicitudProducto = idSolicitudProducto;
}
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
public double getPrecio() {
	return precio;
}
public void setPrecio(double precio) {
	this.precio = precio;
}
public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}
public String getIdProductoProv() {
	return idProductoProv;
}
public void setIdProductoProv(String idProductoProv) {
	this.idProductoProv = idProductoProv;
}



}
