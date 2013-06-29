package IngSoft.administracion.bean;

import java.io.Serializable;

public class ConcesionarioBeanData implements Serializable{
	
	private String codigo;
	private String razonSocial;
	private long ruc;
	private String descripcion;
	private String estado;
	private Integer flag;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public long getRuc() {
		return ruc;
	}
	public void setRuc(long ruc) {
		this.ruc = ruc;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
}
