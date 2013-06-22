package IngSoft.venta.bean;

import java.sql.Date;

public class SolicitudProductoBeanData {
		

private String idSolicitudProducto;
private Integer cantidad;
private String idEmpleado;
private String idProducto;
private String estado;
private double montoTotal;
public String getIdProducto() {
	return idProducto;
}
public void setIdProducto(String idProducto) {
	this.idProducto = idProducto;
}
private Date fecha;

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
public String getIdEmpleado() {
	return idEmpleado;
}
public void setIdEmpleado(String idEmpleado) {
	this.idEmpleado = idEmpleado;
}
public String getEstado() {
	return estado;
}
public void setEstado(String estado) {
	this.estado = estado;
}
public double getMontoTotal() {
	return montoTotal;
}
public void setMontoTotal(double montoTotal) {
	this.montoTotal = montoTotal;
}
public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}
public String getIdSede() {
	return idSede;
}
public void setIdSede(String idSede) {
	this.idSede = idSede;
}
private String idSede;


}
