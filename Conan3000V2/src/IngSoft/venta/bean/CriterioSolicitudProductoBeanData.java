package IngSoft.venta.bean;

import java.sql.Date;

public class CriterioSolicitudProductoBeanData {

	private String idSolicitudProducto;
	private Date fecha;
	
	public String getIdSolicitudProducto() {
		return idSolicitudProducto;
	}
	public void setIdSolicitudProducto(String idSolicitudProducto) {
		this.idSolicitudProducto = idSolicitudProducto;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
