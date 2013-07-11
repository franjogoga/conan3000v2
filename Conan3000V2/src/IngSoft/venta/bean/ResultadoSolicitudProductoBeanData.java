package IngSoft.venta.bean;

public class ResultadoSolicitudProductoBeanData {
	
	private String estado;
	private Double monto;
	private Integer cantidad;
	private String idSolicitudProducto;
		
	public String getIdSolicitudProducto() {
		return idSolicitudProducto;
	}
	public void setIdSolicitudProducto(String idSolicitudProducto) {
		this.idSolicitudProducto = idSolicitudProducto;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
}
